<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasa de interes compuesto</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<form action="Controller.jsp" method="post">

<div>
	<label>Valor:</label>
	<input type="number" name="vf">
</div>

<div>
	<label>Tasa de interes </label>
	<input type="number" name="ti">
</div>

<div>
	<label>Compuesto o simple? </label><br>
	<label>Compuesto </label><input type="radio" name="type" value="compuesto"><br>
	<label>Simple </label><input type="radio" name="type" value="simple">
</div>

<div>
	<label>Periodo de tiempo</label>
	<input type="number" name="pt">
</div>

<button type="submit">Enviar</button>

</form>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>