package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.AsignaturaDao;
import com.fabrica.sisgenefac.dao.ProfesorDao;
import com.fabrica.sisgenefac.transformers.CursoMatricula;
import com.fabrica.sisgenefac.transformers.ProfesorMatricula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (06:07 a.m.)
 */
@Transactional
@Service("asignaturaService")
public class AsignaturaServiceImpl extends AbstractService implements AsignaturaService {

    @Autowired
    private AsignaturaDao asigDao;
    
    @Autowired
    private ProfesorDao profDao;
    
    @Override
    public List<CursoMatricula> getCursosMatriculados(String idUsuario) {
        
        List<Object[]> lstObj = asigDao.getCursosMatriculados(idUsuario);
        System.out.println("lstObj:" + lstObj);
        if ( lstObj != null ) {
            System.out.println("lstObj:" + lstObj.size());
        }
        
        List<CursoMatricula> lstCurMat = new ArrayList<CursoMatricula>();
        List<ProfesorMatricula> lstProMat = null;
//        int contCurso = 1;
//        int contProfesor = 1;
        
        if ( lstObj != null ) {
            // 1° Elemento del listado de Cursos Matriculados.
            Object[] arrayObj = lstObj.get(0);
            
            CursoMatricula cur = getNuevoCurso(arrayObj);
//            mostrarCurso(cur, contCurso);
            
            String anteriorCodCurso = String.valueOf(arrayObj[1]);
//            System.out.println("anteriorCodCurso:" + anteriorCodCurso);
            
            ProfesorMatricula pro = getNuevoProfesor(arrayObj);
//            mostrarProfesor(pro, contProfesor);
            
            lstProMat = new ArrayList<ProfesorMatricula>();
            lstProMat.add(pro);
            
            if ( lstObj.size() == 1 ) {
                cur.setLstProfesores(lstProMat);
                lstCurMat.add(cur);
                
            } else {
                for ( int i = 1; i < lstObj.size(); i++ ) {
                    arrayObj = lstObj.get(i);
                    String actualCodCurso = String.valueOf(arrayObj[1]);

                    // Cada elemento de la lista de Array de Objects se debe agregar como "ProfesorMatricula" 
                    pro = getNuevoProfesor(arrayObj);
//                    contProfesor++;
//                    mostrarProfesor(pro, contProfesor);

//                    System.out.println("(*)anteriorCodCurso:" + anteriorCodCurso);
//                    System.out.println("(*)actualCodCurso:" + actualCodCurso);

                    // Si son código de cursos DIFERENTES, crear NUEVO Curso
                    if ( !anteriorCodCurso.equals(actualCodCurso) ) {
//                        System.out.println("1.DIFERENTES.....");
                        // Agregar lista de "ProfesorMatricula" el profesor anterior a "CursoMatricula" y 
                        cur.setLstProfesores(lstProMat);
                        
                        // Agregar a lista de "CursoMatricula" el curso anterior
                        lstCurMat.add(cur);
//                        contCurso++;
//                        mostrarCurso(cur, contCurso);

                        // Crea nuevo "CursoMatricula"
                        cur = getNuevoCurso(arrayObj);

                        // Crear nueva "lista de ProfesorMatricula"
                        lstProMat = new ArrayList<ProfesorMatricula>();

                    }
                    lstProMat.add(pro);
                    anteriorCodCurso = actualCodCurso;
//                    contProfesor++;
//                    mostrarProfesor(pro, contProfesor);
                }
                cur.setLstProfesores(lstProMat);
                lstCurMat.add(cur);
//                contCurso++;
//                mostrarCurso(cur, contCurso);
                System.out.println("N° lista Curso Matricula:" + lstCurMat.size());
            }
        }
        return lstCurMat;
    }
    
    private void mostrarProfesor(ProfesorMatricula prof, int cont) {
        System.out.println("-------------- NUEVO PROFESOR " + cont + "-----------------------");
        System.out.println("idProf:" + prof.getId());
        System.out.println("codigo:" + prof.getCodigo());
        System.out.println("nombre:" + prof.getNombre());
        System.out.println("apPaterno:" + prof.getApellidoPaterno());
        System.out.println("apMaterno:" + prof.getApellidoMaterno());
        System.out.println("grupo:" + prof.getGrupo());
        System.out.println("tipo:" + prof.getTipo());
    }
    
    private void mostrarCurso(CursoMatricula curso, int cont) {
        System.out.println("-------------- NUEVO CURSO " + cont + "---------------");
        System.out.println("idCurso:" + curso.getIdCurso());
        System.out.println("codigo:" + curso.getCodigo());
        System.out.println("descripcion:" + curso.getDescripcion());
    }
    
    private CursoMatricula getNuevoCurso(Object[] obj) {
        CursoMatricula cur = new CursoMatricula();
        cur.setIdCurso(aString(obj[0]));
        
        String codigoCurso = aString(obj[1]);
        cur.setCodigo(codigoCurso);
        
        cur.setDescripcion(aString(obj[2]));
        
        String nombreResponsable = profDao.getResponsableAsignatura(codigoCurso);
        cur.setNombreResponsable(nombreResponsable);
        return cur;
    }
    
    private ProfesorMatricula getNuevoProfesor(Object[] obj) {
        ProfesorMatricula pro = new ProfesorMatricula();
        pro.setId(aString(obj[3]));
        pro.setCodigo(aString(obj[4]));
        pro.setNombre(aString(obj[5]));
        pro.setApellidoPaterno(aString(obj[6]));
        pro.setApellidoMaterno(aString(obj[7]));
        pro.setGrupo(aString(obj[8]));
        pro.setTipo(aString(obj[9]));
        return pro;
    }
    
    private String aString(Object obj) {
        return String.valueOf(obj);
    }
}