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
@Table(name = "pro_sed_dep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProSedDep.findAll", query = "SELECT p FROM ProSedDep p"),
    @NamedQuery(name = "ProSedDep.findByProsedeId", query = "SELECT p FROM ProSedDep p WHERE p.prosedeId = :prosedeId"),
    @NamedQuery(name = "ProSedDep.findByProsedeCicloAnio", query = "SELECT p FROM ProSedDep p WHERE p.prosedeCicloAnio = :prosedeCicloAnio"),
    @NamedQuery(name = "ProSedDep.findByProsedeHoras", query = "SELECT p FROM ProSedDep p WHERE p.prosedeHoras = :prosedeHoras"),
    @NamedQuery(name = "ProSedDep.findByCatCategoria", query = "SELECT p FROM ProSedDep p WHERE p.catCategoria = :catCategoria"),
    @NamedQuery(name = "ProSedDep.findByCatRegimen", query = "SELECT p FROM ProSedDep p WHERE p.catRegimen = :catRegimen")})
public class ProSedDep implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prosede_id")
    private Integer prosedeId;
    
    @Column(name = "prosede_ciclo_anio")
    private String prosedeCicloAnio;
    
    @Column(name = "prosede_horas")
    private Integer prosedeHoras;
    
    @Basic(optional = false)
    @Column(name = "cat_categoria")
    private int catCategoria;
    
    @Column(name = "cat_regimen")
    private Integer catRegimen;
    
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Profesor proId;
    
    @JoinColumn(name = "dea_id", referencedColumnName = "dea_id")
    @ManyToOne(optional = false)
    private DepartamentoAcademico deaId;
    
    @JoinColumn(name = "sed_id", referencedColumnName = "sed_id")
    @ManyToOne(optional = false)
    private Sede sedId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prosedeId")
    private List<Dictado> dictadoList;

    public ProSedDep() {
    }

    public ProSedDep(Integer prosedeId) {
        this.prosedeId = prosedeId;
    }

    public ProSedDep(Integer prosedeId, int catCategoria) {
        this.prosedeId = prosedeId;
        this.catCategoria = catCategoria;
    }

    public Integer getProsedeId() {
        return prosedeId;
    }

    public void setProsedeId(Integer prosedeId) {
        this.prosedeId = prosedeId;
    }

    public String getProsedeCicloAnio() {
        return prosedeCicloAnio;
    }

    public void setProsedeCicloAnio(String prosedeCicloAnio) {
        this.prosedeCicloAnio = prosedeCicloAnio;
    }

    public Integer getProsedeHoras() {
        return prosedeHoras;
    }

    public void setProsedeHoras(Integer prosedeHoras) {
        this.prosedeHoras = prosedeHoras;
    }

    public int getCatCategoria() {
        return catCategoria;
    }

    public void setCatCategoria(int catCategoria) {
        this.catCategoria = catCategoria;
    }

    public Integer getCatRegimen() {
        return catRegimen;
    }

    public void setCatRegimen(Integer catRegimen) {
        this.catRegimen = catRegimen;
    }

    public Profesor getProId() {
        return proId;
    }

    public void setProId(Profesor proId) {
        this.proId = proId;
    }

    public DepartamentoAcademico getDeaId() {
        return deaId;
    }

    public void setDeaId(DepartamentoAcademico deaId) {
        this.deaId = deaId;
    }

    public Sede getSedId() {
        return sedId;
    }

    public void setSedId(Sede sedId) {
        this.sedId = sedId;
    }

    @XmlTransient
    public List<Dictado> getDictadoList() {
        return dictadoList;
    }

    public void setDictadoList(List<Dictado> dictadoList) {
        this.dictadoList = dictadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prosedeId != null ? prosedeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProSedDep)) {
            return false;
        }
        ProSedDep other = (ProSedDep) object;
        if ((this.prosedeId == null && other.prosedeId != null) || (this.prosedeId != null && !this.prosedeId.equals(other.prosedeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.ProSedDep[ prosedeId=" + prosedeId + " ]";
    }
    
}
