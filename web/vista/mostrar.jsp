
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Administar Clientes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>
<body>
<br/>
<h1>Lista de Clientes</h1>
<div class="container">
    <table>
        <p>
            <tr>
                <td><a class="btn btn-info" href="adminCliente?action=index">Ir al menú</a></td>
            </tr>
        </p>
        <br/>
    </table>
    <br/>
    <table class="table table-striped table-bordered">
        <tr>
            <td scope="col">ID</td>
            <td scope="col">NOMBRE</td>
            <td scope="col">APELLIDO</td>
            <td scope="col">CORREO</td>
            <td scope="col">CELULAR</td>
            <td colspan=2 scope="col">ACCIONES</td>
        </tr>
        <c:forEach var="cliente" items="">
            <tr>
                <td scope="row"><c:out value=""/></td>
                <td scope="row"><c:out value=""/></td>
                <td scope="row"><c:out value=""/></td>
                <td scope="row"><c:out value=""/></td>
                <td scope="row"><c:out value=""/></td>
                <td scope="row"><a class="btn btn-primary" href="adminCliente?action=showedit&id=<c:out value="" /> ">Editar</a>
                </td>
                <td scope="row"><a class="btn btn-danger" href="adminCliente?action=eliminar&id=<c:out value=""/> ">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
