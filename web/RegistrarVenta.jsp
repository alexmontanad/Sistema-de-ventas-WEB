<%-- 
    Document   : RegistrarVenta
    Created on : 26/02/2022, 03:38:44 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">
                            <label> Datos del cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrecliente" class="form-control" placeholder="Nombre">
                            </div>
                        </div>
                        <div class="form-group">
                            <label> Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombreproducto" class="form-control" placeholder="Nombre">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4 d-flex">
                                <input type="text" name="precio" class="form-control" placeholder="Codigo">
                            </div>
                            <div class="col-sm-2 d-flex">
                                <input type="number" name="cantidad" class="form-control" placeholder="Codigo">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="stock" class="form-control" placeholder="Nombre">
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="col-sm-8">

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
