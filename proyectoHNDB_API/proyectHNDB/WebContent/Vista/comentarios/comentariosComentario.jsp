<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@page import="com.hackernews.modelo.usuario"%>
		<%@page import="java.util.ArrayList"%>
	
	<%
	
		usuario user = (usuario) session.getAttribute("usuario") ;
	
	%>
	
<!DOCTYPE html>
<html op="reply">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="news.css?zmv1cFqwP2NxAzHrEq4q">
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/proyectHNDB/Vista/css/styles.css">
<title>Add Comment | Hacker News</title>
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
								href="https://news.ycombinator.com"><img src="y18.gif"
									width="18" height="18" style="border: 1px white solid;"></a></td>
							<td style="line-height: 12pt; height: 10px;"><span
								class="pagetop"><b>Add Comment</b></span></td>
						</tr>
					</table></td>
			</tr>
			<tr id="pagespace" title="Add Comment" style="height: 10px"></tr>
			<tr>
				<td><table class="fatitem" border="0">
						<tr class='athing' id='19793552'>
							<td class='ind'></td>
							<td valign="top" class="votelinks"><center>
									<a id='up_19793552' onclick='return vote(event, this, "up")'
										href='vote?id=19793552&amp;how=up&amp;auth=c803056bad94dbb4b24e450c5791ef6663de2d94&amp;goto=reply%3Fgoto%3Ditem%253Fid%253D19791683%252319793552%26id%3D19793552#19793552'><div
											class='votearrow' title='upvote'></div></a>
								</center></td>
							<td class="default"><div
									style="margin-top: 2px; margin-bottom: -10px;">
									<span class="comhead"> <a href="user?id=basetop"
										class="hnuser"><%=request.getParameter("usuarioAutor") %></a> <span class="age"><a
											href="item?id=19793552">42 minutes ago</a></span> <span
										id="unv_19793552"></span><span class="par"> | <a
											href="item?id=19793486">parent</a></span> <a class="togg" n="1"
										href="javascript:void(0)"
										onclick="return toggle(event, 19793552)"></a> <span
										class='storyon'> | on: <a href="item?id=19791683"><%= request.getParameter("nombreNoticia") %></a></span>
									</span>
								</div>
								<br>
							<div class="comment">
									<span class="commtext c00"><%=request.getParameter("contenido") %> </span>
									<div class='reply'></div>
								</div></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td colspan="2"></td>
							<td>
								<form method="get" action="/proyectHNDB/comentarComentario?idnoticia=<%=request.getParameter("idnoticia")%>">
									<input type="hidden" name="parent" value="19793552"><input
										type="hidden" name="goto" value="item?id=19791683#19793552"><input
										type="hidden" name="hmac"
										value="9761cba20326250b9ee725fe9e32054f0593be80">
									<textarea name="text" rows="6" cols="60"></textarea>
									
									
									<input type="hidden" value="<%=request.getParameter("idusuario")%>" name="idusuario"/>
									<input type="hidden" value="<%=request.getParameter("idcomentario")%>" name="idcomentario"/>
									<input type="hidden" value="<%=request.getParameter("idnoticia")%>" name="idnoticia"/>
									
									
									<br>
									<br>
									<input type="submit" value="reply">
								</form>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?zmv1cFqwP2NxAzHrEq4q'></script>
</html>
