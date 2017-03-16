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
@Table(name = "acceso_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccesoEncuesta.findAll", query = "SELECT a FROM AccesoEncuesta a"),
    @NamedQuery(name = "AccesoEncuesta.findByAceId", query = "SELECT a FROM AccesoEncuesta a WHERE a.aceId = :aceId")})
public class AccesoEncuesta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ace_id")
    private Integer aceId;
    
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne
    private Usuario usuId;
    
    @JoinColumn(name = "por_id", referencedColumnName = "por_id")
    @ManyToOne
    private Portada porId;

    public AccesoEncuesta() {
    }

    public AccesoEncuesta(Integer aceId) {
        this.aceId = aceId;
    }

    public Integer getAceId() {
        return aceId;
    }

    public void setAceId(Integer aceId) {
        this.aceId = aceId;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    public Portada getPorId() {
        return porId;
    }

    public void setPorId(Portada porId) {
        this.porId = porId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aceId != null ? aceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccesoEncuesta)) {
            return false;
        }
        AccesoEncuesta other = (AccesoEncuesta) object;
        if ((this.aceId == null && other.aceId != null) || (this.aceId != null && !this.aceId.equals(other.aceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.AccesoEncuesta[ aceId=" + aceId + " ]";
    }
    
}
