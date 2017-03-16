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
@Table(name = "dictado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dictado.findAll", query = "SELECT d FROM Dictado d"),
    @NamedQuery(name = "Dictado.findByDicId", query = "SELECT d FROM Dictado d WHERE d.dicId = :dicId"),
    @NamedQuery(name = "Dictado.findByDicFechaRealizada", query = "SELECT d FROM Dictado d WHERE d.dicFechaRealizada = :dicFechaRealizada"),
    @NamedQuery(name = "Dictado.findByCatTipoDocente", query = "SELECT d FROM Dictado d WHERE d.catTipoDocente = :catTipoDocente")})
public class Dictado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dic_id")
    private Integer dicId;
    
    @Column(name = "dic_fecha_realizada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dicFechaRealizada;
    
    @Basic(optional = false)
    @Column(name = "cat_tipo_docente")
    private int catTipoDocente;
    
    @OneToMany(mappedBy = "dicId")
    private List<Resultado> resultadoList;
    
    @JoinColumn(name = "prosede_id", referencedColumnName = "prosede_id")
    @ManyToOne(optional = false)
    private ProSedDep prosedeId;
    
    @JoinColumn(name = "gru_id", referencedColumnName = "gru_id")
    @ManyToOne(optional = false)
    private Grupo gruId;
    
    @JoinColumn(name = "moc_id", referencedColumnName = "moc_id")
    @ManyToOne
    private ModalidadClase mocId;
    
    @JoinColumn(name = "see_id", referencedColumnName = "see_id")
    @ManyToOne
    private SesionEncuesta seeId;
    
    @OneToMany(mappedBy = "dicId")
    private List<DetRpta> detRptaList;

    public Dictado() {
    }

    public Dictado(Integer dicId) {
        this.dicId = dicId;
    }

    public Dictado(Integer dicId, int catTipoDocente) {
        this.dicId = dicId;
        this.catTipoDocente = catTipoDocente;
    }

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public Date getDicFechaRealizada() {
        return dicFechaRealizada;
    }

    public void setDicFechaRealizada(Date dicFechaRealizada) {
        this.dicFechaRealizada = dicFechaRealizada;
    }

    public int getCatTipoDocente() {
        return catTipoDocente;
    }

    public void setCatTipoDocente(int catTipoDocente) {
        this.catTipoDocente = catTipoDocente;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    public ProSedDep getProsedeId() {
        return prosedeId;
    }

    public void setProsedeId(ProSedDep prosedeId) {
        this.prosedeId = prosedeId;
    }

    public Grupo getGruId() {
        return gruId;
    }

    public void setGruId(Grupo gruId) {
        this.gruId = gruId;
    }

    public ModalidadClase getMocId() {
        return mocId;
    }

    public void setMocId(ModalidadClase mocId) {
        this.mocId = mocId;
    }

    public SesionEncuesta getSeeId() {
        return seeId;
    }

    public void setSeeId(SesionEncuesta seeId) {
        this.seeId = seeId;
    }

    @XmlTransient
    public List<DetRpta> getDetRptaList() {
        return detRptaList;
    }

    public void setDetRptaList(List<DetRpta> detRptaList) {
        this.detRptaList = detRptaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dicId != null ? dicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dictado)) {
            return false;
        }
        Dictado other = (Dictado) object;
        if ((this.dicId == null && other.dicId != null) || (this.dicId != null && !this.dicId.equals(other.dicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Dictado[ dicId=" + dicId + " ]";
    }
    
}
