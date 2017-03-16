/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByResId", query = "SELECT r FROM Resultado r WHERE r.resId = :resId"),
    @NamedQuery(name = "Resultado.findByResNotaParcial", query = "SELECT r FROM Resultado r WHERE r.resNotaParcial = :resNotaParcial"),
    @NamedQuery(name = "Resultado.findByResDenominacion", query = "SELECT r FROM Resultado r WHERE r.resDenominacion = :resDenominacion")})
public class Resultado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Integer resId;
    
    @Basic(optional = false)
    @Column(name = "res_nota_parcial")
    private double resNotaParcial;
    
    @Basic(optional = false)
    @Column(name = "res_denominacion")
    private String resDenominacion;
    
    @JoinColumn(name = "rep_id", referencedColumnName = "rep_id")
    @ManyToOne
    private Reporte repId;
    
    @JoinColumn(name = "por_id", referencedColumnName = "por_id")
    @ManyToOne
    private Portada porId;
    
    @JoinColumn(name = "dic_id", referencedColumnName = "dic_id")
    @ManyToOne
    private Dictado dicId;

    public Resultado() {
    }

    public Resultado(Integer resId) {
        this.resId = resId;
    }

    public Resultado(Integer resId, double resNotaParcial, String resDenominacion) {
        this.resId = resId;
        this.resNotaParcial = resNotaParcial;
        this.resDenominacion = resDenominacion;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public double getResNotaParcial() {
        return resNotaParcial;
    }

    public void setResNotaParcial(double resNotaParcial) {
        this.resNotaParcial = resNotaParcial;
    }

    public String getResDenominacion() {
        return resDenominacion;
    }

    public void setResDenominacion(String resDenominacion) {
        this.resDenominacion = resDenominacion;
    }

    public Reporte getRepId() {
        return repId;
    }

    public void setRepId(Reporte repId) {
        this.repId = repId;
    }

    public Portada getPorId() {
        return porId;
    }

    public void setPorId(Portada porId) {
        this.porId = porId;
    }

    public Dictado getDicId() {
        return dicId;
    }

    public void setDicId(Dictado dicId) {
        this.dicId = dicId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Resultado[ resId=" + resId + " ]";
    }
    
}
