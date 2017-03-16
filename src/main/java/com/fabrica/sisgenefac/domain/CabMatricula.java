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
@Table(name = "cab_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabMatricula.findAll", query = "SELECT c FROM CabMatricula c"),
    @NamedQuery(name = "CabMatricula.findByCamId", query = "SELECT c FROM CabMatricula c WHERE c.camId = :camId"),
    @NamedQuery(name = "CabMatricula.findByCatRegimen", query = "SELECT c FROM CabMatricula c WHERE c.catRegimen = :catRegimen")})
public class CabMatricula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cam_id")
    private Integer camId;
    
    @Basic(optional = false)
    @Column(name = "cat_regimen")
    private int catRegimen;
    
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne
    private Estudiante estId;
    
    @JoinColumn(name = "pea_id", referencedColumnName = "pea_id")
    @ManyToOne
    private PeriodoAcademico peaId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camId")
    private List<DetMatricula> detMatriculaList;

    public CabMatricula() {
    }

    public CabMatricula(Integer camId) {
        this.camId = camId;
    }

    public CabMatricula(Integer camId, int catRegimen) {
        this.camId = camId;
        this.catRegimen = catRegimen;
    }

    public Integer getCamId() {
        return camId;
    }

    public void setCamId(Integer camId) {
        this.camId = camId;
    }

    public int getCatRegimen() {
        return catRegimen;
    }

    public void setCatRegimen(int catRegimen) {
        this.catRegimen = catRegimen;
    }

    public Estudiante getEstId() {
        return estId;
    }

    public void setEstId(Estudiante estId) {
        this.estId = estId;
    }

    public PeriodoAcademico getPeaId() {
        return peaId;
    }

    public void setPeaId(PeriodoAcademico peaId) {
        this.peaId = peaId;
    }

    @XmlTransient
    public List<DetMatricula> getDetMatriculaList() {
        return detMatriculaList;
    }

    public void setDetMatriculaList(List<DetMatricula> detMatriculaList) {
        this.detMatriculaList = detMatriculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camId != null ? camId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabMatricula)) {
            return false;
        }
        CabMatricula other = (CabMatricula) object;
        if ((this.camId == null && other.camId != null) || (this.camId != null && !this.camId.equals(other.camId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.CabMatricula[ camId=" + camId + " ]";
    }
    
}
