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
@Table(name = "det_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetMatricula.findAll", query = "SELECT d FROM DetMatricula d"),
    @NamedQuery(name = "DetMatricula.findByDemId", query = "SELECT d FROM DetMatricula d WHERE d.demId = :demId"),
    @NamedQuery(name = "DetMatricula.findByDemRepPlanActual", query = "SELECT d FROM DetMatricula d WHERE d.demRepPlanActual = :demRepPlanActual")})
public class DetMatricula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dem_id")
    private Integer demId;
    
    @Column(name = "dem_rep_plan_actual")
    private Integer demRepPlanActual;
    
    @JoinColumn(name = "cam_id", referencedColumnName = "cam_id")
    @ManyToOne(optional = false)
    private CabMatricula camId;
    
    @JoinColumn(name = "gru_id", referencedColumnName = "gru_id")
    @ManyToOne
    private Grupo gruId;

    public DetMatricula() {
    }

    public DetMatricula(Integer demId) {
        this.demId = demId;
    }

    public Integer getDemId() {
        return demId;
    }

    public void setDemId(Integer demId) {
        this.demId = demId;
    }

    public Integer getDemRepPlanActual() {
        return demRepPlanActual;
    }

    public void setDemRepPlanActual(Integer demRepPlanActual) {
        this.demRepPlanActual = demRepPlanActual;
    }

    public CabMatricula getCamId() {
        return camId;
    }

    public void setCamId(CabMatricula camId) {
        this.camId = camId;
    }

    public Grupo getGruId() {
        return gruId;
    }

    public void setGruId(Grupo gruId) {
        this.gruId = gruId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (demId != null ? demId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetMatricula)) {
            return false;
        }
        DetMatricula other = (DetMatricula) object;
        if ((this.demId == null && other.demId != null) || (this.demId != null && !this.demId.equals(other.demId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.DetMatricula[ demId=" + demId + " ]";
    }
    
}
