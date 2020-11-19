/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProductoDAO;
import DAO.UbicacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DetallePedido;
import modelo.Estado;
import modelo.MetodoPago;
import modelo.Pedido;
import modelo.Producto;
import modelo.PuntoVenta;
import modelo.TipoEntrega;
import modelo.Ubicacion;
import modelo.Usuario;

/**
 *
 * @author dream
 */
@WebServlet(name = "DetalleCompraServlet", urlPatterns = {"/DetalleCompra"})
public class DetalleCompraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoDAO pdao = new ProductoDAO();
    UbicacionDAO ubdao = new UbicacionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //busco si viene con opcion
        String op = request.getParameter("op");
        if (op != null) {
            //si la opcion no esta vacia es cancelar
            //limpio el carrito
            request.getSession().removeAttribute("carrito");
        }
        //buscar la sede del usuario
        Usuario u = (Usuario) request.getSession().getAttribute("login");
        int sede = u.getSede().getIdSede();
        //buscar las ubicaciones
        List<Ubicacion> ubicaciones = ubdao.listarUbicacionesSede(sede);
        //guardo para mostrar
        request.getSession().setAttribute("ubicaciones", ubicaciones);
        //limpio los mensajes de error
        request.getSession().removeAttribute("msjErrorCarrito");
        //redirecciona a pagina
        request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //si no se invalido la sesion por tiempo
        try {
            //busco el login
            Usuario u = (Usuario) request.getSession().getAttribute("login");
            //valido si llego solo un colaborador
            if (u.isActivo() && u.getTipoUsuario().getIdTipoUsuario() == 3) {
                //recojo la accion del boton enviado
                String accion = request.getParameter("enviar");

                try {
                    //si hay accion a evaluar
                    switch (accion) {

                        case "Quitar":
                            //busco el id del producto a quitar
                            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                            //busco el carrito
                            List<DetallePedido> carrito = (List<DetallePedido>) request.getSession().getAttribute("carrito");
                            //busco el producto en el carrito
                            for (DetallePedido pedido : carrito) {
                                if (pedido.getProducto().getIdProducto() == idProducto) {
                                    //lo elimina del carrito
                                    carrito.remove(pedido);
                                }
                            }
                            response.sendRedirect("DetalleCompra");
                            break;
                        case "Ordenar":
                            //busco el medio de entrega
                            String tipoe=request.getParameter("rbEntrega");
                            TipoEntrega tipoEntrega=new TipoEntrega();
                            //si el tipo de entrega fue escojido
                            if (tipoe!=null) {
                                //lo parseo para usar como id
                                int idTipoEntrega=Integer.parseInt(tipoe);
                                
                                tipoEntrega.setIdTipoEntrega(idTipoEntrega);
                            }else{
                                //seteo un mensaje y redirecciono
                                request.getSession().setAttribute("msjErrorCarrito", "Debe escojer un metodo de entrega");
                                request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);
                            }
                            Ubicacion ubicacion=new Ubicacion();
                            //busco la ubicacion
                            String ubi=request.getParameter("cboUbicacion");
                            //si hay una ubicacion escojida
                            if (ubi!=null) {
                                //praseo para usar
                                int idUbicacion=Integer.parseInt(ubi);
                                
                                ubicacion.setIdUbicacion(idUbicacion);
                            }else{
                                //seteo un mensaje y redirecciono
                                request.getSession().setAttribute("msjErrorCarrito", "Debe escojer una ubicacion");
                                request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);
                            }
                            //busco el detalleUbicacion
                            String detalleUbicacion=request.getParameter("detalleUbicacion");
                            if (detalleUbicacion==null || detalleUbicacion.equals("")) {
                                request.getSession().setAttribute("msjErrorCarrito", "Debe anotar la sala, oficina o cualquier otro dato de utilidad");
                                request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);
                            }
                            //set metodo pago
                            MetodoPago metodoPago=new MetodoPago();
                            //busco el medio de entrega
                            String metodop=request.getParameter("rbPago");
                            //si el tipo de entrega fue escojido
                            if (metodop!=null) {
                                //lo parseo para usar como id
                                int idMetodoPago=Integer.parseInt(metodop);
                                metodoPago.setIdMetodo(idMetodoPago);
                            }else{
                                //seteo un mensaje y redirecciono
                                request.getSession().setAttribute("msjErrorCarrito", "Debe escojer un metodo de entrega");
                                request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);
                            }
                            Estado estado=new Estado();
                            estado.setIdEstado(1);
                            //Armo el pedido
//                            Pedido pedido=new Pedido(estado, metodoPago, tipoEntrega, ubicacion, u, fechaventa, idProducto);
                            //seteo detalle ubicacion en pedido
//                            pedido.setDetalleUbicacion(detalleUbicacion);
                            //busco el carrito
                            List<DetallePedido> carrit = (List<DetallePedido>) request.getSession().getAttribute("carrito");
                            
                            break;
                        default:
                            response.sendRedirect("DetalleCompra");
                            break;
                    }
                } catch (Exception e) {
                    //redirecciona a servlet
                    response.sendRedirect("DetalleCompra");
                    //request.getRequestDispatcher("Delivery/detalle_compra.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            //redirecciona a servlet
            response.sendRedirect("index");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
