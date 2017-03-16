package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Dictado;
/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:11 p.m.)
 */
public interface DictadoDao extends GenericDao<Dictado, Integer> {
    
    public Dictado buscarDictado(int idProfesor, int idAsignatura /*, int idGrupo*/, int idModClase);
    
}