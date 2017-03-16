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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c"),
    @NamedQuery(name = "Catalogo.findByCatId", query = "SELECT c FROM Catalogo c WHERE c.catId = :catId"),
    @NamedQuery(name = "Catalogo.findByCatGrupo", query = "SELECT c FROM Catalogo c WHERE c.catGrupo = :catGrupo"),
    @NamedQuery(name = "Catalogo.findByCatSubGrupo", query = "SELECT c FROM Catalogo c WHERE c.catSubGrupo = :catSubGrupo"),
    @NamedQuery(name = "Catalogo.findByCatNombre", query = "SELECT c FROM Catalogo c WHERE c.catNombre = :catNombre"),
    @NamedQuery(name = "Catalogo.findByCatDescripcion", query = "SELECT c FROM Catalogo c WHERE c.catDescripcion = :catDescripcion"),
    @NamedQuery(name = "Catalogo.findByCatCodigo", query = "SELECT c FROM Catalogo c WHERE c.catCodigo = :catCodigo")})
public class Catalogo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    
    @Basic(optional = false)
    @Column(name = "cat_grupo")
    private int catGrupo;
    
    @Column(name = "cat_sub_grupo")
    private Integer catSubGrupo;
    
    @Basic(optional = false)
    @Column(name = "cat_nombre")
    private String catNombre;
    
    @Basic(optional = false)
    @Column(name = "cat_descripcion")
    private String catDescripcion;
    
    @Column(name = "cat_codigo")
    private String catCodigo;

    public Catalogo() {
    }

    public Catalogo(Integer catId) {
        this.catId = catId;
    }

    public Catalogo(Integer catId, int catGrupo, String catNombre, String catDescripcion) {
        this.catId = catId;
        this.catGrupo = catGrupo;
        this.catNombre = catNombre;
        this.catDescripcion = catDescripcion;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public int getCatGrupo() {
        return catGrupo;
    }

    public void setCatGrupo(int catGrupo) {
        this.catGrupo = catGrupo;
    }

    public Integer getCatSubGrupo() {
        return catSubGrupo;
    }

    public void setCatSubGrupo(Integer catSubGrupo) {
        this.catSubGrupo = catSubGrupo;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public String getCatDescripcion() {
        return catDescripcion;
    }

    public void setCatDescripcion(String catDescripcion) {
        this.catDescripcion = catDescripcion;
    }

    public String getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(String catCodigo) {
        this.catCodigo = catCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fabrica.sisgenefac.domain.Catalogo[ catId=" + catId + " ]";
    }
    
}
