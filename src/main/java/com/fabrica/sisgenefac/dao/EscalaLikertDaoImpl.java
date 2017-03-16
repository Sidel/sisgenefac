package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.EscalaLikert;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:38 p.m.)
 */
@Repository("escalaLikertDao")
@Transactional
public class EscalaLikertDaoImpl extends GenericDaoImpl<EscalaLikert, Integer> implements EscalaLikertDao {

    public EscalaLikertDaoImpl() {
        super(EscalaLikert.class);
    }
    
    @Override
    public EscalaLikert buscarEscalaLikert(int idPortada, int idPregunta, int cantidadRptasSi) {
        System.out.println("(LIKERT) idPortada:" + idPortada);
        System.out.println("(LIKERT) idPregunta:" + idPregunta);
        System.out.println("(LIKERT) cantidadRptasSi:" + cantidadRptasSi);
        
        String query = " select escLik "
                + " from EscalaLikert escLik "
                + " inner join escLik.posId pos "
                + " inner join pos.porId por "
                + " inner join pos.cuestionarioList cue "
                + " inner join cue.preId pre "
                
                + " where por.porId=:idPortada "
                + " and pre.preId=:idPregunta "
                + " and escLik.eslCantPregSi=:cantPregSi ";
        
        System.out.println("query(buscarLikert):" + query);
        List<EscalaLikert> lstEscalaLikert = em.createQuery(query)
                                           .setParameter("idPortada", idPortada)
                                           .setParameter("idPregunta", idPregunta)
                                           .setParameter("cantPregSi", cantidadRptasSi)
                                           .getResultList();
        
        return ( lstEscalaLikert.size() == 1 ) ? lstEscalaLikert.get(0) : null;
    }
}