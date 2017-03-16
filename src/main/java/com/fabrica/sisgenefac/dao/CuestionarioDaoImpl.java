package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Cuestionario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/13/2017 (13:28 p.m.)
 */
@Repository("cuestionarioDao")
@Transactional
public class CuestionarioDaoImpl extends GenericDaoImpl<Cuestionario, Integer> implements CuestionarioDao {
    
    public CuestionarioDaoImpl() {
        super(Cuestionario.class);
    }

    @Override
    public List<Object[]> getPreguntasCuestionario(String idPortada) {
        int idPort = Integer.parseInt(idPortada);
        String query = "SELECT "
                + " sec.sec_id, "
                + " sec.sec_nombre, "
                
                + " pre.pre_id, "
                + " pre.pre_enunciado "

                + " FROM Portada por "
                + " INNER JOIN Portada_Seccion pos ON pos.por_id = por.por_id "
                + " INNER JOIN Cuestionario cue ON cue.pos_id = pos.pos_id "
                + " INNER JOIN Seccion sec ON sec.sec_id = pos.sec_id "
                + " INNER JOIN Pregunta pre ON pre.pre_id = cue.pre_id "
                + " WHERE por.por_id = " + idPort;
        
        List<Object[]> lstPreguntas = em.createNativeQuery(query).getResultList();
        return lstPreguntas;
    }

    @Override
    public Cuestionario buscarCuestionario(int idPregunta, int idPortada) {
        String query = "select cue "
                + " from Cuestionario cue "
                + " inner join cue.posId pos "
                + " inner join pos.porId por "
                + " inner join cue.preId pre"
                
                + " where pre.preId=:idPregunta "
                + " and por.porId=:idPortada ";
        
        System.out.println("query(buscarCuestionario):" + query);
        List<Cuestionario> lstCuestionario = em.createQuery(query)
                                               .setParameter("idPregunta", idPregunta)
                                               .setParameter("idPortada", idPortada)
                                               .getResultList();
        
        return ( lstCuestionario.size() == 1 ) ? lstCuestionario.get(0) : null;
    }
}