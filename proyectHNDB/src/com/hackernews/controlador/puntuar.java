package com.hackernews.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.noticiaDAO;
import com.hackernews.modelo.usuario;

@WebServlet("/puntuar")
public class puntuar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
		
		HttpSession session=  request.getSession();//Invocamos el objeto sesion
		
		usuario user = (usuario) session.getAttribute("usuario") ;//Variable para verificar que haya un usuario conectado
		
		if (user != null) {//Verificamos si hay alguien conectado
			int puntuada = noticiaDAO.votar(idNoticia);
		} else {
			response.sendRedirect("/proyectHNDB/Vista/registrar-loguear/loginVoto.jsp");
			return;
		}
		
		
		
		response.sendRedirect("/proyectHNDB/Vista/menuPrincipal.jsp");//Redireccionamos al menu principal cuando iniciemos la sesion
		
	}

}
