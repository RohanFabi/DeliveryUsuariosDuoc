package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jspf/menuPrincipal.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("        <title>Delivery Duoc</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- ESTILOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->\r\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <!-- FLECHAS Y ICONOS NECESARIOS PARA EL DISEÑO (sacado de plantilla bootstrap) -->\r\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"img/logo_duoc.png\" />\r\n");
      out.write("        <script data-search-pseudo-elements defer\r\n");
      out.write("        src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.24.1/feather.min.js\" crossorigin=\"anonymous\">\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"layoutDefault\">\r\n");
      out.write("            ");
      out.write("        \r\n");
      out.write("<!-- CONTENT -->\r\n");
      out.write("        ");

            HttpSession objSes = request.getSession();
            Usuario user = (Usuario)objSes.getAttribute("usuario");
            System.out.println(user.getTipoUsuario());
            if (user.getTipoUsuario()==null){
        
      out.write("\r\n");
      out.write("        <div id=\"layoutDefault_content\">\r\n");
      out.write("            <main>\r\n");
      out.write("                <nav class=\"navbar navbar-marketing navbar-expand-lg navbar-light\" style=\"background-color:001B37 ;\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <img class=\"img-fluid\" src=\"img/logo-duoc-uc-universidad-catolica.jpg\" alt=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a class=\"navbar-brand text-dark\" href=\"index\">Sitio Delivery</a><button\r\n");
      out.write("                            class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("                            data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\"\r\n");
      out.write("                            aria-expanded=\"false\" aria-label=\"Toggle navigation\"><i data-feather=\"menu\"></i></button>\r\n");
      out.write("                        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                            <ul class=\"navbar-nav ml-auto mr-lg-5\">\r\n");
      out.write("                                <!-- INCIO -->\r\n");
      out.write("                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"index\">Inicio </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"Administracion\">Inicio Administracion </a></li>\r\n");
      out.write("                                <!-- ITEM OFERTAS -->\r\n");
      out.write("                                <li class=\"nav-item dropdown dropdown-xl no-caret\">\r\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdownDemos\" href=\"#\" role=\"button\"\r\n");
      out.write("                                       data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Promociones<i\r\n");
      out.write("                                            class=\"fas fa-chevron-right dropdown-arrow\"></i></a>\r\n");
      out.write("                                    <div class=\"dropdown-menu dropdown-menu-right animated--fade-in-up mr-lg-n15\"\r\n");
      out.write("                                         aria-labelledby=\"navbarDropdownDemos\">\r\n");
      out.write("                                        <div class=\"row no-gutters\">\r\n");
      out.write("                                            <!-- ZONA IZQUIERDA (COVER) -->\r\n");
      out.write("                                            <div class=\"col-lg-5 p-lg-3 bg-img-cover overlay overlay-primary overlay-70 d-none d-lg-block\"\r\n");
      out.write("                                                 style='background-image: url(\"https://source.unsplash.com/mqO0Rf-PUMs/500x350\")'>\r\n");
      out.write("                                                <div\r\n");
      out.write("                                                    class=\"d-flex h-100 w-100 align-items-center justify-content-center\">\r\n");
      out.write("                                                    <div class=\"text-white text-center z-1\">\r\n");
      out.write("                                                        <div class=\"mb-3\"></div>\r\n");
      out.write("                                                        <a class=\"btn btn-white btn-sm text-primary rounded-pill\"\r\n");
      out.write("                                                           href=\"{%url 'inicio'%}\">Todas las ofertas</a>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <!-- SECCIONES -->\r\n");
      out.write("                                            <div class=\"col-lg-7 p-lg-5\">\r\n");
      out.write("                                                <div class=\"row\">\r\n");
      out.write("                                                    <!-- COLUMNA IZQUIERDA -->\r\n");
      out.write("                                                    <div class=\"col-lg-6\">\r\n");
      out.write("                                                        <h6 class=\"dropdown-header text-primary\">Puntos</h6>\r\n");
      out.write("                                                        <a class=\"dropdown-item\" href=\"Doggis\">Doggis</a>\r\n");
      out.write("                                                        <a class=\"dropdown-item\" href=\"{%url 'Bistro'%}\">Bistro</a>\r\n");
      out.write("                                                        <a class=\"dropdown-item\" href=\"{%url 'Starbuck'%}\">Starbucks</a>\r\n");
      out.write("                                                        <a class=\"dropdown-item\" href=\"Achoclonados\">Achoclonados</a>\r\n");
      out.write("                                                        <div class=\"dropdown-divider border-0\"></div>\r\n");
      out.write("\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                    <!-- COLUMNA DERECHA -->\r\n");
      out.write("                                                    <div class=\"col-lg-6\">\r\n");
      out.write("\r\n");
      out.write("                                                        <a class=\"dropdown-item\" href=\"{%url 'Junaeb'%}\">Junaeb</a><a\r\n");
      out.write("                                                            class=\"dropdown-item\" href=\"{%url 'Docente'%}\">Docente</a>\r\n");
      out.write("                                                        <div class=\"dropdown-divider border-0\"></div>\r\n");
      out.write("\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- AYUDA -->\r\n");
      out.write("                                <li class=\"nav-item dropdown no-caret\">\r\n");
      out.write("                                    <!-- TITULO EN NAV -->\r\n");
      out.write("                                    <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdownDocs\" href=\"#\" role=\"button\"\r\n");
      out.write("                                       data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Ayuda<i\r\n");
      out.write("                                            class=\"fas fa-chevron-right dropdown-arrow\"></i></a>\r\n");
      out.write("                                    <!-- SECCIONES DE AYUDA -->\r\n");
      out.write("                                    <div class=\"dropdown-menu dropdown-menu-right animated--fade-in-up\"\r\n");
      out.write("                                         aria-labelledby=\"navbarDropdownDocs\">\r\n");
      out.write("                                        <!-- AYUDA 1 -->\r\n");
      out.write("                                        <a class=\"dropdown-item py-3\"\r\n");
      out.write("                                           href=\"https://docs.startbootstrap.com/sb-ui-kit-pro/quickstart\"\r\n");
      out.write("                                           target=\"_blank\">\r\n");
      out.write("                                            <div class=\"icon-stack bg-primary-soft text-primary mr-4\"><i\r\n");
      out.write("                                                    class=\"fas fa-book-open\"></i></div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <div class=\"small text-gray-500\">Como comprar?</div>\r\n");
      out.write("                                                Para comprar necesita estar registrado en el sistema.\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <div class=\"dropdown-divider m-0\"></div>\r\n");
      out.write("                                        <!-- AYUDA 2 -->\r\n");
      out.write("                                        <a class=\"dropdown-item py-3\"\r\n");
      out.write("                                           href=\"https://docs.startbootstrap.com/sb-ui-kit-pro/components\"\r\n");
      out.write("                                           target=\"_blank\">\r\n");
      out.write("                                            <div class=\"icon-stack bg-primary-soft text-primary mr-4\"><i\r\n");
      out.write("                                                    class=\"fas fa-code\"></i></div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <div class=\"small text-gray-500\">Como es el pago?</div>\r\n");
      out.write("                                                El pago se realiza una vez el producto este en tus manos.\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <div class=\"dropdown-divider m-0\"></div>\r\n");
      out.write("                                        <!-- AYUDA 3 -->\r\n");
      out.write("                                        <a class=\"dropdown-item py-3\"\r\n");
      out.write("                                           href=\"https://docs.startbootstrap.com/sb-ui-kit-pro/changelog\"\r\n");
      out.write("                                           target=\"_blank\">\r\n");
      out.write("                                            <div class=\"icon-stack bg-primary-soft text-primary mr-4\"><i\r\n");
      out.write("                                                    class=\"fas fa-file\"></i></div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <div class=\"small text-gray-500\">Opciones de retiro</div>\r\n");
      out.write("                                                Puede retirar los productos en tienda o seleccionar delivery a su\r\n");
      out.write("                                                ubicacion dentro de la institución\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <!-- USUARIO -->\r\n");
      out.write("                                <li class=\"nav-item dropdown no-caret  dropdown-user\">\r\n");
      out.write("                                    <a class=\" dropdown-toggle\" id=\"navbarDropdownUserImage\" href=\"\" role=\"button\"\r\n");
      out.write("                                       data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("\r\n");
      out.write("                                        <!-- Imagen usuario en nav -->\r\n");
      out.write("                                        <div class=\"avatar avatar-online avatar-lg mr-1\">\r\n");
      out.write("                                            <img class=\"avatar-img img-fluid\"\r\n");
      out.write("                                                 src=\"img/logosTiendas/Missing_avatar.png\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <div class=\"dropdown-menu dropdown-menu-right border-0 shadow animated--fade-in-up\"\r\n");
      out.write("                                         aria-labelledby=\"navbarDropdownUserImage\">\r\n");
      out.write("                                        <!-- Datos usuario -->\r\n");
      out.write("                                        <!--la siguiente etiqueta era un h6 pero daba un error \r\n");
      out.write("                                        -no puede tener un div dentro, la cambie por div-->\r\n");
      out.write("                                        <div class=\"dropdown-header d-flex align-items-center\">\r\n");
      out.write("                                            <img class=\"dropdown-user-img\" src=\"img/logosTiendas/Missing_avatar.png\">\r\n");
      out.write("                                            <div class=\"dropdown-user-details\">\r\n");
      out.write("                                                <div class=\"dropdown-user-details-name\">Desconocido</div>\r\n");
      out.write("                                                <div class=\"dropdown-user-details-email\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"dropdown-divider\"></div>\r\n");
      out.write("                                        <!-- Cuenta -->\r\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"#!\">\r\n");
      out.write("                                            <div class=\"dropdown-item-icon\"><i data-feather=\"settings\"></i></div>\r\n");
      out.write("                                            Cuenta\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <!-- Pedido -->\r\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"estado.html\">\r\n");
      out.write("                                            <div class=\"dropdown-item-icon\"><i data-feather=\"file\"></i></div>\r\n");
      out.write("                                            Pedidos\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <!-- Salir -->\r\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"#!\">\r\n");
      out.write("                                            <div class=\"dropdown-item-icon\"><i data-feather=\"log-out\"></i></div>\r\n");
      out.write("                                            Salir\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <!-- Entrar -->\r\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"login.html\">\r\n");
      out.write("                                            <div class=\"dropdown-item-icon\"><i data-feather=\"log-in\"></i></div>\r\n");
      out.write("                                            Entrar\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <!-- Registrarme -->\r\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"login.html\">\r\n");
      out.write("                                            <div class=\"dropdown-item-icon\"><i data-feather=\"edit-2\"></i></div>\r\n");
      out.write("                                            Registrarme\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <!-- BOTON COMPRAR -->\r\n");
      out.write("                            <a class=\"btn-blue btn rounded-pill px-4 ml-lg-4\" href=\"DetalleCompra\">Comprar<i\r\n");
      out.write("                                    class=\"fas fa-arrow-right ml-1\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </main>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
 
            }
        
      out.write("\r\n");
      out.write("        ");
      out.write(" \r\n");
      out.write("            <!-- SECCCION TITULO Y TIENDAS -->\r\n");
      out.write("            <section class=\"bg-light py-5\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <!-- TITULO -->\r\n");
      out.write("                    <div class=\"row justify-content-center\">\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"mb-5 text-center\">\r\n");
      out.write("                                <div class=\"text-xs text-uppercase-expanded text-primary mb-2\">Tiendas a disposición\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p class=\"lead mb-0\">Recuerde que el horario de compras de entrega es entre las\r\n");
      out.write("                                    13:00-14:30 </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- TIENDAS (Tamaño perfecto para foto de 800 * 500) -->\r\n");
      out.write("                    <div class=\"row justify-content-center\">\r\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- SEPARADOR DE ESPACION ENTRE TIENDAS  Y EL SUSCRIBIRSE A PROMOCIONES -->\r\n");
      out.write("                <div class=\"svg-border-angled text-white\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 100 100\" preserveAspectRatio=\"none\"\r\n");
      out.write("                         fill=\"currentColor\">\r\n");
      out.write("                    <polygon points=\"0,100 100,0 100,100\"></polygon>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("            <!-- SECCION SUSCRIBIRSE Y  PLATOS ESTRELLA-->\r\n");
      out.write("            <section class=\"bg-white pt-5 pb-10\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <!-- SUSCRIBETE -->\r\n");
      out.write("                    <div class=\"card mt-n15 mb-10 z-1\">\r\n");
      out.write("                        <div class=\"card-body p-5\">\r\n");
      out.write("                            <div class=\"row align-items-center\">\r\n");
      out.write("                                <div class=\"col-lg-6\">\r\n");
      out.write("                                    <h4>Susribete a las promociones diarias</h4>\r\n");
      out.write("                                    <p class=\"lead text-gray-500 mb-0\">\r\n");
      out.write("                                        Debes estar atento a tus correos, todos los dias promociones diferentes.\r\n");
      out.write("                                    </p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-lg-6\">\r\n");
      out.write("                                    <div class=\"input-group mb-2\">\r\n");
      out.write("                                        <input class=\"form-control form-control-solid\" type=\"text\"\r\n");
      out.write("                                               placeholder=\"youremail@example.com\" aria-label=\"Recipient's username\"\r\n");
      out.write("                                               aria-describedby=\"button-addon2\" />\r\n");
      out.write("                                        <div class=\"input-group-append\"><button class=\"btn btn-primary\"\r\n");
      out.write("                                                                                id=\"button-addon2\" type=\"button\">Suscribirme</button></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"small text-gray-500\">Puedes cancelar la suscripción cuando lo\r\n");
      out.write("                                        desees.</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- PLATOS ESTRELLA -->\r\n");
      out.write("                    <!-- Titutlo y descripción (Tamaño perfecto de imagen de 800 x 500) -->\r\n");
      out.write("                    <div class=\"row justify-content-center\">\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"mb-5 text-center\">\r\n");
      out.write("                                <div class=\"text-xs text-uppercase-expanded text-primary mb-2\">Productos Estrella\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p class=\"lead mb-0\">Te seleccionamos los platos mejor valorados para ti!\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <!-- PLATO N1 -->\r\n");
      out.write("                        <div class=\"col-lg-4 mb-5 mb-lg-0\">\r\n");
      out.write("                            <a class=\"card lift\" href=\"#!\"><img class=\"card-img-top\"\r\n");
      out.write("                                                                src=\"img/platos/queso-cheddar-salsa.jpg\" alt=\"...\" />\r\n");
      out.write("                                <div class=\"card-body text-center py-3\">\r\n");
      out.write("                                    <h6 class=\"card-title mb-0\">Papitas con queso Cheddar</h6>\r\n");
      out.write("                                    <div class=\"text-yellow\"><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star\"></i><i class=\"fas fa-star-half-alt\"></i></div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"small\">Disfruta de unas deliciosas papitas bañadas con queso Cheddar\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-footer text-center text-xs\"><i\r\n");
      out.write("                                        class=\"fas fa-store-alt mr-1\"></i>BISTRO</div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- PLATO N2 -->\r\n");
      out.write("                        <div class=\"col-lg-4 mb-5 mb-lg-0\">\r\n");
      out.write("                            <a class=\"card lift\" href=\"#!\"><img class=\"card-img-top\"\r\n");
      out.write("                                                                src=\"img/platos/Gohan-Salmón.jpg\" alt=\"...\" />\r\n");
      out.write("                                <div class=\"card-body text-center py-3\">\r\n");
      out.write("                                    <h6 class=\"card-title mb-0\">Gohan Salmon</h6>\r\n");
      out.write("                                    <div class=\"text-yellow\"><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star\"></i><i class=\"fas fa-star-half-alt\"></i></div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"small\">Disfruta del mejor sushi en plato</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-footer text-center text-xs\"><i\r\n");
      out.write("                                        class=\"fas fa-store-alt mr-1\"></i>BISTRO</div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- PLATO N3 -->\r\n");
      out.write("                        <div class=\"col-lg-4\">\r\n");
      out.write("                            <a class=\"card lift\" href=\"#!\"><img class=\"card-img-top\" src=\"img/platos/bigmac.jpg\"\r\n");
      out.write("                                                                alt=\"...\" />\r\n");
      out.write("                                <div class=\"card-body text-center py-3\">\r\n");
      out.write("                                    <h6 class=\"card-title mb-0\">Big Mac</h6>\r\n");
      out.write("                                    <div class=\"text-yellow\"><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star\"></i><i class=\"fas fa-star\"></i><i\r\n");
      out.write("                                            class=\"fas fa-star-half-alt\"></i><i class=\"far fa-star\"></i></div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"small\">Contempla la famosa Big Mac</div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-footer text-center text-xs\"><i\r\n");
      out.write("                                        class=\"fas fa-store-alt mr-1\"></i>McDonald</div>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"svg-border-angled text-dark\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 100 100\" preserveAspectRatio=\"none\"\r\n");
      out.write("                         fill=\"currentColor\">\r\n");
      out.write("                    <polygon points=\"0,100 100,0 100,100\"></polygon>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/jspf/footer.jspf", out, false);
      out.write("\r\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\">\r\n");
      out.write("            </script>\r\n");
      out.write("            <!-- POR EL MOMENTO NO INFLUYE EL SCRIPT -->\r\n");
      out.write("            <script src=\"js/scripts.js\"></script>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${puntos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("t");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                            <div class=\"col-md-6 col-lg-4 col-xl-3\">\r\n");
          out.write("                                <a class=\"card lift\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><img class=\"card-img-top\" src=\"img/logosTiendas/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.imagen}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"...\" />\r\n");
          out.write("                                    <div class=\"card-body text-center py-3\">\r\n");
          out.write("                                        <h6 class=\"card-title mb-0\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                </a>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
