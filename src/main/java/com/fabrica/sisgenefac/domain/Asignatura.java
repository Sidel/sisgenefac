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
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findByAsiId", query = "SELECT a FROM Asignatura a WHERE a.asiId = :asiId"),
    @NamedQuery(name = "Asignatura.findByAsiCodigo", query = "SELECT a FROM Asignatura a WHERE a.asiCodigo = :asiCodigo"),
    @NamedQuery(name = "Asignatura.findByAsiNombre", query = "SELECT a FROM Asignatura a WHERE a.asiNombre = :asiNombre"),
    @NamedQuery(name = "Asignatura.findByAsiCicloAnio", query = "SELECT a FROM Asignatura a WHERE a.asiCicloAnio = :asiCicloAnio"),
    @NamedQuery(name = "Asignatura.findByAsiCreditos", query = "SELECT a FROM Asignatura a WHERE a.asiCreditos = :asiCreditos"),
    @NamedQuery(name = "Asignatura.findByCatRegimen", query = "SELECT a FROM Asignatura a WHERE a.catRegimen = :catRegimen"),
    @NamedQuery(name = "Asignatura.findByAsiEstado", query = "SELECT a FROM Asignatura a WHERE a.asiEstado = :asiEstado"),
    @NamedQuery(name = "Asignatura.findByTipCurso", query = "SELECT a FROM Asignatura a WHERE a.tipCurso = :tipCurso")})
public class Asignatura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asi_id")
    private Integer asiId;
    
    @Basic(optional = false)
    @Column(name = "asi_codigo")
    private String asiCodigo;
    
    @Basic(optional = false)
    @Column(name = "asi_nombre")
    private String asiNombre;
    
    @Basic(optional = false)
    @Column(name = "asi_ciclo_anio")
    private String asiCicloAnio;
    
    @Basic(optional = false)
    @Column(name = "asi_creditos")
    private int asiCreditos;
    
    @Column(name = "cat_regimen")
    private Integer catRegimen;
    
    @Basic(optional = false)
    @Column(name = "asi_estado")
    private char asiEstado;
    
    @Column(name = "tip_curso")
    private String tipCurso;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asiId")
    private List<Grupo> grupoList;
    
    @OneToMany(mappedBy = "asiId")
    private List<SesionAsignatura> sesionAsignaturaList;
    
    @OneToMany(mappedBy = "asiId")
    private List<SesionEncuesta> sesionEncuestaList;
    
    @JoinColumn(name = "ple_id", referencedColumnName = "ple_id")
    @ManyToOne
    private PlanEstudio pleId;

    public Asignatura() {
    }

    public Asignatura(Integer asiId) {
        this.asiId = asiId;
    }

    public Asignatura(Integer asiId, String asiCodigo, String asiNombre, String asiCicloAnio, int asiCreditos, char asiEstado) {
        this.asiId = asiId;
        this.asiCodigo = asiCodigo;
        this.asiNombre = asiNombre;
        this.asiCicloAnio = asiCicloAnio;
        this.asiCreditos = asiCreditos;
        this.asiEstado = asiEstado;
    }

    public Integer getAsiId() {
        return asiId;
    }

    public void setAsiId(Integer asiId) {
        this.asiId = asiId;
    }

    public String getAsiCodigo() {
        return asiCodigo;
    }

    public void setAsiCodigo(String asiCodigo) {
        this.asiCodigo = asiCodigo;
    }

    public String getAsiNombre() {
        return asiNombre;
    }

    public void setAsiNombre(String asiNombre) {
        this.asiNombre = asiNombre;
    }

    public String getAsiCicloAnio() {
        return asiCicloAnio;
    }

    public void setAsiCicloAnio(String asiCicloAnio) {
        this.asiCicloAnio = asiCicloAnio;
    }

    public int getAsiCreditos() {
        return asiCreditos;
    }

    public void setAsiCreditos(int asiCreditos) {
        this.asiCreditos = asiCreditos;
    }

    public Integer getCatRegimen() {
        return catRegimen;
    }

    public void setCatRegimen(Integer catRegimen) {
        this.catRegimen = catRegimen;
    }

    public char getAsiEstado() {
        return asiEstado;
    }

    public void setAsiEstado(char asiEstado) {
        this.asiEstado = asiEstado;
    }

    public String getTipCurso() {
        return tipCurso;
    }

    public void setTipCurso(String tipCurso) {
        this.tipCurso = tipCurso;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @XmlTransient
    public List<SesionAsignatura> getSesionAsignaturaList() {
        return sesionAsignaturaList;
    }

    public void setSesionAsignaturaList(List<SesionAsignatura> sesionAsignaturaList) {
        this.sesionAsignaturaList = sesionAsignaturaList;
    }

    @XmlTransient
    public List<SesionEncuesta> getSesionEncuestaList() {
        return sesionEncuestaList;
    }

    public void setSesionEncuestaList(List<SesionEncuesta> sesionEncuestaList) {
        this.sesionEncuestaList = sesionEncuestaList;
    }

    public PlanEstudio getPleId() {
        return pleId;
    }

    public void setPleId(PlanEstudio pleId) {
        this.pleId = pleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asiId != null ? asiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.asiId == null && other.asiId != null) || (this.asiId != null && !this.asiId.equals(other.asiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Asignatura[ asiId=" + asiId + " ]";
    }
    
}
