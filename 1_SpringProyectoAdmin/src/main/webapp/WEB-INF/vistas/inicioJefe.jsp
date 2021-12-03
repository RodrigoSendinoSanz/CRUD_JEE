<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <link
      href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
      rel="stylesheet"
    />
<link href="/css/main.css" rel="stylesheet" />
    <title>Inicio</title>
  </head>
  <body>

    <table cellpadding="2" id="titulo">
        <tr>
        <td>Proyectos</td>
        </tr>
    </table>
  <h3> Mensaje : ${mensaje }</h3>
    <table cellpadding="3" class="cabezeralogo">
        <tbody>
        <tr>
        <td id="nada" ><div class="logo flexbox">Logo</div></td>
        <td id="select">Todos los proyectos</td>
 		<td class="cabezera"><a href="/jefe/altaProyecto">Nuevo Proyecto</a></td>
        <td class="cabezera"><a href="CerrarSesion">Salir</a></td>
        </tr>
        </tbody>
    </table>

    <div id="lista">
        <span id="subti">Proyectos Todos</span>
        <table border="3" cellpadding="2">
          <tbody>
            <tr>
            <td id="cablista">Id</td>
            <td id="cablista">Descripcion</td>
            <td id="cablista">Fecha final</td>
            <td id="cablista">Estado</td>
            <td id="cablista">Coste</td>
            <td id="cablista">Terminar Proyecto</td>
            <td id="cablista">Opciones</td>
            </tr>
             <c:forEach var="ele" items="${listaProyectos }">
		            <tr>
		            <td id="tabla" class="morado">${ele.idProyecto}</td>
		            <td id="tabla" class="morado">${ele.descripcion}</td>
		            <td id="tabla"class="morado"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${ele.fechaFinReal}"/></td>
		            <td id="tabla" class="morado">${ele.estado}</td>
		            <td id="tabla" class="morado">${ele.costeReal}</td>
		          	<td id="tabla" ><a href="/jefe/terminarProyecto/${ele.idProyecto}" class="morado">Terminar Proyecto</a></td>
		            <td id="tabla" ><a href="/jefe/verDetalle/${ele.idProyecto}" class="morado"> Ver detalle</a></td>
		            </tr>
             </c:forEach>
          </tbody>
        </table>
        
       
    </div>


  </body>
</html>