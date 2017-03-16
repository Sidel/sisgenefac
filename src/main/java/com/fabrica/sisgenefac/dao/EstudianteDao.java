package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Estudiante;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (18:41 p.m.)
 */
public interface EstudianteDao extends GenericDao<Estudiante, Integer> {
    
    public Estudiante buscarEncuestador(int idUsuario);
    
}