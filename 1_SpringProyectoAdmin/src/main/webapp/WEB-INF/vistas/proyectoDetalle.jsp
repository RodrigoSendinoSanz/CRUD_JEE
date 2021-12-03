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
			<th class="ui-helper-center" id="cablista">Id Proyecto</th>
			<th  class="ui-helper-center" id="cablista">Coste Real</th>
			<th  class="ui-helper-center" id="cablista">Costes Previsto</th>
			<th  class="ui-helper-center" id="cablista">Descripcion</th>
			<th  class="ui-helper-center" id="cablista">Estado</th>
			<th  class="ui-helper-center" id="cablista">Fecha Fin Previsto</th>
			<th  class="ui-helper-center" id="cablista">Fecha Fin Real</th>
			<th  class="ui-helper-center" id="cablista">Fecha Inicio</th>
			<th  class="ui-helper-center" id="cablista">Venta Previsto</th>
			<th  class="ui-helper-center" id="cablista">Numero de empleados de ${proyecto.cliente.getNombre()}</th>
			<th  class="ui-helper-center" id="cablista">Jefe Proyecto</th>
		</tr>
		<tr>
			<th class="morado">${proyecto.idProyecto}</th>
			<th class="morado">${proyecto.costeReal}</th>
			<th class="morado">${proyecto.costesPrevisto}</th>
			<th class="morado">${proyecto.descripcion}</th>
			<th class="morado">${proyecto.estado}</th>
			<th class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${proyecto.fechaFinPrevisto}"/></th>
			<th class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${proyecto.fechaFinReal}"/></th>
			<th class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${proyecto.fechaInicio}"/></th>
			<th class="morado">${proyecto.ventaPrevisto}</th>
			<th class="morado">${proyecto.cliente.getNumeroEmpleados()}</th>
			<th class="morado">${proyecto.jefeProyecto.getNombre()}</th>
		</tr>
	</table>

	<a href="/jefe/proyectos">Inicio</a>
</body>
</html>