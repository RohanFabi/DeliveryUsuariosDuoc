<%-- 
    Document   : index
    Created on : 09-11-2020, 15:08:21
    Author     : fabiola sáez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Inicio de Sesión</title>
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
            <%@ include file= "WEB-INF/jspf/header.jsp" %> 
            <!-- SECCCION TITULO Y TIENDAS -->
            <section class="bg-light py-5">
                
                <div class="svg-border-angled text-dark">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"
                         fill="currentColor">
                    <polygon points="0,100 100,0 100,100"></polygon>
                    </svg>
                </div>
            </section>
            <jsp:include page="WEB-INF/jspf/footer.jspf" />
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
            </script>
            <!-- POR EL MOMENTO NO INFLUYE EL SCRIPT -->
            <script src="js/scripts.js"></script>
        </div>
    </body>
</html>
