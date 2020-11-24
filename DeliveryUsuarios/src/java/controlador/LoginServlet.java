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
import modelo.Usuario;

/**
 *
 * @author dream
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        //limpio los mensajes
        request.getSession().removeAttribute("msjerror");
        //busco la info del login
        Usuario u = (Usuario) request.getSession().getAttribute("login");

        //si hay un usuario logeado es porque entre con el boton salir
        //entonces limpio la sesion y redirecciono
        if (u != null) {
            request.getSession().invalidate();
            response.sendRedirect("index");
        } else {
            //redirecciono
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
        //busco los datos
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        //busco si hay un login activo
        UsuarioDAO udao = new UsuarioDAO();
        Usuario usuario = udao.buscarUsuarioLogin(email, contrasena);
        //si te devolvio algun usuario
        if (usuario != null) {
            //si el usuario esta activo
            if (usuario.isActivo()) {
                if (usuario.getTipoUsuario().getIdTipoUsuario() == 2) {
                    request.getSession().setAttribute("login", usuario);
                    response.sendRedirect("Administracion");
                } else if (usuario.getTipoUsuario().getIdTipoUsuario() == 3) {
                    request.getSession().setAttribute("login", usuario);
                    response.sendRedirect("index");
                } else {
                    request.getSession().setAttribute("msjerror", "Dirijase a modulo de administracion");
                    //redirecciono para q no borre el mensaje
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

        } else {
            //guardo un mensaje
            request.getSession().setAttribute("msjerror", "email o contraseña incorrectas, si olvido su contraseña dirijase a un administrador");
            //redirecciono para q no borre el mensaje
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
