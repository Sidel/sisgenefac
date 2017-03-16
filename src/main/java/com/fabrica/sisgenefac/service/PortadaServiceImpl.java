package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.PortadaDao;
import com.fabrica.sisgenefac.domain.Portada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 */
@Transactional
@Service("portadaService")
public class PortadaServiceImpl extends AbstractService implements PortadaService {

    @Autowired
    private PortadaDao porDao;
    
    @Override
    public List<Portada> getEncuestasHabilitadas(String idUsuario) {
        return porDao.getEncuestasHabilitadas(idUsuario);
    }    
}