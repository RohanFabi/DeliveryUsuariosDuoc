package modelo;
// Generated 17-11-2020 11:48:38 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PuntoVenta generated by hbm2java
 */
public class PuntoVenta  implements java.io.Serializable {


     private Integer idPuntoVenta;
     private Sede sede;
     private String nombre;
     private String empresa;
     private String imagen;
     private Date horaInicio;
     private Date horaFin;
     private boolean activo;
     private Set<Producto> productos = new HashSet<Producto>(0);
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public PuntoVenta() {
    }

	
    public PuntoVenta(Sede sede, String nombre, String empresa, String imagen, Date horaInicio, Date horaFin, boolean activo) {
        this.sede = sede;
        this.nombre = nombre;
        this.empresa = empresa;
        this.imagen = imagen;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.activo = activo;
    }
    public PuntoVenta(Sede sede, String nombre, String empresa, String imagen, Date horaInicio, Date horaFin, boolean activo, Set<Producto> productos, Set<Usuario> usuarios) {
       this.sede = sede;
       this.nombre = nombre;
       this.empresa = empresa;
       this.imagen = imagen;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.activo = activo;
       this.productos = productos;
       this.usuarios = usuarios;
    }
   
    public Integer getIdPuntoVenta() {
        return this.idPuntoVenta;
    }
    
    public void setIdPuntoVenta(Integer idPuntoVenta) {
        this.idPuntoVenta = idPuntoVenta;
    }
    public Sede getSede() {
        return this.sede;
    }
    
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Date getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Date getHoraFin() {
        return this.horaFin;
    }
    
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


