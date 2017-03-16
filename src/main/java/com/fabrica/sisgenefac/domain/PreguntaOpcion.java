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
@Table(name = "pregunta_opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaOpcion.findAll", query = "SELECT p FROM PreguntaOpcion p"),
    @NamedQuery(name = "PreguntaOpcion.findByProId", query = "SELECT p FROM PreguntaOpcion p WHERE p.proId = :proId")})
public class PreguntaOpcion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    
    @JoinColumn(name = "opc_id", referencedColumnName = "opc_id")
    @ManyToOne
    private Opcion opcId;
    
    @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")
    @ManyToOne
    private Pregunta preId;

    public PreguntaOpcion() {
    }

    public PreguntaOpcion(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Opcion getOpcId() {
        return opcId;
    }

    public void setOpcId(Opcion opcId) {
        this.opcId = opcId;
    }

    public Pregunta getPreId() {
        return preId;
    }

    public void setPreId(Pregunta preId) {
        this.preId = preId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaOpcion)) {
            return false;
        }
        PreguntaOpcion other = (PreguntaOpcion) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.PreguntaOpcion[ proId=" + proId + " ]";
    }
    
}
