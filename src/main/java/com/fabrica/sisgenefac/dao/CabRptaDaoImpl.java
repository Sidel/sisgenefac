package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.CabRpta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (18:18 p.m.)
 */
@Repository("cabRptaDao")
@Transactional
public class CabRptaDaoImpl extends GenericDaoImpl<CabRpta, Integer> implements CabRptaDao {
    
    public CabRptaDaoImpl() {
        super(CabRpta.class);
    }
}