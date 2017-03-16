package com.fabrica.sisgenefac.transformers;

import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 */
public class CursoMatricula {
    private String idCurso;
    private String codigo;
    private String descripcion;
    private String nombreResponsable;
    private List<ProfesorMatricula> lstProfesores;

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public List<ProfesorMatricula> getLstProfesores() {
        return lstProfesores;
    }

    public void setLstProfesores(List<ProfesorMatricula> lstProfesores) {
        this.lstProfesores = lstProfesores;
    }
}