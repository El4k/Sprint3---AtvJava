package br.com.compass.pb.sprint3.atv2.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.xml.sax.SAXException;

@Path("/exe")
public class ClimaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ResourceExe(@QueryParam("city_name") String city_name) throws JSONException, IOException, ParserConfigurationException, SAXException {
		URL url = new URL("https://api.hgbrasil.com/weather?locale=pt&city_name="+city_name+"&key=acd8d9b6&array_limit=5&fields=only_results,"
				+ "city_name,date,temp,forecast,weekday,max,min,date");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String output = new String(buffer.readLine().getBytes("UTF-8"));
		
		connection.disconnect();
		Response.status(Response.Status.BAD_REQUEST).build();
		return Response.ok(output).build();
	}
}