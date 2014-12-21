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
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByIdevento", query = "SELECT a FROM Agenda a WHERE a.idevento = :idevento"),
    @NamedQuery(name = "Agenda.findByHoraEvento", query = "SELECT a FROM Agenda a WHERE a.horaEvento = :horaEvento"),
    @NamedQuery(name = "Agenda.findByTipoevento", query = "SELECT a FROM Agenda a WHERE a.tipoevento = :tipoevento"),
    @NamedQuery(name = "Agenda.findByCiudadevento", query = "SELECT a FROM Agenda a WHERE a.ciudadevento = :ciudadevento"),
    @NamedQuery(name = "Agenda.findByFechaevento", query = "SELECT a FROM Agenda a WHERE a.fechaevento = :fechaevento")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevento")
    private Integer idevento;
    @Basic(optional = false)
    @Column(name = "hora_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEvento;
    @Basic(optional = false)
    @Column(name = "tipoevento")
    private String tipoevento;
    @Basic(optional = false)
    @Column(name = "ciudadevento")
    private String ciudadevento;
    @Basic(optional = false)
    @Column(name = "fechaevento")
    @Temporal(TemporalType.DATE)
    private Date fechaevento;

    public Agenda() {
    }

    public Agenda(Integer idevento) {
        this.idevento = idevento;
    }

    public Agenda(Integer idevento, Date horaEvento, String tipoevento, String ciudadevento, Date fechaevento) {
        this.idevento = idevento;
        this.horaEvento = horaEvento;
        this.tipoevento = tipoevento;
        this.ciudadevento = ciudadevento;
        this.fechaevento = fechaevento;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Date getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Date horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(String tipoevento) {
        this.tipoevento = tipoevento;
    }

    public String getCiudadevento() {
        return ciudadevento;
    }

    public void setCiudadevento(String ciudadevento) {
        this.ciudadevento = ciudadevento;
    }

    public Date getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(Date fechaevento) {
        this.fechaevento = fechaevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cotizar.Agenda[ idevento=" + idevento + " ]";
    }
    
}
