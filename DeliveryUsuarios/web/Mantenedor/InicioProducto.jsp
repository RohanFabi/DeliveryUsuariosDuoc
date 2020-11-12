<%-- 
    Document   : inicioTienda
    Created on : 10-11-2020, 18:50:07
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
        <title>Inicio Producto</title>
        <!-- ESTILOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->
        <link href="css/styles.css" rel="stylesheet" />
        <!-- FLECHAS Y ICONOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->
        <link rel="icon" type="image/x-icon" href="img/logo_duoc.png" />
        <script data-search-pseudo-elements defer
        src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.24.1/feather.min.js" crossorigin="anonymous">
        </script>
    </head>
    <body>
        <div id="layoutDefault">
            <div id="layoutDefault_content">
                <main>
                    <jsp:include page="menuMantenedor.jspf" />

                    <br><br><br>
                    <a href="Producto?op=crear">Crear un producto</a>
                    <br><br><br>
                    <table align="center">
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Acciones</th>
                        </tr>

                        <c:set var = "productos" scope = "session" value = "${productos}"/>
                        <c:choose>
                            <c:when test = "${empty productos}">
                                <tr>
                                    <td colspan="3"><p>No hay producto</p></td>                
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${productos}" var="p">
                                    <tr>
                                        <th>${ p.idProducto }</th>
                                        <th>${ p.nombre }</th>
                                        <th><a href="Producto?op=modificar${p.idProducto}">Modificar</a><a href="Producto?op=eliminar${p.idProducto}">Eliminar</a></th>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </table>
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
