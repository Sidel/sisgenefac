package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.transformers.Encuesta;
import com.fabrica.sisgenefac.transformers.Respuesta;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (18:15 p.m.)
 */
public interface CabRptaService {
    
    public boolean guardarEncuesta(Encuesta encuesta, List<Respuesta> lstMapRptas);
    
}