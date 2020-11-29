
package controlador;

import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
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

    ProductoDAO objP = new ProductoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //instancio sesion
        HttpSession session = request.getSession();
        session.removeAttribute("productoMod"); 
        session.removeAttribute("productos"); 
        session.setAttribute("modo", "Guardar"); //Se entra a la página con la opción de crear un producto
        comprobarAcceso(session,request,response);//Si el usuario no "tiene permiso" para estar aquí, se va al indice.
        //Se buscan las categorias de prodyctos y se guardan en una lista
        List<Categoria> categorias = objP.listarCategorias();
        //luego se guardan en un atributo para la pagina
        session.setAttribute("categorias", categorias);
        
        actualizarProductos(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        comprobarAcceso(request.getSession(),request,response);//Si el usuario no "tiene permiso" para estar aquí, se va al indice.
        String accion = request.getParameter("btnPost");
        switch (accion) {
            case "Guardar":
                guardarProducto(request, response);
                break; 
            case "Cancelar": //Si se pulsa el botón de cancelar, se recarga la página, entrando por doGet de este archivo
                response.sendRedirect("Producto");
                break;
            case "Modificar": //Entrar por apretar este botón selecciona el producto y pone sus datos en los campos de registro
                request.getSession().setAttribute("modo", "Actualizar");
                //si el valor es modificar, se entra a este metodo
                seleccionarParaModificar(request, response);
                break;
            case "Actualizar":
                modificarProducto(request, response);
                break;
            case "Desactivar":
                ProductoDAO pDAO = new ProductoDAO();
                pDAO.alternarActivo(0);
//                alternarProdHabilitado(request,response);
                break;
        }
    }

    private void deshabilitar(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    private void seleccionarParaModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //busco el id que viene despues de la r del valor
        //Ojalá se debiese cambiar esto para no tener que sacar el ID producto desde un input invisible, porque esto se podría explotar o utilizar mal a proposito.
        int id = Integer.parseInt(request.getParameter("idProd")); 
        //busco el producto con el id
        Producto producto = objP.buscarProducto(id);
        //instancio una sesión
        HttpSession session = request.getSession();
        //guardo en un atributo el producto
        session.setAttribute("productoMod", producto);
//        redirecciono a la pagina
        request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
    }
    
    private void guardarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Se guardan los atributos de la sesión temporalmente como objetos.
        HttpSession session = request.getSession();
        
        Usuario respUser = (Usuario)session.getAttribute("login");
        List<Categoria> respCateg = (List<Categoria>)session.getAttribute("categoria");
        List<PuntoVenta> respPuntosVenta = (List<PuntoVenta>)session.getAttribute("puntos");
        List<Producto> respProducto = (List<Producto>)session.getAttribute("productos");
        
        //busco el nombre del input
        String nombre = request.getParameter("nombre");
        //busco el precio del input
        int precio = Integer.parseInt(request.getParameter("precio"));
        //busco la categoria del combobox
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //GUARDAR IMAGEN EN EL PROYECTO:
        //busco el nombre de la imagen del input que esta oculto
        String imagen = request.getParameter("nombreImagen");
        //busco el archivo de imagen
        Part archivo = request.getPart("imagen");
        //lo transforma en una cadena de datos
        InputStream is = archivo.getInputStream();
        //crea un archivo en la locacion indicada
