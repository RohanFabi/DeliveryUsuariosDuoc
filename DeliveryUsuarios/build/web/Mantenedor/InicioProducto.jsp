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
        <link href="css/tablas.css" rel="stylesheet" />
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
                    <%@ include file= "../WEB-INF/jspf/header.jsp" %> 
                    <br>
                    <div>
                        <h2 align="center">Creación de Producto</h2>
                        <br>
                    </div>
                    <form method="POST" enctype="multipart/form-data" name="guardarProducto" action="Producto">
                    <table align="center" >
                        <tr>
                            <th><label for="nombre">Nombre</label></th>
                            <th><input type="text" id="nombre" name="nombre" value="${productoMod.nombre}" required></th>
                            <th><label for="categoria">Categoria</label>
                                <select name="categoria" required="True">
                                    <option value="">Seleccionar</option>
                                    <c:forEach var="c" items="${categorias}">
                                        <option value="${c.idCategoria}" <c:if test="${productoMod.categoria.idCategoria == c.idCategoria}">selected</c:if>>${c.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th><label for="precio">Precio</label></th>
                            <th><input type="text" id="precio" name="precio" value="${productoMod.precio}" required></th>
                            <th id="th_imagenProd">
                                <c:choose>
                                    <c:when test="${productoMod.idProducto != null}">
                                        <label for="imagen">Imagen actual</label> <br>
                                        <img id="sqr_imgProd" src="Delivery/media/producto/${productoMod.imagen}" alt="..." style="width:10vw; border-style:solid;"/> <br>
                                        <label for="imagen">Actualizar</label> <br>
                                        <input class="form-control" type="file" name="imagen" onchange="cargarArchivo(this)">
                                    </c:when>
                                    <c:otherwise>
                                        <div>
                                            <label for="imagen">Imagen</label>
                                            <input class="form-control" type="file" name="imagen" onchange="cargarArchivo(this)">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </th>
                        </tr>
                    </table>

                        <input type="hidden" name="nombreImagen" value="">
                        <input type="hidden" name="imagenActual" value="${productoMod.imagen}">
                        <!--este no lo puedo alinear lo meti en un div y tampoco-->
                        <br>
                        <div id="btns_creacion">
                            <input type="submit" value="Cancelar" name="btnPost">
                            <input type="submit" value="${modo}" name="btnPost">
                        </div>
                    </form>
                    <iframe name="null" style="display: none;"></iframe>

                    <br><br><br>
                    <table class="table col-sm-9 table-bordered table-striped" align="center">
                        <tr>
                            <th>Código</th>
                            <th>Producto</th>
                            <th>Precio</th>
                            <th>Categoria</th>
                            <th>¿Producto disponible?</th>
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
                                        <th>${p.precio}</th>
                                        <th>${ p.categoria.descripcion}</th>
                                        <th>${ p.activo }</th>
                                        <th>
                                            <form method="POST" action="Producto" class="form form-inline">
                                                <input type="submit" value="Modificar" name="btnPost">
                                                <input type="hidden" value="${p.idProducto}" name="idProd">
                                                <input type="submit" value="Desactivar" name="btnPost">
                                            </form>
                                        </th>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                                    
                        </c:choose>
                    </table>
                    <br><br><br><br>
                    <jsp:include page="../WEB-INF/jspf/footer.jspf" />
                </main>
            </div> 
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
        </script>

    </body>
</html>
