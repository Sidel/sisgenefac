/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "periodo_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoAcademico.findAll", query = "SELECT p FROM PeriodoAcademico p"),
    @NamedQuery(name = "PeriodoAcademico.findByPeaId", query = "SELECT p FROM PeriodoAcademico p WHERE p.peaId = :peaId"),
    @NamedQuery(name = "PeriodoAcademico.findByPeaNombre", query = "SELECT p FROM PeriodoAcademico p WHERE p.peaNombre = :peaNombre"),
    @NamedQuery(name = "PeriodoAcademico.findByPeaCodSemestre", query = "SELECT p FROM PeriodoAcademico p WHERE p.peaCodSemestre = :peaCodSemestre"),
    @NamedQuery(name = "PeriodoAcademico.findByPeaFdesde", query = "SELECT p FROM PeriodoAcademico p WHERE p.peaFdesde = :peaFdesde"),
    @NamedQuery(name = "PeriodoAcademico.findByPeaFhasta", query = "SELECT p FROM PeriodoAcademico p WHERE p.peaFhasta = :peaFhasta")})
public class PeriodoAcademico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pea_id")
    private Integer peaId;
    
    @Basic(optional = false)
    @Column(name = "pea_nombre")
    private String peaNombre;
    
    @Basic(optional = false)
    @Column(name = "pea_cod_semestre")
    private int peaCodSemestre;
    
    @Basic(optional = false)
    @Column(name = "pea_fdesde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date peaFdesde;
    
    @Basic(optional = false)
    @Column(name = "pea_fhasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date peaFhasta;
    
    @OneToMany(mappedBy = "peaId")
    private List<CabMatricula> cabMatriculaList;

    public PeriodoAcademico() {
    }

    public PeriodoAcademico(Integer peaId) {
        this.peaId = peaId;
    }

    public PeriodoAcademico(Integer peaId, String peaNombre, int peaCodSemestre, Date peaFdesde, Date peaFhasta) {
        this.peaId = peaId;
        this.peaNombre = peaNombre;
        this.peaCodSemestre = peaCodSemestre;
        this.peaFdesde = peaFdesde;
        this.peaFhasta = peaFhasta;
    }

    public Integer getPeaId() {
        return peaId;
    }

    public void setPeaId(Integer peaId) {
        this.peaId = peaId;
    }

    public String getPeaNombre() {
        return peaNombre;
    }

    public void setPeaNombre(String peaNombre) {
        this.peaNombre = peaNombre;
    }

    public int getPeaCodSemestre() {
        return peaCodSemestre;
    }

    public void setPeaCodSemestre(int peaCodSemestre) {
        this.peaCodSemestre = peaCodSemestre;
    }

    public Date getPeaFdesde() {
        return peaFdesde;
    }

    public void setPeaFdesde(Date peaFdesde) {
        this.peaFdesde = peaFdesde;
    }

    public Date getPeaFhasta() {
        return peaFhasta;
    }

    public void setPeaFhasta(Date peaFhasta) {
        this.peaFhasta = peaFhasta;
    }

    @XmlTransient
    public List<CabMatricula> getCabMatriculaList() {
        return cabMatriculaList;
    }

    public void setCabMatriculaList(List<CabMatricula> cabMatriculaList) {
        this.cabMatriculaList = cabMatriculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peaId != null ? peaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoAcademico)) {
            return false;
        }
        PeriodoAcademico other = (PeriodoAcademico) object;
        if ((this.peaId == null && other.peaId != null) || (this.peaId != null && !this.peaId.equals(other.peaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.PeriodoAcademico[ peaId=" + peaId + " ]";
    }
    
}
