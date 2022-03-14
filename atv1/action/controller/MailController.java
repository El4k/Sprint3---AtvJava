package br.com.compass.pb.sprint3.atv1.action.controller;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.User;

public class MailController implements Action {
	
	protected Document documento(String url) {
		try {
			HttpRequest requestClient = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> responseClient = httpClient.send(requestClient, BodyHandlers.ofString());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(responseClient.body())));
			doc.getDocumentElement().normalize();
			return doc;
		} catch (IOException | InterruptedException | ParserConfigurationException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

	protected Double getValueFee(Document doc) {
		String fee = doc.getElementsByTagName("Valor").item(0).getTextContent().replace(",", ".");
		Double valueFee = Double.parseDouble(fee);
		return valueFee;
	}

	protected Integer getDeadline(Document doc) {
		String dead = doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent().replace(",", ".");
		Integer deadline = Integer.parseInt(dead);
		return deadline;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		User user = (User) sessao.getAttribute("userLogged");
		String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=08082650&sDsSenha=564321&sCepOrigem=70002900&sCepDestino="+user.getAddress().getCEP()+"&nVlPeso=1&nCdFormato=1&nVlComprimento=20&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
		Document doc = documento(url);
		user.setValueFee(getValueFee(doc));
		user.setDeadline(getDeadline(doc));
		UserDao userDao = new UserDao();
		
		userDao.update(user);
		return "forward:fee.jsp";
	}
}