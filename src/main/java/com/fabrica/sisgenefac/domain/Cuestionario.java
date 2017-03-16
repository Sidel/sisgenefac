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
@Table(name = "cuestionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuestionario.findAll", query = "SELECT c FROM Cuestionario c"),
    @NamedQuery(name = "Cuestionario.findByCueId", query = "SELECT c FROM Cuestionario c WHERE c.cueId = :cueId")})
public class Cuestionario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cue_id")
    private Integer cueId;
    
    @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")
    @ManyToOne
    private Pregunta preId;
    
    @JoinColumn(name = "pos_id", referencedColumnName = "pos_id")
    @ManyToOne
    private PortadaSeccion posId;
    
    @OneToMany(mappedBy = "cueId")
    private List<DetRpta> detRptaList;

    public Cuestionario() {
    }

    public Cuestionario(Integer cueId) {
        this.cueId = cueId;
    }

    public Integer getCueId() {
        return cueId;
    }

    public void setCueId(Integer cueId) {
        this.cueId = cueId;
    }

    public Pregunta getPreId() {
        return preId;
    }

    public void setPreId(Pregunta preId) {
        this.preId = preId;
    }

    public PortadaSeccion getPosId() {
        return posId;
    }

    public void setPosId(PortadaSeccion posId) {
        this.posId = posId;
    }

    @XmlTransient
    public List<DetRpta> getDetRptaList() {
        return detRptaList;
    }

    public void setDetRptaList(List<DetRpta> detRptaList) {
        this.detRptaList = detRptaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cueId != null ? cueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuestionario)) {
            return false;
        }
        Cuestionario other = (Cuestionario) object;
        if ((this.cueId == null && other.cueId != null) || (this.cueId != null && !this.cueId.equals(other.cueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Cuestionario[ cueId=" + cueId + " ]";
    }
    
}
