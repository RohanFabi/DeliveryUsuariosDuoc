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
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
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
    
    public PuntoVenta buscar(int id){
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement("Select * from punto_venta where id_punto_venta = ?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            PuntoVenta p=new PuntoVenta();
            while(rs.next()){
               p.setIdPuntoVenta(rs.getInt("id_punto_venta"));
               p.setNombre(rs.getString("nombre"));
               p.setEmpresa(rs.getString("empresa"));
               p.setImagen(rs.getString("imagen")); 
               p.setActivo(rs.getBoolean("activo"));
            }    
            return p;
            
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            objConn.Cerrar();
        }
    }
    
}
