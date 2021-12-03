<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
	form {
	  border: 3px solid #f1f1f1;
	}
	
	/* Full-width inputs */
	input[type=text], input[type=password], input[type=email] {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  box-sizing: border-box;
	}
	
	/* Set a style for all buttons */
	button {
	  background-color: #04AA6D;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  cursor: pointer;
	  width: 100%;
	}
	
	/* Add a hover effect for buttons */
	button:hover {
	  opacity: 0.8;
	}
	
	/* Extra style for the cancel button (red) */
	.cancelbtn {
	  width: auto;
	  padding: 10px 18px;
	  background-color: #f44336;
	}
	
	/* Add padding to containers */
	.container {
	  padding: 16px;
	}
	
	/* The "Forgot password" text */
	span.psw {
	  float: right;
	  padding-top: 16px;
	}
	</style>
</head>
<body>
		<form action="loginvalidar" method="post">

		  <div class="container">
		    <label for="uname"><b>Numero de identificacion</b></label>
		    <input type="text" placeholder="Enter Username" name="idEmpl" required>
		
		    <label for="psw"><b>Correo</b></label>
		    <input type="email" placeholder="Enter Email" name="correo" required>
		    
		    <label for="psw"><b>Contraseña</b></label>
		    <input type="password" placeholder="Enter Password" name="password" required>
		
		    <button type="submit">Login</button>
		  </div>
		
		  <div class="container" style="background-color:#f1f1f1">
		    <button type="reset" class="cancelbtn">Cancel</button>
		    <span class="psw">Forgot <a href="#">password?</a></span>
		  </div>
		</form>
</body>
</html>