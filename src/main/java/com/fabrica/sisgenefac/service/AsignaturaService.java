package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.transformers.CursoMatricula;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:05 a.m.)
 */
public interface AsignaturaService {
    
    public List<CursoMatricula> getCursosMatriculados(String idUsuario);
    
}