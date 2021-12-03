<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link href="/css/main.css" rel="stylesheet" />
<title>Login</title>
</head>
<body>
	<table border="1"  class="tabladatos">
		<tr>
			<th class="ui-helper-center" id="cablista">Id</th>
			<th  class="ui-helper-center" id="cablista">Nombre</th>
			<th  class="ui-helper-center" id="cablista">Fecha Inicio</th>
			<th  class="ui-helper-center" id="cablista">Duracion</th>
			<th  class="ui-helper-center" id="cablista">Direccion</th>
			<th  class="ui-helper-center" id="cablista">Estado</th>
			<th  class="ui-helper-center" id="cablista">Destacado</th>
			<th  class="ui-helper-center" id="cablista">Aforo maximo</th>
			<th  class="ui-helper-center" id="cablista">Asistencia minima</th>
			<th  class="ui-helper-center" id="cablista">Precio</th>
		</tr>
		<tr>
			<th class="morado">${evento.idEvento}</th>
			<th class="morado">${evento.nombreEvento}</th>
			<th class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${evento.fecha_inicio}"/></th>
			<th class="morado">${evento.duracion}</th>
			<th class="morado">${evento.direccion}</th>
			<th class="morado">${evento.estado}</th>
			<th class="morado">${evento.destacado}</th>
			<th class="morado">${evento.aforo_maximo}</th>
			<th class="morado">${evento.asistencia_minima}</th>
			<th class="morado">${evento.precio}</th>
		</tr>
	</table>
	<br>
	<br>
	<h3>Te quedan disponibles ${10 - reservaUsu.cantidad}</h3>
	<form action="/reservas/verificarpedido/${evento.idEvento}"
		method="POST">
		Cantidad entradas:<input type="number" name="cantidadEntradas"><br>
		<br> <input type="submit" value="Comprar entradas">
	</form>
	${mensaje_compra}
	<br>
	<a href="/">Inicio</a>
	<br>
	<a href="/activos">Ver activos</a>
	<br>
	<a href="/destacados">Ver destacados</a>
	<br>
</body>
</html>