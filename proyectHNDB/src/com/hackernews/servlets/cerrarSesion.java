package com.hackernews.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerrarSesion")

public class cerrarSesion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();//Obtenemos la sesion en caso de que exista
		session.invalidate();//Destruimos la sesion del usuario actual
		
		request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);//Redireccionamos al menu principal cuando cerremos la sesion
	}
}
