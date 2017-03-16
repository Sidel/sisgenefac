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
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGruId", query = "SELECT g FROM Grupo g WHERE g.gruId = :gruId"),
    @NamedQuery(name = "Grupo.findByGruCodigo", query = "SELECT g FROM Grupo g WHERE g.gruCodigo = :gruCodigo"),
    @NamedQuery(name = "Grupo.findByGruNumero", query = "SELECT g FROM Grupo g WHERE g.gruNumero = :gruNumero")})
public class Grupo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gru_id")
    private Integer gruId;
    
    @Basic(optional = false)
    @Column(name = "gru_codigo")
    private String gruCodigo;
    
    @Basic(optional = false)
    @Column(name = "gru_numero")
    private int gruNumero;
    
    @JoinColumn(name = "asi_id", referencedColumnName = "asi_id")
    @ManyToOne(optional = false)
    private Asignatura asiId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gruId")
    private List<Dictado> dictadoList;
    
    @OneToMany(mappedBy = "gruId")
    private List<DetMatricula> detMatriculaList;

    public Grupo() {
    }

    public Grupo(Integer gruId) {
        this.gruId = gruId;
    }

    public Grupo(Integer gruId, String gruCodigo, int gruNumero) {
        this.gruId = gruId;
        this.gruCodigo = gruCodigo;
        this.gruNumero = gruNumero;
    }

    public Integer getGruId() {
        return gruId;
    }

    public void setGruId(Integer gruId) {
        this.gruId = gruId;
    }

    public String getGruCodigo() {
        return gruCodigo;
    }

    public void setGruCodigo(String gruCodigo) {
        this.gruCodigo = gruCodigo;
    }

    public int getGruNumero() {
        return gruNumero;
    }

    public void setGruNumero(int gruNumero) {
        this.gruNumero = gruNumero;
    }

    public Asignatura getAsiId() {
        return asiId;
    }

    public void setAsiId(Asignatura asiId) {
        this.asiId = asiId;
    }

    @XmlTransient
    public List<Dictado> getDictadoList() {
        return dictadoList;
    }

    public void setDictadoList(List<Dictado> dictadoList) {
        this.dictadoList = dictadoList;
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
        hash += (gruId != null ? gruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Grupo[ gruId=" + gruId + " ]";
    }
    
}
