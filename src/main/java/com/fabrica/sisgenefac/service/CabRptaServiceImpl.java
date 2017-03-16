package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.CabRptaDao;
import com.fabrica.sisgenefac.dao.CuestionarioDao;
import com.fabrica.sisgenefac.dao.DetRptaDao;
import com.fabrica.sisgenefac.dao.DictadoDao;
import com.fabrica.sisgenefac.dao.EscalaLikertDao;
import com.fabrica.sisgenefac.dao.EstudianteDao;
import com.fabrica.sisgenefac.dao.ModalidadClaseDao;
import com.fabrica.sisgenefac.domain.CabRpta;
import com.fabrica.sisgenefac.domain.Cuestionario;
import com.fabrica.sisgenefac.domain.DetRpta;
import com.fabrica.sisgenefac.domain.Dictado;
import com.fabrica.sisgenefac.domain.EscalaLikert;
import com.fabrica.sisgenefac.domain.Estudiante;
import com.fabrica.sisgenefac.domain.ModalidadClase;
import com.fabrica.sisgenefac.transformers.DetRptaTransformer;
import com.fabrica.sisgenefac.transformers.Encuesta;
import com.fabrica.sisgenefac.transformers.Respuesta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.fabrica.sisgenefac.util.Constantes.RPTA_SI;

/**
 *
 * @author Ledis Rivera Changra
 * @date Jueves 09/03/2017 (18:15 p.m.)
 */
@Transactional
@Service("cabRptaService")
public class CabRptaServiceImpl extends AbstractService implements CabRptaService {
    
    @Autowired
    private CabRptaDao cabRptaDao;
    
    @Autowired
    private EstudianteDao estDao;
    
    @Autowired
    private DetRptaDao detRptaDao;
    
    @Autowired
    private DictadoDao dicDao;
    
    @Autowired
    private CuestionarioDao cueDao;
    
    @Autowired
    private ModalidadClaseDao modDao;
    
    @Autowired
    private EscalaLikertDao escLikDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public boolean guardarEncuesta(Encuesta encuesta, List<Respuesta> lstRptas) {
        boolean guardado = false;
        
        try {
            CabRpta cabRpta = asignarCabRpta(encuesta);
            cabRptaDao.persist(cabRpta);
            
            Dictado dictado = asignarDictado(encuesta);
            int idPortada = encuesta.getIdPortada();
            
//            int acumuladosSi = 0; // Rptas Si de preguntas por cada Sección
//            double acumuladoLikert = 0.00;
            
            Respuesta rpta = lstRptas.get(0);
            DetRpta detRpta = construirDetRptaInicial(cabRpta, dictado, idPortada, rpta);
            detRptaDao.persist(detRpta);
            
            for ( int i = 1; i < lstRptas.size(); i++ ) {
                rpta = lstRptas.get(i);
                detRpta = construirDetRpta(cabRpta, dictado, idPortada, rpta, detRpta);
                detRptaDao.persist(detRpta);
            }
            guardado = true;
            
        } catch ( Exception ex ) {
            System.out.println("Excepcion(CabRptaServiceImpl-guardarEncuesta):" + ex.getMessage());
            guardado = false;
        }
        return guardado;
    }
    
