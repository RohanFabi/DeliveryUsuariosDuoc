package modelo;
// Generated 10-11-2020 13:52:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sede generated by hbm2java
 */
@Entity
@Table(name="sede"
    ,catalog="deliveryduoc"
)
public class Sede  implements java.io.Serializable {


     private Integer idSede;
     private String nombreSede;
     private String direccion;
     private Set<Ubicacion> ubicacions = new HashSet<Ubicacion>(0);
     private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);

    public Sede() {
    }

	
    public Sede(String nombreSede, String direccion) {
        this.nombreSede = nombreSede;
        this.direccion = direccion;
    }
    public Sede(String nombreSede, String direccion, Set<Ubicacion> ubicacions, Set<PuntoVenta> puntoVentas) {
       this.nombreSede = nombreSede;
       this.direccion = direccion;
       this.ubicacions = ubicacions;
       this.puntoVentas = puntoVentas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_sede", unique=true, nullable=false)
    public Integer getIdSede() {
        return this.idSede;
    }
    
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    
    @Column(name="nombre_sede", nullable=false, length=50)
    public String getNombreSede() {
        return this.nombreSede;
    }
    
    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    
    @Column(name="direccion", nullable=false, length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sede")
    public Set<Ubicacion> getUbicacions() {
        return this.ubicacions;
    }
    
    public void setUbicacions(Set<Ubicacion> ubicacions) {
        this.ubicacions = ubicacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sede")
    public Set<PuntoVenta> getPuntoVentas() {
        return this.puntoVentas;
    }
    
    public void setPuntoVentas(Set<PuntoVenta> puntoVentas) {
        this.puntoVentas = puntoVentas;
    }




}


