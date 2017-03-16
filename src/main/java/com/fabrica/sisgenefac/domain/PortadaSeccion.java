/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "portada_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PortadaSeccion.findAll", query = "SELECT p FROM PortadaSeccion p"),
    @NamedQuery(name = "PortadaSeccion.findByPosId", query = "SELECT p FROM PortadaSeccion p WHERE p.posId = :posId"),
    @NamedQuery(name = "PortadaSeccion.findByPosValorMax", query = "SELECT p FROM PortadaSeccion p WHERE p.posValorMax = :posValorMax")})
public class PortadaSeccion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pos_id")
    private Integer posId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pos_valor_max")
    private Double posValorMax;
    
    @OneToMany(mappedBy = "posId")
    private List<Cuestionario> cuestionarioList;
    
    @JoinColumn(name = "sec_id", referencedColumnName = "sec_id")
    @ManyToOne
    private Seccion secId;
    
    @JoinColumn(name = "por_id", referencedColumnName = "por_id")
    @ManyToOne
    private Portada porId;
    
    @OneToMany(mappedBy = "posId")
    private List<MaxRptaSec> maxRptaSecList;
    
    @OneToMany(mappedBy = "posId")
    private List<EscalaLikert> escalaLikertList;

    public PortadaSeccion() {
    }

    public PortadaSeccion(Integer posId) {
        this.posId = posId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Double getPosValorMax() {
        return posValorMax;
    }

    public void setPosValorMax(Double posValorMax) {
        this.posValorMax = posValorMax;
    }

    @XmlTransient
    public List<Cuestionario> getCuestionarioList() {
        return cuestionarioList;
    }

    public void setCuestionarioList(List<Cuestionario> cuestionarioList) {
        this.cuestionarioList = cuestionarioList;
    }

    public Seccion getSecId() {
        return secId;
    }

    public void setSecId(Seccion secId) {
        this.secId = secId;
    }

    public Portada getPorId() {
        return porId;
    }

    public void setPorId(Portada porId) {
        this.porId = porId;
    }

    @XmlTransient
    public List<MaxRptaSec> getMaxRptaSecList() {
        return maxRptaSecList;
    }

    public void setMaxRptaSecList(List<MaxRptaSec> maxRptaSecList) {
        this.maxRptaSecList = maxRptaSecList;
    }

    @XmlTransient
    public List<EscalaLikert> getEscalaLikertList() {
        return escalaLikertList;
    }

    public void setEscalaLikertList(List<EscalaLikert> escalaLikertList) {
        this.escalaLikertList = escalaLikertList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posId != null ? posId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PortadaSeccion)) {
            return false;
        }
        PortadaSeccion other = (PortadaSeccion) object;
        if ((this.posId == null && other.posId != null) || (this.posId != null && !this.posId.equals(other.posId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.PortadaSeccion[ posId=" + posId + " ]";
    }
    
}
