package com.hackernews.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.comentario;
import com.hackernews.modelo.comentarioDAO;
import com.hackernews.modelo.noticia;
import com.hackernews.modelo.noticiaDAO;
import com.hackernews.modelo.usuario;

/**
 * Servlet implementation class comentar
 */
@WebServlet("/comentar")
public class comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();//sesion para saber is hay alguien conectado
		usuario user = (usuario) session.getAttribute("usuario") ;//traemos el usuario conectado en una variable
		
			//Obtenemos por metodo get la noticia seleccionada
			int id_noticia = Integer.parseInt(request.getParameter("noticiaid"));
			
			noticia noticia = noticiaDAO.obtenerNoticiaPorId(id_noticia);
			
			request.setAttribute("noticiaSeleccionada",noticia);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Vista/comentarios/comentariosNoticia.jsp");
			rd.forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recibimos el texto o comentario que se halla puesto
		String texto = request.getParameter("text");
		int id_noticia = Integer.parseInt(request.getParameter("idNoticia"));
		
		HttpSession session = request.getSession();//sesion para saber is hay alguien conectado
		usuario user = (usuario) session.getAttribute("usuario") ;//traemos el usuario conectado en una variable
		
		//Añadimos a la sesion la noticia
		noticia noticia = noticiaDAO.obtenerNoticiaPorId(id_noticia);
		request.setAttribute("noticiaSeleccionada",noticia);
		
		if(user==null) {
			response.sendRedirect("/proyectHNDB/Vista/registrar-loguear/badLogin.jsp");//Si no hay ningun usuario conectado, lo redirigimos para que se loguee
		}
		
		else if (texto!=null) {
			//Creamos un objeto de tipo comentarios
			comentario c = new comentario();
			
			c.setId_noticia(id_noticia);
			c.setId_usuario(user.getId());
			c.setContenido(texto);
					
			//Ejecutamos el query para guardarlo en la base de datos
			int guardo = comentarioDAO.guardar(c);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Vista/comentarios/comentariosNoticia.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect("/proyectHNDB/Vista/comentarios/comentariosNoticia.jsp");
		}
		
		
	}

}
