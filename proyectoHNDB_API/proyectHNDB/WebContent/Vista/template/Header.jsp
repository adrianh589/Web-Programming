<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.hackernews.modelo.usuario"%>
	
	<%
		usuario user = (usuario) session.getAttribute("usuario") ;	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<tr>
		<td bgcolor="#ff6600"><table border="0" cellpadding="0"
				cellspacing="0" width="100%" style="padding: 2px">
				<tr>
					<td style="width: 18px; padding-right: 4px"><a href="/proyectHNDB/Vista/menuPrincipal.jsp"><img
							src="/proyectHNDB/Vista/img/y18.gif" width="18" height="18"
							style="border: 1px white solid;"></a></td>
					<td style="line-height: 12pt; height: 10px;"><span
						class="pagetop"><b class="hnname"><a href="/proyectHNDB/Vista/menuPrincipal.jsp">Hacker
									News</a></b> <a href="#">new</a> | <a href="#">past</a> | <a href="#">comments</a>
							| <a href="#">ask</a> | <a href="#">show</a> | <a href="#">jobs</a>
							| 	<%
 									if (user == null) {
 								%><a href="/proyectHNDB/Vista/registrar-loguear/badLogin.jsp?variable=submit">submit</a> <%
								} else {
							%>
								<a href="/proyectHNDB/Vista/submit/submit.jsp">submit</a>
							<%
								}
							%>
							
							</span></td>
					<td style="text-align: right; padding-right: 4px;"><span
						class="pagetop"> <%
 							if (user == null) {
 							%><a
							href="/proyectHNDB/Vista/registrar-loguear/registro.jsp">login</a>
							<%
								} else {
							%><a href="/proyectHNDB/Vista/usuario/perfilUsuario.jsp">${usuario.getNombreUsuario()} </a>
							(${usuario.getKarma()}) | <a href="/proyectHNDB/cerrarSesion">logout </a>
							<%
								}
							%>
					</span></td>
				</tr>
			</table></td>
	</tr>

</body>
</html>