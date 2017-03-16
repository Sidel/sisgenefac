package com.fabrica.sisgenefac.transformers;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (19:43 p.m.)
 */
public class Encuesta {
    private int idUsuario;
    private int idProfesor;
    private int idAsignatura;
    private int idPortada;
    
    private int idGrupo;
    
    private String tipoClase;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getIdPortada() {
        return idPortada;
    }

    public void setIdPortada(int idPortada) {
        this.idPortada = idPortada;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }
}