package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Portada;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 */
public interface PortadaDao extends GenericDao<Portada, Integer> {
    public List<Portada> getEncuestasHabilitadas(String idUsuario);
}