    private DetRpta construirDetRptaInicial(CabRpta cabRpta, Dictado dictado, int idPortada, Respuesta rpta) {
        
        int acumuladoSi = 0;
        double acumuladoLikert = 0.00;
        
        DetRpta detRptaIni = new DetRpta();
        detRptaIni.setDerId(1);
        detRptaIni.setCarId(cabRpta);
        detRptaIni.setDicId(dictado);
        
//        String numSecAntes = intToString(detRptaIni.getCueId().getPosId().getSecId().getSecNumero());
//        String numPreAntes = intToString(detRptaIni.getCueId().getPreId().getPreNumero());
//        int acumuladoSi = detRptaAntes.getDerAcumuladoSi();
//        double acumuladoLikert = detRptaAntes.getDerAcumuladoValor();
        String numSecIni = rpta.getNumSeccion();
        String numPreIni = rpta.getNumPregunta();
        int idPreguntaIni = stringToInt(rpta.getIdPregunta());
        String valorRptaIni = rpta.getRespuesta().toUpperCase();
        detRptaIni.setDerValorRpta(valorRptaIni);
        
        Cuestionario cuestionario = cueDao.buscarCuestionario(idPreguntaIni, idPortada);
        System.out.println("(CabRptaServiceImpl)cuestionario:" + cuestionario);
        detRptaIni.setCueId(cuestionario);
            
        if ( RPTA_SI.equals(valorRptaIni) ) {
            acumuladoSi++;
            acumuladoLikert += asignarValorLikert(idPortada, idPreguntaIni, acumuladoSi);
        }

        System.out.println(">> N° Seccion(1°):" + numSecIni); // AGREGADO AL JSON DE Jesús C.
        System.out.println(">> N° Pregunta(1°):" + numPreIni); // AGREGADO AL JSON DE Jesús C.
        System.out.println(">> idPregunta(1°):" + idPreguntaIni);
        System.out.println(">> valorRpta(1°):" + valorRptaIni);
        System.out.println(">> AcumuladoSi(1°):" + acumuladoSi);
        System.out.println("");

        detRptaIni.setDerAcumuladoSi(acumuladoSi);

        System.out.println("acumuladoLikert(FINAL):" + acumuladoLikert);
        detRptaIni.setDerAcumuladoValor(acumuladoLikert);
        
        return detRptaIni;
    }
    
//    private DetRptaTransformer construirDetRpta(CabRpta cabRpta, Dictado dictado, int idPortada, Respuesta rpta, DetRptaTransformer drt) {
    private DetRpta construirDetRpta(CabRpta cabRpta, Dictado dictado, int idPortada, Respuesta rpta, DetRpta detRptaAntes) {
        
        String numSecActual = rpta.getNumSeccion(); // AGREGADO AL JSON DE Jesús C.
        String numPreActual = rpta.getNumPregunta(); // AGREGADO AL JSON DE Jesús C.

        DetRpta detRptaActual = new DetRpta();
        detRptaActual.setDerId(1);
        detRptaActual.setCarId(cabRpta);
        detRptaActual.setDicId(dictado);

        int idPregunta = stringToInt(rpta.getIdPregunta());
        Cuestionario cuestionario = cueDao.buscarCuestionario(idPregunta, idPortada);
        System.out.println("(CabRptaServiceImpl)cuestionario:" + cuestionario);
        detRptaActual.setCueId(cuestionario);
        
        String valorRpta = rpta.getRespuesta().toUpperCase();
        detRptaActual.setDerValorRpta(valorRpta);
        
        /* Cada registro de respuesta ordenado en forma incremental por "der_id" (DET_RPTA) 
         se sumará como subtotal hasta el último registro de valorRpta */
//        String numSecAntes = drt.getNumSecAntes();
//        String numPreAntes = drt.getNumPreAntes();
//        int acumuladoSi = drt.getAcumuladosSi();
//        double acumuladoLikert = drt.getAcumuladoLikert();
        String numSecAntes = intToString(detRptaAntes.getCueId().getPosId().getSecId().getSecNumero());
        String numPreAntes = intToString(detRptaAntes.getCueId().getPreId().getPreNumero());
        int acumuladoSi = detRptaAntes.getDerAcumuladoSi();
        double acumuladoLikert = detRptaAntes.getDerAcumuladoValor();
        
        if ( numSecActual.equals(numSecAntes) ) {
            if ( RPTA_SI.equals(valorRpta) ) {
                acumuladoSi++;
                acumuladoLikert = asignarValorLikert(idPortada, idPregunta, acumuladoSi);
            }
        } else {
            if ( RPTA_SI.equals(valorRpta) ) {
                acumuladoSi = 1;
                acumuladoLikert = asignarValorLikert(idPortada, idPregunta, acumuladoSi);
                
            } else {
                acumuladoSi = 0;
                acumuladoLikert = 0.00;
            }
        }
//        numSecAntes = numSecActual;
//        numPreAntes = numPreActual;

        System.out.println(">> N° Seccion(actual):" + numSecActual); // AGREGADO AL JSON DE Jesús C.
        System.out.println(">> N° Pregunta(actual):" + numPreActual); // AGREGADO AL JSON DE Jesús C.
        System.out.println(">> idPregunta(actual):" + idPregunta);
        System.out.println(">> valorRpta(actual):" + valorRpta);
        System.out.println(">> AcumuladoSi:(actual)" + acumuladoSi);
        detRptaActual.setDerAcumuladoSi(acumuladoSi);

        System.out.println("acumuladoLikert(FINAL):" + acumuladoLikert);
        detRptaActual.setDerAcumuladoValor(acumuladoLikert);
        
        // Setear DetRptaTransformer (transporta datos anteriores y acumulados que se van actualizar para la próxima llamada al método)
//        drt.setDetRpta(detRpta);
//        drt.setNumSecAntes(numSecAntes);
//        drt.setNumPreAntes(numPreAntes);
//        
//        drt.setAcumuladosSi(acumuladoSi);
//        drt.setAcumuladoLikert(acumuladoLikert);
//        return drt;
        return detRptaActual;
    }
    
