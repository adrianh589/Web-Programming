package com.hackernews.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hackernews.modelo.usuario;
import com.hackernews.modelo.usuarioDAO;

@WebServlet("/iniciarSesion")

public class iniciarSesion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 
		String nombreUsuario = request.getParameter("acct");
        String contraseña = request.getParameter("pw");
        
        //AQUI TRAEMOS LOS DATOS DE LA BD
        usuario existe=usuarioDAO.verificar(nombreUsuario, contraseña);
        
        if(existe!=null) {
        	session = request.getSession(true);
			session.setAttribute("usuario", existe);
			
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);//Redireccionamos al menu principal cuando iniciemos la sesion
			
        }else {
        	request.getRequestDispatcher("/registrar-loguear/badLogin.jsp").forward(request, response);//Redireccionamos al bad login si se ingresaron mal los datos
        }
          
    }
	

}
