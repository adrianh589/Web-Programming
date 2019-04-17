<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.hackernews.modelo.usuario"%>
	
	<% usuario user = (usuario) session.getAttribute("usuario") ;
	
	String showdead = user.getShowdead();
	String noprocast = user.getNoprocast();
	%>
	
<!DOCTYPE html>
<html op="user">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="../css/styles.css">
<link rel="shortcut icon" href="favicon.ico">
<title>Profile: ${usuario.getNombreUsuario()} | Hacker News</title>



</head>
<body>
	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">
			
			<jsp:include page="/Vista/template/Header.jsp"></jsp:include>
			
		
		
			<tr id="pagespace" title="Profile: adrianh_589" style="height: 10px"></tr>
			<tr>
				<td>
				
				<%if(user.getEmail()==null || user.getEmail().equals("")){%>
				<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td bgcolor="#ffffaa"><table cellpadding="5" width="100%">
									<tr>
										<td>Please put a valid address in the email field, or we
											won't be able to send you a new password if you forget yours.
											Your address is only visible to you and us. Crawlers and
											other users can't see it.</td>
									</tr>
								</table></td>
						</tr>
					</table>
					
					<% } %>
					
					<form class="profileform" method="get" action="../../actualizarDatosUsuario">
						<input type="hidden" name="id" value="adrianh_589"><input
							type="hidden" name="hmac"
							value="5c0db96677bfe175fd860d4b90a4065eb8049e17">
						<table border="0">
							<tr class='athing'>
								<td valign="top">user:</td>
								<td timestamp="1550957118"><a href="user?id=adrianh_589"
									class="hnuser">${usuario.getNombreUsuario()}</a></td>
							</tr>
							<tr>
								<td valign="top">created:</td>
								<td><a href="front?day=2019-02-23&birth=adrianh_589">${usuario.getFecha_creacion()}</a></td>
							</tr>
							<tr>
								<td valign="top">karma:</td>
								<td>${usuario.getKarma()}</td>
							</tr>
							<tr>
								<td valign="top">about:</td>
								<td><textarea cols="60" rows="5" wrap="virtual"
										name="about">
${usuario.getAcerca_de_mi()}</textarea> <font size="-2"><a href="formatdoc" tabindex="-1"><font
											color="#afafaf">help</font></a></font></td>
							</tr>
							<tr>
								<td valign="top">email:</td>
								<td><input type="text" name="uemail" value="${usuario.getEmail()}" size="60"></td>
							</tr>
							<tr>
								<td valign="top">showdead:</td>
								<td>
								
								<%if(showdead.equals("yes")) { %>
								<select name="showdead">
								<option selected>yes</option>
								<option >no</option></select>
								<% }else{ %>	
								<select name="showdead">
								<option>yes</option>
								<option selected>no</option></select>
								<%} %>	
							</tr>
							<tr>
								<td valign="top">noprocrast:</td>
								<td>	
								
								<%if(noprocast.equals("yes")) { %>
								<select name="noprocast">
								<option selected>yes</option>
								<option >no</option></select>
								<% }else{ %>	
								<select name="noprocast">
								<option>yes</option>
								<option selected>no</option></select>
								<%} %>	
										</td>
							</tr>
							<tr>
								<td valign="top">maxvisit:</td>
								<td><input type="text" name="maxv" value="${usuario.getVisitasMaximas()}" size="16"></td>
							</tr>
							<tr>
								<td valign="top">minaway:</td>
								<td><input type="text" name="mina" value="${usuario.getMinAway()}" size="16"></td>
							</tr>
							<tr>
								<td valign="top">delay:</td>
								<td><input type="text" name="delay" value="${usuario.getRetraso()}" size="16"></td>
							</tr>
							<tr>
								<td></td>
								<td><a href="changepw"><u>change password</u></a></td>
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
<script type='text/javascript' src='hn.js?CKdj6sCCb4nsO5niHXII'></script>
</html>
