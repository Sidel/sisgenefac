package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Usuario;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, String> implements UsuarioDao {

    public UsuarioDaoImpl() {
        super(Usuario.class);
    }

    @Override
    public Object[] getUsuarioRol(String usuario, String clave) {
//    public UsuarioRol getUsuarioRol(String usuario, String clave) {
//        com.fabrica.sisgenefac.transformers.UsuarioRol usuRol = new com.fabrica.sisgenefac.transformers.UsuarioRol();
        
        String query = "SELECT "
                + " u.usu_id, "
                + " e.est_nombres, "
                + " e.est_appaterno, "
                + " e.est_apmaterno, "
                + " ea.esa_escuela, "
                + " catFac.cat_nombre AS 'Facultad', "
                + " r.rol_id, "
                + " r.rol_descripcion "

                + " FROM Usuario u "
                + " INNER JOIN Usuario_Rol usr ON usr.usu_id = u.usu_id "
                + " INNER JOIN Rol r ON r.rol_id = usr.rol_id "
                + " INNER JOIN Estudiante e ON e.est_id = usr.est_id "
                + " INNER JOIN Escuela_Academica ea ON ea.esa_id = e.esa_id "
                + " INNER JOIN Catalogo catFac ON catFac.cat_sub_grupo = ea.cat_facultad "
                + " INNER JOIN Catalogo catGru ON catGru.cat_sub_grupo = catFac.cat_grupo "
                + " WHERE r.rol_codigo = 'EST' "
                + " AND u.usu_usuario = '" + usuario + "' "
                + " AND u.usu_clave = '" + clave + "' "
                + " AND catGru.cat_nombre = 'FACULTAD_ESCUELA_ACADEMICA'";

        System.out.println("UsuarioDaoImpl: " + query);

        List<Object[]> lstUsuBD = em.createNativeQuery(query).getResultList();
        Iterator iteBD = lstUsuBD.iterator();
        Object[] obj = null;
                
        if ( iteBD.hasNext() ) {
            obj = (Object[]) iteBD.next();
            
//            usuRol.setIdUsuario(String.valueOf(obj[0]));
//            usuRol.setUsuario(String.valueOf(obj[1]));
//            usuRol.setNombre(String.valueOf(obj[2]));
//            usuRol.setApPaterno(String.valueOf(obj[3]));
//            usuRol.setApMaterno(String.valueOf(obj[4]));
//            usuRol.setEscuela(String.valueOf(obj[5]));
//            usuRol.setFacultad(String.valueOf(obj[6]));
//            
//            usuRol.setIdRol(String.valueOf(obj[7]));
//            usuRol.setDescripcionRol(String.valueOf(obj[8]));
        }
//        return usuRol;
        return obj;
    }
}