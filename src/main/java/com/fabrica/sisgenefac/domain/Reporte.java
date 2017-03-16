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
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByRepId", query = "SELECT r FROM Reporte r WHERE r.repId = :repId"),
    @NamedQuery(name = "Reporte.findByRepNotaFinal", query = "SELECT r FROM Reporte r WHERE r.repNotaFinal = :repNotaFinal"),
    @NamedQuery(name = "Reporte.findByRepDenominacion", query = "SELECT r FROM Reporte r WHERE r.repDenominacion = :repDenominacion"),
    @NamedQuery(name = "Reporte.findByRepFdesde", query = "SELECT r FROM Reporte r WHERE r.repFdesde = :repFdesde"),
    @NamedQuery(name = "Reporte.findByRepFhasta", query = "SELECT r FROM Reporte r WHERE r.repFhasta = :repFhasta"),
    @NamedQuery(name = "Reporte.findByRepFecha", query = "SELECT r FROM Reporte r WHERE r.repFecha = :repFecha"),
    @NamedQuery(name = "Reporte.findByRepHora", query = "SELECT r FROM Reporte r WHERE r.repHora = :repHora"),
    @NamedQuery(name = "Reporte.findByRepCicloAnio", query = "SELECT r FROM Reporte r WHERE r.repCicloAnio = :repCicloAnio"),
    @NamedQuery(name = "Reporte.findByRepModalidad", query = "SELECT r FROM Reporte r WHERE r.repModalidad = :repModalidad")})
public class Reporte implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_id")
    private Integer repId;
    
    @Basic(optional = false)
    @Column(name = "rep_nota_final")
    private double repNotaFinal;
    
    @Basic(optional = false)
    @Column(name = "rep_denominacion")
    private String repDenominacion;
    
    @Basic(optional = false)
    @Column(name = "rep_fdesde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repFdesde;
    
    @Basic(optional = false)
    @Column(name = "rep_fhasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repFhasta;
    
    @Basic(optional = false)
    @Column(name = "rep_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repFecha;
    
    @Basic(optional = false)
    @Column(name = "rep_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repHora;
    
    @Basic(optional = false)
    @Column(name = "rep_ciclo_anio")
    private String repCicloAnio;
    
    @Basic(optional = false)
    @Column(name = "rep_modalidad")
    private char repModalidad;
    
    @OneToMany(mappedBy = "repId")
    private List<Resultado> resultadoList;
    
    @OneToMany(mappedBy = "repId")
    private List<MaxRptaSec> maxRptaSecList;

    public Reporte() {
    }

    public Reporte(Integer repId) {
        this.repId = repId;
    }

    public Reporte(Integer repId, double repNotaFinal, String repDenominacion, Date repFdesde, Date repFhasta, Date repFecha, Date repHora, String repCicloAnio, char repModalidad) {
        this.repId = repId;
        this.repNotaFinal = repNotaFinal;
        this.repDenominacion = repDenominacion;
        this.repFdesde = repFdesde;
        this.repFhasta = repFhasta;
        this.repFecha = repFecha;
        this.repHora = repHora;
        this.repCicloAnio = repCicloAnio;
        this.repModalidad = repModalidad;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public double getRepNotaFinal() {
        return repNotaFinal;
    }

    public void setRepNotaFinal(double repNotaFinal) {
        this.repNotaFinal = repNotaFinal;
    }

    public String getRepDenominacion() {
        return repDenominacion;
    }

    public void setRepDenominacion(String repDenominacion) {
        this.repDenominacion = repDenominacion;
    }

    public Date getRepFdesde() {
        return repFdesde;
    }

    public void setRepFdesde(Date repFdesde) {
        this.repFdesde = repFdesde;
    }

    public Date getRepFhasta() {
        return repFhasta;
    }

    public void setRepFhasta(Date repFhasta) {
        this.repFhasta = repFhasta;
    }

    public Date getRepFecha() {
        return repFecha;
    }

    public void setRepFecha(Date repFecha) {
        this.repFecha = repFecha;
    }

    public Date getRepHora() {
        return repHora;
    }

    public void setRepHora(Date repHora) {
        this.repHora = repHora;
    }

    public String getRepCicloAnio() {
        return repCicloAnio;
    }

    public void setRepCicloAnio(String repCicloAnio) {
        this.repCicloAnio = repCicloAnio;
    }

    public char getRepModalidad() {
        return repModalidad;
    }

    public void setRepModalidad(char repModalidad) {
        this.repModalidad = repModalidad;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @XmlTransient
    public List<MaxRptaSec> getMaxRptaSecList() {
        return maxRptaSecList;
    }

    public void setMaxRptaSecList(List<MaxRptaSec> maxRptaSecList) {
        this.maxRptaSecList = maxRptaSecList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repId != null ? repId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.repId == null && other.repId != null) || (this.repId != null && !this.repId.equals(other.repId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Reporte[ repId=" + repId + " ]";
    }
    
}