//        File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/Delivery v02/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
        File f = new File("C:/Users/DiegoM/Desktop/DeliveryUsuariosDuoc/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
        //lee los datos y los guarda en el archivo
        FileOutputStream ous = new FileOutputStream(f);
        int dato = is.read();
        while (dato != -1) {
            ous.write(dato);
            dato = is.read();
        }
        ous.close();
        is.close(); //FIN GUARDAR IMAGEN
        //hago una categoria y le seteo el id
        Categoria cat = new Categoria();
        cat.setIdCategoria(categoria);
        //hago un punto de venta y le seteo el id a partir del idPuntoVenta presente en el usuario respaldado.
        PuntoVenta punto = respUser.getPuntoVenta(); 
        //id del producto = guardar producto en la bd
        int id = objP.guardar(new Producto(cat, punto, nombre, precio, imagen, true));        
        
        actualizarProductos(request,response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //busco el id en la sesion
        Producto productoMod=(Producto)session.getAttribute("productoMod");
        int idProducto = productoMod.getIdProducto();
        //busco el nombre del input
        String nombre = request.getParameter("nombre");
        //busco el precio del input
        int precio = Integer.parseInt(request.getParameter("precio"));
        //busco la categoria del combobox
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
        Usuario usuarioLog=(Usuario)session.getAttribute("login");
        int puntoVenta = usuarioLog.getPuntoVenta().getIdPuntoVenta();
        //GUARDAR IMAGEN EN EL PROYECTO
        //busco el nombre de la imagen del input que esta oculto
        String imagen = request.getParameter("nombreImagen");
        //si la imagen no fue cambiada
        if (imagen==null||imagen.isEmpty()) {
            //guardo el nombre de la imagen actual qque esta en el input oculto
            imagen = productoMod.getImagen();
        } else {
            //GUARDAR IMAGEN EN EL PROYECTO 
            //busco el archivo de imagen
            Part archivo = request.getPart("imagen");
            //lo transforma en una cadena de datos
            InputStream is = archivo.getInputStream();
            //crea un archivo en la locacion indicada
            File f = new File("C:/Users/DiegoM/Desktop/DeliveryUsuariosDuoc/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
            //File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/Delivery v02/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
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
        //guardo elproducto para verlo con los nuevos datos
        session.setAttribute("productoMod", producto);
        //redirecciono a la pagina
        //request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
        response.sendRedirect("Producto");
    }
    
//    private void alternarProdHabilitado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        HttpSession session = request.getSession();
//        //busco el id en la sesion
//        Producto productoMod=(Producto)session.getAttribute("productoMod");
//        int idProducto = productoMod.getIdProducto();
//        //busco el nombre del input
//        String nombre = request.getParameter("nombre");
//        //busco el precio del input
//        int precio = Integer.parseInt(request.getParameter("precio"));
//        //busco la categoria del combobox
//        int categoria = Integer.parseInt(request.getParameter("categoria"));
//        //ESTE HAY QUE CAMBIARLO cuando tengamos el id de la tienda por sesion
//        Usuario usuarioLog=(Usuario)session.getAttribute("login");
//        int puntoVenta = usuarioLog.getPuntoVenta().getIdPuntoVenta();
//        //GUARDAR IMAGEN EN EL PROYECTO
//        //busco el nombre de la imagen del input que esta oculto
//        String imagen = request.getParameter("nombreImagen");
//        //si la imagen no fue cambiada
//        if (imagen==null||imagen.isEmpty()) {
//            //guardo el nombre de la imagen actual qque esta en el input oculto
//            imagen = productoMod.getImagen();
//        } else {
//            //GUARDAR IMAGEN EN EL PROYECTO 
//            //busco el archivo de imagen
//            Part archivo = request.getPart("imagen");
//            //lo transforma en una cadena de datos
//            InputStream is = archivo.getInputStream();
//            //crea un archivo en la locacion indicada
//            File f = new File("C:/Users/DiegoM/Desktop/DeliveryUsuariosDuoc/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
//            //File f = new File("C:/Users/dream/Documents/proyecto delivery iVaras/DeliveryFS/Delivery v02/DeliveryUsuarios/web/Delivery/media/producto/" + imagen);
//            //lee los datos y los guarda en el archivo
//            FileOutputStream ous = new FileOutputStream(f);
//            int dato = is.read();
//            while (dato != -1) {
//                ous.write(dato);
//                dato = is.read();
//            }
//            ous.close();
//            is.close();
//        }
//        //hago una categoria y le seteo el id
//        Categoria cat = new Categoria();
//        cat.setIdCategoria(categoria);
//        //hago un punto de venta y le seteo el id
//        PuntoVenta punto = new PuntoVenta();
//        punto.setIdPuntoVenta(puntoVenta);
//        //instancio un producto con los datos
//        Producto producto = new Producto(cat, punto, nombre, precio, imagen, true);
//        producto.setIdProducto(idProducto);
//        //modificar producto
//        objP.modificar(producto);
//        //guardo elproducto para verlo con los nuevos datos
//        session.setAttribute("productoMod", producto);
//        //redirecciono a la pagina
//        //request.getRequestDispatcher("Mantenedor/ModificarProducto.jsp").forward(request, response);
//        response.sendRedirect("Producto");
//    }
    
    private void comprobarAcceso(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
    }
    
    private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //Se saca el id punto de venta a partir del usuario logueado, desde ahí se trae un listado de productos de ese punto de venta usando el id obtenido al inicio. 
        Integer idPuntoVenta = ((Usuario) session.getAttribute("login")).getPuntoVenta().getIdPuntoVenta();
        List<Producto> productos = objP.listarProductoIdTienda(idPuntoVenta);
        //los guardo en un atributo para la pagina
        session.setAttribute("productos", productos);
        //redirecciono a la pagina
        request.getRequestDispatcher("Mantenedor/InicioProducto.jsp").forward(request, response);
    }

}