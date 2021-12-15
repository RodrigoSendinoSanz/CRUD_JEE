<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Jefe Proyecto</title>
</head>
<body>
	<h1>Control de proyectos</h1>
	<h2>Jefe de Proyecto: ${empleado.nombre}</h2>
	<a href="/cerrarSesion"><button>Salir</button></a>
	<br><br>
	<div>
		<table border="2px">
			<thead>
				<tr>
					<th>IdProyecto</th>
					<th>Descripcion</th>
					<th>Estado</th>
					<th colspan=1>opciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="proy" items="${proyectosJefe}">
				<tr>
					<td>${proy.idProyecto}</td>
					<td>${proy.descripcion}</td>
					<td>${proy.estado}</td>
					<td><a href="/jefe/verDetalle/${proy.idProyecto}">Ver Detalle</a></td>
					
				</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr><th colspan=5> Listado de proyectos activos de ${sesionEmp.nombre}</th></tr>
			</tfoot>
		</table>
	</div>
	<p>${mensajeAlta}</p><br>
</body>
</html>