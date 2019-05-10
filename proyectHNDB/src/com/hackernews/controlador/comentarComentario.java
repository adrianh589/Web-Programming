package com.hackernews.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.comentario;
import com.hackernews.modelo.comentarioDAO;
import com.hackernews.modelo.usuario;

@WebServlet("/comentarComentario")
public class comentarComentario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idusuario = Integer.parseInt(request.getParameter("idusuario")); 
		int idcomentario = Integer.parseInt(request.getParameter("idcomentario"));
		int idnoticia = Integer.parseInt(request.getParameter("idnoticia"));
		String contenido = request.getParameter("text");
		
		comentario c = new comentario();
		
		c.setId_usuario(idusuario);
		c.setId(idcomentario);
		c.setId_noticia(idnoticia);
		c.setContenido(contenido);
		
		int estado = comentarioDAO.guardarComentariosComentario(c);
		
		if(estado>0) {
			response.sendRedirect("/proyectHNDB/comentar?noticiaid="+idnoticia);//Redireccionamos al menu principal cuando iniciemos la sesion
		}else {
			System.out.println("no se guardo");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
