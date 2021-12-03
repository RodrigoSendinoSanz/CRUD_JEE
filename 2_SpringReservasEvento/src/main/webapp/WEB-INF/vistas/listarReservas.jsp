<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/main.css" rel="stylesheet" />
<title>Listar ${tipoListar}</title>
</head>
<body>
<h1>Listar reservas</h1>
	<table border="1">
		<tr>
			<th>ID Reserva</th>
			<th>ID Evento</th>
			<th>Precio Venta</th>
			<th>Observaciones</th>
			<th>Cantidad</th>
			<th>Precio Total</th>
		</tr>
		<c:forEach var="ele" items="${reservas}">
			<tr>
				<th>${ele.idReserva}</th>
				<th>${ele.idEvento}</th>
				<th>${ele.precioVenta}</th>
				<th>${ele.observaciones}</th>
				<th>${ele.cantidad}</th>
				<th>${ele.cantidad * ele.precioVenta}</th>
			</tr>
		</c:forEach>
	</table>
	<a href="/">Inicio</a>
</body>
</html>