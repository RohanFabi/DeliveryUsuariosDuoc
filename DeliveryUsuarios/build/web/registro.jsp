<%-- 
    Document   : registro
    Created on : 13-11-2020, 15:38:56
    Author     : dream
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
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
            <jsp:include page="WEB-INF/jspf/header.jsp"/>
            <!-- CONTENT -->
            <div id="layoutDefault_content">
                <main>
                    <!-- HEADER DE REGISTRO -->
                    <header class="page-header page-header-dark bg-img-repeat bg-duoc"
                            style='background-image: url("assets/img/pattern-shapes.png")'>
                        <div class="page-header-content">
                            <div class="container">
                                <div class="row align-items-center">
                                    <div class="col-lg-6">
                                        <div class="badge badge-marketing badge-pill badge-warning-soft text-dark mb-3">
                                            Registrate ya!</div>
                                        <h1 class="page-header-title">Disfruta del nuevo sistema de compras en tu
                                            institución.</h1>
                                        <p class="page-header-text">Bienvenido al nuevo sistema Delivery Duoc, para
                                            poder realizar compras debes registrarte y seleccionar tu sede!</p>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="card rounded-lg text-dark ">
                                            <div class="card-header py-4">Registro</div>
                                            <div class="card-body">
                                                <form method="POST" action="Registro" name="registro">
                                                    <!-- NOMBRES -->
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapFirstName">Nombre</label><input
                                                                                                class="form-control rounded-pill" id="nombre"
                                                                                                name="nombre" type="text"/></div>
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapLastName">Apellido</label><input
                                                                                                class="form-control rounded-pill" id="apellido"
                                                                                                name="apellido" type="text" /></div>
                                                    </div>

                                                    <!-- EMAIL -->
                                                    <div class="form-group"><label class="small text-gray-600"
                                                                                   for="leadCapEmail">Email </label><input
                                                                                   class="form-control rounded-pill" id="email"
                                                                                   name="email" type="email" /></div>

                                                    <div class="form-row">
                                                        <!-- telefono -->
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapCompany">Telefono</label><input
                                                                                                class="form-control rounded-pill" id="telefono"
                                                                                                name="telefono" type="text" /></div>
                                                        <!-- Rut -->
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapCompany">Rut</label><input
                                                                                                class="form-control rounded-pill" id="rut"
                                                                                                name="rut" type="text" /></div>
                                                    </div>
                                                    <div class="form-row">
                                                        <!-- telefono -->
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapCompany">Contraseña</label><input
                                                                                                class="form-control rounded-pill" id="contra"
                                                                                                name="contrasena1" type="password" /></div>
                                                        <!-- Rut -->
                                                        <div class="form-group col-md-6"><label class="small text-gray-600"
                                                                                                for="leadCapCompany">Repita la contraseña</label><input
                                                                                                class="form-control rounded-pill" id="contrasena2"
                                                                                                name="contrasena2" type="password" onkeyup="contrasena()"/></div>
                                                        <div id="msjpass" class="alert alert-danger d-none">
                                                            Las contraseñas no coinciden! vuelva a intentar.
                                                        </div>
                                                    </div>
                                                    <!-- SEDES
                                                    <label for="exampleFormControlSelect1">Selecciona tu
                                                        sede</label><select class="form-control"
                                                                        id="exampleFormControlSelect1">
                                                        <option>Selecciona</option>
                                                        <option>Alameda</option>
                                                        <option>Antonio Varas</option>
                                                        <option>Campus arauco</option>
                                                        <option>Campus Villarica</option>
                                                        <option>Maipu</option>
                                                        <option>Melipilla</option>
                                                        <option>Padre Alonso de Ovalle</option>
                                                        <option>Plaza norte</option>
                                                        <option>Plaza Oeste</option>
                                                        <option>Plaza Vespucio</option>
                                                    </select>
                                                    <!-- PROFESOR O ALUMNO 

                                                    <div class="container form-row">

                                                        <div class="custom-control custom-radio col-md-6">
                                                            <input class="custom-control-input" id="customRadio1"
                                                                   type="radio" name="customRadio">
                                                            <label class="custom-control-label"
                                                                   for="customRadio1">Profesor</label>
                                                        </div>
                                                        <div class="custom-control custom-radio col-md-6">
                                                            <input class="custom-control-input" id="customRadio2"
                                                                   type="radio" name="customRadio">
                                                            <label class="custom-control-label"
                                                                   for="customRadio2">Alumno</label>
                                                        </div>
                                                    </div>  -->
                                                    <!-- BOTON -->
                                                    <button
                                                        class="btn btn-primary btn-marketing btn-block rounded-pill mt-4"
                                                        type="submit" id="btnRegistro" name="btnRegistro">Registrarme!</button>
                                                </form>

                                                <c:if test="${not empty msjok}">
                                                    <br><br><br><br>
                                                    <div class="alert alert-success">
                                                        ${msjok}
                                                    </div>
                                                </c:if>
                                                <c:if test="${not empty msjerror}">
                                                    <br><br><br><br>
                                                    <div class="alert alert-danger">
                                                        ${msjerror}
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- DISEÑO DE TERMINO DIAGONAL EN HEADER -->
                        <div class="svg-border-angled text-white">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"
                                 fill="currentColor">
                            <polygon points="0,100 100,0 100,100"></polygon>
                            </svg>
                        </div>
                    </header>
                    <!-- SECCION VACIA-->
                    <section class="bg-white pt-5 pb-10">

                        <div class="svg-border-angled text-dark">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"
                                 fill="currentColor">
                            <polygon points="0,100 100,0 100,100"></polygon>
                            </svg>
                        </div>
                    </section>
                </main>
            </div>
            <jsp:include page="WEB-INF/jspf/footer.jspf" />
            <!-- SCRIPT DEL CODIGO -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous">
            </script>
            <script src="js/validacion.js" type="text/javascript"></script>
            <!-- POR EL MOMENTO NO INFLUYE EL SCRIPT -->
            <script src="js/scripts.js"></script>
    </body>
</html>
