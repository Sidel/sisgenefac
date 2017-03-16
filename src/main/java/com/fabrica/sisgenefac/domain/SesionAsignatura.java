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
@Table(name = "sesion_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SesionAsignatura.findAll", query = "SELECT s FROM SesionAsignatura s"),
    @NamedQuery(name = "SesionAsignatura.findBySeaId", query = "SELECT s FROM SesionAsignatura s WHERE s.seaId = :seaId"),
    @NamedQuery(name = "SesionAsignatura.findBySeaNumero", query = "SELECT s FROM SesionAsignatura s WHERE s.seaNumero = :seaNumero"),
    @NamedQuery(name = "SesionAsignatura.findBySeaContenido", query = "SELECT s FROM SesionAsignatura s WHERE s.seaContenido = :seaContenido"),
    @NamedQuery(name = "SesionAsignatura.findBySeaSumilla", query = "SELECT s FROM SesionAsignatura s WHERE s.seaSumilla = :seaSumilla")})
public class SesionAsignatura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sea_id")
    private Integer seaId;
    
    @Basic(optional = false)
    @Column(name = "sea_numero")
    private int seaNumero;
    
    @Column(name = "sea_contenido")
    private String seaContenido;
    
    @Column(name = "sea_sumilla")
    private String seaSumilla;
    
    @JoinColumn(name = "asi_id", referencedColumnName = "asi_id")
    @ManyToOne
    private Asignatura asiId;

    public SesionAsignatura() {
    }

    public SesionAsignatura(Integer seaId) {
        this.seaId = seaId;
    }

    public SesionAsignatura(Integer seaId, int seaNumero) {
        this.seaId = seaId;
        this.seaNumero = seaNumero;
    }

    public Integer getSeaId() {
        return seaId;
    }

    public void setSeaId(Integer seaId) {
        this.seaId = seaId;
    }

    public int getSeaNumero() {
        return seaNumero;
    }

    public void setSeaNumero(int seaNumero) {
        this.seaNumero = seaNumero;
    }

    public String getSeaContenido() {
        return seaContenido;
    }

    public void setSeaContenido(String seaContenido) {
        this.seaContenido = seaContenido;
    }

    public String getSeaSumilla() {
        return seaSumilla;
    }

    public void setSeaSumilla(String seaSumilla) {
        this.seaSumilla = seaSumilla;
    }

    public Asignatura getAsiId() {
        return asiId;
    }

    public void setAsiId(Asignatura asiId) {
        this.asiId = asiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seaId != null ? seaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SesionAsignatura)) {
            return false;
        }
        SesionAsignatura other = (SesionAsignatura) object;
        if ((this.seaId == null && other.seaId != null) || (this.seaId != null && !this.seaId.equals(other.seaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.SesionAsignatura[ seaId=" + seaId + " ]";
    }
    
}
