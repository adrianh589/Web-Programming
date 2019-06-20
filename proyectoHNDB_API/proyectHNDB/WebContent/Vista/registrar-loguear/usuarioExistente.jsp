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
	That username is taken. Please choose another.
	<br>
	<br>
	<b>Create Account</b>
	<br>
	<br>
	<form method="post" action="/proyectHNDB/registrar">
		<input type="hidden" name="goto" value="news"><input
			type="hidden" name="creating" value="t"><input type="hidden"
			name="switch" value="register">
		<table border="0">
			<tr>
				<td>username:</td>
				<td><input type="text" name="acct" value=""
					size="20" autocorrect="off" spellcheck="false" autocapitalize="off"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="pw" value="" size="20"></td>
			</tr>
		</table>
		<br> <input type="submit" value="create account">
	</form>
</body>
</html>
