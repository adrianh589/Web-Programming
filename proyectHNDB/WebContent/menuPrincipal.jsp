<%@page import="java.util.ArrayList"%>
<%@page import="com.hackernews.usuario.usuario"%>
<%@page import="com.hackernews.noticia.*"%>
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
<link rel="shortcut icon" href="css/y18.gif">
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
										href='puntuar?idNoticia=<%out.print(i+1); %>'><div
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
									points</span> by <a href="user?id=apjana" class="hnuser"><%out.write(noticias.get(i).getAutor()); %></a> <span
								class="age"><a href="#"><%out.print(noticias.get(i).getFecha_publicacion()); %></a></span> <span
								id="unv_19606101"></span> | <a
								href="hide?id=19606101&amp;goto=news">hide</a> | <a
								href="item?id=19606101">3&nbsp;comments</a></td>
						</tr>
						<tr class="spacer" style="height: 5px"></tr>
						
						<%}%>
						
						<!--  <tr class="morespace" style="height: 10px"></tr>
						<tr>
							<td colspan="2"></td>
							<td class="title"><a href="news?p=2" class="morelink"
								rel="next">More</a></td>
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
						<span class="yclinks"><a href="newsguidelines.html">Guidelines</a>
							| <a href="newsfaq.html">FAQ</a> | <a
							href="mailto:hn@ycombinator.com">Support</a> | <a
							href="https://github.com/HackerNews/API">API</a> | <a
							href="security.html">Security</a> | <a href="lists">Lists</a> | <a
							href="bookmarklet.html" rel="nofollow">Bookmarklet</a> | <a
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
<script type='text/javascript' src='hn.js?QgdJSS42LNOZeZ6LTMlK'></script>
</html>
