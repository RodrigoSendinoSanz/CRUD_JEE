<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Termina Proyecto</title><br>
</head>
<body>
	<h1>Cambiar a terminado el Proyecto: ${proyecto.idProyecto}</h1>
	<h2>Cliente: ${proyecto.cliente.nombre}</h2>
	<h3>Jefe de proyecto: ${proyecto.jefeProyecto.nombre}</h3>
	<table>
		<tr>
			<th>Descripción</th><td>${proyecto.descripcion}</td>
		</tr>
		<tr>
			<th>Estado</th><td>${proyecto.estado}</td>
		</tr>
		<tr>
			<th>Fecha de Inicio</th><td><fmt:formatDate value="${proyecto.fechaInicio}" pattern="dd-MM-yyyy"/></td>
		</tr>
		<tr>
			<th>Fecha Fin Previsto</th><td><fmt:formatDate value="${proyecto.fechaFinPrevisto}" pattern="dd-MM-yyyy"/></td>
		</tr>
		<tr>
			<th>Presupuesto</th><td><fmt:formatNumber value="${proyecto.ventaPrevisto}" maxFractionDigits="2" /> &#8364;</td>
		</tr>
		<tr>
			<th>Costes Estimados</th><td><fmt:formatNumber value="${proyecto.costesPrevisto}" maxFractionDigits="2" /> &#8364;</td>
		</tr>
	</table>
	<br>
	<form action="/gestion/terminarProyecto" method="post">
		<input type="text" name="idProyecto" value=${proyecto.idProyecto} hidden>
        <label for="estado">Nuevo estado: </label>
        <input type="radio" name="estado" value="Terminado" checked readonly><label>Terminado</label><br><br>
        <label for="fechaFinReal">Fecha finalización Real: </label>
        <input type="date" name="fechaFinReal" id="fechaFinReal" ><br><br>
        <label for="costesFinales">Costes finales: </label>
        <input type="number" name="costeReal" id="costesFinales" placeholder="Coste real del proyecto"> Euros<br><br>
		<input type="reset" value="Borrar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Enviar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
    </form>
    <p>${cambioEstado}</p>
</body>
</html>