package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Profesor;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:51 a.m.)
 */
@Repository("profesorDao")
@Transactional
public class ProfesorDaoImpl extends GenericDaoImpl<Profesor, Integer> implements ProfesorDao {
    
    public ProfesorDaoImpl() {
        super(Profesor.class);
    }

    @Override
    public String getResponsableAsignatura(String codigoAsignatura) {
        String nombreProfesor = "ERRORBD";
        String query = "SELECT "
                + " distinct(concat(p.pro_nombres, ' ', p.pro_appaterno, ' ', p.pro_apmaterno)) "
                + " FROM Dictado di "
                + " INNER JOIN Grupo gr ON gr.gru_id = di.gru_id "
                + " INNER JOIN Asignatura asi ON asi.asi_id = gr.asi_id "
                + " INNER JOIN Pro_Sed_Dep psd ON psd.prosede_id = di.prosede_id "
                + " INNER JOIN Profesor p ON p.pro_id = psd.pro_id "
                + " INNER JOIN Catalogo catCat ON catCat.cat_sub_grupo = di.cat_tipo_docente "
                + " INNER JOIN Catalogo catGru ON catGru.cat_sub_grupo = catCat.cat_grupo "

                + " WHERE asi.asi_codigo = '" + codigoAsignatura + "' "
                + " AND catGru.cat_nombre = 'TIPO_DOCENTE_PRO_SED_DEP' ";
        
        List<String> profesor = em.createNativeQuery(query).getResultList();
        
        if ( profesor.size() == 1 ) {
            nombreProfesor = profesor.get(0);   
        }
        return nombreProfesor;
    }
}