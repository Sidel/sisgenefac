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
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o"),
    @NamedQuery(name = "Opcion.findByOpcId", query = "SELECT o FROM Opcion o WHERE o.opcId = :opcId"),
    @NamedQuery(name = "Opcion.findByOpcNombre", query = "SELECT o FROM Opcion o WHERE o.opcNombre = :opcNombre")})
public class Opcion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "opc_id")
    private Integer opcId;
    
    @Basic(optional = false)
    @Column(name = "opc_nombre")
    private String opcNombre;
    
    @OneToMany(mappedBy = "opcId")
    private List<PreguntaOpcion> preguntaOpcionList;

    public Opcion() {
    }

    public Opcion(Integer opcId) {
        this.opcId = opcId;
    }

    public Opcion(Integer opcId, String opcNombre) {
        this.opcId = opcId;
        this.opcNombre = opcNombre;
    }

    public Integer getOpcId() {
        return opcId;
    }

    public void setOpcId(Integer opcId) {
        this.opcId = opcId;
    }

    public String getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(String opcNombre) {
        this.opcNombre = opcNombre;
    }

    @XmlTransient
    public List<PreguntaOpcion> getPreguntaOpcionList() {
        return preguntaOpcionList;
    }

    public void setPreguntaOpcionList(List<PreguntaOpcion> preguntaOpcionList) {
        this.preguntaOpcionList = preguntaOpcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcId != null ? opcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcId == null && other.opcId != null) || (this.opcId != null && !this.opcId.equals(other.opcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Opcion[ opcId=" + opcId + " ]";
    }
    
}
