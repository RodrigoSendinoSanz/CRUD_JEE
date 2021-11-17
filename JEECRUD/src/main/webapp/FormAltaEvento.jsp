<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de alta de eventos</title>
</head>
<link rel="stylesheet" href="CSS/style.css">
<body>
<h1>Formulario de alta de eventos</h1>

<form action="eventos?opcion=alta" method="post">
		<p>
		Nombre:<br>
		<input type="text" name="nombre"><br>
		</p>
		<p>
		Descripcion:<br>
		<textarea  name="descripcion" rows="4" cols="120"></textarea><br>
		</p>
		<p>
		Fecha de inicio:<br>
		<input type="date" name="fecha_inicio"><br>
		</p>
		<p>
		Duracion:<br>
		<input type="number" name="duracion"><br>
		</p>
		<p>
		Direccion:<br>
		<input type="text" name="direccion"><br>
		</p>
		<p>
		Estado:<br>
		<select name="estado">
		  <option value="ACTIVO"selected>ACTIVO</option>
		  <option value="RETRASADO">RETRASADO</option>
		  <option value="CANCELADO">CANCELADO</option>
		</select>
		</p>
		<p>
		Destacado:<br>
		<select name="destacado">
		  <option value="A">Prioridad alta</option>
		  <option value="B" selected>Prioridad media</option>
		  <option value="C">Prioridad baja</option>
		</select>
		</p>
		<p>
		Aforo maximo:<br>
		<input type="number" name="aforo_maximo"><br>
		</p>
		<p>
		Minimo asistencia:<br>
		<input type="number" name="minimo_asistencia"><br>
		</p>
		<p>
		Precio:<br>
		<input type="number" name="precio"><br>
		</p>
		
		<p><input id="link" type="submit" value="Enviar"></p>
	</form>
</body>
</html>