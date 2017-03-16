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
@Table(name = "plan_estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanEstudio.findAll", query = "SELECT p FROM PlanEstudio p"),
    @NamedQuery(name = "PlanEstudio.findByPleId", query = "SELECT p FROM PlanEstudio p WHERE p.pleId = :pleId"),
    @NamedQuery(name = "PlanEstudio.findByPleNombre", query = "SELECT p FROM PlanEstudio p WHERE p.pleNombre = :pleNombre"),
    @NamedQuery(name = "PlanEstudio.findByPleAnio", query = "SELECT p FROM PlanEstudio p WHERE p.pleAnio = :pleAnio"),
    @NamedQuery(name = "PlanEstudio.findByPleCodigo", query = "SELECT p FROM PlanEstudio p WHERE p.pleCodigo = :pleCodigo"),
    @NamedQuery(name = "PlanEstudio.findByPleSumilla", query = "SELECT p FROM PlanEstudio p WHERE p.pleSumilla = :pleSumilla"),
    @NamedQuery(name = "PlanEstudio.findByPleCompetenciasGenerales", query = "SELECT p FROM PlanEstudio p WHERE p.pleCompetenciasGenerales = :pleCompetenciasGenerales"),
    @NamedQuery(name = "PlanEstudio.findByPleCompetenciasEspecificas", query = "SELECT p FROM PlanEstudio p WHERE p.pleCompetenciasEspecificas = :pleCompetenciasEspecificas")})
public class PlanEstudio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ple_id")
    private Integer pleId;
    
    @Basic(optional = false)
    @Column(name = "ple_nombre")
    private String pleNombre;
    
    @Basic(optional = false)
    @Column(name = "ple_anio")
    private int pleAnio;
    
    @Basic(optional = false)
    @Column(name = "ple_codigo")
    private int pleCodigo;
    
    @Column(name = "ple_sumilla")
    private String pleSumilla;
    
    @Column(name = "ple_competencias_generales")
    private String pleCompetenciasGenerales;
    
    @Column(name = "ple_competencias_especificas")
    private String pleCompetenciasEspecificas;
    
    @OneToMany(mappedBy = "pleId")
    private List<Asignatura> asignaturaList;

    public PlanEstudio() {
    }

    public PlanEstudio(Integer pleId) {
        this.pleId = pleId;
    }

    public PlanEstudio(Integer pleId, String pleNombre, int pleAnio, int pleCodigo) {
        this.pleId = pleId;
        this.pleNombre = pleNombre;
        this.pleAnio = pleAnio;
        this.pleCodigo = pleCodigo;
    }

    public Integer getPleId() {
        return pleId;
    }

    public void setPleId(Integer pleId) {
        this.pleId = pleId;
    }

    public String getPleNombre() {
        return pleNombre;
    }

    public void setPleNombre(String pleNombre) {
        this.pleNombre = pleNombre;
    }

    public int getPleAnio() {
        return pleAnio;
    }

    public void setPleAnio(int pleAnio) {
        this.pleAnio = pleAnio;
    }

    public int getPleCodigo() {
        return pleCodigo;
    }

    public void setPleCodigo(int pleCodigo) {
        this.pleCodigo = pleCodigo;
    }

    public String getPleSumilla() {
        return pleSumilla;
    }

    public void setPleSumilla(String pleSumilla) {
        this.pleSumilla = pleSumilla;
    }

    public String getPleCompetenciasGenerales() {
        return pleCompetenciasGenerales;
    }

    public void setPleCompetenciasGenerales(String pleCompetenciasGenerales) {
        this.pleCompetenciasGenerales = pleCompetenciasGenerales;
    }

    public String getPleCompetenciasEspecificas() {
        return pleCompetenciasEspecificas;
    }

    public void setPleCompetenciasEspecificas(String pleCompetenciasEspecificas) {
        this.pleCompetenciasEspecificas = pleCompetenciasEspecificas;
    }

    @XmlTransient
    public List<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(List<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pleId != null ? pleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanEstudio)) {
            return false;
        }
        PlanEstudio other = (PlanEstudio) object;
        if ((this.pleId == null && other.pleId != null) || (this.pleId != null && !this.pleId.equals(other.pleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.PlanEstudio[ pleId=" + pleId + " ]";
    }
    
}
