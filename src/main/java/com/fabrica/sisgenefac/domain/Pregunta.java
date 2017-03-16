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
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByPreId", query = "SELECT p FROM Pregunta p WHERE p.preId = :preId"),
    @NamedQuery(name = "Pregunta.findByPreEnunciado", query = "SELECT p FROM Pregunta p WHERE p.preEnunciado = :preEnunciado"),
    @NamedQuery(name = "Pregunta.findByPreNumero", query = "SELECT p FROM Pregunta p WHERE p.preNumero = :preNumero"),
    @NamedQuery(name = "Pregunta.findByPreComentario", query = "SELECT p FROM Pregunta p WHERE p.preComentario = :preComentario"),
    @NamedQuery(name = "Pregunta.findByPreTipoRpta", query = "SELECT p FROM Pregunta p WHERE p.preTipoRpta = :preTipoRpta")})
public class Pregunta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_id")
    private Integer preId;
    
    @Basic(optional = false)
    @Column(name = "pre_enunciado")
    private String preEnunciado;
    
    @Basic(optional = false)
    @Column(name = "pre_numero")
    private int preNumero;
    
    @Column(name = "pre_comentario")
    private String preComentario;
    
    @Basic(optional = false)
    @Column(name = "pre_tipo_rpta")
    private String preTipoRpta;
    
    @OneToMany(mappedBy = "preId")
    private List<Cuestionario> cuestionarioList;
    
    @OneToMany(mappedBy = "preId")
    private List<PreguntaOpcion> preguntaOpcionList;

    public Pregunta() {
    }

    public Pregunta(Integer preId) {
        this.preId = preId;
    }

    public Pregunta(Integer preId, String preEnunciado, int preNumero, String preTipoRpta) {
        this.preId = preId;
        this.preEnunciado = preEnunciado;
        this.preNumero = preNumero;
        this.preTipoRpta = preTipoRpta;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public String getPreEnunciado() {
        return preEnunciado;
    }

    public void setPreEnunciado(String preEnunciado) {
        this.preEnunciado = preEnunciado;
    }

    public int getPreNumero() {
        return preNumero;
    }

    public void setPreNumero(int preNumero) {
        this.preNumero = preNumero;
    }

    public String getPreComentario() {
        return preComentario;
    }

    public void setPreComentario(String preComentario) {
        this.preComentario = preComentario;
    }

    public String getPreTipoRpta() {
        return preTipoRpta;
    }

    public void setPreTipoRpta(String preTipoRpta) {
        this.preTipoRpta = preTipoRpta;
    }

    @XmlTransient
    public List<Cuestionario> getCuestionarioList() {
        return cuestionarioList;
    }

    public void setCuestionarioList(List<Cuestionario> cuestionarioList) {
        this.cuestionarioList = cuestionarioList;
    }

    @XmlTransient
    public List<PreguntaOpcion> getPreguntaOpcionList() {
        return preguntaOpcionList;
    }

    public void setPreguntaOpcionList(List<PreguntaOpcion> preguntaOpcionList) {
        this.preguntaOpcionList = preguntaOpcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preId != null ? preId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preId == null && other.preId != null) || (this.preId != null && !this.preId.equals(other.preId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Pregunta[ preId=" + preId + " ]";
    }
    
}
