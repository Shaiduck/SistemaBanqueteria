/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_cotizar;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zaibeh
 */
@Entity
@Table(name = "cotizar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizar.findAll", query = "SELECT c FROM Cotizar c"),
    @NamedQuery(name = "Cotizar.findByIdcotizacion", query = "SELECT c FROM Cotizar c WHERE c.idcotizacion = :idcotizacion"),
    @NamedQuery(name = "Cotizar.findByNumpax", query = "SELECT c FROM Cotizar c WHERE c.numpax = :numpax"),
    @NamedQuery(name = "Cotizar.findByTotalpax", query = "SELECT c FROM Cotizar c WHERE c.totalpax = :totalpax"),
    @NamedQuery(name = "Cotizar.findByCostototal", query = "SELECT c FROM Cotizar c WHERE c.costototal = :costototal"),
    @NamedQuery(name = "Cotizar.findByEstado", query = "SELECT c FROM Cotizar c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cotizar.findByFechacotizar", query = "SELECT c FROM Cotizar c WHERE c.fechacotizar = :fechacotizar")})
public class Cotizar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcotizacion")
    private Integer idcotizacion;
    @Basic(optional = false)
    @Column(name = "numpax")
    private int numpax;
    @Basic(optional = false)
    @Column(name = "totalpax")
    private float totalpax;
    @Basic(optional = false)
    @Column(name = "costototal")
    private float costototal;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "fechacotizar")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacotizar;

    public Cotizar() {
    }

    public Cotizar(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public Cotizar(Integer idcotizacion, int numpax, float totalpax, float costototal, int estado, Date fechacotizar) {
        this.idcotizacion = idcotizacion;
        this.numpax = numpax;
        this.totalpax = totalpax;
        this.costototal = costototal;
        this.estado = estado;
        this.fechacotizar = fechacotizar;
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public int getNumpax() {
        return numpax;
    }

    public void setNumpax(int numpax) {
        this.numpax = numpax;
    }

    public float getTotalpax() {
        return totalpax;
    }

    public void setTotalpax(float totalpax) {
        this.totalpax = totalpax;
    }

    public float getCostototal() {
        return costototal;
    }

    public void setCostototal(float costototal) {
        this.costototal = costototal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechacotizar() {
        return fechacotizar;
    }

    public void setFechacotizar(Date fechacotizar) {
        this.fechacotizar = fechacotizar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcotizacion != null ? idcotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizar)) {
            return false;
        }
        Cotizar other = (Cotizar) object;
        if ((this.idcotizacion == null && other.idcotizacion != null) || (this.idcotizacion != null && !this.idcotizacion.equals(other.idcotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cotizar.Cotizar[ idcotizacion=" + idcotizacion + " ]";
    }
    
}
