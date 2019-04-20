package com.hackernews.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.usuario;
import com.hackernews.modelo.usuarioDAO;

@WebServlet("/registrar")

public class registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String nombreUsuario = request.getParameter("username");
		        String contraseña = request.getParameter("password");
		        
		        usuario u = new usuario();
		        u.setNombreUsuario(nombreUsuario);
		        u.setContraseña(contraseña);
		        
		        int existe = usuarioDAO.guardar(u);//Vemos si el query se ejecuto correctamnte
		        
		        if(existe>0) {
		        	HttpSession session = request.getSession();//Obtenemos la sesion
		        	
		        	usuario user=usuarioDAO.verificar(nombreUsuario, contraseña);//Pasamos a traer los atributos del nuevo usuario
		        	
					session.setAttribute("usuario", user);//Los ponemos en sesion
					
					response.sendRedirect("/proyectHNDB/Vista/menuPrincipal.jsp");//Redireccionamos al menu principal cuando iniciemos la sesion
		        }else {
		        	
		        	response.sendRedirect("/proyectHNDB/Vista/registrar-loguear/usuarioExistente.jsp");//En caso de que el usuario este registrado, evitamos que inicie sesion (Arreglarlo porque en Ycombinator muestra los campos de create Account unicamente)
		        	
		        }
	}

}
