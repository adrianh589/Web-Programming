<%@page import="com.hackernews.modelo.comentarioDAO"%>
<%@page import="com.hackernews.modelo.comentario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.hackernews.modelo.noticia"%>
<%@page import="com.hackernews.modelo.usuario"%>

<%
	noticia noticia = (noticia) request.getAttribute("noticiaSeleccionada");
	ArrayList<comentario> comentarios = comentarioDAO.obtenerComentariosPorIdNoticia(noticia.getId());
	usuario user = (usuario) session.getAttribute("usuario");
	
%>

<!DOCTYPE html>
<html op="item">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/proyectHNDB/Vista/css/styles.css">
<link rel="shortcut icon" href="favicon.ico">
<title><%=noticia.getTitulo()%> | Hacker News</title>
</head>
<body>
	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">


			<jsp:include page="/Vista/template/Header.jsp"></jsp:include>


			<tr id="pagespace" title="<%=noticia.getTitulo()%>"
				style="height: 10px"></tr>
			<tr>
				<td><table class="fatitem" border="0">
						<tr class='athing' id='19693253'>
							<td align="right" valign="top" class="title"><span
								class="rank"></span></td>
							<td valign="top" class="votelinks"><center>
									<a id='up_19693253' onclick='return vote(event, this, "up")'
										href='vote?id=19693253&amp;how=up&amp;auth=900706e0cbf87cd017524c3ae3cb2919200a69f8&amp;goto=item%3Fid%3D19693253'><div
											class='votearrow' title='upvote'></div></a>
								</center></td>
							<td class="title"><a href="<%=noticia.getUrl()%>"
								class="storylink" rel="nofollow"><%=noticia.getTitulo()%></a><span
								class="sitebit comhead"> (<a href="from?site=kite.com"><span
										class="sitestr"><%=noticia.getHost()%></span></a>)
							</span></td>
						</tr>
						<tr>
							<td colspan="2"></td>
							<td class="subtext"><span class="score" id="score_19693253"><%=noticia.getPuntos()%>
									point</span> by <a href="user?id=brendanmcd" class="hnuser"><%=noticia.getAutor()%></a>
								<span class="age"><a href="item?id=19693253">0
										minutes ago</a></span> <span id="unv_19693253"></span> | <a
								href="hide?id=19693253&amp;auth=900706e0cbf87cd017524c3ae3cb2919200a69f8&amp;goto=item%3Fid%3D19693253">hide</a>
								| <a
								href="https://hn.algolia.com/?query=Flask%20vs.%20Django&sort=byDate&dateRange=all&type=story&storyText=false&prefix&page=0"
								class="hnpast">past</a> | <a
								href="https://www.google.com/search?q=Flask%20vs.%20Django">web</a>
								| <a
								href="fave?id=19693253&amp;auth=900706e0cbf87cd017524c3ae3cb2919200a69f8">favorite</a>
								| <a href="item?id=19693253">discuss</a></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td colspan="2"></td>
							<td>
								<form method="post"
									action="/proyectHNDB/comentar?idNoticia=<%=noticia.getId()%>">
									<input type="hidden" name="parent" value="19693253"><input
										type="hidden" name="goto" value="item?id=19693253"><input
										type="hidden" name="hmac"
										value="0c383273dc0056dc12fa91c9fb50a265919b0d49">
									<textarea name="text" rows="6" cols="60"></textarea>
									<br> <br> <input type="submit" value="add comment">
								</form>
							</td>
						</tr>
					</table> <br> <br>



					<table border="0" class="comment-tree">
						<tbody>

							<%
								for (int i = 0; i < comentarios.size(); i++) {
							%>
							<tr class="athing comtr " id="19695810">
								<td>
									<table border="0">
										<tbody>
											<tr>
												<td class="ind"><img src="s.gif" height="1" width="0"></td>
												<td valign="top" class="votelinks"><center>
														<a id="up_19695810"
															href="vote?id=19695810&amp;how=up&amp;goto=item%3Fid%3D19695477"><div
																class="votearrow" title="upvote"></div></a>
													</center></td>
												<td class="default"><div
														style="margin-top: 2px; margin-bottom: -10px;">
														<span class="comhead"> <a href="user?id=phildo3"
															class="hnuser"><%=comentarios.get(i).getAutor()%></a> <span
															class="age"><a href="item?id=19695810"><%=comentarios.get(i).getFecha_creacion()%></a></span>
															<span id="unv_19695810"></span><span class="par"></span>
															<a class="togg" n="1" href="javascript:void(0)"
															onclick="return toggle(event, 19695810)">[-]</a> <span
															class="storyon"></span>
														</span>
													</div> <br>
													<div class="comment">
														<span class="commtext c00"><%=comentarios.get(i).getContenido()%></span>
														<div class="reply">
															<p>
																<font size="1"> <u><a
																		href="/proyectHNDB/Vista/comentarios/comentariosComentario.jsp?usuarioAutor=<%=user.getNombreUsuario()%>&idcomentario=<%=comentarios.get(i).getId()%>&idnoticia=<%=comentarios.get(i).getId_noticia()%>&nombreNoticia=<%=comentarios.get(i).getNombreNoticia()%>&contenido=<%=comentarios.get(i).getContenido()%>&idusuario=<%=user.getId()%>">reply</a></u>
																</font>
															</p>
														</div>
													</div></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>

							<!-- Esto es de los ocmentarios de los comentarios -->
							<%
								ArrayList<comentario> comentariosComentario = comentarioDAO
											.obtenerComentariosdeComentario(comentarios.get(i).getId());

									for (int j = 0; j < comentariosComentario.size(); j++) {
							%>
							<tr class="athing comtr " id="19821705">
								<td>
									<table border="0">
										<tbody>
											<tr>
												<td class="ind"><img src="s.gif" height="1" width="40"></td>
												<td valign="top" class="votelinks"><center>
														<a id="up_19821705"
															href="vote?id=19821705&amp;how=up&amp;goto=item%3Fid%3D19819636"><div
																class="votearrow" title="upvote"></div></a>
													</center></td>
												<td class="default"><div
														style="margin-top: 2px; margin-bottom: -10px;">
														<span class="comhead"> <a href="user?id=marmaduke"
															class="hnuser"><%=comentariosComentario.get(j).getAutor() %></a> <span class="age"><a
																href="item?id=19821705">0 minutes ago</a></span> <span
															id="unv_19821705"></span><span class="par"></span> <a
															class="togg" n="1" href="javascript:void(0)"
															onclick="return toggle(event, 19821705)">[-]</a> <span
															class="storyon"></span>
														</span>
													</div>
													<br>
												<div class="comment">
														<span class="commtext c00"><%=comentariosComentario.get(j).getContenido() %></span>
													</div></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<%
								}
							%>

							<!-- Esto es de los ocmentarios de los comentarios -->
							<%
								}
							%>


						</tbody>
					</table></td>
			</tr>

			<jsp:include page="/Vista/template/Footer.jsp"></jsp:include>


		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?oDXVjRWEmQHY91M1gmHN'></script>
</html>
