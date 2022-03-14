package br.com.compass.pb.sprint3.atv1.action.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compass.pb.sprint3.atv1.action.Action;

public class ErrorController implements Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "forward:error404.jsp";
	}
}