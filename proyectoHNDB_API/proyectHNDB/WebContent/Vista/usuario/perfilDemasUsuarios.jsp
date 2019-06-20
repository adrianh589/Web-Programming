<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="com.hackernews.modelo.usuario"%>
	
	<%usuario user = (usuario) request.getAttribute("usuarioRecibido"); %>
	
<!DOCTYPE html>
<html op="user">
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/proyectHNDB/Vista/css/styles.css">
<link rel="shortcut icon" href="../img/y18.gif">
<title>Profile: <% out.write(user.getNombreUsuario()); %> | Hacker News</title>
</head>
<body>
	<center>
		<table id="hnmain" border="0" cellpadding="0" cellspacing="0"
			width="85%" bgcolor="#f6f6ef">
			<tr>
			
				<jsp:include page="/Vista/template/Header.jsp"></jsp:include>
				
			</tr>
			<tr id="pagespace" title="Profile: derwiki" style="height: 10px"></tr>
			<tr>
				<td><table border="0">
						<tr class='athing'>
							<td valign="top">user:</td>
							<td timestamp="1224721910"><a href="user?id=derwiki"
								class="hnuser"><% out.write(user.getNombreUsuario()); %></a></td>
						</tr>
						<tr>
							<td valign="top">created:</td>
							<td><a href="front?day=2008-10-23&birth=derwiki"><% out.write(user.getFecha_creacion().toString()); %></a></td>
						</tr>
						<tr>
							<td valign="top">karma:</td>
							<td><% out.print(user.getKarma()); %></td>
						</tr>
						<tr>
							<td valign="top">about:</td>
							<td><% if(user.getAcerca_de_mi()!=null){out.write(user.getAcerca_de_mi());} %></td>
						</tr>
						<tr>
							<td></td>
							<td><a href="submitted?id=derwiki"><u>submissions</u></a></td>
						</tr>
						<tr>
							<td></td>
							<td><a href="threads?id=derwiki"><u>comments</u></a></td>
						</tr>
						<tr>
							<td></td>
							<td><a href="favorites?id=derwiki"><u>favorites</u></a></td>
						</tr>
					</table> <br>
				<br></td>
			</tr>
		</table>
	</center>
</body>
<script type='text/javascript' src='hn.js?kq1kzKjRe95dmqHo68Cz'></script>
</html>
