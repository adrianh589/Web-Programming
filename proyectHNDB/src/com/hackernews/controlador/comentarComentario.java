package com.hackernews.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comentarComentario")
public class comentarComentario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idcomentario = Integer.parseInt(request.getParameter("idcomentario"));
		int idnoticia = Integer.parseInt(request.getParameter("idnoticia"));
		String usuarioAutor = request.getParameter("usuarioAutor");
		String nombreNoticia = request.getParameter("nombreNoticia");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
