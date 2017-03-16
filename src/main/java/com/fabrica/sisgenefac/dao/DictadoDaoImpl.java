package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Dictado;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (20:16 p.m.)
 */
@Repository("dictadoDao")
@Transactional
public class DictadoDaoImpl extends GenericDaoImpl<Dictado, Integer> implements DictadoDao {
    
    public DictadoDaoImpl() {
        super(Dictado.class);
    }

    @Override
    public Dictado buscarDictado(int idProfesor, int idAsignatura, /*int idGrupo,*/ int idModClase) {
        int numeroGrupo = 1; // Por ahora todos los N° de grupos de Asignaturas son 1
        System.out.println("idProfesor:" + idProfesor);
        System.out.println("idAsignatura:" + idAsignatura);
        System.out.println("numeroGrupo:" + numeroGrupo);
        System.out.println("idModClase:" + idModClase);
        
        String query = "select dic "
                + " from Dictado dic "
                + " inner join dic.prosedeId psd "
                + " inner join psd.proId pro "
                + " inner join dic.gruId gru "
                + " inner join gru.asiId asi "
                + " inner join dic.mocId moc "
                
                + " where pro.proId=:idProfesor "
                + " and asi.asiId=:idAsignatura "
                + " and gru.gruNumero=:numeroGrupo "
                + " and moc.mocId=:idModClase "
                + " order by dic.dicId asc ";
        
        System.out.println("query(buscarDictado):" + query);
        List<Dictado> lstDictado = em.createQuery(query)
                                           .setParameter("idProfesor", idProfesor)
                                           .setParameter("idAsignatura", idAsignatura)
                                           .setParameter("numeroGrupo", numeroGrupo)
                                           .setParameter("idModClase", idModClase)
                                           .getResultList();
        
        return ( lstDictado.size() == 1 ) ? lstDictado.get(0) : null;
    }
}