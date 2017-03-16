/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fabrica.sisgenefac.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sesion_encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SesionEncuesta.findAll", query = "SELECT s FROM SesionEncuesta s"),
    @NamedQuery(name = "SesionEncuesta.findBySeeId", query = "SELECT s FROM SesionEncuesta s WHERE s.seeId = :seeId"),
    @NamedQuery(name = "SesionEncuesta.findBySeeNumero", query = "SELECT s FROM SesionEncuesta s WHERE s.seeNumero = :seeNumero"),
    @NamedQuery(name = "SesionEncuesta.findBySeeContenido", query = "SELECT s FROM SesionEncuesta s WHERE s.seeContenido = :seeContenido"),
    @NamedQuery(name = "SesionEncuesta.findBySeeSumilla", query = "SELECT s FROM SesionEncuesta s WHERE s.seeSumilla = :seeSumilla"),
    @NamedQuery(name = "SesionEncuesta.findBySeeFechaProgramada", query = "SELECT s FROM SesionEncuesta s WHERE s.seeFechaProgramada = :seeFechaProgramada")})
public class SesionEncuesta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "see_id")
    private Integer seeId;
    
    @Basic(optional = false)
    @Column(name = "see_numero")
    private int seeNumero;
    
    @Column(name = "see_contenido")
    private String seeContenido;
    
    @Column(name = "see_sumilla")
    private String seeSumilla;
    
    @Column(name = "see_fecha_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seeFechaProgramada;
    
    @JoinColumn(name = "asi_id", referencedColumnName = "asi_id")
    @ManyToOne
    private Asignatura asiId;
    
    @OneToMany(mappedBy = "seeId")
    private List<Dictado> dictadoList;

    public SesionEncuesta() {
    }

    public SesionEncuesta(Integer seeId) {
        this.seeId = seeId;
    }

    public SesionEncuesta(Integer seeId, int seeNumero) {
        this.seeId = seeId;
        this.seeNumero = seeNumero;
    }

    public Integer getSeeId() {
        return seeId;
    }

    public void setSeeId(Integer seeId) {
        this.seeId = seeId;
    }

    public int getSeeNumero() {
        return seeNumero;
    }

    public void setSeeNumero(int seeNumero) {
        this.seeNumero = seeNumero;
    }

    public String getSeeContenido() {
        return seeContenido;
    }

    public void setSeeContenido(String seeContenido) {
        this.seeContenido = seeContenido;
    }

    public String getSeeSumilla() {
        return seeSumilla;
    }

    public void setSeeSumilla(String seeSumilla) {
        this.seeSumilla = seeSumilla;
    }

    public Date getSeeFechaProgramada() {
        return seeFechaProgramada;
    }

    public void setSeeFechaProgramada(Date seeFechaProgramada) {
        this.seeFechaProgramada = seeFechaProgramada;
    }

    public Asignatura getAsiId() {
        return asiId;
    }

    public void setAsiId(Asignatura asiId) {
        this.asiId = asiId;
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
        hash += (seeId != null ? seeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SesionEncuesta)) {
            return false;
        }
        SesionEncuesta other = (SesionEncuesta) object;
        if ((this.seeId == null && other.seeId != null) || (this.seeId != null && !this.seeId.equals(other.seeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.SesionEncuesta[ seeId=" + seeId + " ]";
    }
    
}
