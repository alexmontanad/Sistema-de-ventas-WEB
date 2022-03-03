<%-- 
    Document   : Empleado
    Created on : 26/02/2022, 03:38:10 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width==device-width, initial-scale=1, shri">
        <title>Vista de productos</title>
    </head>
    <body>
        <form action = "Controlador?menu=empleado" method ="POST">
            
        </form>
        <div class="container">
            <div class="row"><h1>Productos</h1></div>
            <div class="row">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Cedula</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>Estado</th>
                                <th>User</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="em" items="${empleados}">
                                <tr>
                                    <td>${objP.getId()}</td>                    
                                    <td>${objP.getCedula()}</td>                    
                                    <td>${objP.getNombre()}</td>                    
                                    <td>${objP.getTelefono()}</td>                    
                                    <td>${objP.getEstado()}</td>                    
                                    <td>${objP.getUser()}</td>                    
                                    <td>
                                        <a type="button" class="btn btn-outline-success" style="height: 35px; width: 80px;" href="ProductoCTO?accion=ver&id=${objP.getId_prod()}">Ver</a>                  
                                        <a type="button" class="btn btn-outline-warning" style="height: 35px; width: 80px;" href="ProductoCTO?accion=editar&id=${objP.getId_prod()}">Editar</a>                    
                                        <a type="button" class="btn btn-outline-danger" style="height: 35px; width: 80px;" href="ProductoCTO?accion=eliminar&id=${objP.getId_prod()}">Eliminar</a>
                                    </td>                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>