<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de login</title>
</head>
<body>
	<form action="/login" method="post">
	    <input type="number" name="idEmpl" id="idEmpl" placeholder="Numero de empleado"><br><br>
	    <input type="email" name="correo" id="correo" placeholder="Email"><br><br>
	    <input type="password" name="password" id="password" placeholder="Contraseña"><br><br>
	    <input type="submit" value="Entrar">
	</form>
	<p>${mensaje}</p>
	<p>${mensaje2}</p>
</body>
</html>