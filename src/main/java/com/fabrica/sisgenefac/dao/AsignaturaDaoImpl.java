package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Asignatura;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2016 (06:01 a.m.)
 */
@Repository("asignaturaDao")
@Transactional
public class AsignaturaDaoImpl extends GenericDaoImpl<Asignatura, Integer> implements AsignaturaDao {
    
    public AsignaturaDaoImpl() {
        super(Asignatura.class);
    }

    @Override
    public List<Object[]> getCursosMatriculados(String idUsuario) {
        int idUsu = Integer.parseInt(idUsuario);
        String query = "select "
//                distinct(pro.pro_id),
//                asi.asi_id,
                + " distinct(asi.asi_id), "
                + " asi.asi_codigo, "
                + " asi.asi_nombre, "
                
                + " pro.pro_id, "
                + " pro.pro_codigo, "
                + " pro.pro_nombres, "
                + " pro.pro_appaterno, "
                + " pro.pro_apmaterno, "

                + " gr.gru_codigo, "
                + " catCat.cat_nombre "

                + " from usuario u "
                + " inner join usuario_rol usr on usr.usu_id = u.usu_id "
                + " inner join estudiante es on es.est_id = usr.est_id "
                + " inner join cab_matricula cam on cam.est_id = es.est_id "
                + " inner join det_matricula dem on dem.cam_id = cam.cam_id "
                + " inner join grupo gr on gr.gru_id = dem.gru_id "
                + " inner join asignatura asi on asi.asi_id = gr.asi_id "
                
                + " inner join sesion_encuesta see on see.asi_id = asi.asi_id "
                + " inner join dictado di "
                    + " on di.gru_id = gr.gru_id "
                    + " and di.see_id = see.see_id "
    
                + " inner join catalogo catCat on catCat.cat_sub_grupo = di.cat_tipo_docente "
                + " inner join catalogo catGru on catGru.cat_sub_grupo = catCat.cat_grupo "
                + " inner join modalidad_clase moc on moc.moc_id = di.moc_id "
                + " inner join pro_sed_dep psd on psd.prosede_id = di.prosede_id "
                + " inner join profesor pro on pro.pro_id = psd.pro_id "
                
                + " where u.usu_id = " + idUsu
                + " and asi.asi_estado = 'A' "
                + " and catGru.cat_nombre = 'TIPO_DOCENTE_PRO_SED_DEP' "
                + " order by asi.asi_codigo asc, gr.gru_codigo asc, pro.pro_id ";
        
        System.out.println("(getCursosMatriculados)query:" + query);
        
        List<Object[]> lstCursos = em.createNativeQuery(query).getResultList();
        return lstCursos;
    }
}