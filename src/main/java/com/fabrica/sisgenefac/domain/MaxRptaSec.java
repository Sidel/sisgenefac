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
@Table(name = "max_rpta_sec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaxRptaSec.findAll", query = "SELECT m FROM MaxRptaSec m"),
    @NamedQuery(name = "MaxRptaSec.findByMrsId", query = "SELECT m FROM MaxRptaSec m WHERE m.mrsId = :mrsId"),
    @NamedQuery(name = "MaxRptaSec.findByMrsValorMax", query = "SELECT m FROM MaxRptaSec m WHERE m.mrsValorMax = :mrsValorMax"),
    @NamedQuery(name = "MaxRptaSec.findByMrsDenominacion", query = "SELECT m FROM MaxRptaSec m WHERE m.mrsDenominacion = :mrsDenominacion")})
public class MaxRptaSec implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mrs_id")
    private Integer mrsId;
    
    @Basic(optional = false)
    @Column(name = "mrs_valor_max")
    private double mrsValorMax;
    
    @Basic(optional = false)
    @Column(name = "mrs_denominacion")
    private String mrsDenominacion;
    
    @JoinColumn(name = "rep_id", referencedColumnName = "rep_id")
    @ManyToOne
    private Reporte repId;
    
    @JoinColumn(name = "por_id", referencedColumnName = "por_id")
    @ManyToOne
    private Portada porId;
    
    @JoinColumn(name = "pos_id", referencedColumnName = "pos_id")
    @ManyToOne
    private PortadaSeccion posId;

    public MaxRptaSec() {
    }

    public MaxRptaSec(Integer mrsId) {
        this.mrsId = mrsId;
    }

    public MaxRptaSec(Integer mrsId, double mrsValorMax, String mrsDenominacion) {
        this.mrsId = mrsId;
        this.mrsValorMax = mrsValorMax;
        this.mrsDenominacion = mrsDenominacion;
    }

    public Integer getMrsId() {
        return mrsId;
    }

    public void setMrsId(Integer mrsId) {
        this.mrsId = mrsId;
    }

    public double getMrsValorMax() {
        return mrsValorMax;
    }

    public void setMrsValorMax(double mrsValorMax) {
        this.mrsValorMax = mrsValorMax;
    }

    public String getMrsDenominacion() {
        return mrsDenominacion;
    }

    public void setMrsDenominacion(String mrsDenominacion) {
        this.mrsDenominacion = mrsDenominacion;
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

    public PortadaSeccion getPosId() {
        return posId;
    }

    public void setPosId(PortadaSeccion posId) {
        this.posId = posId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrsId != null ? mrsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaxRptaSec)) {
            return false;
        }
        MaxRptaSec other = (MaxRptaSec) object;
        if ((this.mrsId == null && other.mrsId != null) || (this.mrsId != null && !this.mrsId.equals(other.mrsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.MaxRptaSec[ mrsId=" + mrsId + " ]";
    }
    
}
