/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
    
    public List<Producto> listarProductoIdTienda(int idPuntoVenta) { //Devuelve todos los productos de una tienda, buscandolos por ID del punto de venta
        List<Producto> productos = null; 
        Session sesion = HibernateUtil.getSessionFactory().openSession(); 
        try {
            String hql = "from Producto p where p.puntoVenta.idPuntoVenta= :id order by p.idProducto DESC";            
            Query q = sesion.createQuery(hql); 
            q.setParameter("id", idPuntoVenta); 
            productos = q.list();
            
            List<Categoria> categorias = null;
            hql = "from Categoria"; 
            q = sesion.createQuery(hql); 
            categorias = q.list(); 
            
            for(Producto p : productos){ 
                p.setCategoria(categorias.get(p.getCategoria().getIdCategoria())); 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return productos;
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
    
    public int guardar(Producto p) { //Metodo para guardar nuevos productos en la base de datos
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        int id = 0;
        try {
            Transaction tx = sesion.beginTransaction();
            id = (int)sesion.save(p);
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
    
    public void alternarActivo(int idProducto){
        Producto p = this.buscarProducto(idProducto);
        p.setActivo(!p.isActivo());
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
    
    public List<Categoria> listarCategoriasPunto(int idPuntoVenta){
        List<Categoria> categorias = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "Select new Categoria(c.idCategoria, c.descripcion) from Producto as p inner join p.categoria as c where p.puntoVenta.idPuntoVenta= :idPuntoVenta"
                    + " group by c.idCategoria";
            Query q = sesion.createQuery(hql);
            q.setParameter("idPuntoVenta", idPuntoVenta);
            
            categorias = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return categorias;
    }
    
    public List<Producto> listarProductosbyTiendaCategoria(int idPuntoVenta, int idCategoria) {
        List<Producto> productos = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Producto p where p.puntoVenta.idPuntoVenta= :idPuntoVenta and p.categoria.idCategoria= :idCategoria order by p.idProducto DESC";            
            Query q = sesion.createQuery(hql);
            q.setParameter("idPuntoVenta", idPuntoVenta);
            q.setParameter("idCategoria", idCategoria);
            
            productos = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return productos;
    }
    
    public Categoria buscarCategoriabyDescripcion(String descripcion) {
        Categoria categoria = new Categoria();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Categoria c where c.descripcion= :descripcion";            
            Query q = sesion.createQuery(hql);
            q.setParameter("descripcion", descripcion);
            
            categoria = (Categoria) q.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return categoria;
    }
    
    public List<Producto> listarProductosbyBusquedaTienda(String textoBusqueda, int idPuntoVenta) {
        List<Producto> productos = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Producto p where p.nombre LIKE :textoBusqueda and"
                    + " p.puntoVenta.idPuntoVenta= :idPuntoVenta order by p.idProducto DESC";            
            Query q = sesion.createQuery(hql);
            q.setParameter("idPuntoVenta", idPuntoVenta);
            q.setParameter("textoBusqueda", "%"+textoBusqueda+"%");
            
            productos = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return productos;
    }
}
