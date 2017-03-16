package com.fabrica.sisgenefac.transformers;

import com.fabrica.sisgenefac.domain.DetRpta;

/**
 *
 * @author Ledis Rivera Changra
 */
public class DetRptaTransformer {
    private DetRpta detRpta;
    private String numSecAntes;
    private String numPreAntes;
    
    private int acumuladosSi;
    private double acumuladoLikert;

    public DetRpta getDetRpta() {
        return detRpta;
    }

    public void setDetRpta(DetRpta detRpta) {
        this.detRpta = detRpta;
    }

    public String getNumSecAntes() {
        return numSecAntes;
    }

    public void setNumSecAntes(String numSecAntes) {
        this.numSecAntes = numSecAntes;
    }

    public String getNumPreAntes() {
        return numPreAntes;
    }

    public void setNumPreAntes(String numPreAntes) {
        this.numPreAntes = numPreAntes;
    }

    public int getAcumuladosSi() {
        return acumuladosSi;
    }

    public void setAcumuladosSi(int acumuladosSi) {
        this.acumuladosSi = acumuladosSi;
    }

    public double getAcumuladoLikert() {
        return acumuladoLikert;
    }

    public void setAcumuladoLikert(double acumuladoLikert) {
        this.acumuladoLikert = acumuladoLikert;
    }
}