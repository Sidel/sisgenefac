package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.ProfesorDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:54 a.m.)
 */

@Transactional
@Service("profesorService")
public class ProfesorServiceImpl extends AbstractService implements ProfesorService {
    
    @Autowired
    private ProfesorDao profDao;
    
    @Override
    public String getResponsableAsignatura(String codigoAsignatura) {
        return profDao.getResponsableAsignatura(codigoAsignatura);
    }
}