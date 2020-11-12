/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.ProductoDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Categoria;
import modelo.Producto;
import modelo.PuntoVenta;

/**
 *
 * @author dream
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/Producto"})
@MultipartConfig
public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductoDAO objP = new ProductoDAO();

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
        HttpSession session = request.getSession();

        String operacion = request.getParameter("op");

        if (operacion != null) {
            int i = operacion.lastIndexOf("r");
            String op = operacion.substring(0, i + 1);
            System.out.println(op);
            switch (op) {

                case "crear":
                    List<Categoria> categorias = objP.listarCategorias();
                    session.setAttribute("categorias", categorias);
                    request.getRequestDispatcher("Mantenedor/CrearProducto.jsp").forward(request, response);
                    break;
                case "modificar":
                    verModificar(request, response);
                case "eliminar":
                    eliminar(request, response);
                    break;
                case "ver":
                default:
                    List<Producto> productos = objP.listarProductos();
                    session.setAttribute("productos", productos);
                    request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
            }
        } else {
            List<Producto> productos = objP.listarProductos();
            session.setAttribute("productos", productos);
            request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
        }

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
        String accion = request.getParameter("guardar");
        switch (accion) {
            case "Guardar":
                guardarProducto(request, response);
                break;
            case "Modificar":
                modificarProducto(request, response);
                break;
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

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void verModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("op");
        int i = request.getParameter("op").lastIndexOf("r");
        int id = Integer.parseInt(opcion.substring(i + 1));
        Producto producto = objP.buscarProducto(id);
        List<Categoria> categorias = objP.listarCategorias();
        HttpSession session = request.getSession();
        session.setAttribute("categorias", categorias);
        session.setAttribute("producto", producto);
        request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
    }

    private void guardarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
        int puntoVenta = 1;
        //guardar imagen en el proyecto
        String imagen = request.getParameter("nombreImagen");
        Part archivo = request.getPart("imagen");
        InputStream is = archivo.getInputStream();
        File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
        FileOutputStream ous = new FileOutputStream(f);
        int dato = is.read();
        while (dato != -1) {
            ous.write(dato);
            dato = is.read();
        }
        ous.close();
        is.close();

        Categoria cat = new Categoria();
        cat.setIdCategoria(categoria);
        PuntoVenta punto = new PuntoVenta();
        punto.setIdPuntoVenta(puntoVenta);
        int guardado = objP.guardar(new Producto(cat, punto, nombre, precio, imagen, true));
        request.getRequestDispatcher("Mantenedor/CrearProducto.jsp").forward(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProducto = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio"));
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
        int puntoVenta = 1;

        String imagen = request.getParameter("nombreImagen");
        //si la imagen no fue cambiada
        if (imagen.isEmpty()) {
            imagen = request.getParameter("imagenActual");
        } else {
            //guardar imagen en el proyecto 
            Part archivo = request.getPart("imagen");
            InputStream is = archivo.getInputStream();
            File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
            FileOutputStream ous = new FileOutputStream(f);
            int dato = is.read();
            while (dato != -1) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
        }

        Categoria cat = new Categoria();
        cat.setIdCategoria(categoria);
        PuntoVenta punto = new PuntoVenta();
        punto.setIdPuntoVenta(puntoVenta);

        Producto producto = new Producto(cat, punto, nombre, precio, imagen, true);
        producto.setIdProducto(idProducto);
        objP.modificar(producto);
        
        HttpSession session = request.getSession();
        session.setAttribute("producto", producto);
        request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
    }

}
