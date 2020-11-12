/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Categoria;
import modelo.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dream
 */
public class ProductoDAO {
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public List<Producto> listarProductos() {
        List<Producto> productos = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Producto order by id_punto_venta";
            Query q = sesion.createQuery(hql);
            
            productos = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return productos;
    }
    
    public ArrayList<Producto> listarProductoIdTienda(int id_punto_venta) {
        try {
            ArrayList<Producto> LPro = new ArrayList();
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement("Select * from producto where id_punto_venta = ?");
            ps.setInt(1, id_punto_venta);
            rs = ps.executeQuery();
            while (rs.next()) {
//                LPro.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getInt("precio"), rs.getString("imagen"), rs.getBoolean("activo")));
            }
            return LPro;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            objConn.Cerrar();
        }
    }
    
    public Producto buscarProducto(int id) {
        Producto producto = new Producto();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Producto p where p.idProducto= :id";            
            Query q = sesion.createQuery(hql);
            q.setParameter("id", id);
            
            producto = (Producto) q.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return producto;
    }
    
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Categoria";
            Query q = sesion.createQuery(hql);
            
            categorias = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return categorias;
    }
    
    public int guardar(Producto p) {
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

    public void modificar(Producto p) {
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
