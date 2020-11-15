package org.apache.jsp.Delivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detalle_005fcompra_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("        <title>Detalle compra</title>\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../WEB-INF/jspf/menuPrincipal.jspf", out, false);
      out.write("\r\n");
      out.write("            <!----------------------------------------------------------------------->    \r\n");
      out.write("            <section class=\"bg-white pt-5 pb-10\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <!-- SECCION IZQUIERDA - DE OPCIONES -->\r\n");
      out.write("                        <div class=\"col-lg-4 col-xl-3 mb-5\">\r\n");
      out.write("                            <!-- Cancelar compra -->\r\n");
      out.write("                            <div class=\"card mb-2\">\r\n");
      out.write("                                <div class=\"list-group list-group-flush small\">\r\n");
      out.write("                                    <!-- TODOS -->\r\n");
      out.write("                                    <a class=\"list-group-item list-group-item-action \" href=\"#!\"><i\r\n");
      out.write("                                            class=\"fas fa-times-circle fa-fw mr-2 text-gray-400\"></i>Cancelar\r\n");
      out.write("                                    </a>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <!-- forma de  envio -->\r\n");
      out.write("                            <div class=\"card rounded-lg text-dark \">\r\n");
      out.write("                                <div class=\"card-header py-3 \">\r\n");
      out.write("                                    <!-- Forma de envio -->\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\" form-row container \">\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"custom-control custom-radio  col-sm-8\">\r\n");
      out.write("                                            <input class=\"custom-control-input\" id=\"customRadio1\" type=\"radio\"\r\n");
      out.write("                                                   name=\"customRadio\">\r\n");
      out.write("                                            <label class=\"custom-control-label\" for=\"customRadio1\">Retiro</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"custom-control custom-radio col-sm-8\">\r\n");
      out.write("                                            <input class=\"custom-control-input\" id=\"customRadio2\" type=\"radio\"\r\n");
      out.write("                                                   name=\"customRadio\">\r\n");
      out.write("                                            <label class=\"custom-control-label\" for=\"customRadio2\">Depacho</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <form>\r\n");
      out.write("                                        <!-- Torre y Piso -->\r\n");
      out.write("                                        <div class=\"form-row\">\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"form-group col-md-6\">\r\n");
      out.write("                                                <!-- Sede -->\r\n");
      out.write("                                                <label for=\"torre\">Torre</label><select class=\"form-control\"\r\n");
      out.write("                                                                                        id=\"torre\">\r\n");
      out.write("                                                    <option>Selecciona</option>\r\n");
      out.write("                                                    <option>A</option>\r\n");
      out.write("                                                    <option>B</option>\r\n");
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"form-group col-md-6\">\r\n");
      out.write("                                                <!-- piso -->\r\n");
      out.write("                                                <label for=\"piso\">Piso</label><select class=\"form-control\"\r\n");
      out.write("                                                                                      id=\"piso\">\r\n");
      out.write("                                                    <option>Selecciona</option>\r\n");
      out.write("                                                    <option>1</option>\r\n");
      out.write("                                                    <option>2</option>\r\n");
      out.write("\r\n");
      out.write("                                                </select>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <!-- Sala o ubicación -->\r\n");
      out.write("                                        <div class=\"form-group\"><label class=\"small text-gray-600\"\r\n");
      out.write("                                                                       for=\"leadCapEmail\">Sala/Ubicación\r\n");
      out.write("                                            </label><input class=\"form-control rounded-pill\" id=\"leadCapEmail\"\r\n");
      out.write("                                                           type=\"email\" /></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <!-- BOTON -->\r\n");
      out.write("                                        <button class=\"btn btn-primary btn-marketing btn-block rounded-pill mt-4\"\r\n");
      out.write("                                                type=\"submit\">Ordenar!</button>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- SECCION DERECHA - DE CASOS -->\r\n");
      out.write("                        <div class=\"col-lg-8 col-xl-9\">\r\n");
      out.write("                            <div class=\"table-responsive\">\r\n");
      out.write("                                <table class=\"table\">\r\n");
      out.write("\r\n");
      out.write("                                    <thead class=\"thead-dark\">\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th scope=\"col\">#</th>\r\n");
      out.write("                                            <th scope=\"col\">Producto</th>\r\n");
      out.write("                                            <th scope=\"col\">Total</th>\r\n");
      out.write("                                            <th scope=\"col\">Subtotal</th>\r\n");
      out.write("                                            <th scope=\"col\">Cantidad</th>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th scope=\"row\">1</th>\r\n");
      out.write("                                            <td><img src=\"img/platos/Gohan-Salmón.jpg\" width=\"120\" height=\"100\">\r\n");
      out.write("                                            </td>\r\n");
      out.write("\r\n");
      out.write("                                            <td>$1.999</td>\r\n");
      out.write("                                            <td>$1.999</td>\r\n");
      out.write("                                            <td>1</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th scope=\"row\">2</th>\r\n");
      out.write("                                            <td><img src=\"img/platos/muffin.jpg\" width=\"120\" height=\"100\">\r\n");
      out.write("                                            </td>\r\n");
      out.write("\r\n");
      out.write("                                            <td>$1.999</td>\r\n");
      out.write("                                            <td>$1.999</td>\r\n");
      out.write("                                            <td>2</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th scope=\"row\">3</th>\r\n");
      out.write("                                            <td><img src=\"img/platos/promo3.jpg\" width=\"120\" height=\"100\">\r\n");
      out.write("                                            </td>\r\n");
      out.write("\r\n");
      out.write("                                            <td>$5.998</td>\r\n");
      out.write("                                            <td>$1.999</td>\r\n");
      out.write("                                            <td>3</td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th scope=\"row\">Total</th>\r\n");
      out.write("                                            <td></td>\r\n");
      out.write("                                            <td>$5.500</td>\r\n");
      out.write("                                            <td>$5.997</td>\r\n");
      out.write("                                            <td>6</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- EFECTO REDONDO CON COLOR DE FONDO -->\r\n");
      out.write("                <!-- <div class=\"svg-border-rounded text-dark\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 144.54 17.34\" preserveAspectRatio=\"none\"\r\n");
      out.write("                        fill=\"currentColor\">\r\n");
      out.write("                        <path d=\"M144.54,17.34H0V0H144.54ZM0,0S32.36,17.34,72.27,17.34,144.54,0,144.54,0\"></path>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div> -->\r\n");
      out.write("                <!-- EFECT DIGANAL DE COLOR DE FONDO -->\r\n");
      out.write("                <div class=\"svg-border-angled text-dark\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 100 100\" preserveAspectRatio=\"none\"\r\n");
      out.write("                         fill=\"currentColor\">\r\n");
      out.write("                    <polygon points=\"0,100 100,0 100,100\"></polygon>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!------------------------------------------------------------------------------------------------------------------>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../WEB-INF/jspf/footer.jspf", out, false);
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
}
