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
@Table(name = "cab_rpta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabRpta.findAll", query = "SELECT c FROM CabRpta c"),
    @NamedQuery(name = "CabRpta.findByCarId", query = "SELECT c FROM CabRpta c WHERE c.carId = :carId"),
    @NamedQuery(name = "CabRpta.findByCarFecha", query = "SELECT c FROM CabRpta c WHERE c.carFecha = :carFecha"),
    @NamedQuery(name = "CabRpta.findByCarHora", query = "SELECT c FROM CabRpta c WHERE c.carHora = :carHora")})
public class CabRpta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Integer carId;
    
    @Basic(optional = false)
    @Column(name = "car_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carFecha;
    
    @Basic(optional = false)
    @Column(name = "car_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carHora;
    
    @OneToMany(mappedBy = "carId")
    private List<DetRpta> detRptaList;
    
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne
    private Estudiante estId;

    public CabRpta() {
    }

    public CabRpta(Integer carId) {
        this.carId = carId;
    }

    public CabRpta(Integer carId, Date carFecha, Date carHora) {
        this.carId = carId;
        this.carFecha = carFecha;
        this.carHora = carHora;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getCarFecha() {
        return carFecha;
    }

    public void setCarFecha(Date carFecha) {
        this.carFecha = carFecha;
    }

    public Date getCarHora() {
        return carHora;
    }

    public void setCarHora(Date carHora) {
        this.carHora = carHora;
    }

    @XmlTransient
    public List<DetRpta> getDetRptaList() {
        return detRptaList;
    }

    public void setDetRptaList(List<DetRpta> detRptaList) {
        this.detRptaList = detRptaList;
    }

    public Estudiante getEstId() {
        return estId;
    }

    public void setEstId(Estudiante estId) {
        this.estId = estId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carId != null ? carId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabRpta)) {
            return false;
        }
        CabRpta other = (CabRpta) object;
        if ((this.carId == null && other.carId != null) || (this.carId != null && !this.carId.equals(other.carId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.CabRpta[ carId=" + carId + " ]";
    }
    
}
