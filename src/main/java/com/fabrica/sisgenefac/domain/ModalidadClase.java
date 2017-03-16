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
@Table(name = "modalidad_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadClase.findAll", query = "SELECT m FROM ModalidadClase m"),
    @NamedQuery(name = "ModalidadClase.findByMocId", query = "SELECT m FROM ModalidadClase m WHERE m.mocId = :mocId"),
    @NamedQuery(name = "ModalidadClase.findByMocTipo", query = "SELECT m FROM ModalidadClase m WHERE m.mocTipo = :mocTipo"),
    @NamedQuery(name = "ModalidadClase.findByMocDescripcion", query = "SELECT m FROM ModalidadClase m WHERE m.mocDescripcion = :mocDescripcion")})
public class ModalidadClase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moc_id")
    private Integer mocId;
    
    @Basic(optional = false)
    @Column(name = "moc_tipo")
    private String mocTipo;
    
    @Basic(optional = false)
    @Column(name = "moc_descripcion")
    private String mocDescripcion;
    
    @OneToMany(mappedBy = "mocId")
    private List<Dictado> dictadoList;

    public ModalidadClase() {
    }

    public ModalidadClase(Integer mocId) {
        this.mocId = mocId;
    }

    public ModalidadClase(Integer mocId, String mocTipo, String mocDescripcion) {
        this.mocId = mocId;
        this.mocTipo = mocTipo;
        this.mocDescripcion = mocDescripcion;
    }

    public Integer getMocId() {
        return mocId;
    }

    public void setMocId(Integer mocId) {
        this.mocId = mocId;
    }

    public String getMocTipo() {
        return mocTipo;
    }

    public void setMocTipo(String mocTipo) {
        this.mocTipo = mocTipo;
    }

    public String getMocDescripcion() {
        return mocDescripcion;
    }

    public void setMocDescripcion(String mocDescripcion) {
        this.mocDescripcion = mocDescripcion;
    }

    @XmlTransient
    public List<Dictado> getDictadoList() {
        return dictadoList;
    }

    public void setDictadoList(List<Dictado> dictadoList) {
        this.dictadoList = dictadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mocId != null ? mocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadClase)) {
            return false;
        }
        ModalidadClase other = (ModalidadClase) object;
        if ((this.mocId == null && other.mocId != null) || (this.mocId != null && !this.mocId.equals(other.mocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.ModalidadClase[ mocId=" + mocId + " ]";
    }
    
}
