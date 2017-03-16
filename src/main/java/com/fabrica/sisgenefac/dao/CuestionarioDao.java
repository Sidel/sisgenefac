package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Cuestionario;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (13:26 p.m.)
 */
public interface CuestionarioDao extends GenericDao<Cuestionario, Integer> {
    
    public List<Object[]> getPreguntasCuestionario(String idPortada);
    
    public Cuestionario buscarCuestionario(int idPregunta, int idPortada);
    
}