package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.EscalaLikert;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:36 p.m.)
 */
public interface EscalaLikertDao extends GenericDao<EscalaLikert, Integer> {
    
    public EscalaLikert buscarEscalaLikert(int idPortada, int idPregunta /*, int idSeccion*/, int cantidadRptasSi);
    
}