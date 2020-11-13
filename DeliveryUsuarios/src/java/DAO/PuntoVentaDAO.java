/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PuntoVenta;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author dream
 */
public class PuntoVentaDAO {
    
  
    public List<PuntoVenta> listarPuntos() {
        List<PuntoVenta> puntos = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from PuntoVenta";
            Query q = sesion.createQuery(hql);

            puntos = q.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return puntos;
    }
    
    public PuntoVenta buscar(int id) {
        PuntoVenta punto = new PuntoVenta();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Punto p where p.idPuntoVenta= :id";            
            Query q = sesion.createQuery(hql);
            q.setParameter("id", id);
            
            punto = (PuntoVenta) q.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return punto;
    }
    
}
