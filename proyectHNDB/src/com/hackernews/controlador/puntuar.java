package com.hackernews.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hackernews.modelo.noticiaDAO;

@WebServlet("/puntuar")
public class puntuar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
		
		int puntuada = noticiaDAO.votar(idNoticia);
		
		request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		
	}

}
