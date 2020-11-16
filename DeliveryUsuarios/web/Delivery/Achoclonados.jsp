<%-- 
    Document   : Achoclonados
    Created on : 10-11-2020, 14:49:58
    Author     : dream
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Achoclonados</title>
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
            <jsp:include page="../WEB-INF/jspf/header.jsp"/>
            <!-- LOGO DE TIENDA y SECCION BUSCAR -->
            <div class="container">
                <div class="d-flex justify-content-center pb-5 ">
                    <img src="img/logosTiendas/achoclonado-chico.png" class="img-fluid">
                </div>
                <!-- SECCIÓN BUSCAR -->
                <div class=" input-group input-group-md mb-5">
                    <div class="input-group-prepend ">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">Categorias</button>
                        <div class="dropdown-menu animated--fade-in-up"><a class="dropdown-item"
                                                                           href="#!">Dulces</a><a class="dropdown-item" href="#!">Tortas
                            </a>
                            <a class="dropdown-item" href="#!">Sándwich</a>
                            <a class="dropdown-item" href="#!">Ensaladas</a>
                            <a class="dropdown-item" href="#!">Bebestibles</a>
                            <a class="dropdown-item" href="#promo">Promociones</a>
                        </div>
                    </div>
                    <input class="form-control" type="text" aria-label="Text input with dropdown button"
                           placeholder="Busca tu pedido!" />
                </div>
            </div>
            <c:forEach items="${tiendas}" var="t">
                <section class="bg-white py-5 ">
                    <div class="container">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h3 class="mb-0" >${t.nombre}</h3>
                        </div>
                        <div class="row">
                            <!-- PRODUCTO 1 -->
                            <c:forEach items="${productos}" var="p">
                                <c:if test="${p.puntoVenta.idPuntoVenta == t.idPuntoVenta}">
                                    <div class="col-lg-4 mb-5 mb-lg-0">
                                        <a class="card lift h-100" href="#!">

                                            <img class="card-img-top" src="Delivery/media/producto/${p.imagen}" alt="..." />
                                            <div class="card-body">
                                                <h3 class="text-primary mb-0">${p.precio}</h3>
                                                <div class="small text-gray-800 font-weight-500">${p.nombre}</div>
                                                <div class="small text-gray-500">${t.nombre}</div>
                                            </div>
                                            <div
                                                class="card-footer bg-transparent border-top d-flex align-items-center justify-content-between">
                                                <div class="small text-gray-500">Añadir</div>
                                                <div class="small text-gray-500"><i data-feather="arrow-right"></i></div>
                                            </div>
                                        </a>
                                    </div>
                                </c:if>
                            </c:forEach> 
                        </div>
                </section>
            </c:forEach>
            
            <jsp:include page="../WEB-INF/jspf/footer.jspf" />
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
            </script>
            <!-- POR EL MOMENTO NO INFLUYE EL SCRIPT -->
            <script src="js/scripts.js"></script>
        </div>
    </body>
</html>
