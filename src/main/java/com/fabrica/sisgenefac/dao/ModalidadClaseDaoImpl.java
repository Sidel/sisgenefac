package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.ModalidadClase;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:23 p.m.)
 */
@Repository("modalidadClaseDao")
@Transactional
public class ModalidadClaseDaoImpl extends GenericDaoImpl<ModalidadClase, Integer> implements ModalidadClaseDao {
    
    public ModalidadClaseDaoImpl() {
        super(ModalidadClase.class);
    }

    @Override
    public ModalidadClase buscarModClase(String tipoClase) {
        
        List<ModalidadClase> lstModClase = em.createNamedQuery("ModalidadClase.findByMocTipo")
                                             .setParameter("mocTipo", tipoClase)
                                             .getResultList();
        
        return ( lstModClase.size() == 1 ? lstModClase.get(0) : null);
    }
}