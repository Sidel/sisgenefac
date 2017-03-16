package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.CuestionarioDao;
import com.fabrica.sisgenefac.domain.Cuestionario;
import com.fabrica.sisgenefac.transformers.PreguntaCuestionario;
import com.fabrica.sisgenefac.transformers.SeccionCuestionario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (13:34 p.m.)
 */
@Transactional
@Service("cuestionarioService")
public class CuestionarioServiceImpl extends AbstractService implements CuestionarioService {
    
    @Autowired
    private CuestionarioDao cuesDao;
    
    @Override
    public List<SeccionCuestionario> getPreguntasCuestionario(String idPortada) {
        
        List<Object[]> lstObj = cuesDao.getPreguntasCuestionario(idPortada);
        
        List<SeccionCuestionario> lstSecCue = new ArrayList<SeccionCuestionario>();
        List<PreguntaCuestionario> lstPregCue = null;
            
//        int contSeccion = 1;
//        int contPregunta = 1;
        
        if ( lstObj != null ) {
            // 1° Elemento del listado de Preguntas del Cuestionario.
            Object[] arrayObj = lstObj.get(0);
            
            SeccionCuestionario sec = getNuevaSeccion(arrayObj);
//            mostrarSeccion(sec, contSeccion);
            
            String anteriorIdSeccion = String.valueOf(arrayObj[0]);
//            System.out.println("anteriorIdSeccion:" + anteriorIdSeccion);
            
            PreguntaCuestionario pre = getNuevaPregunta(arrayObj);
//            mostrarPregunta(pre, contPregunta);
            
            lstPregCue = new ArrayList<PreguntaCuestionario>();
            lstPregCue.add(pre);
            
            if ( lstObj.size() == 1 ) {
                sec.setLstPregCue(lstPregCue);
                lstSecCue.add(sec);
                
            } else {
                for ( int i = 1; i < lstObj.size(); i++ ) {
                    arrayObj = lstObj.get(i);
                    String actualIdSeccion = String.valueOf(arrayObj[0]);

                    // Cada elemento de la lista de Array de Objects se debe agregar como "Seccion" 
                    pre = getNuevaPregunta(arrayObj);
//                    contPregunta++;
//                    mostrarPregunta(pre, contPregunta);

//                    System.out.println("(*)anteriorIdSeccion:" + anteriorIdSeccion);
//                    System.out.println("(*)actualIdSeccion:" + actualIdSeccion);

                    // Si son IDs de seciones DIFERENTES, crear NUEVA Seccion
                    if ( !anteriorIdSeccion.equals(actualIdSeccion) ) {
//                        System.out.println("1.DIFERENTES.....");
                        // Agregar lista de "Preguntas" la pregunta anterior a "Seccion" y 
                        sec.setLstPregCue(lstPregCue);
                        
                        // Agregar a lista de "Secciones" la seccion anterior
                        lstSecCue.add(sec);
//                        contSeccion++;
//                        mostrarSeccion(sec, contSeccion);

                        // Crea nueva "Seccion"
                        sec = getNuevaSeccion(arrayObj);

                        // Crear nueva "lista de Preguntas"
                        lstPregCue = new ArrayList<PreguntaCuestionario>();

                    }
                    lstPregCue.add(pre);
                    anteriorIdSeccion = actualIdSeccion;
                }
                sec.setLstPregCue(lstPregCue);
                lstSecCue.add(sec);
//                contSeccion++;
//                mostrarSeccion(sec, contSeccion);
//                System.out.println("N° lista Secciones:" + lstSecCue.size());
            }
        }
        return lstSecCue;
    }
    
    private void mostrarSeccion(SeccionCuestionario sec, int cont) {
        System.out.println("-------------- NUEVA SECCION " + cont + "---------------");
        System.out.println("idSeccion:" + sec.getIdSeccion());
        System.out.println("descripcion:" + sec.getDescripcion());
    }
    
    private void mostrarPregunta(PreguntaCuestionario pre, int cont) {
        System.out.println("-------------- NUEVA PREGUNTA " + cont + "-----------------------");
        System.out.println("idPregunta:" + pre.getIdPregunta());
        System.out.println("enunciado:" + pre.getDescripcion());
    }
    
    private SeccionCuestionario getNuevaSeccion(Object[] obj) {
        SeccionCuestionario sec = new SeccionCuestionario();
        sec.setIdSeccion(aString(obj[0]));
        sec.setDescripcion(aString(obj[1]));
        return sec;
    }
    
    private PreguntaCuestionario getNuevaPregunta(Object[] obj) {
        PreguntaCuestionario pre = new PreguntaCuestionario();
        pre.setIdPregunta(aString(obj[2]));
        pre.setDescripcion(aString(obj[3]));
        return pre;
    }
    
    private String aString(Object obj) {
        return String.valueOf(obj);
    }

    @Override
    public Cuestionario buscarCuestionario(int idPregunta, int idPortada) {
        return cuesDao.buscarCuestionario(idPregunta, idPortada);
    }
}