    private String intToString(int entero) {
        return String.valueOf(entero);
    }
    
    private CabRpta asignarCabRpta(Encuesta encuesta) {
        CabRpta cabRpta = new CabRpta();
        try {
            cabRpta.setCarId(1);

            int idUsuario = encuesta.getIdUsuario();
            Estudiante estudiante = estDao.buscarEncuestador(idUsuario);
            cabRpta.setEstId(estudiante);

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date hoy = new Date();
//            Date fecha = sdf.parse(desde);

            String dateInString = sdf.format(new Date());
            Date date = sdf.parse(dateInString);

            cabRpta.setCarFecha(date);
            cabRpta.setCarHora(date);
            
        } catch ( Exception ex ) {
            System.out.println("Exception:" + ex.getMessage());
        }
        return cabRpta;
    }
    
    private Dictado asignarDictado(Encuesta encuesta) {
        int idProfesor = encuesta.getIdProfesor();
        int idAsignatura = encuesta.getIdAsignatura();    
//        int idGrupo = encuesta.getIdGrupo();
        String tipoClase = encuesta.getTipoClase();
        
        ModalidadClase modClase = modDao.buscarModClase(tipoClase);
        int idModClase = modClase.getMocId();

        Dictado dictado = dicDao.buscarDictado(idProfesor, idAsignatura /*, idGrupo*/, idModClase);
        System.out.println("(CabRptaServiceImpl)dictado:" + dictado);
        return dictado;
    }
    
    private double asignarValorLikert(int idPortada, int idPregunta /*, int idSeccion*/, int cantidadRptasSi) {
        EscalaLikert escLik = escLikDao.buscarEscalaLikert(idPortada, idPregunta /*, idSeccion*/, cantidadRptasSi);
        System.out.println("(CabRptaServiceImpl)buscarLikert:" + escLik);
        return escLik.getEslValor();
    }
        
    private int stringToInt(String cadena) {
        return Integer.parseInt(cadena);
    }
    
    private int mapToInt(Map mapa, String etiqueta) {
        Object obj = mapa.get(etiqueta);
        return Integer.parseInt(String.valueOf(obj));
    }
    
    private String mapToString(Map mapa, String etiqueta) {
        Object obj = mapa.get(etiqueta);
        return String.valueOf(obj);
    }
}