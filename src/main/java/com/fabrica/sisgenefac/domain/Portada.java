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
@Table(name = "portada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portada.findAll", query = "SELECT p FROM Portada p"),
    @NamedQuery(name = "Portada.findByPorId", query = "SELECT p FROM Portada p WHERE p.porId = :porId"),
    @NamedQuery(name = "Portada.findByPorCodigo", query = "SELECT p FROM Portada p WHERE p.porCodigo = :porCodigo"),
    @NamedQuery(name = "Portada.findByPorNombre", query = "SELECT p FROM Portada p WHERE p.porNombre = :porNombre"),
    @NamedQuery(name = "Portada.findByPorDescripcion", query = "SELECT p FROM Portada p WHERE p.porDescripcion = :porDescripcion"),
    @NamedQuery(name = "Portada.findByPorFinicio", query = "SELECT p FROM Portada p WHERE p.porFinicio = :porFinicio"),
    @NamedQuery(name = "Portada.findByPorFfin", query = "SELECT p FROM Portada p WHERE p.porFfin = :porFfin"),
    @NamedQuery(name = "Portada.findByPorObservaciones", query = "SELECT p FROM Portada p WHERE p.porObservaciones = :porObservaciones"),
    @NamedQuery(name = "Portada.findByPorCicloAnio", query = "SELECT p FROM Portada p WHERE p.porCicloAnio = :porCicloAnio"),
    @NamedQuery(name = "Portada.findByPorEstado", query = "SELECT p FROM Portada p WHERE p.porEstado = :porEstado"),
    @NamedQuery(name = "Portada.findByPorFechaCreacion", query = "SELECT p FROM Portada p WHERE p.porFechaCreacion = :porFechaCreacion")})
public class Portada implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "por_id")
    private Integer porId;
    
    @Basic(optional = false)
    @Column(name = "por_codigo")
    private String porCodigo;
    
    @Basic(optional = false)
    @Column(name = "por_nombre")
    private String porNombre;
    
    @Column(name = "por_descripcion")
    private String porDescripcion;
    @Column(name = "por_finicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date porFinicio;
    @Column(name = "por_ffin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date porFfin;
    @Column(name = "por_observaciones")
    private String porObservaciones;
    @Column(name = "por_ciclo_anio")
    private String porCicloAnio;
    @Basic(optional = false)
    @Column(name = "por_estado")
    private char porEstado;
    @Basic(optional = false)
    @Column(name = "por_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date porFechaCreacion;
    @OneToMany(mappedBy = "porId")
    private List<AccesoEncuesta> accesoEncuestaList;
    @OneToMany(mappedBy = "porId")
    private List<Resultado> resultadoList;
    @OneToMany(mappedBy = "porId")
    private List<PortadaSeccion> portadaSeccionList;
    @OneToMany(mappedBy = "porId")
    private List<MaxRptaSec> maxRptaSecList;
    @OneToMany(mappedBy = "porId")
    private List<Denominacion> denominacionList;

    public Portada() {
    }

    public Portada(Integer porId) {
        this.porId = porId;
    }

    public Portada(Integer porId, String porCodigo, String porNombre, char porEstado, Date porFechaCreacion) {
        this.porId = porId;
        this.porCodigo = porCodigo;
        this.porNombre = porNombre;
        this.porEstado = porEstado;
        this.porFechaCreacion = porFechaCreacion;
    }

    public Integer getPorId() {
        return porId;
    }

    public void setPorId(Integer porId) {
        this.porId = porId;
    }

    public String getPorCodigo() {
        return porCodigo;
    }

    public void setPorCodigo(String porCodigo) {
        this.porCodigo = porCodigo;
    }

    public String getPorNombre() {
        return porNombre;
    }

    public void setPorNombre(String porNombre) {
        this.porNombre = porNombre;
    }

    public String getPorDescripcion() {
        return porDescripcion;
    }

    public void setPorDescripcion(String porDescripcion) {
        this.porDescripcion = porDescripcion;
    }

    public Date getPorFinicio() {
        return porFinicio;
    }

    public void setPorFinicio(Date porFinicio) {
        this.porFinicio = porFinicio;
    }

    public Date getPorFfin() {
        return porFfin;
    }

    public void setPorFfin(Date porFfin) {
        this.porFfin = porFfin;
    }

    public String getPorObservaciones() {
        return porObservaciones;
    }

    public void setPorObservaciones(String porObservaciones) {
        this.porObservaciones = porObservaciones;
    }

    public String getPorCicloAnio() {
        return porCicloAnio;
    }

    public void setPorCicloAnio(String porCicloAnio) {
        this.porCicloAnio = porCicloAnio;
    }

    public char getPorEstado() {
        return porEstado;
    }

    public void setPorEstado(char porEstado) {
        this.porEstado = porEstado;
    }

    public Date getPorFechaCreacion() {
        return porFechaCreacion;
    }

    public void setPorFechaCreacion(Date porFechaCreacion) {
        this.porFechaCreacion = porFechaCreacion;
    }

    @XmlTransient
    public List<AccesoEncuesta> getAccesoEncuestaList() {
        return accesoEncuestaList;
    }

    public void setAccesoEncuestaList(List<AccesoEncuesta> accesoEncuestaList) {
        this.accesoEncuestaList = accesoEncuestaList;
    }

    @XmlTransient
    public List<Resultado> getResultadoList() {
        return resultadoList;
    }

    public void setResultadoList(List<Resultado> resultadoList) {
        this.resultadoList = resultadoList;
    }

    @XmlTransient
    public List<PortadaSeccion> getPortadaSeccionList() {
        return portadaSeccionList;
    }

    public void setPortadaSeccionList(List<PortadaSeccion> portadaSeccionList) {
        this.portadaSeccionList = portadaSeccionList;
    }

    @XmlTransient
    public List<MaxRptaSec> getMaxRptaSecList() {
        return maxRptaSecList;
    }

    public void setMaxRptaSecList(List<MaxRptaSec> maxRptaSecList) {
        this.maxRptaSecList = maxRptaSecList;
    }

    @XmlTransient
    public List<Denominacion> getDenominacionList() {
        return denominacionList;
    }

    public void setDenominacionList(List<Denominacion> denominacionList) {
        this.denominacionList = denominacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (porId != null ? porId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portada)) {
            return false;
        }
        Portada other = (Portada) object;
        if ((this.porId == null && other.porId != null) || (this.porId != null && !this.porId.equals(other.porId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Portada[ porId=" + porId + " ]";
    }
    
}
