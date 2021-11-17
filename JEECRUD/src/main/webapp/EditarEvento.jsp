<%@page import="modelo.beans.Evento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
   <% Evento evento = (Evento)request.getSession().getAttribute("evento"); %>
 	<h1>Editar evento de <%=evento.getNombre()  %></h1>
 	        <table border="1">
			<tr>
                <th>Id</th>
                <td><%=evento.getId_evento() %></td>
            </tr>
            <tr>
            	<th>Nombre</th>
            	<td><%=evento.getNombre() %></td>
            </tr>
            <tr>
                <th>Precio</th>
            	<td><%=evento.getPrecio() %></td>
            </tr>
            <tr>
            	<th>Descripcion</th>
            	<td><%=evento.getDescripcion() %></td>
            </tr>
            <tr>
            	<th>Fecha inicio</th>
            	<td><%=evento.getFecha_inicio() %></td>
            </tr>
            <tr>
            	<th>Duracion</th>
            	<td><%=evento.getDuracion() %></td>
            </tr>
            <tr>
            	<th>Estado</th>
            	<td><%=evento.getEstado() %></td>
            </tr>
            <tr>
            	<th>Destacado</th>
            	<td><%=evento.getDestacado() %></td>
            </tr>
            <tr>
            	<th>Maximo Aforo</th>
            	<td><%=evento.getAforo_maximo() %></td>
            </tr>
            <tr>
				<th>Minimo Aforo</th>
                <td><%=evento.getMinimo_asistencia() %></td>
            </tr>
            <tr>
				<th>ID Tipo</th>
                <td><%=evento.getId_tipo().getId_tipo()%></td>
            </tr>
              <tr>
				<th>Descripcion Tipo</th>
                <td><%=evento.getId_tipo().getDescripcion()%></td>
            </tr>
        	</table>
        	 <a id="link" href="index.jsp">Volver</a><!-- boton para volver al inicio -->
</body>
</html>