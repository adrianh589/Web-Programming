<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="java.util.ArrayList"%>
<%@page import="sesion.*"%>
<%@page import="registros.registro"%>
<%@page import="usuario.usuario"%>
	
	<%
		inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
		ArrayList<usuario> usuarios = registro.getArrayUsuarios();//Obtenemos los usuarios que estan registados 
	
		String[] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion
	
		int id = Integer.parseInt(retorno[1]);//id del usuario con sesion abierta
		usuario usuarioActual = usuarios.get(id);//Objeto usuario con sesion abierta
		
		
	%>


<html op="changepw">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="shortcut icon" href="favicon.ico">
<title>Profile: <%out.print(usuarioActual.getNombreUsuario()); %> | Hacker News</title>
</head>
<body>
	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">
			<tr>
				<td bgcolor="#ff6600"><table border="0" cellpadding="0"
						cellspacing="0" width="100%" style="padding: 2px">
						<tr>
							<td style="width: 18px; padding-right: 4px"><a
								href="mainMenu.jsp"> <img src="img/y18.gif"
									width="18" height="18" style="border: 1px #ffffff solid;">
							</a></td>
							<td style="line-height: 12pt; height: 10px;"><span
								class="pagetop"> <b>Reset Password for <%out.print(usuarioActual.getNombreUsuario()); %></b>
								</span></td>
						</tr>
					</table></td>
			</tr>
			<tr style="height: 10px">
			</tr>
			<tr>
				<td>First, please put a valid email address in your <a
					href="perfilUsuario.jsp"><u>profile</u></a>. Otherwise you could
					lose your account if you mistype your new password.<br>
				<br>
					<form method="post" action="cambioDeContrasena">
						<input type="hidden" name="fnid" value="yBuE6BeQZi5t2TIGfT9r5s"><input
							type="hidden" name="fnop" value="changepw-page">
						<table border="0">
							<tr>
								<td>Current Password:</td>
								<td><input type="password" value="<% out.write(usuarioActual.getContraseña()); %>" name="oldpw" size="20"></td>
							</tr>
							<tr>
								<td>New Password:</td>
								<td><input type="password" name="pw" size="20"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Change"></td>
							</tr>
						</table>
					</form></td>
			</tr>
		</table>
	</center>
</body>
</html>