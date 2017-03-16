package com.fabrica.sisgenefac.transformers;

import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (14:24 p.m.)
 */
public class SeccionCuestionario {
    
    private String idSeccion;
    private String descripcion;
    
    private List<PreguntaCuestionario> lstPregCue;

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PreguntaCuestionario> getLstPregCue() {
        return lstPregCue;
    }

    public void setLstPregCue(List<PreguntaCuestionario> lstPregCue) {
        this.lstPregCue = lstPregCue;
    }
}