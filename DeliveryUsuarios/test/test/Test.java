/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.PedidoDAO;
import DAO.ProductoDAO;
import DAO.PuntoVentaDAO;
import java.util.Iterator;
import java.util.List;
import modelo.Categoria;
import modelo.DetallePedido;
import modelo.Pedido;
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
//        List<Categoria> categorias = pd.listarCategoriasPunto(1);
//
//        for (Categoria c : categorias) {
//            System.out.println(c.getIdCategoria()+" "+c.getDescripcion());
//        }

//            PuntoVentaDAO pvDAO=new PuntoVentaDAO();
//            PuntoVenta pv=pvDAO.buscarNombreSede("Achoclonados", 1);
//            System.out.println("nombre punto "+pv.getNombre());
//        PedidoDAO dpDAO= new PedidoDAO();
//        List<Pedido> pedidos = dpDAO.listarPedidosActivosbyPuntoVenta(1);
//        for (Pedido c : pedidos) {
//            System.out.println("id pedido:"+c.getIdPedido()+" id Estado"+c.getEstado().getIdEstado());
//        }
        
         List<Producto> productos = pd.listarProductosActivoByTiendaCategoria(1, 1);
         for (Producto c : productos) {
            System.out.println("nombre "+c.getNombre());
        }
        

    }

}
