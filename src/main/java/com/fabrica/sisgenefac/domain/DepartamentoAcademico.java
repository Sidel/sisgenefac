/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "departamento_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoAcademico.findAll", query = "SELECT d FROM DepartamentoAcademico d"),
    @NamedQuery(name = "DepartamentoAcademico.findByDeaId", query = "SELECT d FROM DepartamentoAcademico d WHERE d.deaId = :deaId"),
    @NamedQuery(name = "DepartamentoAcademico.findByDeaNombre", query = "SELECT d FROM DepartamentoAcademico d WHERE d.deaNombre = :deaNombre")})
public class DepartamentoAcademico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dea_id")
    private Integer deaId;
    
    @Basic(optional = false)
    @Column(name = "dea_nombre")
    private String deaNombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deaId")
    private List<ProSedDep> proSedDepList;

    public DepartamentoAcademico() {
    }

    public DepartamentoAcademico(Integer deaId) {
        this.deaId = deaId;
    }

    public DepartamentoAcademico(Integer deaId, String deaNombre) {
        this.deaId = deaId;
        this.deaNombre = deaNombre;
    }

    public Integer getDeaId() {
        return deaId;
    }

    public void setDeaId(Integer deaId) {
        this.deaId = deaId;
    }

    public String getDeaNombre() {
        return deaNombre;
    }

    public void setDeaNombre(String deaNombre) {
        this.deaNombre = deaNombre;
    }

    @XmlTransient
    public List<ProSedDep> getProSedDepList() {
        return proSedDepList;
    }

    public void setProSedDepList(List<ProSedDep> proSedDepList) {
        this.proSedDepList = proSedDepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deaId != null ? deaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoAcademico)) {
            return false;
        }
        DepartamentoAcademico other = (DepartamentoAcademico) object;
        if ((this.deaId == null && other.deaId != null) || (this.deaId != null && !this.deaId.equals(other.deaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.DepartamentoAcademico[ deaId=" + deaId + " ]";
    }
    
}
