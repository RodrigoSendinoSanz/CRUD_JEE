<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/main.css" rel="stylesheet" />
<title>Listar ${tipoListar}</title>
</head>
<body>
	<h1>Listar ${tipoListar}</h1>
	<table border="1" id="lista">
		<tr>
			<th id="cablista">Nombre</th>
			<th id="cablista">Fecha Inicio</th>
			<th id="cablista">Aforo maximo</th>
			<th id="cablista">Opciones</th>
		</tr>
		<c:forEach var="ele" items="${eventos}">
			<tr>
				<th  id="tabla" class="morado">${ele.nombreEvento}</th>
				<th  id="tabla" class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${ele.fecha_inicio}"/></th>
				<th  id="tabla" class="morado">${ele.aforo_maximo}</th>
				<th  id="tabla" class="morado"><a href="/reservas/reserva/${ele.idEvento}">Detalle</a></th>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/">Inicio</a><br>
	<a href="/activos">Ver activos</a><br>
	<a href="/destacados">Ver destacados</a><br>
</body>
</html>