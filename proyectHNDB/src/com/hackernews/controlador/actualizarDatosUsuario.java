package com.hackernews.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.usuario;
import com.hackernews.modelo.usuarioDAO;

/**
 * Servlet implementation class actualizarDatosUsuario
 */
@WebServlet("/actualizarDatosUsuario")
public class actualizarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtenemos la sesion del usuario que esta conectado
		HttpSession session = request.getSession();
		usuario user = (usuario) session.getAttribute("usuario") ;
		
		//Recibimos los parametros proporionados
		String about = request.getParameter("about");
		String email = request.getParameter("uemail");
		String showdead = request.getParameter("showdead");
		String noprocast = request.getParameter("noprocast");
		int max_visit = Integer.parseInt(request.getParameter("maxv"));
		int min_away = Integer.parseInt(request.getParameter("mina"));
		int delay = Integer.parseInt(request.getParameter("delay"));
		
		//Cambiamos los datos al usuario conectado
		user.setAcerca_de_mi(about);
		user.setEmail(email);
		user.setShowdead(showdead);
		user.setNoprocast(noprocast);
		user.setVisitasMaximas(max_visit);
		user.setMinAway(min_away);
		user.setRetraso(delay);
		
		//Ejecutamos lso cambios
		usuarioDAO.actualizar(user);
		
		//Redireccionamos a la pagina perfil usuario con los datos cambiados
		response.sendRedirect("/proyectHNDB/Vista/usuario/perfilUsuario.jsp");
		
	}

}
