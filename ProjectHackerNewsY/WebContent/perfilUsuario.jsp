<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="sesion.*"%>
<%@page import="registros.registro"%>
<%@page import="usuario.usuario"%>

<link rel="stylesheet" type="text/css" href="css/styles.css">


<%
	inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
	ArrayList<usuario> usuarios = registro.getArrayUsuarios();//Obtenemos los usuarios que estan registados 

	String[] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion

	int id = Integer.parseInt(retorno[1]);//id del usuario con sesion abierta
	usuario usuarioActual = usuarios.get(id);//Objeto usuario con sesion abierta
	String emailUsuario = usuarioActual.getEmail();//Email del usuario con sesion abierta
	int karmaUsuario = usuarioActual.getKarma();//Karma del usuario con sesion abierta
	String nombreUsuario = usuarioActual.getNombreUsuario();//Nombre del usuario actual
	String fecha_creacionUsuario = usuarioActual.getFecha_creacion();///Fecha de creacion de la cuenta del usuario actual
	String acerca_de_miUsuario = usuarioActual.getAcerca_de_mi();//Acerca de mi del usuario
	int minAwayUsuario = usuarioActual.getMinAway();
	int delay = usuarioActual.getRetraso();
	String showDeadUsuario = usuarioActual.getShowdead();

	usuarioActual.obtenerDatos();
%>


<html op="user">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="news.css?wRwy7xNrRA8iSr8OOZLh">
<link rel="shortcut icon" href="favicon.ico">
<title>Profile: <%
	out.write(retorno[0]);
%> | Hacker News
</title>
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
								href="mainMenu.jsp"><img src="img/y18.gif" width="18"
									height="18" style="border: 1px white solid;"></a></td>
							<td style="line-height: 12pt; height: 10px;"><span
								class="pagetop"><b class="hnname"><a
										href="mainMenu.jsp">Hacker News</a></b> <a href="newest">new</a> |
									<a href="threads?id=adrianh_589">threads</a> | <a href="front">past</a>
									| <a href="newcomments">comments</a> | <a href="ask">ask</a> |
									<a href="show">show</a> | <a href="jobs">jobs</a> | <a
									href="submit.jsp">submit</a> </span></td>
							<td style="text-align: right; padding-right: 4px;"><span
								class="pagetop"> <a id='me' href="perfilUsuario.jsp">
										<%
											out.write(nombreUsuario);
										%>
								</a> (<%
									out.print(karmaUsuario);
								%>) | <a id='logout'
									href="CierreDeSesionServlet">logout</a>
							</span></td>
						</tr>
					</table></td>
			</tr>
			<tr id="pagespace" title="Profile: adrianh_589" style="height: 10px"></tr>
			<tr>
				<td><table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td bgcolor="#ffffaa"><table cellpadding="5" width="100%">
									<tr>

										<%
											if (emailUsuario == null) {
										%>
										<td>Please put a valid address in the email field, or we
											won't be able to send you a new password if you forget yours.
											Your address is only visible to you and us. Crawlers and
											other users can't see it.</td>
										<%
											}
										%>
										<%
											System.err.println(karmaUsuario);
										%>


									</tr>
								</table></td>
						</tr>
					</table>
					<form class="profileform" method="post"
						action="editarPerfilServlet">
						<input type="hidden" name="id" value="adrianh_589"><input
							type="hidden" name="hmac"
							value="5c0db96677bfe175fd860d4b90a4065eb8049e17">
						<table border="0">
							<tr class='athing'>
								<td valign="top">user:</td>
								<td timestamp="1550957118"><a href="user?id=adrianh_589"
									class="hnuser">
										<%
											out.write(nombreUsuario);
										%>
								</a></td>
							</tr>
							<tr>
								<td valign="top">created:</td>
								<td><a href="front?day=2019-02-23&birth=adrianh_589">
										<%
											out.write(fecha_creacionUsuario);
										%>
								</a></td>
							</tr>
							<tr>
								<td valign="top">karma:</td>
								<td>
									<%
										out.print(karmaUsuario);
									%>
								</td>
							</tr>
							<tr>
								<td valign="top">about:</td>
								<td><textarea cols="60" rows="5" wrap="virtual"
										name="about"">
										<%
											out.print(acerca_de_miUsuario);
										%>
</textarea> <font size="-2"><a href="formatdoc" tabindex="-1"><font
											color="#afafaf">help</font></a></font></td>
							</tr>
							<tr>
								<td valign="top">email:</td>
								<td><input type="text" name="uemail"
									value="<%out.print(emailUsuario);%>" size="60"></td>
							</tr>
							<tr>
								<td valign="top">showdead:</td>
								<td><select name="showd" id="showd">

										<%
											if (usuarioActual.getNoprocast().equals("yes")) {
										%>
										<option value="yes" selected>yes</option>
										<option value="no">no</option>
										<%
											} else {
										%>
										<option value="yes">yes</option>
										<option value="no" sselected>no</option>
										<%
											}
										%>

								</select></td>
							</tr>
							<tr>
								<td valign="top">noprocrast:</td>
								<td><select name="nopro"
									value="<%out.write(usuarioActual.getNoprocast());%>>"><option>yes</option>
										<option>no</option></select></td>
							</tr>
							<tr>
								<td valign="top">maxvisit:</td>
								<td><input type="number" name="maxv"
									value="<%out.print(usuarioActual.getVisitasMaximas());%>"
									size="16"></td>
							</tr>
							<tr>
								<td valign="top">minaway:</td>
								<td><input type="number" name="mina"
									value="<%out.print(minAwayUsuario);%>" size="16"></td>
							</tr>
							<tr>
								<td valign="top">delay:</td>
								<td><input type="number" name="delay"
									value="<%out.print(delay);%>" size="16"></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="cambioDeContrasena.jsp"><u>change password</u></a></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="submitted?id=adrianh_589"><u>submissions</u></a></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="threads?id=adrianh_589"><u>comments</u></a></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="hidden"><u>hidden</u></a></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="upvoted?id=adrianh_589"><u>upvoted
											submissions</u></a> / <a href="upvoted?id=adrianh_589&amp;comments=t"><u>comments</u></a>
									&nbsp;<span style='font-style: italic'>(private)</span></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="favorites?id=adrianh_589"><u>favorite
											submissions</u></a> / <a
									href="favorites?id=adrianh_589&amp;comments=t"><u>comments</u></a>
									&nbsp;<span style='font-style: italic'>(shared)</span></td>
							</tr>
						</table>
						<br>
						<input type="submit" value="update">
					</form> <br>
				<br></td>
			</tr>
		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?wRwy7xNrRA8iSr8OOZLh'></script>
</html>