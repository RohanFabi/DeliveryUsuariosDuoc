/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ProductoDAO;
import DAO.PuntoVentaDAO;
import DAO.UsuarioDAO;
import java.util.Iterator;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;
import modelo.PuntoVenta;

/**
 *
 * @author dream
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProductoDAO pd = new ProductoDAO();
        System.out.println(pd.listarProductoIdTienda(1));


    }

}
