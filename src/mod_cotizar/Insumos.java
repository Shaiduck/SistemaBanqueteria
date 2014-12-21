/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mod_cotizar;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zaibeh
 */
@Entity
@Table(name = "insumos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumos.findAll", query = "SELECT i FROM Insumos i"),
    @NamedQuery(name = "Insumos.findByIdinsumo", query = "SELECT i FROM Insumos i WHERE i.idinsumo = :idinsumo"),
    @NamedQuery(name = "Insumos.findByNombreinsumo", query = "SELECT i FROM Insumos i WHERE i.nombreinsumo = :nombreinsumo"),
    @NamedQuery(name = "Insumos.findByForma", query = "SELECT i FROM Insumos i WHERE i.forma = :forma"),
    @NamedQuery(name = "Insumos.findByTama\u00f1o", query = "SELECT i FROM Insumos i WHERE i.tama\u00f1o = :tama\u00f1o"),
    @NamedQuery(name = "Insumos.findByColor", query = "SELECT i FROM Insumos i WHERE i.color = :color"),
    @NamedQuery(name = "Insumos.findByDise\u00f1o", query = "SELECT i FROM Insumos i WHERE i.dise\u00f1o = :dise\u00f1o"),
    @NamedQuery(name = "Insumos.findByCintilla", query = "SELECT i FROM Insumos i WHERE i.cintilla = :cintilla"),
    @NamedQuery(name = "Insumos.findByPrecio", query = "SELECT i FROM Insumos i WHERE i.precio = :precio")})
public class Insumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinsumo")
    private Integer idinsumo;
    @Basic(optional = false)
    @Column(name = "nombreinsumo")
    private String nombreinsumo;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "forma")
    private String forma;
    @Column(name = "tama\u00f1o")
    private String tamaño;
    @Column(name = "color")
    private String color;
    @Column(name = "dise\u00f1o")
    private String diseño;
    @Column(name = "cintilla")
    private Boolean cintilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;

    public Insumos() {
    }

    public Insumos(Integer idinsumo) {
        this.idinsumo = idinsumo;
    }

    public Insumos(Integer idinsumo, String nombreinsumo) {
        this.idinsumo = idinsumo;
        this.nombreinsumo = nombreinsumo;
    }

    public Integer getIdinsumo() {
        return idinsumo;
    }

    public void setIdinsumo(Integer idinsumo) {
        this.idinsumo = idinsumo;
    }

    public String getNombreinsumo() {
        return nombreinsumo;
    }

    public void setNombreinsumo(String nombreinsumo) {
        this.nombreinsumo = nombreinsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiseño() {
        return diseño;
    }

    public void setDiseño(String diseño) {
        this.diseño = diseño;
    }

    public Boolean getCintilla() {
        return cintilla;
    }

    public void setCintilla(Boolean cintilla) {
        this.cintilla = cintilla;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinsumo != null ? idinsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumos)) {
            return false;
        }
        Insumos other = (Insumos) object;
        if ((this.idinsumo == null && other.idinsumo != null) || (this.idinsumo != null && !this.idinsumo.equals(other.idinsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cotizar.Insumos[ idinsumo=" + idinsumo + " ]";
    }
    
}
