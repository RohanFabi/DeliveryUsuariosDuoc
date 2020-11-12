/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ProductoDAO;
import java.util.Iterator;
import java.util.List;
import modelo.Producto;

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
        Producto p = pd.buscarProducto(3);

        System.out.println("producto "+p.getNombre());
        
        p.setNombre("jugo 200cc");
        pd.modificar(p);
        p = pd.buscarProducto(3);
        System.out.println("producto "+p.getNombre());

    }

}
