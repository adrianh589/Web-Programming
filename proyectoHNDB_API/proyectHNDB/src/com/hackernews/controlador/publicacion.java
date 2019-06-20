package com.hackernews.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.dao.noticiaDAO;
import com.hackernews.dao.usuarioDAO;
import com.hackernews.modelo.noticia;
import com.hackernews.modelo.usuario;

@WebServlet("/publicacion")
public class publicacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();//sesion para saber is hay alguien conectado
		usuario user = (usuario) session.getAttribute("usuario") ;//traemos el usuario conectado en una variable	
		
		String titulo = request.getParameter("title");
        String url = request.getParameter("url");
        String contenido = request.getParameter("text");
        
        noticia n = new noticia();
        n.setId_usuario(user.getId());
        n.setTitulo(titulo);
        n.setUrl(url);
        n.setContenido(contenido);
        
        int guardada = noticiaDAO.guardar(n);
        
        if(guardada>0) {
        	response.sendRedirect("/proyectHNDB/Vista/menuPrincipal.jsp");//Redireccionamos al menu principal cuando iniciemos la sesion
        }else {
        	response.sendRedirect("/proyectHNDB/Vista/submit/submit.jsp");//Si la noticia nose guardo lo redireccionamos al mismo sitio
        }
	}

}
