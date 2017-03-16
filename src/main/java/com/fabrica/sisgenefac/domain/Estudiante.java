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
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstId", query = "SELECT e FROM Estudiante e WHERE e.estId = :estId"),
    @NamedQuery(name = "Estudiante.findByEstNombres", query = "SELECT e FROM Estudiante e WHERE e.estNombres = :estNombres"),
    @NamedQuery(name = "Estudiante.findByEstAppaterno", query = "SELECT e FROM Estudiante e WHERE e.estAppaterno = :estAppaterno"),
    @NamedQuery(name = "Estudiante.findByEstApmaterno", query = "SELECT e FROM Estudiante e WHERE e.estApmaterno = :estApmaterno"),
    @NamedQuery(name = "Estudiante.findByEstCodigoMatricula", query = "SELECT e FROM Estudiante e WHERE e.estCodigoMatricula = :estCodigoMatricula"),
    @NamedQuery(name = "Estudiante.findByEstCorreo", query = "SELECT e FROM Estudiante e WHERE e.estCorreo = :estCorreo"),
    @NamedQuery(name = "Estudiante.findByEstGenero", query = "SELECT e FROM Estudiante e WHERE e.estGenero = :estGenero"),
    @NamedQuery(name = "Estudiante.findByEstAnioIngreso", query = "SELECT e FROM Estudiante e WHERE e.estAnioIngreso = :estAnioIngreso"),
    @NamedQuery(name = "Estudiante.findByEstCodPlan", query = "SELECT e FROM Estudiante e WHERE e.estCodPlan = :estCodPlan"),
    @NamedQuery(name = "Estudiante.findByEstEstado", query = "SELECT e FROM Estudiante e WHERE e.estEstado = :estEstado")})
public class Estudiante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    
    @Basic(optional = false)
    @Column(name = "est_nombres")
    private String estNombres;
    
    @Basic(optional = false)
    @Column(name = "est_appaterno")
    private String estAppaterno;
    
    @Basic(optional = false)
    @Column(name = "est_apmaterno")
    private String estApmaterno;
    
    @Basic(optional = false)
    @Column(name = "est_codigo_matricula")
    private String estCodigoMatricula;
    
    @Column(name = "est_correo")
    private String estCorreo;
    
    @Column(name = "est_genero")
    private Character estGenero;
    
    @Basic(optional = false)
    @Column(name = "est_anio_ingreso")
    private int estAnioIngreso;
    
    @Basic(optional = false)
    @Column(name = "est_cod_plan")
    private int estCodPlan;
    
    @Basic(optional = false)
    @Column(name = "est_estado")
    private char estEstado;
    
    @JoinColumn(name = "esa_id", referencedColumnName = "esa_id")
    @ManyToOne
    private EscuelaAcademica esaId;
    
    @OneToMany(mappedBy = "estId")
    private List<CabMatricula> cabMatriculaList;
    
    @OneToMany(mappedBy = "estId")
    private List<UsuarioRol> usuarioRolList;
    
    @OneToMany(mappedBy = "estId")
    private List<CabRpta> cabRptaList;

    public Estudiante() {
    }

    public Estudiante(Integer estId) {
        this.estId = estId;
    }

    public Estudiante(Integer estId, String estNombres, String estAppaterno, String estApmaterno, String estCodigoMatricula, int estAnioIngreso, int estCodPlan, char estEstado) {
        this.estId = estId;
        this.estNombres = estNombres;
        this.estAppaterno = estAppaterno;
        this.estApmaterno = estApmaterno;
        this.estCodigoMatricula = estCodigoMatricula;
        this.estAnioIngreso = estAnioIngreso;
        this.estCodPlan = estCodPlan;
        this.estEstado = estEstado;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNombres() {
        return estNombres;
    }

    public void setEstNombres(String estNombres) {
        this.estNombres = estNombres;
    }

    public String getEstAppaterno() {
        return estAppaterno;
    }

    public void setEstAppaterno(String estAppaterno) {
        this.estAppaterno = estAppaterno;
    }

    public String getEstApmaterno() {
        return estApmaterno;
    }

    public void setEstApmaterno(String estApmaterno) {
        this.estApmaterno = estApmaterno;
    }

    public String getEstCodigoMatricula() {
        return estCodigoMatricula;
    }

    public void setEstCodigoMatricula(String estCodigoMatricula) {
        this.estCodigoMatricula = estCodigoMatricula;
    }

    public String getEstCorreo() {
        return estCorreo;
    }

    public void setEstCorreo(String estCorreo) {
        this.estCorreo = estCorreo;
    }

    public Character getEstGenero() {
        return estGenero;
    }

    public void setEstGenero(Character estGenero) {
        this.estGenero = estGenero;
    }

    public int getEstAnioIngreso() {
        return estAnioIngreso;
    }

    public void setEstAnioIngreso(int estAnioIngreso) {
        this.estAnioIngreso = estAnioIngreso;
    }

    public int getEstCodPlan() {
        return estCodPlan;
    }

    public void setEstCodPlan(int estCodPlan) {
        this.estCodPlan = estCodPlan;
    }

    public char getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(char estEstado) {
        this.estEstado = estEstado;
    }

    public EscuelaAcademica getEsaId() {
        return esaId;
    }

    public void setEsaId(EscuelaAcademica esaId) {
        this.esaId = esaId;
    }

    @XmlTransient
    public List<CabMatricula> getCabMatriculaList() {
        return cabMatriculaList;
    }

    public void setCabMatriculaList(List<CabMatricula> cabMatriculaList) {
        this.cabMatriculaList = cabMatriculaList;
    }

    @XmlTransient
    public List<UsuarioRol> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
    }

    @XmlTransient
    public List<CabRpta> getCabRptaList() {
        return cabRptaList;
    }

    public void setCabRptaList(List<CabRpta> cabRptaList) {
        this.cabRptaList = cabRptaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Estudiante[ estId=" + estId + " ]";
    }
    
}
