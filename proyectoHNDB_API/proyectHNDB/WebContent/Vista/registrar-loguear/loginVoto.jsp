<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta name="referrer" content="origin">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
</head>
<body>
	You have to be logged in to vote.
	<br>
	<br>
	<b>Login</b>
	<br>
	<br>
	<form method="post" action="../../iniciarSesion">
		<input type="hidden" name="goto" value="news">
		<table border="0">
			<tr>
				<td>username:</td>
				<td><input type="text" name="acct" size="20" autocorrect="off"
					spellcheck="false" autocapitalize="off" autofocus="true" required></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="pw" size="20" required></td>
			</tr>
		</table>
		<br> <input type="submit" value="login">
	</form>
	<a href="forgot">Forgot your password?</a>
	<br>
	<br>

	<b>Create Account</b>
	<br>
	<br>
	<form method="post" action="../../registrar">
		<input type="hidden" name="goto" value="news"> <input
			type="hidden" name="creating" value="t">
		<table border="0">
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" size="20"
					autocorrect="off" spellcheck="false" autocapitalize="off" required></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" size="20" required></td>
			</tr>
		</table>

		<br> <input type="submit" value="create account">
	</form>

</body>
</html>