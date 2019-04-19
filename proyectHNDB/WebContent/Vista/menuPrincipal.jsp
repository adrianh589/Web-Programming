<%@page import="java.util.ArrayList"%>
<%@page import="com.hackernews.controlador.*"%>
<%@page import="com.hackernews.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%ArrayList<noticia> noticias = noticiaDAO.obtenerNoticias(); %>
	
<!DOCTYPE html>
<html op="news">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="css/styles.css">
<link rel="alternate" type="application/rss+xml" title="RSS" href="rss">
<title>Hacker News</title>
</head>
<body>

	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">
			
			<jsp:include page="template/Header.jsp"></jsp:include>
			
			<tr id="pagespace" title="" style="height: 10px"></tr>
			<tr>
				<td><table border="0" cellpadding="0" cellspacing="0"
						class="itemlist">
			
			<%for(int i = 0; i < noticias.size(); i++){ %>
			
			
						
						<tr class='athing' id='19606101'>
							<td align="right" valign="top" class="title"><span
								class="rank"><%out.print(i+1); %>.</span></td>
							<td valign="top" class="votelinks"><center>
									<a id='<%out.print(i); %>'
										href='../puntuar?idNoticia=<%out.print(i+1); %>'><div
											class='votearrow' title='upvote'></div></a>
								</center></td>
							<td class="title"><a href="<%out.write(noticias.get(i).getUrl()); %>"
								class="storylink"><%out.write(noticias.get(i).getTitulo()); %></a><span class="sitebit comhead"> <% if(!noticias.get(i).getHost().equals("")){%> (<a
									href="<%out.write(noticias.get(i).getUrl());%>"><span class="sitestr"><%out.write(noticias.get(i).getHost()); %></span></a>)<%} %>
							</span></td>
						</tr>
						<tr>
							<td colspan="2"></td>
							<td class="subtext"><span class="score" id="score_19606101"><%out.print(noticias.get(i).getPuntos()); %>
									points</span> by <a href="../verUsuario?user=<%out.print(noticias.get(i).getId_usuario()); %>" class="hnuser"><%out.write(noticias.get(i).getAutor()); %></a> <span
								class="age"><a href="#"><%out.print(noticias.get(i).getFecha_publicacion()); %></a></span> <span
								id="unv_19606101"></span> | <a
								href="hide?id=19606101&amp;goto=news">hide</a> | <a
								href="/proyectHNDB/comentar?noticiaid=<%out.print(i+1); %>">discuss</a></td>
						</tr>
						<tr class="spacer" style="height: 5px"></tr>
						
						<%}%>
						
					</table></td>
			</tr>
			
			
			<jsp:include page="template/Footer.jsp"></jsp:include>
			
		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?QgdJSS42LNOZeZ6LTMlK'></script>
</html>
