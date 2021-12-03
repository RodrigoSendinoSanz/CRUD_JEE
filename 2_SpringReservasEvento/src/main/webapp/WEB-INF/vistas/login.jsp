<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Login</title>
</head>
<style type="text/css">
	form {
	  border: 3px solid #f1f1f1;
	}
	
	/* Full-width inputs */
	input[type=text], input[type=password] {
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
	  font-size: large;
	  border: none;
	  cursor: pointer;
	  width:200%;
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
<body>
<form action="/usuario/login" method="POST">
 <div class="container">
    <table>
        <tr>
            <td>Usuario</td>
            <td><input type="text" name="user" required></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="pass" required></td>
        </tr>
        <tr>
            <td><button type="submit" >Login</button></td>
        </tr>
    </table>
    ${error_usuario}
    </div>
</form>
</body>
</html>