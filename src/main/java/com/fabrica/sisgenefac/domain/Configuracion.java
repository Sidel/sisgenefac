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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c"),
    @NamedQuery(name = "Configuracion.findByConId", query = "SELECT c FROM Configuracion c WHERE c.conId = :conId"),
    @NamedQuery(name = "Configuracion.findByConFacultad", query = "SELECT c FROM Configuracion c WHERE c.conFacultad = :conFacultad"),
    @NamedQuery(name = "Configuracion.findByConEscuela", query = "SELECT c FROM Configuracion c WHERE c.conEscuela = :conEscuela"),
    @NamedQuery(name = "Configuracion.findByConRutaLogo", query = "SELECT c FROM Configuracion c WHERE c.conRutaLogo = :conRutaLogo"),
    @NamedQuery(name = "Configuracion.findByConUserAdmin", query = "SELECT c FROM Configuracion c WHERE c.conUserAdmin = :conUserAdmin"),
    @NamedQuery(name = "Configuracion.findByConClaveAdmin", query = "SELECT c FROM Configuracion c WHERE c.conClaveAdmin = :conClaveAdmin")})
public class Configuracion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    
    @Basic(optional = false)
    @Column(name = "con_facultad")
    private String conFacultad;
    
    @Column(name = "con_escuela")
    private String conEscuela;
    
    @Column(name = "con_ruta_logo")
    private String conRutaLogo;
    
    @Basic(optional = false)
    @Column(name = "con_user_admin")
    private String conUserAdmin;
    
    @Basic(optional = false)
    @Column(name = "con_clave_admin")
    private String conClaveAdmin;

    public Configuracion() {
    }

    public Configuracion(Integer conId) {
        this.conId = conId;
    }

    public Configuracion(Integer conId, String conFacultad, String conUserAdmin, String conClaveAdmin) {
        this.conId = conId;
        this.conFacultad = conFacultad;
        this.conUserAdmin = conUserAdmin;
        this.conClaveAdmin = conClaveAdmin;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConFacultad() {
        return conFacultad;
    }

    public void setConFacultad(String conFacultad) {
        this.conFacultad = conFacultad;
    }

    public String getConEscuela() {
        return conEscuela;
    }

    public void setConEscuela(String conEscuela) {
        this.conEscuela = conEscuela;
    }

    public String getConRutaLogo() {
        return conRutaLogo;
    }

    public void setConRutaLogo(String conRutaLogo) {
        this.conRutaLogo = conRutaLogo;
    }

    public String getConUserAdmin() {
        return conUserAdmin;
    }

    public void setConUserAdmin(String conUserAdmin) {
        this.conUserAdmin = conUserAdmin;
    }

    public String getConClaveAdmin() {
        return conClaveAdmin;
    }

    public void setConClaveAdmin(String conClaveAdmin) {
        this.conClaveAdmin = conClaveAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Configuracion[ conId=" + conId + " ]";
    }
    
}
