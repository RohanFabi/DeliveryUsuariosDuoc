/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dream
 */
public class Conexion {
    
    public static Conexion InstConn;
    private Connection conn;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/deliveryduoc?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public synchronized static Conexion InstanciaConn(){
        if(InstConn==null)
        {
            InstConn = new Conexion();
        }
        
        return InstConn;
    }
        
    public Connection getConn(){
        return conn;
    }
    
    public void Cerrar(){
        InstConn = null;
    }
}
