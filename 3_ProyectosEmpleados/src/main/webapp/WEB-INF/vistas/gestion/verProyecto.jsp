<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Proyectos</title>
</head>
<body>
	<h1>Informaci�n del  Proyecto : ${proyecto.idProyecto }</h1>
	 
	<br><br>
	<div>
		<table border="2px">
			<thead>
				<tr>
					 
					<th>Descripcion</th>
					<th>Estado</th>
					<th>Fecha Inicio</th>
					<th>Fecha Fin</th>
					<th>Presupuesto</th>
					<th>Costes Previstos</th>
					<th>Cliente</Th>
					<th>Jefe de Proyecto</th>
				</tr>
			</thead>
			<tbody>
				 
					<tr>
						 
						<td>${proyecto.descripcion}</td>
						<td>${proyecto.estado}</td>
						<td><fmt:formatDate value="${proyecto.fechaInicio}" pattern="dd-MM-yyyy"/></td>
						<td><fmt:formatDate value="${proyecto.fechaFinPrevisto}" pattern="dd-MM-yyyy"/></td>
						<td style="text-align:right"><fmt:formatNumber type="number" value="${proyecto.ventaPrevisto}" maxFractionDigits="2"/>&#8364;</td>
						<td style="text-align:right"><fmt:formatNumber type="number" value="${proyecto.costesPrevisto}" maxFractionDigits="2"/>&#8364;</td>
						<td>${proyecto.cliente.nombre}</td>
						<td>${proyecto.jefeProyecto.nombre}</td>
					</tr>
			 
			</tbody>
			<tfoot>
				<tr><th colspan=9> Info de proyecto</th></tr>
			</tfoot>
		</table>
	<table border="2px">
			<thead>
				<tr>
					<th>N�m Orden</th>
					<th>Empleado</th>
					<th>Fecha Incorporaci�n</th>
					<th>Horas asignadas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pce" items="${proyecto.proyectoConEmpleados}">
					<tr>
						<td>${pce.numeroOrden}</td>
						<td>${pce.empleado.nombre}</td>
						<td><fmt:formatDate value="${pce.fechaIncorporacion}" pattern="dd-MM-yyyy"/></td>
						<td>${pce.horasAsignadas}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr><th colspan=8> Empleados asignados al proyecto</th></tr>
			</tfoot>
		</table>
		<br>
		<table border="2px">
			<thead>
				<tr>
					<th>N�m Orden</th>
					<th>Producto</th>
					<th>Cantidad</th>
					<th>Precio Asignado</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pcp" items="${proyecto.proyectoConProductos}">
					<tr>
						<td>${pcp.numeroOrden}</td>
						<td>${pcp.producto.descripcionBreve}</td>
						<td>${pcp.cantidad}</td>
						<td><fmt:formatNumber value="${pcp.precioAsignado}" maxFractionDigits="2"/></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr><th colspan=8> Productos asignados al proyecto</th></tr>
			</tfoot>
		</table>
	</div>
	
	<p>${mensaje}</p><br>
	<a href="/gestion/"><button>Volver</button></a>
</body>
</html>