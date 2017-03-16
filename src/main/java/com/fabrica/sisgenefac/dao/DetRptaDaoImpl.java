package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.DetRpta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:08 p.m.)
 */
@Repository("detRptaDao")
@Transactional
public class DetRptaDaoImpl extends GenericDaoImpl<DetRpta, Integer> implements DetRptaDao {
    
    public DetRptaDaoImpl() {
        super(DetRpta.class);
    }
}