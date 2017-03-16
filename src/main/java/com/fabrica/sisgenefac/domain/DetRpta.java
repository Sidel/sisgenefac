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
@Table(name = "det_rpta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetRpta.findAll", query = "SELECT d FROM DetRpta d"),
    @NamedQuery(name = "DetRpta.findByDerId", query = "SELECT d FROM DetRpta d WHERE d.derId = :derId"),
    @NamedQuery(name = "DetRpta.findByDerValorRpta", query = "SELECT d FROM DetRpta d WHERE d.derValorRpta = :derValorRpta"),
    @NamedQuery(name = "DetRpta.findByDerAcumuladoSi", query = "SELECT d FROM DetRpta d WHERE d.derAcumuladoSi = :derAcumuladoSi"),
    @NamedQuery(name = "DetRpta.findByDerAcumuladoValor", query = "SELECT d FROM DetRpta d WHERE d.derAcumuladoValor = :derAcumuladoValor")})
public class DetRpta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "der_id")
    private Integer derId;
    
    @Basic(optional = false)
    @Column(name = "der_valor_rpta")
    private String derValorRpta;
    
    @Basic(optional = false)
    @Column(name = "der_acumulado_si")
    private int derAcumuladoSi;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "der_acumulado_valor")
    private Double derAcumuladoValor;
    
    @JoinColumn(name = "dic_id", referencedColumnName = "dic_id")
    @ManyToOne
    private Dictado dicId;
    
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @ManyToOne
    private CabRpta carId;
    
    @JoinColumn(name = "cue_id", referencedColumnName = "cue_id")
    @ManyToOne
    private Cuestionario cueId;

    public DetRpta() {
    }

    public DetRpta(Integer derId) {
        this.derId = derId;
    }

    public DetRpta(Integer derId, String derValorRpta, int derAcumuladoSi) {
        this.derId = derId;
        this.derValorRpta = derValorRpta;
        this.derAcumuladoSi = derAcumuladoSi;
    }

    public Integer getDerId() {
        return derId;
    }

    public void setDerId(Integer derId) {
        this.derId = derId;
    }

    public String getDerValorRpta() {
        return derValorRpta;
    }

    public void setDerValorRpta(String derValorRpta) {
        this.derValorRpta = derValorRpta;
    }

    public int getDerAcumuladoSi() {
        return derAcumuladoSi;
    }

    public void setDerAcumuladoSi(int derAcumuladoSi) {
        this.derAcumuladoSi = derAcumuladoSi;
    }

    public Double getDerAcumuladoValor() {
        return derAcumuladoValor;
    }

    public void setDerAcumuladoValor(Double derAcumuladoValor) {
        this.derAcumuladoValor = derAcumuladoValor;
    }

    public Dictado getDicId() {
        return dicId;
    }

    public void setDicId(Dictado dicId) {
        this.dicId = dicId;
    }

    public CabRpta getCarId() {
        return carId;
    }

    public void setCarId(CabRpta carId) {
        this.carId = carId;
    }

    public Cuestionario getCueId() {
        return cueId;
    }

    public void setCueId(Cuestionario cueId) {
        this.cueId = cueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (derId != null ? derId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetRpta)) {
            return false;
        }
        DetRpta other = (DetRpta) object;
        if ((this.derId == null && other.derId != null) || (this.derId != null && !this.derId.equals(other.derId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.DetRpta[ derId=" + derId + " ]";
    }
    
}
