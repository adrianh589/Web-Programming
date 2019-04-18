package com.hackernews.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hackernews.modelo.usuario;
import com.hackernews.modelo.usuarioDAO;

@WebServlet("/verUsuario")
public class verUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Este es el id recibido: "+request.getParameter("user"));
		
		int usuarioRecibido = Integer.parseInt(request.getParameter("user"));
		
		usuario user = usuarioDAO.traerUsuario(usuarioRecibido);
		
		request.setAttribute("usuarioRecibido",user);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Vista/usuario/perfilDemasUsuarios.jsp");
		rd.forward(request, response);
	}


}
