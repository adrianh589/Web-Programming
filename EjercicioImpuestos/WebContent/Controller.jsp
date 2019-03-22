<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    
    int vf  = Integer.parseInt(request.getParameter("vf"));//Valor futuro
    int ti =  Integer.parseInt(request.getParameter("ti"));//tasa de interes
    int pt =  Integer.parseInt(request.getParameter("pt"));//Periodo de tiempo
    String cosi = request.getParameter("type");//Compuesto o simple
    
    /*Fornmula
    	VA = VF (1 + i) ^n
    */
    
    double valorCompuesto = vf * Math.pow( 1 + ti, pt) ;
    double valorSimple = vf * ( 1 + pt * ti) ;
    
    DecimalFormat df = new DecimalFormat("#0.00000");
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculos</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<%if(cosi.equals("compuesto")){
	%><label>El valor calculado Compuesto es: <%out.print(df.format(valorCompuesto)); %></label><%
}else{
	%><label>El valor calculado Simple es: <%out.print(valorSimple); %></label>
<%}%>

</body>

<jsp:include page="Footer.jsp"></jsp:include>


</html>