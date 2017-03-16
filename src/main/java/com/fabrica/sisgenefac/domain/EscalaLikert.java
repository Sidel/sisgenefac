/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "escala_likert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscalaLikert.findAll", query = "SELECT e FROM EscalaLikert e"),
    @NamedQuery(name = "EscalaLikert.findByEslId", query = "SELECT e FROM EscalaLikert e WHERE e.eslId = :eslId"),
    @NamedQuery(name = "EscalaLikert.findByEslCantPregSi", query = "SELECT e FROM EscalaLikert e WHERE e.eslCantPregSi = :eslCantPregSi"),
    @NamedQuery(name = "EscalaLikert.findByEslValor", query = "SELECT e FROM EscalaLikert e WHERE e.eslValor = :eslValor")})
public class EscalaLikert implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esl_id")
    private Integer eslId;
    
    @Basic(optional = false)
    @Column(name = "esl_cant_preg_si")
    private int eslCantPregSi;
    
    @Basic(optional = false)
    @Column(name = "esl_valor")
    private double eslValor;
    
    @JoinColumn(name = "pos_id", referencedColumnName = "pos_id")
    @ManyToOne
    private PortadaSeccion posId;

    public EscalaLikert() {
    }

    public EscalaLikert(Integer eslId) {
        this.eslId = eslId;
    }

    public EscalaLikert(Integer eslId, int eslCantPregSi, double eslValor) {
        this.eslId = eslId;
        this.eslCantPregSi = eslCantPregSi;
        this.eslValor = eslValor;
    }

    public Integer getEslId() {
        return eslId;
    }

    public void setEslId(Integer eslId) {
        this.eslId = eslId;
    }

    public int getEslCantPregSi() {
        return eslCantPregSi;
    }

    public void setEslCantPregSi(int eslCantPregSi) {
        this.eslCantPregSi = eslCantPregSi;
    }

    public double getEslValor() {
        return eslValor;
    }

    public void setEslValor(double eslValor) {
        this.eslValor = eslValor;
    }

    public PortadaSeccion getPosId() {
        return posId;
    }

    public void setPosId(PortadaSeccion posId) {
        this.posId = posId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eslId != null ? eslId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscalaLikert)) {
            return false;
        }
        EscalaLikert other = (EscalaLikert) object;
        if ((this.eslId == null && other.eslId != null) || (this.eslId != null && !this.eslId.equals(other.eslId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.EscalaLikert[ eslId=" + eslId + " ]";
    }
    
}
