<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="sesion.*"%>
    <%@page import="registros.*"%>
    <%@page import="usuario.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="icon" type="image/ico" href="img/y18.gif"/>
<title>Submit | Hacker News</title>
</head>
<body>

<% 
                              
                              inicio_de_sesion is = inicio_de_sesion.getInstanciaInicioSesion();//instancia de la clase
                              cierre_de_sesion cs = new cierre_de_sesion();//instancia de cerrar sesion
                              
                              String [] retorno = is.usuarioConSesionAbierta();//variable que almacena el usuario que inicio sesion
                              
                              ArrayList<usuario> prueba = registro.getArrayUsuarios();
                              
                              for(int i = 0; i < prueba.size(); i++){
                              	prueba.get(i).obtenerDatos();
                              }
                              
                              if(!retorno[0].equals("ninguno")){
                            	  %>
                            	  	
									<html op="submit">
									<head>
									<meta name="referrer" content="origin">
									<meta name="viewport" content="width=device-width, initial-scale=1.0">
									<link rel="stylesheet" type="text/css"
										href="news.css?wRwy7xNrRA8iSr8OOZLh">
									<link rel="shortcut icon" href="favicon.ico">
									<title>Submit | Hacker News</title>
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
																		height="18" style="border: 1px #ffffff solid;"></a></td>
																<td style="line-height: 12pt; height: 10px;"><span
																	class="pagetop"><b>Submit</b></span></td>
															</tr>
														</table></td>
												</tr>
												<tr style="height: 10px"></tr>
												<tr>
													<td><form method="post" action="submitServlet">
															<input type="hidden" name="fnid" value="9aGpRUSaGvEUjqaciZCI8j"><input
																type="hidden" name="fnop" value="submit-page">
															<script type="text/javascript">
																function tlen(el) {
																	var n = el.value.length - 80;
																	el.nextSibling.innerText = n > 0 ? n
																			+ ' too long' : '';
																}
															</script>
															<table border="0">
																<tr>
																	<td >title</td>
																	<td><input type="text" name="title" value="" size="50"
																		oninput="tlen(this)" onfocus="tlen(this)" required><span
																		style="margin-left: 10px"></span></td>
																</tr>
																<tr>
																	<td>url</td>
																	<td><input type="text" name="url" value="" size="50"></td>
																</tr>
																<tr>
																	<td></td>
																	<td><b>or</b></td>
																</tr>
																<tr>
																	<td>text</td>
																	<td><textarea name="text" rows="4" cols="49"></textarea></td>
																</tr>
																<tr>
																	<td></td>
																	<td></td>
																</tr>
																<tr>
																	<td></td>
																	<td><input type="submit" value="submit"></td>
																</tr>
																<tr style="height: 20px"></tr>
																<tr>
																	<td></td>
																	<td>Leave url blank to submit a question for discussion. If
																		there is no url, the text (if any) will appear at the top of
																		the thread.<br>
																	<br> You can also submit via <a href="bookMarklet.jsp"
																		rel="nofollow"><u>bookmarklet</u></a>.
																	</td>
																</tr>
															</table>
														</form></td>
												</tr>
											</table>
										</center>
									</body>
									</html>
<%
                              }else{
                            	  %>
                            	  	<html>
									<head>
									<meta http-equiv="refresh" content="0; url=http://localhost:8080/ProjectHackerNewsY/registro2.jsp ">
									</head>
									</body>
									</body>
									</html>
                            	  <%
                              }%>

</body>
</html>