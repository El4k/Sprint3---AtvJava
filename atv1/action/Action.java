package br.com.compass.pb.sprint3.atv1.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}