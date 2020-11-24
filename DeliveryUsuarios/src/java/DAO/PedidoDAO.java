/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.DetallePedido;
import modelo.Pedido;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dream
 */
public class PedidoDAO {
    public int guardarPedido(Pedido p) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int id = 0;
        try {
            Transaction tx = sesion.beginTransaction();
            id = (int) sesion.save(p);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return id;
    }
    public int guardarDetallePedido(DetallePedido detalle) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int id = 0;
        try {
            Transaction tx = sesion.beginTransaction();
            id = (int) sesion.save(detalle);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return id;
    }
    
    public void modificarPedido(Pedido p) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(p);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
    } 
}
