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
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a"),
    @NamedQuery(name = "Acceso.findByAccId", query = "SELECT a FROM Acceso a WHERE a.accId = :accId"),
    @NamedQuery(name = "Acceso.findByAccEstado", query = "SELECT a FROM Acceso a WHERE a.accEstado = :accEstado")})
public class Acceso implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acc_id")
    private Integer accId;
    
    @Basic(optional = false)
    @Column(name = "acc_estado")
    private char accEstado;
    
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;
    
    @JoinColumn(name = "men_id", referencedColumnName = "men_id")
    @ManyToOne
    private Menu menId;

    public Acceso() {
    }

    public Acceso(Integer accId) {
        this.accId = accId;
    }

    public Acceso(Integer accId, char accEstado) {
        this.accId = accId;
        this.accEstado = accEstado;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public char getAccEstado() {
        return accEstado;
    }

    public void setAccEstado(char accEstado) {
        this.accEstado = accEstado;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Menu getMenId() {
        return menId;
    }

    public void setMenId(Menu menId) {
        this.menId = menId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Acceso[ accId=" + accId + " ]";
    }
    
}
