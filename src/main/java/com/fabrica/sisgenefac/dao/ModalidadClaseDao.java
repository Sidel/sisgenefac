package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.ModalidadClase;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:21 p.m.)
 */
public interface ModalidadClaseDao extends GenericDao<ModalidadClase, Integer> {
    
    public ModalidadClase buscarModClase(String tipoClase);
    
}