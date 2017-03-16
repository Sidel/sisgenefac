package com.fabrica.sisgenefac.transformers;

/**
 *
 * @author Ledis Rivera Changra
 */
public class Respuesta implements Comparable<Respuesta> {
    private String numSeccion;
    private String numPregunta;
    
    private String idPregunta;
    private String respuesta;

    public Respuesta() {
        
    }
    
//    public Respuesta(String numSeccion, String numPregunta) {
//        this.numSeccion = numSeccion;
//        this.numPregunta = numPregunta;
//    }
    
    public String getNumSeccion() {
        return numSeccion;
    }

    public void setNumSeccion(String numSeccion) {
        this.numSeccion = numSeccion;
    }

    public String getNumPregunta() {
        return numPregunta;
    }

    public void setNumPregunta(String numPregunta) {
        this.numPregunta = numPregunta;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    @Override
    public int compareTo(Respuesta o) {
        String a = numSeccion + numPregunta;
        String b = o.numSeccion + o.numPregunta;
        
//        String a = numPregunta + numSeccion;
//        String b = o.numPregunta + o.numSeccion;
        return a.compareTo(b);
    }
}