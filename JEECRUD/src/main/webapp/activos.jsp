<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List"%>
<%@page import="modelo.beans.Evento" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<nav class="menu">
	  <ul>
	    <li><a id="menu" href="#">Tipos</a></li>
	    <li><a id="menu"href="#">Eventos</a></li>
	    <li><a id="menu"href="#">Usuarios</a></li>
	   	<li><a id="menu" class="active" href="index.jsp">Index</a></li>
	    <li><a id="menu"href="#">Login</a></li>
	    <li><a id="menu"href="#">Registro</a></li>
	   	<li><a id="menu"href="#">Salir</a></li>
	  </ul>
	</nav>
	
	
	
	<h1>Bienvenido a Eventos App</h1>
	
	<h2>Opciones Eventos</h2>

	
	<a id="link" href="index.jsp">Todos</a>

	
	<h2>Listado de eventos</h2>
	 
	 
	<h3><a id="link" href="FormAltaEvento.jsp">Nuevo Evento</a></h3>
	<table border="2">
	<tr>
	<th>Id</th><th>Nombre</th><th>Precio</th><th>Editar</th><th>Eliminar</th><th>Cancelar</th>
	</tr>
	<%
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listarEventos");
	%>
	<% for (Evento ele: lista){ %>
		<%if(ele.getEstado().equals("ACTIVO")){ %>
		<tr>
			<td><%= ele.getId_evento() %></td>
			<td><%= ele.getNombre() %></td>
			<td><%= ele.getPrecio() %></td>
			<td><a id="link" href="eventos?opcion=editar&id=<%= ele.getId_evento()  %> ">Editar</a></td>
			<td><a  id="link" href="eventos?opcion=eliminar&id=<%= ele.getId_evento()  %>">Eliminar</a></td>
			<td><a id="link" href="eventos?opcion=cancelar&id=<%= ele.getId_evento()  %>">Cancelar</a></td>
		</tr>
		<%} %>
	<%} %>
	</table>

</body>
</html>