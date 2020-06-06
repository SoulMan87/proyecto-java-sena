<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Actualizar Cliente</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		  crossorigin="anonymous">
</head>
<body>
<h1>Actualizar Cliente</h1>
<form action="adminArticulo?action=editar" method="post" >
	<table class="table table-striped table-bordered">
		<tr>
			<td><label>Id</label></td>
			<td><input class="form-control" type="text" name="id" value="<c:out value="${cliente.id}"></c:out>" ></td>
		</tr>
		<tr>
			<td><label>Nombre</label></td>
			<td><input type="text" name="nombre" value='<c:out value="${articulo.nombre}"></c:out>' ></td>
		</tr>
		<tr>
			<td><label>Apellido</label></td>
			<td><input type="text" name="apellido" value='<c:out value="${cliente.apellido}"></c:out>' ></td>
		</tr>
		<tr>
			<td><label>Correo</label></td>
			<td><input type="text" name="correo" value='<c:out value="${cliente.correo }"></c:out>' ></td>
		</tr>

		<tr>
			<td><label>Celular</label></td>
			<td><input type="text" name="celular" value='<c:out value="${cliente.celular }"></c:out>' ></td>
		</tr>
	</table>

	<input class="btn-btn info" type="submit" name="registrar" value="Guardar">
</form>

</body>
</html>