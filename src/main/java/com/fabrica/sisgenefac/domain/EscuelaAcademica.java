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
@Table(name = "escuela_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscuelaAcademica.findAll", query = "SELECT e FROM EscuelaAcademica e"),
    @NamedQuery(name = "EscuelaAcademica.findByEsaId", query = "SELECT e FROM EscuelaAcademica e WHERE e.esaId = :esaId"),
    @NamedQuery(name = "EscuelaAcademica.findByEsaEscuela", query = "SELECT e FROM EscuelaAcademica e WHERE e.esaEscuela = :esaEscuela"),
    @NamedQuery(name = "EscuelaAcademica.findByCatFacultad", query = "SELECT e FROM EscuelaAcademica e WHERE e.catFacultad = :catFacultad")})
public class EscuelaAcademica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esa_id")
    private Integer esaId;
    
    @Basic(optional = false)
    @Column(name = "esa_escuela")
    private String esaEscuela;
    
    @Basic(optional = false)
    @Column(name = "cat_facultad")
    private int catFacultad;
    
    @OneToMany(mappedBy = "esaId")
    private List<Estudiante> estudianteList;

    public EscuelaAcademica() {
    }

    public EscuelaAcademica(Integer esaId) {
        this.esaId = esaId;
    }

    public EscuelaAcademica(Integer esaId, String esaEscuela, int catFacultad) {
        this.esaId = esaId;
        this.esaEscuela = esaEscuela;
        this.catFacultad = catFacultad;
    }

    public Integer getEsaId() {
        return esaId;
    }

    public void setEsaId(Integer esaId) {
        this.esaId = esaId;
    }

    public String getEsaEscuela() {
        return esaEscuela;
    }

    public void setEsaEscuela(String esaEscuela) {
        this.esaEscuela = esaEscuela;
    }

    public int getCatFacultad() {
        return catFacultad;
    }

    public void setCatFacultad(int catFacultad) {
        this.catFacultad = catFacultad;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esaId != null ? esaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscuelaAcademica)) {
            return false;
        }
        EscuelaAcademica other = (EscuelaAcademica) object;
        if ((this.esaId == null && other.esaId != null) || (this.esaId != null && !this.esaId.equals(other.esaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.EscuelaAcademica[ esaId=" + esaId + " ]";
    }
    
}
