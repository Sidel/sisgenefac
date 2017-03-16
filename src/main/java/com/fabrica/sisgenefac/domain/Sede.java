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
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s"),
    @NamedQuery(name = "Sede.findBySedId", query = "SELECT s FROM Sede s WHERE s.sedId = :sedId"),
    @NamedQuery(name = "Sede.findBySedCodigo", query = "SELECT s FROM Sede s WHERE s.sedCodigo = :sedCodigo"),
    @NamedQuery(name = "Sede.findBySedNombre", query = "SELECT s FROM Sede s WHERE s.sedNombre = :sedNombre"),
    @NamedQuery(name = "Sede.findBySedDireccion", query = "SELECT s FROM Sede s WHERE s.sedDireccion = :sedDireccion")})
public class Sede implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sed_id")
    private Integer sedId;
    
    @Column(name = "sed_codigo")
    private String sedCodigo;
    
    @Basic(optional = false)
    @Column(name = "sed_nombre")
    private String sedNombre;
    
    @Column(name = "sed_direccion")
    private String sedDireccion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sedId")
    private List<ProSedDep> proSedDepList;

    public Sede() {
    }

    public Sede(Integer sedId) {
        this.sedId = sedId;
    }

    public Sede(Integer sedId, String sedNombre) {
        this.sedId = sedId;
        this.sedNombre = sedNombre;
    }

    public Integer getSedId() {
        return sedId;
    }

    public void setSedId(Integer sedId) {
        this.sedId = sedId;
    }

    public String getSedCodigo() {
        return sedCodigo;
    }

    public void setSedCodigo(String sedCodigo) {
        this.sedCodigo = sedCodigo;
    }

    public String getSedNombre() {
        return sedNombre;
    }

    public void setSedNombre(String sedNombre) {
        this.sedNombre = sedNombre;
    }

    public String getSedDireccion() {
        return sedDireccion;
    }

    public void setSedDireccion(String sedDireccion) {
        this.sedDireccion = sedDireccion;
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
        hash += (sedId != null ? sedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.sedId == null && other.sedId != null) || (this.sedId != null && !this.sedId.equals(other.sedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Sede[ sedId=" + sedId + " ]";
    }
    
}
