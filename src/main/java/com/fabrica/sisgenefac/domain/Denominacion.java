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
@Table(name = "denominacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denominacion.findAll", query = "SELECT d FROM Denominacion d"),
    @NamedQuery(name = "Denominacion.findByDenId", query = "SELECT d FROM Denominacion d WHERE d.denId = :denId"),
    @NamedQuery(name = "Denominacion.findByDenDesde", query = "SELECT d FROM Denominacion d WHERE d.denDesde = :denDesde"),
    @NamedQuery(name = "Denominacion.findByDenHasta", query = "SELECT d FROM Denominacion d WHERE d.denHasta = :denHasta"),
    @NamedQuery(name = "Denominacion.findByDenNombre", query = "SELECT d FROM Denominacion d WHERE d.denNombre = :denNombre")})
public class Denominacion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "den_id")
    private Integer denId;
    
    @Basic(optional = false)
    @Column(name = "den_desde")
    private double denDesde;
    
    @Basic(optional = false)
    @Column(name = "den_hasta")
    private double denHasta;
    
    @Basic(optional = false)
    @Column(name = "den_nombre")
    private String denNombre;
    
    @JoinColumn(name = "por_id", referencedColumnName = "por_id")
    @ManyToOne
    private Portada porId;

    public Denominacion() {
    }

    public Denominacion(Integer denId) {
        this.denId = denId;
    }

    public Denominacion(Integer denId, double denDesde, double denHasta, String denNombre) {
        this.denId = denId;
        this.denDesde = denDesde;
        this.denHasta = denHasta;
        this.denNombre = denNombre;
    }

    public Integer getDenId() {
        return denId;
    }

    public void setDenId(Integer denId) {
        this.denId = denId;
    }

    public double getDenDesde() {
        return denDesde;
    }

    public void setDenDesde(double denDesde) {
        this.denDesde = denDesde;
    }

    public double getDenHasta() {
        return denHasta;
    }

    public void setDenHasta(double denHasta) {
        this.denHasta = denHasta;
    }

    public String getDenNombre() {
        return denNombre;
    }

    public void setDenNombre(String denNombre) {
        this.denNombre = denNombre;
    }

    public Portada getPorId() {
        return porId;
    }

    public void setPorId(Portada porId) {
        this.porId = porId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (denId != null ? denId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denominacion)) {
            return false;
        }
        Denominacion other = (Denominacion) object;
        if ((this.denId == null && other.denId != null) || (this.denId != null && !this.denId.equals(other.denId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Denominacion[ denId=" + denId + " ]";
    }
    
}
