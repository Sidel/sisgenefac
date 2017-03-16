package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.domain.Cuestionario;
import com.fabrica.sisgenefac.transformers.SeccionCuestionario;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (13:40 p.m.)
 */
public interface CuestionarioService {
    
    public List<SeccionCuestionario> getPreguntasCuestionario(String idPortada);
    
    public Cuestionario buscarCuestionario(int idPregunta, int idPortada);
    
}