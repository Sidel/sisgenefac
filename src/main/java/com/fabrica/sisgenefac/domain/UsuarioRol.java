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
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findByUsrId", query = "SELECT u FROM UsuarioRol u WHERE u.usrId = :usrId"),
    @NamedQuery(name = "UsuarioRol.findByUsrEstado", query = "SELECT u FROM UsuarioRol u WHERE u.usrEstado = :usrEstado")})
public class UsuarioRol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;
    
    @Basic(optional = false)
    @Column(name = "usr_estado")
    private char usrEstado;
    
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne
    private Usuario usuId;
    
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;
    
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne
    private Estudiante estId;
    
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private Profesor proId;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer usrId) {
        this.usrId = usrId;
    }

    public UsuarioRol(Integer usrId, char usrEstado) {
        this.usrId = usrId;
        this.usrEstado = usrEstado;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public char getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(char usrEstado) {
        this.usrEstado = usrEstado;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    public Estudiante getEstId() {
        return estId;
    }

    public void setEstId(Estudiante estId) {
        this.estId = estId;
    }

    public Profesor getProId() {
        return proId;
    }

    public void setProId(Profesor proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.UsuarioRol[ usrId=" + usrId + " ]";
    }
    
}
