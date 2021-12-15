<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Bienvenido a Proyectos Activos de Control de Gestion</h1>
	
	<h2>Opciones Proyectos</h2>

	
	
	<h2>Listado de proyectos Activos</h2>
	 
		<h3>Mensajes : ${requestScope.mensaje}</h3>
	 
	<h3><a href="/gestion/altaProyecto">Nuevo Proyecto</a></h3>
	<h3><a href="/cerrarSesion">Cerrar Sesion</a></h3>
	
	<table border="2">
	<tr>
	<th>Id Proyecto</th><th>Cif Cliente</th><th>Fin Previsto</th><th>jefe proyecto</th><th>Editar</th><th>Eliminar</th>
	</tr>
	<c:forEach var="ele" items="${listaProyectosActivos }">
		<tr>
		
		<td>${ele.idProyecto}</td>
		<td>${ele.cliente.cif}</td>
		<td><fmt:formatDate value="${ele.fechaFinPrevisto}" pattern="dd-MM-yyyy"/></td>
		<td>${ele.jefeProyecto.nombre}</td>
		<td><a href="/gestion/verProyecto/${ele.idProyecto }">Ver Detalle</a></td>
		<td><a href="/gestion/terminarProyecto/${ele.idProyecto }">Terminar</a></td>
		</tr>
	
	</c:forEach>
	</table>
</body>
</html>