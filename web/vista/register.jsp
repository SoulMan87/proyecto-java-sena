<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registrar Cliente</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>
<body>
<h1>Registrar Cliente</h1>
<div class="container">
    <form action="adminArticulo?action=register" method="post">
        <table class="table table-striped table-bordered" border="1" align="center">
            <tr>
                <td scope="col">ID:</td>
                <td><input class="form-control" type="text" name="id"/></td>
            </tr>
            <tr>
                <td scope="col">Nombre:</td>
                <td><input class="form-control" type="text" name="nombre"/></td>
            </tr>
            <tr>
                <td scope="col">Apellido:</td>
                <td><input class="form-control" type="text" name="apellido"/></td>
            </tr>
            <tr>
                <td scope="col">Correo:</td>
                <td><input class="form-control" type="text" name="correo"/></td>
            </tr>
            <tr>
                <td scope="col">Celular:</td>
                <td><input class="form-control" type="text" name="celular"/></td>
            </tr>

        </table>
        <br>
        <table class="table table-striped table-bordered" border="0" align="center">
            <tr>
                <td><input class="btn btn-success" type="submit" value="Agregar" name="agregar"></td>
            </tr>
    </form>
</div>
</body>
</html>