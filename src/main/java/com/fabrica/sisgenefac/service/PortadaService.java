package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.domain.Portada;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 */
public interface PortadaService {
    public List<Portada> getEncuestasHabilitadas(String idUsuario);
}