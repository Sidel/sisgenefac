package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Estudiante;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (18:37 p.m.)
 */
@Repository("estudianteDao")
@Transactional
public class EstudianteDaoImpl extends GenericDaoImpl<Estudiante, Integer> implements EstudianteDao {

    public EstudianteDaoImpl() {
        super(Estudiante.class);
    }
    
    @Override
    public Estudiante buscarEncuestador(int idUsuario) {
        String query = "select est "
                + " from Estudiante est "
                + " inner join est.usuarioRolList usr "
                + " inner join usr.rolId rol "
                + " inner join usr.usuId usu "
                + " where usu.usuId = :idUsuario "
                + " and rol.rolCodigo = 'EST' ";
        
        System.out.println("query(buscarEncuestador):" + query);
        List<Estudiante> lstEstudiante = em.createQuery(query)
                                           .setParameter("idUsuario", idUsuario)
                                           .getResultList();
        
        return ( lstEstudiante.size() == 1 ) ? lstEstudiante.get(0) : null;
    }
}