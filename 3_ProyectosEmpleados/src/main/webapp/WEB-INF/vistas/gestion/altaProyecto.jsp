<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Nuevo Proyecto</title><br>
</head>
<body>
	<h1>Dar de alta nuevo proyecto:</h1>
	<form action="/gestion/altaProyecto" method="post">
		<label for="idProyecto">Número de proyecto:</label>
        <input type="text" name="idProyecto" id="idProyecto" placeholder="Número de proyecto">&nbsp;&nbsp;&nbsp;&nbsp;
        <label for="descripcion">Descripción:</label>
        <input type="text" name="descripcion" id="descripcion" placeholder="Descripción"><br><br>
        <label for="estado">Estado: </label>
        <input type="radio" name="estado" value="Activo"><label>Activo</label>&nbsp;&nbsp;
        <input type="radio" name="estado" value="Pendiente"><label>Pendiente</label><br><br>
        <label for="fechaInicio">Fecha de inicio: </label>
        <input type="date" name="fechaInicio" id="fechaInicio">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label for="fechaFin">Fecha finalización prevista: </label>
        <input type="date" name="fechaFinPrevisto" id="fechaFin"><br><br>
        <label for="venta">Presupuesto: </label>
        <input type="number" name="ventaPrevisto" id="venta" placeholder="Presupuesto" step="any"> Euros&nbsp;&nbsp;&nbsp;&nbsp;
        <label for="costes">Previsión de costes: </label>
        <input type="number" name="costesPrevisto" id="costes" placeholder="Previsión de costes" step="any"> Euros<br><br>
        <label for="cliente">Cliente: </label>
        <select name="cliente.cif">
        	<c:forEach var="cli" items="${clientes}">
        	<option value="${cli.cif}">${cli.nombre}</option>
        	</c:forEach>
        </select><br><br>
        <label for="jefe">Jefe de Proyecto: </label>
        <select name="empleado.idEmpl">
        	<c:forEach var="emp" items="${jefesProyecto}">
        	<option value="${emp.idEmpl}">${emp.nombre}</option>
        	</c:forEach>
        </select><br><br>
		
		<input type="submit" value="Enviar">

    </form>
    <a href="/gestion/"><input type="button" value="Volver"></a>
    <p>${mensajeAlta}</p>
</body>
</html>