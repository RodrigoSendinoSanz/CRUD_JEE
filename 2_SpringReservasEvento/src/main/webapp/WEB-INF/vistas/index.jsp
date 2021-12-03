<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link href="/css/main.css" rel="stylesheet" />
    <title>Index</title>
    <style>
        .nombre {
            text-transform: uppercase;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${usuarioSesion eq null}">
        <h3><span class="nombre">No estás registrado</span></h3>
    </c:when>
    <c:when test="${usuarioSesion.idUsuario eq 0}">
        <h3><span class="nombre">No estás registrado</span></h3>
    </c:when>
    <c:when test="${usuarioSesion.idUsuario ne 0}">
        <h3>Bienvenido, <span class="nombre">${usuarioSesion.nombre}</span></h3>
    </c:when>
</c:choose>
<table border="1" class="cabezeralogo">
    <tr>
    	<td id="nada" ><div class="logo flexbox">Logo</div></td>
        <th class="cabezera"><a href="/activos">Ver activos</a></th>
        <th class="cabezera"><a href="/destacados">Ver destacados</a></th>
        <th class="cabezera"><a href="/reservas/detalle">Ver tus reservas</a></th>
        <th class="cabezera"><c:choose>
            <c:when test="${usuarioSesion eq null}">
                <a href="/usuario/">Login</a>
            </c:when>
            <c:when test="${usuarioSesion.idUsuario eq 0}">
                <a href="/usuario/">Login</a>
            </c:when>
            <c:when test="${usuarioSesion.idUsuario ne 0}">
                <a href="/usuario/detalle/">Detalles usuario</a>
            </c:when>
        </c:choose></th>
        <th class="cabezera"><a href="/usuario/logout">Cerrar sesión</a></th>
    </tr>
</table>
<br>

    <div id="lista">
        <span id="subti">Listado de eventos</span>
        <table border="3" cellpadding="2">
          <tbody>
            <tr>
            <td id="cablista">Nombre</td>
            <td id="nada">&nbsp;</td>
            <td id="cablista">Aforo</td>
            <td id="cablista">Fecha inicio</td>
            <td id="cablista">Precio</td>
            </tr>
             <c:forEach var="ele" items="${eventoDao }">
		            <tr>
		            <td id="tabla" class="morado">${ele.nombreEvento}</td>
		            <td id="nada" class="morado">&nbsp;</td>
		            <td id="tabla" class="morado">${ele.aforo_maximo}</td>
		            <td id="tabla"class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${ele.fecha_inicio}"/></td>
		            <td id="tabla" class="morado">${ele.precio}</td>
		            </tr>
             </c:forEach>
          </tbody>
        </table>
        
       
    </div>




${res_alta}
</body>
</html>