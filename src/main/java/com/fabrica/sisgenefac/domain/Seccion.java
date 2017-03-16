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
@Table(name = "seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findBySecId", query = "SELECT s FROM Seccion s WHERE s.secId = :secId"),
    @NamedQuery(name = "Seccion.findBySecNombre", query = "SELECT s FROM Seccion s WHERE s.secNombre = :secNombre"),
    @NamedQuery(name = "Seccion.findBySecNumero", query = "SELECT s FROM Seccion s WHERE s.secNumero = :secNumero")})
public class Seccion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sec_id")
    private Integer secId;
    
    @Basic(optional = false)
    @Column(name = "sec_nombre")
    private String secNombre;
    
    @Basic(optional = false)
    @Column(name = "sec_numero")
    private int secNumero;
    
    @OneToMany(mappedBy = "secId")
    private List<PortadaSeccion> portadaSeccionList;

    public Seccion() {
    }

    public Seccion(Integer secId) {
        this.secId = secId;
    }

    public Seccion(Integer secId, String secNombre, int secNumero) {
        this.secId = secId;
        this.secNombre = secNombre;
        this.secNumero = secNumero;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecNombre() {
        return secNombre;
    }

    public void setSecNombre(String secNombre) {
        this.secNombre = secNombre;
    }

    public int getSecNumero() {
        return secNumero;
    }

    public void setSecNumero(int secNumero) {
        this.secNumero = secNumero;
    }

    @XmlTransient
    public List<PortadaSeccion> getPortadaSeccionList() {
        return portadaSeccionList;
    }

    public void setPortadaSeccionList(List<PortadaSeccion> portadaSeccionList) {
        this.portadaSeccionList = portadaSeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secId != null ? secId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Seccion[ secId=" + secId + " ]";
    }
    
}
