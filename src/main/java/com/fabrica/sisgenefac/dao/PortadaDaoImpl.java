package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Portada;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Ledis Rivera Changra
 */
@Repository("portadaDao")
@Transactional
public class PortadaDaoImpl extends GenericDaoImpl<Portada, Integer> implements PortadaDao {
    
    public PortadaDaoImpl() {
        super(Portada.class);
    }
    
    @Override
    public List<Portada> getEncuestasHabilitadas(String idUsuario) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horaFecha = hourdateFormat.format(date);
        System.out.println("Hora y fecha: " + horaFecha);
        
        int idUsu = Integer.parseInt(idUsuario);
        String query = " select por "
                + " from Portada por "
                + " inner join por.accesoEncuestaList ace "
                + " inner join ace.usuId u "
                + " inner join u.usuarioRolList usuRol "
                + " inner join usuRol.rolId r "
                
                + " where CURRENT_DATE >= por.porFinicio AND CURRENT_DATE <= por.porFfin "
                
                + " and u.usuId =:idUsuario "
                + " and r.rolCodigo = 'EST' ";
        
        System.out.println("PortadaDaoImpl: " + query);

        List<Portada> lstPortada = em.createQuery(query)
                                     .setParameter("idUsuario", idUsu)
                                     .getResultList();
//        System.out.println("lstPortada:" + lstPortada);
//        if ( lstPortada != null ) {
//            System.out.println("Tamaño de lista portada::" + lstPortada.size());
//        }
        return lstPortada;
    }
}
