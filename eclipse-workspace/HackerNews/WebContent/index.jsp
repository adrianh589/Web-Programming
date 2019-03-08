<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>.::Hacker News::.</title>
</head>
<body>
	<b>Login</b>
	<br>
	s<br>
	<form method="post" action="IngresoServlet">
	<input type="hidden" name="goto" value="news">
	<table border="0"><tr><td>username:</td><td><input type="text" name="acct" size="20" autocorrect="off" spellcheck="false" autocapitalize="off" autofocus="true"></td></tr><tr><td>password:</td><td><input type="password" name="pw" size="20"></td></tr></table><br>
	<input type="submit" value="login"></form><a href="forgot">Forgot your password?</a><br><br>
	
	<b>Create Account</b><br><br>
	<form method="post" action="mainServletAH">
	<input type="hidden" name="goto" value="news">
	<input type="hidden" name="creating" value="t">
	<table border="0"><tr><td>username:</td>
	<td><input type="text" name="username" size="20" autocorrect="off" spellcheck="false" autocapitalize="off"></td>
	</tr>
	<tr><td>password:</td><td><input type="password" name="password" size="20"></td></tr>
	</table>
	
	<br>
	<input type="submit" value="create account">
	</form>

</body>
</html>