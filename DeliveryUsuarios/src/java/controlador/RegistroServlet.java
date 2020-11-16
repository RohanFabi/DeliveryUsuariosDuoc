/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.TipoUsuario;
import modelo.Usuario;

/**
 *
 * @author dream
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/Registro"})
public class RegistroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDAO udao = new UsuarioDAO();

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
        //limpio los mensajes
        session.removeAttribute("msjok");
        session.removeAttribute("msjerror");
        request.getRequestDispatcher("registro.jsp").forward(request, response);
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
        request.getRequestDispatcher("registro.jsp").forward(request, response);
        //instancio sesion
        HttpSession session = request.getSession();
        //rescato el rut
        String rut = request.getParameter("rut");
        //lo formateo
        rut = rut.replaceAll("\\.", "");
        rut = rut.replaceAll("-", "");
        //busco si ya hay un usuario con ese rut
        Usuario u = udao.buscarUsuarioRut(rut);
        //si el usuario ya existe
        if (u != null) {
            //guardo un mensaje
            session.setAttribute("msjerror", "Este rut ya esta registrado, si olvido su contraseña dirijase a un administrador");
            //redirecciono
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        } else {
            //reviso con el email
            String email = request.getParameter("email");
            u = udao.buscarUsuarioEmail(email);
            if (u != null) {
                //guardo un mensaje
                session.setAttribute("msjerror", "Este email ya esta registrado, si olvido su contraseña dirijase a un administrador");
                //redirecciono
//                request.getRequestDispatcher("registro.jsp").forward(request, response);
            } else {
                //rescato los datos
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String telefono = request.getParameter("telefono");
                String contrasena = request.getParameter("contrasena2");

                //los datos que faltan del usuario:
                TipoUsuario tu = new TipoUsuario();
                //3 es el id de colaborador
                tu.setIdTipoUsuario(3);

                //instanciamos el usuario con los datos
                u = new Usuario(tu, rut, nombre, apellido, email, contrasena, true);
                //si el telefono no esta vacio
                if (telefono.isEmpty() == false) {
                    //guardo el telefono en el usuario
                    u.setTelefono(Integer.parseInt(telefono));
                }
                //guardamos
                int id = udao.guardar(u);
                //si guardo en bd
                if (id > 0) {
                    //guardo un mensaje exito
                    session.setAttribute("msjok", "registro exitoso, ya puede ingresar");
                } else {
                    //guardo un mensaje error
                    session.setAttribute("msjerror", "no se pudo registrar, intentelo nuevamente");
                }
            }

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
