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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByProId", query = "SELECT p FROM Profesor p WHERE p.proId = :proId"),
    @NamedQuery(name = "Profesor.findByProNombres", query = "SELECT p FROM Profesor p WHERE p.proNombres = :proNombres"),
    @NamedQuery(name = "Profesor.findByProAppaterno", query = "SELECT p FROM Profesor p WHERE p.proAppaterno = :proAppaterno"),
    @NamedQuery(name = "Profesor.findByProApmaterno", query = "SELECT p FROM Profesor p WHERE p.proApmaterno = :proApmaterno"),
    @NamedQuery(name = "Profesor.findByProCodigo", query = "SELECT p FROM Profesor p WHERE p.proCodigo = :proCodigo"),
    @NamedQuery(name = "Profesor.findByProCorreo", query = "SELECT p FROM Profesor p WHERE p.proCorreo = :proCorreo"),
    @NamedQuery(name = "Profesor.findByProGenero", query = "SELECT p FROM Profesor p WHERE p.proGenero = :proGenero"),
    @NamedQuery(name = "Profesor.findByProEstado", query = "SELECT p FROM Profesor p WHERE p.proEstado = :proEstado")})
public class Profesor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    
    @Basic(optional = false)
    @Column(name = "pro_nombres")
    private String proNombres;
    
    @Basic(optional = false)
    @Column(name = "pro_appaterno")
    private String proAppaterno;
    
    @Basic(optional = false)
    @Column(name = "pro_apmaterno")
    private String proApmaterno;
    
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private String proCodigo;
    
    @Column(name = "pro_correo")
    private String proCorreo;
    
    @Column(name = "pro_genero")
    private Character proGenero;
    
    @Basic(optional = false)
    @Column(name = "pro_estado")
    private char proEstado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private List<ProSedDep> proSedDepList;
    
    @OneToMany(mappedBy = "proId")
    private List<UsuarioRol> usuarioRolList;

    public Profesor() {
    }

    public Profesor(Integer proId) {
        this.proId = proId;
    }

    public Profesor(Integer proId, String proNombres, String proAppaterno, String proApmaterno, String proCodigo, char proEstado) {
        this.proId = proId;
        this.proNombres = proNombres;
        this.proAppaterno = proAppaterno;
        this.proApmaterno = proApmaterno;
        this.proCodigo = proCodigo;
        this.proEstado = proEstado;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombres() {
        return proNombres;
    }

    public void setProNombres(String proNombres) {
        this.proNombres = proNombres;
    }

    public String getProAppaterno() {
        return proAppaterno;
    }

    public void setProAppaterno(String proAppaterno) {
        this.proAppaterno = proAppaterno;
    }

    public String getProApmaterno() {
        return proApmaterno;
    }

    public void setProApmaterno(String proApmaterno) {
        this.proApmaterno = proApmaterno;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProCorreo() {
        return proCorreo;
    }

    public void setProCorreo(String proCorreo) {
        this.proCorreo = proCorreo;
    }

    public Character getProGenero() {
        return proGenero;
    }

    public void setProGenero(Character proGenero) {
        this.proGenero = proGenero;
    }

    public char getProEstado() {
        return proEstado;
    }

    public void setProEstado(char proEstado) {
        this.proEstado = proEstado;
    }

    @XmlTransient
    public List<ProSedDep> getProSedDepList() {
        return proSedDepList;
    }

    public void setProSedDepList(List<ProSedDep> proSedDepList) {
        this.proSedDepList = proSedDepList;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
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
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Profesor[ proId=" + proId + " ]";
    }
    
}
