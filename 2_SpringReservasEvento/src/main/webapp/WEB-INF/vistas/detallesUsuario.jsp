<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/main.css" rel="stylesheet" />
<title>Area personal</title>
</head>
<body>
	<table>
		<tbody>
		  <tr>
		    <td  id="cablista">Username:</td>
		    <td class="morado"><b>${usuarioSesion.username}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Password: </td>
		    <td class="morado"> <b>${usuarioSesion.password}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Id Usuario:</td>
		    <td class="morado"> <b>${usuarioSesion.idUsuario}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Email:</td>
		    <td class="morado"> <b>${usuarioSesion.email}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Nombre:</td>
		    <td class="morado"><b>${usuarioSesion.nombre}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Dirección:</td>
		    <td class="morado"><b>${usuarioSesion.direccion}</b></td>
		  </tr>
		  <tr>
		    <td  id="cablista">Activo:</td>
		    <td class="morado"><b>${usuarioSesion.enabled}</b></td>
		  </tr>
		</tbody>
</table>
	<a href="/">Inicio</a>
</body>
</html>