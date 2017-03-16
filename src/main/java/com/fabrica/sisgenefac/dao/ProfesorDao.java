package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Profesor;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:42 a.m.)
 */

public interface ProfesorDao extends GenericDao<Profesor, Integer> {
    
    public String getResponsableAsignatura(String codigoAsignatura);
    
}