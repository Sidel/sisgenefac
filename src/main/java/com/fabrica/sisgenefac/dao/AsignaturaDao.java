package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Asignatura;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:00 a.m.)
 */
public interface AsignaturaDao extends GenericDao<Asignatura, Integer> {
    public List<Object[]> getCursosMatriculados(String idUsuario);
}