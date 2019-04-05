<%@page import="java.util.ArrayList"%>
<%@page import="noticias.Operaciones_noticia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="sesion.*"%>
<%@page import="registros.*"%>
<%@page import="usuario.*"%>

<%
	inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
	String[] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion

	//Variable para añadir los threads si hay un usuario que haya iniciado sesion
	String threads = " <a href=\"front\" id='" + retorno[0] + "' > threads</a> |";
	
	//variable para imprimir los threads si hay un usuario que inicio sesion
	boolean resultado = (!retorno[0].equals("ninguno")) ? true : false;
	
	//Instancia de las noticias
	Operaciones_noticia instanciaNotcias = new Operaciones_noticia();
	
	//Traemos las noticias publicadas por los usuarios
	ArrayList<Operaciones_noticia> noticias = instanciaNotcias.getArrayNoticias();
%>

<html op="news">
<head>
<meta charset="UTF-8">
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="shortcut icon" href="img/y18.gif">
<link rel="alternate" type="application/rss+xml" title="RSS" href="rss">
<title>.::Hacker News::.</title>
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
																			<%
										 	if (resultado == true) {
										 		out.write(threads);
										 	}
										 %> <a href="front">past</a>
									| <a href="newcomments">comments</a> | <a href="ask">ask</a> |
									<a href="show">show</a> | <a href="jobs">jobs</a> | <a
									href="submit.jsp">submit</a> </span></td>
							<td style="text-align: right; padding-right: 4px;"><span
								class="pagetop"> <%
							 	if (!retorno[0].equals("ninguno")) {
							 %> <a
																href="perfilUsuario.jsp?id=<%out.write(retorno[0]);%>"> <%
							 	out.write(retorno[0]);
							 %></a>
									(0) | <a href="CierreDeSesionServlet">logout</a>
									<%
										} else {
									%><a href="registro.jsp">login</a>
									<%
										}
									%>

							</span></td>
						</tr>
					</table></td>
			</tr>
			<tr id="pagespace" title="" style="height: 10px"></tr>
			<tr>
				<td><table border="0" cellpadding="0" cellspacing="0"
						class="itemlist">
						
						<%for(int i = 0; i < noticias.size(); i++){ %>
							<%if(noticias.get(i).isVisibilidad()==true){ %>
							<tr class='athing' id='19380990'>
							<td align="right" valign="top" class="title"><span
								class="rank"> <%out.print(i); %>.</span></td>
							<td valign="top" class="votelinks"><center>
									<a id='<%out.print(i); %>'
										href="http://localhost:8080/ProjectHackerNewsY/votarNoticiaServlet?Noticia=<%out.print(i); %>"><div
											class='votearrow' title='upvote'></div></a>
								</center></td>
							<td class="title"><a
								href="<%out.write(noticias.get(i).getUrl()); %>"
								class="storylink"><%out.write(noticias.get(i).getTitulo()); %></a><span class="sitebit comhead"> (<a
									href="from?site=polygon.com"><span class="sitestr"><%out.write(noticias.get(i).getHostName(noticias.get(i).getUrl())); %></span></a>)
							</span></td>
						</tr>
						<tr>
							<td colspan="2"></td>
							<td class="subtext"><span class="score" id="score_19380990"><%out.print(noticias.get(i).getPuntos()); %>
									points</span> by <a href="verPerfilesUsuariosServlet?autorNoticia=<%out.write(noticias.get(i).getAutorNoticia()); %>" class="hnuser"><%out.write(noticias.get(i).getAutorNoticia()); %></a> <span
								class="age"><a href="item?id=19380990">1 hour ago</a></span> <span
								id="unv_19380990"></span> | <a
								href="<%if (resultado == false) {%>hideError.jsp<%}else{%>http://localhost:8080/ProjectHackerNewsY/esconderMostrarNoticiaServlet?esconder=<%out.print(i);}%>">hide</a> | <a
								href="item?id=19380990">0&nbsp;comments</a></td>
						</tr>
						<tr class="spacer" style="height: 5px"></tr>
							<%} %>
						<%} %>
						
						
						<!--  <tr class="morespace" style="height: 10px"></tr>
						<tr>
							<td colspan="2"></td>
							<td class="title"><a href="news?p=2" class="morelink"
								rel="nofollow">More</a></td>
						</tr>-->
						
						
					</table></td>
			</tr>
			<tr>
				<td><img src="s.gif" height="10" width="0">
				<table width="100%" cellspacing="0" cellpadding="1">
						<tr>
							<td bgcolor="#ff6600"></td>
						</tr>
					</table>
					<br>
				<center>
						<a href="https://www.ycombinator.com/apply/"> Applications are
							open for YC Summer 2019 </a>
					</center>
					<br>
				<center>
						<span class="yclinks"><a
							href="https://news.ycombinator.com/newsguidelines.html">Guidelines</a>
							| <a href="https://news.ycombinator.com/newsfaq.html">FAQ</a> | <a
							href="mailto:hn@ycombinator.com">Support</a> | <a
							href="https://github.com/HackerNews/API">API</a> | <a
							href="https://news.ycombinator.com/security.html">Security</a> |
							<a href="lists">Lists</a> | <a href="bookMarklet.jsp"
							rel="nofollow">Bookmarklet</a> | <a
							href="http://www.ycombinator.com/legal/">Legal</a> | <a
							href="http://www.ycombinator.com/apply/">Apply to YC</a> | <a
							href="mailto:hn@ycombinator.com">Contact</a></span><br>
						<br>
						<form method="get" action="//hn.algolia.com/">
							Search: <input type="text" name="q" value="" size="17"
								autocorrect="off" spellcheck="false" autocapitalize="off"
								autocomplete="false">
						</form>
					</center></td>
			</tr>
		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?FUQ3zWqNVwHVyEpEQRQr'></script>
</html>