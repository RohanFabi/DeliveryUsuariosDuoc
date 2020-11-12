<%-- 
    Document   : CrearProducto
    Created on : 11-11-2020, 11:08:21
    Author     : fabiola saez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Crear Producto</title>
        <!-- ESTILOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->
        <link href="css/styles.css" rel="stylesheet" />
        <!-- FLECHAS Y ICONOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->
        <link rel="icon" type="image/x-icon" href="img/logo_duoc.png" />
        <script data-search-pseudo-elements defer
        src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.24.1/feather.min.js" crossorigin="anonymous">
        </script>
        <script src="js/cargarArchivo.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="layoutDefault">
            <div id="layoutDefault_content">
                <main>
                    <jsp:include page="menuMantenedor.jspf" />

                    <br><br>
                    <div>
                        <h2 align="center">Creación de Producto</h2>

                    </div>
                    <br><br>
                    <form method="POST" enctype="multipart/form-data" name="guardarProducto" action="Producto">
                        <table align="center" >                            
                            <tr>
                                <th><label for="nombre">Nombre</label></th>
                                <th><input type="text" id="nombre" name="nombre" required></th>
                            </tr>
                            <tr>
                                <th><label for="precio">Precio</label></th>
                                <th><input type="text" id="precio" name="precio" required></th>
                            </tr>
                            <tr>
                                <th><label for="categoria">Categoria</label></th>
                                <th><select name="categoria">
                                        <option value="">Seleccionar</option>
                                        <c:forEach var="c" items="${categorias}">
                                            <option value="${c.idCategoria}">${c.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </th>
                            </tr>
                            <tr>
                                <th><label for="imagen">Imagen</label></th>
                                <th><input class="form-control" type="file" name="imagen" onchange="cargarArchivo(this)"></th>
                            </tr>
                        </table>
                        <input type="hidden" name="nombreImagen" value="">
                        <br><br><br>
                        <!--este no lo puedo alinear lo meti en un div y tampoco-->
                        <div class="center-block"><input type="submit" value="Guardar" name="guardar"></div>
                    </form>
                    <iframe name="null" style="display: none;"></iframe>
                    <br><br><br><br><br><br><br><br><br><br>

                </main>
            </div>
            <jsp:include page="footerMantenedor.jspf" />    
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
        </script>
        <!-- POR EL MOMENTO NO INFLUYE EL SCRIPT -->
        <script src="js/scripts.js"></script>
    </body>
</html>
