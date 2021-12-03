<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
	form {
	  border: 3px solid #f1f1f1;
	  margin: 30px;
      padding: 10px;
	}
	
	/* Full-width inputs */
	input[type=text], input[type=number]{
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
</style>
<body>
<h1>Alta de nuevo evento</h1>
<form action="/gestion/alta" method="post">

		<p>CosteReal:<br>
		<input type="number" name="costeReal"><br>
		</p>
		<p>CostesPrevisto:<br>
		<input type="number" name="costesPrevisto"><br>
		</p>
		<p>
		Descripcion:<br>
		<textarea  name="descripcion" rows="4" cols="120"></textarea><br>
		</p>
		
		<p>Estado:<br>
		<select name="estado">
		  <option value="ACTIVO"selected>ACTIVO</option>
		  <option value="RETRASADO">RETRASADO</option>
		  <option value="CANCELADO">CANCELADO</option>
		</select>
		</p>
		<p>
		Fecha de inicio:<br>
		<input type="date" name="fechaInicio"><br>
		</p>
		<p>
		Fecha de FinPrevisto:<br>
		<input type="date" name="fechaFinPrevisto"><br>
		</p>
		<p>
		Fecha de FinReal:<br>
		<input type="date" name="fechaFinReal"><br>
		</p>
		<p>VentaPrevisto:<br>
		<input type="number" name="ventaPrevisto"><br>
		</p>
		<p>Cliente del proyecto:<br>
		<select name="cliente">
		  <option value="AutocaresRamirez.S.L"selected>AutocaresRamirez.S.L</option>
		  <option value="TaxiSport.S.L">TaxiSport.S.L</option>
		  <option value="Uber.S.L">Uber.S.L</option>
		</select>
		<p>Jefe proyecto:<br>
		<select name="jefeProyecto">
		  <option value="Jose"selected>Jose</option>
		  <option value="Ana">Ana</option>
		  <option value="Pepe">Pepe</option>
		</select>

		
		<p><button id="link" type="submit">Enviar</button></p>
</form>
</body>
</html>