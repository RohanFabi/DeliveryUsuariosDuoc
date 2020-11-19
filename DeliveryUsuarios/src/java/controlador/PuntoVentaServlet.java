/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProductoDAO;
import DAO.PuntoVentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.PuntoVenta;
import modelo.Usuario;

/**
 *
 * @author dream
 */
@WebServlet(name = "PuntoVentaServlet", urlPatterns = {"/PuntoVenta"})
public class PuntoVentaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    PuntoVentaDAO pvdao = new PuntoVentaDAO();
    ProductoDAO pdao = new ProductoDAO();

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
        //busco el punto de venta seleccionado
        String punto = request.getParameter("pv");
        //instancio el id de la sede
        int idSede;
        //busco si existe un login
        if (request.getSession().getAttribute("login") != null) {
            //si existe busco la sede del que esta logeado
            Usuario u = (Usuario) request.getSession().getAttribute("login");
            idSede = u.getSede().getIdSede();
        } else {
            //aqui: cuando se amplie a mas sedes, guardar la sede con javascript en el link
            //por ahora puse solo la de la sede que se esta usando
            idSede = 1;
        }
        //busco el punto de venta en la bd
        PuntoVenta pv = pvdao.buscarNombreSede(punto, idSede);
        //lo guardo en un atributo de sesion para mostrarlo
        request.getSession().setAttribute("puntoventa", pv);
        //busco los productos de ese punto
        List<Producto> productos = pdao.listarProductoIdTienda(pv.getIdPuntoVenta());
        //los guardo en un atributo de sesion para mostrarlos
        request.getSession().setAttribute("productos", productos);
        //busco las Categorias
        List<Categoria> categorias = pdao.listarCategoriasPunto(pv.getIdPuntoVenta());
        //los guardo en un atributo de sesion para mostrarlos
        request.getSession().setAttribute("categorias", categorias);
        //redirecciono a pagina
        request.getRequestDispatcher("Delivery/PuntoVenta.jsp").forward(request, response);

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
        //AGREGAR AL CARRITO
        //busco el producto
        int id = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = pdao.buscarProducto(id);
        //hago un pedido vacio para armar el detalle
        Pedido pedido = new Pedido();
        //armo el detalle pedido
        DetallePedido dp = new DetallePedido(pedido, producto, 1, producto.getPrecio());
        //busco el carrito si ya existia
        List<DetallePedido> carrito = (List<DetallePedido>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito=new ArrayList<DetallePedido>();
        }
        //agrego el detalle al carrito
        carrito.add(dp);
        //agrego el carrito a la session o sobreescribo
        request.getSession().setAttribute("carrito", carrito);
        //busco en que tienda estaba
        PuntoVenta pv = (PuntoVenta) request.getSession().getAttribute("puntoventa");
        response.sendRedirect("PuntoVenta?pv=" + pv.getNombre());
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
