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
import modelo.Usuario;

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
        //instancio sesion
        HttpSession session = request.getSession();
        //busco la operacion que viene en la url "Producto?op=..."
        String operacion = request.getParameter("op");
        
        //Si al acceder por url a gestionar productos, el usuario no es punto de venta, se le debe redirigir al indice.
        Usuario u = (Usuario) session.getAttribute("login");
        int id = 0; //Inicialización de la variable a un valor por defecto.
        //Que intente acceder al metodo getIdTipoUsuario() de la clase TipoUsuario, para asignar el resultado a id. 
        //Si falla, que rediriga al indice.
        try{ 
            id = u.getTipoUsuario().getIdTipoUsuario();
        }catch(Exception e){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        if(id != 2){ //Si el usuario no es un Punto de Venta, también redirige al indice:
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        //Se buscan las categorias de prodyctos y se guardan en una lista
        List<Categoria> categorias = objP.listarCategorias();
        //luego se guardan en un atributo para la pagina
        session.setAttribute("categorias", categorias);
        
        //si la operacion existe en la url
        if (operacion != null) {
            //busco la ultima r en el valor
            int i = operacion.lastIndexOf("r");
            //saco el valor hasta la r
            String op = operacion.substring(0, i + 1);
            //accion a tomar dependiendo del valor
            switch (op) {
                
                case "modificar":
                    //si el valor es modificar 
                    //entra a metodo modificar con ctrl+click en el nombre te lleva al metodo
                    verModificar(request, response);
                case "eliminar":
                    //si el valor es eliminar te lleva al metodo
                    eliminar(request, response);
                    break;
                default:
                    //esto enrealidad jamas deberia pasar pero porsiacaso
                    List<Producto> productos = objP.listarProductos();
                    session.setAttribute("productos", productos);
                    request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
            }
        } else {
            //si no hay opcion en la url
            //busco los productos y los guardo en una lista
            List<Producto> productos = objP.listarProductos();
            //los guardo en un atributo para la pagina
            session.setAttribute("productos", productos);
            //redirecciono a la pagina
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
        
    }

    private void verModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //leo el valor de la opcion que viene en la url
        String opcion = request.getParameter("op");
        //busco la ultima r en el valor
        int i = request.getParameter("op").lastIndexOf("r");
        //busco el id que viene despues de la r del valor
        int id = Integer.parseInt(opcion.substring(i + 1));
        //busco el producto con el id
        Producto producto = objP.buscarProducto(id);
        //busco las categorias
        List<Categoria> categorias = objP.listarCategorias();
        //instancio una sesion
        HttpSession session = request.getSession();
        //guardo en un aributo las categorias y el producto
        session.setAttribute("categorias", categorias);
        session.setAttribute("producto", producto);
//        redirecciono a la pagina
        request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
    }

    private void guardarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //instancio sesion
        HttpSession session = request.getSession();
        //busco el nombre del input
        String nombre = request.getParameter("nombre");
        //busco el precio del input
        int precio = Integer.parseInt(request.getParameter("precio"));
        //busco la categoria del combobox
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
        int puntoVenta = 1;
        //GUARDAR IMAGEN EN EL PROYECTO
        //busco el nombre de la imagen del input que esta oculto
        String imagen = request.getParameter("nombreImagen");
        //busco el archivo de imagen
        Part archivo = request.getPart("imagen");
        //lo transforma en una cadena de datos
        InputStream is = archivo.getInputStream();
        //crea un archivo en la locacion indicada
        File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/Delivery v02/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
        //lee los datos y los guarda en el archivo
        FileOutputStream ous = new FileOutputStream(f);
        int dato = is.read();
        while (dato != -1) {
            ous.write(dato);
            dato = is.read();
        }
        ous.close();
        is.close();
        //FIN GUARDAR IMAGEN
        //hago una categoria y le seteo el id
        Categoria cat = new Categoria();
        cat.setIdCategoria(categoria);
        //hago un punto de venta y le seteo el id
        PuntoVenta punto = new PuntoVenta();
        punto.setIdPuntoVenta(puntoVenta);
        //id del producto = guardar producto en la bd
        int id = objP.guardar(new Producto(cat, punto, nombre, precio, imagen, true));
        //redirecciono a la pagina
        request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //busco el id del input oculto
        int idProducto = Integer.parseInt(request.getParameter("id"));
        //busco el nombre del input
        String nombre = request.getParameter("nombre");
        //busco el precio del input
        int precio = Integer.parseInt(request.getParameter("precio"));
        //busco la categoria del combobox
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
        int puntoVenta = 1;
        //GUARDAR IMAGEN EN EL PROYECTO
        //busco el nombre de la imagen del input que esta oculto
        String imagen = request.getParameter("nombreImagen");
        //si la imagen no fue cambiada
        if (imagen.isEmpty()) {
            //guardo el nombre de la imagen actual qque esta en el input oculto
            imagen = request.getParameter("imagenActual");
        } else {
            //GUARDAR IMAGEN EN EL PROYECTO 
            //busco el archivo de imagen
            Part archivo = request.getPart("imagen");
            //lo transforma en una cadena de datos
            InputStream is = archivo.getInputStream();
            //crea un archivo en la locacion indicada
            File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/Delivery v02/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
            //lee los datos y los guarda en el archivo
            FileOutputStream ous = new FileOutputStream(f);
            int dato = is.read();
            while (dato != -1) {
                ous.write(dato);
                dato = is.read();
            }
            ous.close();
            is.close();
        }

        //hago una categoria y le seteo el id
        Categoria cat = new Categoria();
        cat.setIdCategoria(categoria);
        //hago un punto de venta y le seteo el id
        PuntoVenta punto = new PuntoVenta();
        punto.setIdPuntoVenta(puntoVenta);
        //instancio un producto con los datos
        Producto producto = new Producto(cat, punto, nombre, precio, imagen, true);
        producto.setIdProducto(idProducto);
        //modificar producto
        objP.modificar(producto);

        HttpSession session = request.getSession();
        //guardo elproducto para verlo con los nuevos datos
        session.setAttribute("producto", producto);
        //redirecciono a la pagina
        request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
    }

}
