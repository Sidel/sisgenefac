package com.fabrica.sisgenefac.web;

import com.fabrica.sisgenefac.domain.Cuestionario;
import com.fabrica.sisgenefac.domain.Portada;
import com.fabrica.sisgenefac.service.AsignaturaService;
import com.fabrica.sisgenefac.service.CabRptaService;
import com.fabrica.sisgenefac.service.CuestionarioService;
import com.fabrica.sisgenefac.service.PortadaService;
import com.fabrica.sisgenefac.service.ProfesorService;
import com.fabrica.sisgenefac.service.UsuarioService;
import com.fabrica.sisgenefac.transformers.CursoMatricula;
import com.fabrica.sisgenefac.transformers.Encuesta;
import com.fabrica.sisgenefac.transformers.PreguntaCuestionario;
import com.fabrica.sisgenefac.transformers.ProfesorMatricula;
import com.fabrica.sisgenefac.transformers.Respuesta;
import com.fabrica.sisgenefac.transformers.SeccionCuestionario;
import javax.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import com.fabrica.sisgenefac.vo.Result;
import static com.fabrica.sisgenefac.web.SecurityHelper.SESSION_ATTRIB_USER;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Ledis Rivera Changra
 */

@Controller
@RequestMapping("/auth")
public class SeguridadHandler extends AbstractHandler {

    @Autowired
    protected UsuarioService usuServ;
    
    @Autowired
    protected PortadaService porServ;
    
    @Autowired
    protected AsignaturaService asigServ;
    
    @Autowired
    protected ProfesorService profServ;
    
    @Autowired
    protected CuestionarioService cuesServ;
    
    @Autowired
    protected CabRptaService cabRptaServ;
    
//    @Autowired
//    protected PreguntaService 
    
// 1° Handler : Verificar acceso del Encuestador(Estudiante) por Login
/*
Method: POST
URL: http://localhost:8080/sisgenefac/rest/auth/verificarAcceso
Body: (raw)
{
    "usuario" : "701884",
    "clave" : "EET701884"
}
*/
/*
{
    "usuario" : {
            "idUsuario" : "<idUsuario>",
            "usuario" : "<usuario>",
            "nombre" : "nombre",
            "apellidoPaterno" : "<apellidoPaterno>",
            "apellidoMaterno" : "<apellidoMaterno>",
            "escuela" : "<escuela>",
            "facultad" : "<facultad>"
    },
    "rol" : {
            "idRol" : "<idRol>",
            "descripcion" : "<descripcion>"
    }
}
Resultado:
{
  "usuario": {
    "idUsuario": "1",
    "usuario": "701884",
    "nombre": "TRINIDAD",
    "apellidoPaterno": "ESPIRITU",
    "apellidoMaterno": "ESPINOZA",
    "escuela": "MEDICINA HUMANA",
    "facultad": "MEDICINA"
  },
  "rol": {
    "idRol": "4",
    "descripcion": "ESTUDIANTE"
  }
}    
*/
    @RequestMapping(value = "/verificarAcceso", 
                    method = RequestMethod.POST,
                    produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String login( @RequestBody String jsonData, HttpServletRequest request ) {
        System.out.println("1.jsonData(verificarAcceso):" + jsonData);
        JsonObject jsonObjeto = parseJsonObject(jsonData);
        
        String jsoUsuario = jsonObjeto.getString("usuario");
        String jsoClave = jsonObjeto.getString("clave");
        
        Result<Object[]> rsUsuRol = usuServ.getUsuarioRol(jsoUsuario, jsoClave);
//        Criptografo crp = new Criptografo();
        Object[] tfrUsuRol = rsUsuRol.getData();
//        String desencriptada = crp.desencripta(tblUser.getUsuClave());
        JsonObjectBuilder constructor = Json.createObjectBuilder();
        
        if ( rsUsuRol.isSuccess()
//           && desencriptada.equals(jsoClave) 
           ) {
            String idUsuario = String.valueOf(tfrUsuRol[0]);
            String nombre = String.valueOf(tfrUsuRol[1]);
            String apPaterno = String.valueOf(tfrUsuRol[2]);
            String apMaterno = String.valueOf(tfrUsuRol[3]);
            String escuela = String.valueOf(tfrUsuRol[4]);
            String facultad = String.valueOf(tfrUsuRol[5]);
            
            String idRol = String.valueOf(tfrUsuRol[6]);
            String descripcionRol = String.valueOf(tfrUsuRol[7]);
            constructor.add("codigoRespuesta", "00");
            constructor.add("mensaje", "OK");
            
            constructor.add("usuario", Json.createObjectBuilder()
                       .add("idUsuario", idUsuario)
                       .add("usuario", jsoUsuario)
                       .add("nombre", nombre)
                       .add("apellidoPaterno", apPaterno)
                       .add("apellidoMaterno", apMaterno)
                       .add("escuela", escuela)
                       .add("facultad", facultad)
            );
            constructor.add("rol", Json.createObjectBuilder()
                       .add("idRol", idRol)
                       .add("descripcion", descripcionRol)
            );
            
//            HttpSession session = request.getSession(true);
//            session.setAttribute(SESSION_ATTRIB_USER, userPersonJson);
            return toJsonString(constructor.build());
            
        } else {
            constructor.add("codigoRespuesta", "01");
            constructor.add("mensaje", "Usuario y/o Contraseña incorrecta");
//            return getJsonErrorMsg("");
            return toJsonString(constructor.build());
        }
    }

// 2° Handler : Obtener las Encuestas Habilitadas para el usuario Encuestador(Estudiante).
/*
Method: POST
URL: http://localhost:8080/sisgenefac/rest/auth/obtenerEncuestas
Body (raw):
{
   "idUsuario" : "1"
}
*/
/*
Formato de cadena Json:
{
    "usuario" : {
            "idUsuario" : "<idUsuario>",
            "usuario" : "<usuario>",
            "nombre" : "nombre",
            "apellidoPaterno" : "<apellidoPaterno>",
            "apellidoMaterno" : "<apellidoMaterno>",
            "escuela" : "<escuela>",
            "facultad" : "<facultad>"
    },
    "rol" : {
            "idRol" : "<idRol>",
            "descripcion" : "<descripcion>"
    }
}
*/
/*
Resultado:
{
  "listaEncuestas": [
    {
      "idEncuesta": "1",
      "descripcion": "EVALUACIÓN ESTUDIANTIL DEL DESEMPEÑO DOCENTE"
    }
  ]
}
*/
    @RequestMapping(value = "/obtenerEncuestas", 
                    method = RequestMethod.POST,
                    produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String obtenerEncuestas ( @RequestBody String jsonData, HttpServletRequest request ) {
        
        System.out.println("2.jsonData(obtenerEncuestas):" + jsonData);
        JsonObject jsonObjeto = parseJsonObject(jsonData);
        String jsoIdUsuario = jsonObjeto.getString("idUsuario");
        System.out.println("2.jsoIdUsuario(obtenerEncuestas):" + jsoIdUsuario);
        List<Portada> lstPortada = porServ.getEncuestasHabilitadas(jsoIdUsuario);
        JsonObjectBuilder constructor = Json.createObjectBuilder();

        if ( lstPortada != null ) {
            JsonArrayBuilder lstEncuestas = Json.createArrayBuilder();
//            constructor.add("success", true);
            Iterator ite = lstPortada.iterator();
            
            while ( ite.hasNext() ) {
                Portada p = (Portada) ite.next();
                String idEncuesta = String.valueOf(p.getPorId());
                String descripcion = p.getPorNombre();
                
                lstEncuestas.add(Json.createObjectBuilder()
                            .add("idEncuesta", idEncuesta)
                            .add("descripcion", descripcion)
                );
            }
            
            constructor.add("codigoRespuesta", "00");
            constructor.add("mensaje", "OK");
            
            constructor.add("listaEncuestas", lstEncuestas);
//            HttpSession session = request.getSession(true);
//            session.setAttribute(SESSION_ATTRIB_USER, userPersonJson);
            return toJsonString(constructor.build());
            
        } else {
            
            constructor.add("codigoRespuesta", "01");
            constructor.add("mensaje", "El usuario no tiene encuestas habilitadas.");
//            return getJsonErrorMsg("El usuario no tiene encuestas habilitadas.");
            return toJsonString(constructor.build());
        }
    }
    
// 3° Handler : Obtener los Cursos Maatriculados del usuario Encuestador(Estudiante).
/*
Method: POST
URL: http://localhost:8080/sisgenefac/rest/auth/obtenerCursos
Body(raw):
{
   "idUsuario" : "1"
}
*/
/*
Formato de cadena Json:
{
    "listaCursos" : 
    [
        {
            "idCurso" : "<idCurso>",
            "codigo" : "<codigo >",
            "descripcion" : "<descripcion>",
            "nombreResponsable" : "<nombreResponsable>",
            "listaProfesores" : 
            [
                {
                    "id" : "<id>",
                    "codigo" : "<codigo>",
                    "nombre" : "<nombre>",
                    "apellidoPaterno" : "<apellidoPaterno>",
                    "apellidoMaterno" : "apellidoMaterno",
                    "grupo" : "<grupo>",
                    "tipo" : "<tipo>"
                }
            ]
        }
    ]
 }
*/
/*
Resultado:
{
  "listaCursos": [
    {
      "idCurso": "54",
      "codigo": "M15004M",
      "descripcion": "METODOLOGIA DEL TRABAJO UNIVERSITARIO Y BUSQUEDA INFORMATIZADA",
      "nombreResponsable": "HALLDER MORI RAMIREZ",
      "listaProfesores": [
        {
          "id": "2",
          "codigo": "046477",
          "nombre": "HALLDER",
          "apellidoPaterno": "MORI",
          "apellidoMaterno": "RAMIREZ",
          "grupo": "1",
          "tipo": "RESPONSABLE"
        }
      ]
    },
    {
      "idCurso": "61",
      "codigo": "M15011M",
      "descripcion": "ATENCION DE LA SALUD NIVEL I Y II  (I)",
      "nombreResponsable": "GUSTAVO NESTOR FRANCO PAREDES",
      "listaProfesores": [
        {
          "id": "7",
          "codigo": "092657",
          "nombre": "GUSTAVO NESTOR",
          "apellidoPaterno": "FRANCO",
          "apellidoMaterno": "PAREDES",
          "grupo": "1",
          "tipo": "RESPONSABLE"
        }
      ]
    },
    {
      "idCurso": "48",
      "codigo": "MH0E05",
      "descripcion": "INGLES II",
      "nombreResponsable": "DANIEL ANGEL ANGULO POBLETE",
      "listaProfesores": [
        {
          "id": "9",
          "codigo": "0A1462",
          "nombre": "DANIEL ANGEL",
          "apellidoPaterno": "ANGULO",
          "apellidoMaterno": "POBLETE",
          "grupo": "1",
          "tipo": "RESPONSABLE"
        }
      ]
    }
  ]
}
*/
    @RequestMapping(value = "/obtenerCursos",
                    method = RequestMethod.POST,
                    produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String obtenerCursos ( @RequestBody String jsonData, HttpServletRequest request ) {
        System.out.println("3.jsonData(obtenerCursos):" + jsonData);
        JsonObject jsonObjeto = parseJsonObject(jsonData);
        String jsoIdUsuario = jsonObjeto.getString("idUsuario");
        List<CursoMatricula> lstCurMat = asigServ.getCursosMatriculados(jsoIdUsuario);
        System.out.println("lstCurMat::" + lstCurMat);
        if ( lstCurMat != null ) {
            System.out.println("N° de cursos:" + lstCurMat.size());
        }

        JsonObjectBuilder constructor = Json.createObjectBuilder();
        
        if ( lstCurMat != null ) {
            System.out.println("N° de cursos matriculados:" + lstCurMat.size());
//            mostrarListaCursos_Profesores(lstCurMat);
            
            JsonArrayBuilder lstCursos = Json.createArrayBuilder();
//            constructor.add("success", true);
            Iterator iteCur = lstCurMat.iterator();
            
            while ( iteCur.hasNext() ) {
                CursoMatricula curMat = (CursoMatricula) iteCur.next();
                String idCurso = curMat.getIdCurso();
                String codCurso = curMat.getCodigo();
                String descCurso = curMat.getDescripcion();
                
                String nombreResponsableCurso = profServ.getResponsableAsignatura(codCurso);
                
                    JsonArrayBuilder lstProfesores = Json.createArrayBuilder();
                    List<ProfesorMatricula> lstProf = curMat.getLstProfesores();
                    Iterator itePro = lstProf.iterator();
                    
                    while ( itePro.hasNext() ) {
                        ProfesorMatricula profMat = (ProfesorMatricula) itePro.next();
                        String idProfe = profMat.getId();
                        String codigoProfe = profMat.getCodigo();
                        String nombreProfe = profMat.getNombre();
                        String apPatProfe = profMat.getApellidoPaterno();
                        String apMatProfe = profMat.getApellidoMaterno();
                        String grupo = profMat.getGrupo();
                        String tipo = profMat.getTipo();

                        lstProfesores.add(Json.createObjectBuilder()
                                .add("id", idProfe)
                                .add("codigo", codigoProfe)
                                .add("nombre", nombreProfe)
                                .add("apellidoPaterno", apPatProfe)
                                .add("apellidoMaterno", apMatProfe)
                                .add("grupo", grupo)
                                .add("tipo", tipo)
                        );
                    }
                    
//                lstCursos.add(Json.createObjectBuilder()
//                        .add("listaProfesores", lstProfesores)
//                );
                lstCursos.add(Json.createObjectBuilder()
                         .add("idCurso", idCurso)
                         .add("codigo", codCurso)
                         .add("descripcion", descCurso)
                         .add("nombreResponsable", nombreResponsableCurso)
                         .add("listaProfesores", lstProfesores)
                );
            }
            constructor.add("codigoRespuesta", "00");
            constructor.add("mensaje", "OK");
            
//            constructor.add("listaCursos", lstCursos);
            constructor.add("listaCursosMatriculados", lstCursos);
            
//            HttpSession session = request.getSession(true);
//            session.setAttribute(SESSION_ATTRIB_USER, userPersonJson);
            return toJsonString(constructor.build());
            
        } else {
            constructor.add("codigoRespuesta", "01");
            constructor.add("mensaje", "El usuario no se ha matriculado en ningún curso.");
//            return getJsonErrorMsg("El usuario no se ha matriculado en ningún curso.");
            return toJsonString(constructor.build());
        }
    }
    
    private void mostrarListaCursos_Profesores(List<CursoMatricula> lstCurMat) {
        int contCurso = 1;
        
        for ( CursoMatricula cm : lstCurMat ) {
            String idCurso = cm.getIdCurso();
            String codigo = cm.getCodigo();
            String descripcion = cm.getDescripcion();
            String nombreResponsable = cm.getNombreResponsable();
            
            System.out.println("---------- CURSO " + contCurso + ": -----------");
            System.out.println("IdCurso:" + idCurso);
            System.out.println("Codigo:" + codigo);
            System.out.println("Descripcion:" + descripcion);
            System.out.println("NombreResponsable:" + nombreResponsable);
            contCurso++;
            
            List<ProfesorMatricula> lstPm = new ArrayList<ProfesorMatricula>();
            lstPm = cm.getLstProfesores();
            
            int contProfesor = 1;
            
            if ( lstPm != null ) {
                for ( ProfesorMatricula pm : lstPm ) {
                    System.out.println("---------- PROFESOR (" + contProfesor + ") ----------");
                    System.out.println("\tId:" + pm.getId());
                    System.out.println("\tCodigo:" + pm.getCodigo());
                    System.out.println("\tNombre:" + pm.getNombre());
                    System.out.println("\tApePat:" + pm.getApellidoPaterno());
                    System.out.println("\tApeMat:" + pm.getApellidoMaterno());
                    System.out.println("\tGrupo:" + pm.getGrupo());
                    System.out.println("\tTipo:" + pm.getTipo());
                    contProfesor++;
                }
            }
        }
    }
    
// 4° Handler : Obtener el Cuestionario.
/*
Method: POST
URL: http://localhost:8080/sisgenefac/rest/auth/obtenerCuestionario
Body (raw):
{
   "idEncuesta" : "1"
}
*/
/*
Formato de Cadena Json:
{
    "listaSecciones" : 
    [
        {
            "idSeccion" : "<idSeccion>",
            "descripcion" : "<descripcion>",
            "listaPreguntas" : 
            [
                {
                    "idPregunta" : "<idPregunta>",
                    "descripcion" : "<descripcion>"
                }
            ]
        }
    ]
 }
*/
/*
Resultado:
{
  "listaSecciones": [
    {
      "idSeccion": "1",
      "descripcion": "CONOCIMIENTO DE LA MATERIA",
      "listaPreguntas": [
        {
          "idPregunta": "1",
          "descripcion": "Dominio del Tema"
        },
        {
          "idPregunta": "2",
          "descripcion": "Desarrollo actualizado de contenidos previstos"
        },
        {
          "idPregunta": "3",
          "descripcion": "Tiene claro objetivos a cumplir"
        },
        {
          "idPregunta": "4",
          "descripcion": "Resuelve dudas"
        }
      ]
    },
    {
      "idSeccion": "2",
      "descripcion": "ASISTENCIA Y PUNTUALIDAD",
      "listaPreguntas": [
        {
          "idPregunta": "5",
          "descripcion": "Asiste día de programación"
        },
        {
          "idPregunta": "6",
          "descripcion": "Verifica asistencia de los alumnos"
        },
        {
          "idPregunta": "7",
          "descripcion": "Inicio puntual"
        },
        {
          "idPregunta": "8",
          "descripcion": "Termina puntual"
        }
      ]
    },
    {
      "idSeccion": "3",
      "descripcion": "ÉTICA",
      "listaPreguntas": [
        {
          "idPregunta": "9",
          "descripcion": "Identificación universitaria"
        },
        {
          "idPregunta": "10",
          "descripcion": "Respeto al alumno"
        },
        {
          "idPregunta": "11",
          "descripcion": "Demuestra valores éticos"
        },
        {
          "idPregunta": "12",
          "descripcion": "Promueve valores en los estudiantes"
        }
      ]
    },
    {
      "idSeccion": "4",
      "descripcion": "CAPACIDAD DIDÁCTICA",
      "listaPreguntas": [
        {
          "idPregunta": "13",
          "descripcion": "Utiliza técnicas educativas apropiadas y novedosas"
        },
        {
          "idPregunta": "14",
          "descripcion": "Publica notas dentro de las 72 horas post examen"
        },
        {
          "idPregunta": "15",
          "descripcion": "Promueve participación del alumno"
        },
        {
          "idPregunta": "16",
          "descripcion": "Logra cumplir objetivo del aprendizaje"
        }
      ]
    },
    {
      "idSeccion": "5",
      "descripcion": "CUMPLIMIENTO DEL SILABO",
      "listaPreguntas": [
        {
          "idPregunta": "17",
          "descripcion": "Respeta la programación de temas"
        },
        {
          "idPregunta": "18",
          "descripcion": "Respeta el cronograma de programación"
        },
        {
          "idPregunta": "19",
          "descripcion": "Respeta contenidos"
        },
        {
          "idPregunta": "20",
          "descripcion": "Respeta cumplimiento de las evaluaciones"
        }
      ]
    }
  ]
}
*/
    @RequestMapping(value = "/obtenerCuestionario",
                    method = RequestMethod.POST,
                    produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String obtenerCuestionario ( @RequestBody String jsonData, HttpServletRequest request ) {
        System.out.println("4.jsonData(obtenerCuestionario):" + jsonData);
        JsonObject jsonObjeto = parseJsonObject(jsonData);
        String jsoIdPortada = jsonObjeto.getString("idEncuesta");
        List<SeccionCuestionario> lstSecPreg = cuesServ.getPreguntasCuestionario(jsoIdPortada);
        
        JsonObjectBuilder constructor = Json.createObjectBuilder();

        if ( lstSecPreg != null ) {
//            System.out.println("N° de secciones del cuestionario:" + lstSecPreg.size());
//            mostrarListaSecciones_Preguntas(lstSecPreg);
            
            JsonArrayBuilder lstSecciones = Json.createArrayBuilder();
//            constructor.add("success", true);
            Iterator iteSec = lstSecPreg.iterator();
            
            while ( iteSec.hasNext() ) {
                SeccionCuestionario secCue = (SeccionCuestionario) iteSec.next();
                
                String idSeccion = secCue.getIdSeccion();
                String descrSeccion = secCue.getDescripcion();
                
                    JsonArrayBuilder lstPreguntas = Json.createArrayBuilder();
                    List<PreguntaCuestionario> lstPreCue = secCue.getLstPregCue();
                    Iterator itePre = lstPreCue.iterator();
                    
                    while ( itePre.hasNext() ) {
                        PreguntaCuestionario pregCue = (PreguntaCuestionario) itePre.next();
                        String idPregunta = pregCue.getIdPregunta();
                        String descrPregunta = pregCue.getDescripcion();

                        lstPreguntas.add(Json.createObjectBuilder()
                                .add("idPregunta", idPregunta)
                                .add("descripcion", descrPregunta)
                        );
                    }
                    
//                lstCursos.add(Json.createObjectBuilder()
//                        .add("listaProfesores", lstProfesores)
//                );
                lstSecciones.add(Json.createObjectBuilder()
                         .add("idSeccion", idSeccion)
                         .add("descripcion", descrSeccion)
                         .add("listaPreguntas", lstPreguntas)
                );
            }
            constructor.add("codigoRespuesta", "00");
            constructor.add("mensaje", "OK");
            
            constructor.add("listaSecciones", lstSecciones);
//            HttpSession session = request.getSession(true);
//            session.setAttribute(SESSION_ATTRIB_USER, userPersonJson);
            return toJsonString(constructor.build());
            
        } else {
            constructor.add("codigoRespuesta", "01");
            constructor.add("mensaje", "El cuestionario no tiene preguntas.");
            
//            return getJsonErrorMsg("El cuestionario no tiene preguntas.");
            return toJsonString(constructor.build());
        }
    }
    
    private void mostrarListaSecciones_Preguntas(List<SeccionCuestionario> lstSecPreg) {
        int contSeccion = 1;
        
        for ( SeccionCuestionario sec : lstSecPreg ) {
            System.out.println("---------- SECCION " + contSeccion + ": -----------");
            System.out.println("IdSeccion:" + aString(sec.getIdSeccion()));
            System.out.println("Descripcion:" + aString(sec.getDescripcion()));
            contSeccion++;
            
            List<PreguntaCuestionario> lstPre = new ArrayList<PreguntaCuestionario>();
            lstPre = sec.getLstPregCue();
            
            int contPregunta = 1;
            
            if ( lstPre != null ) {
                for ( PreguntaCuestionario pc : lstPre ) {
                    System.out.println("---------- PREGUNTA (" + contPregunta + ") ----------");
                    System.out.println("\tIdPregunta:" + pc.getIdPregunta());
                    System.out.println("\tDescripcion:" + pc.getDescripcion());
                    contPregunta++;
                }
            }
        }
    }
    
    private String aString(Object obj) {
        return String.valueOf(obj);
    }
    
// 5° Handler : Guardar Encuesta ingresada por Encuestador(Estudiante).
/*
Method: POST
URL: http://localhost:8080/sisgenefac/rest/auth/guardarCuestionario
Body(raw):
{
    "idUsuario" : "<idUsuario>",
    "idDocente" : "<idDocente>",
    "idEncuesta" : "<idEncuesta>",
    "tipoClase" : "<tipoClase>",
    "listaPreguntas" : 
    [
        {
            "idPregunta" : "<idPregunta>",
            "respuesta" : "<respuesta>"
        }
    ]
}
*/
/*
Resultado:
{
    "codigoRespuesta" : "<codigoRespuesta>",
    "mensaje" : "<mensaje>"
}
*/
    
    @RequestMapping(value = "/guardarCuestionario", 
                    method = RequestMethod.POST,
                    produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String guardarCuestionario ( @RequestBody String jsonData, HttpServletRequest request ) {
        System.out.println("5.jsonData(guardarCuestionario):" + jsonData);
        JsonObjectBuilder constructor = Json.createObjectBuilder();
        
        JsonObject jsoObj = parseJsonObject(jsonData);
        int jsoIdUsuario = jsonObjectToInt(jsoObj, "idUsuario");
        int jsoIdProfesor = jsonObjectToInt(jsoObj, "idDocente");
        int jsoIdAsignatura = jsonObjectToInt(jsoObj, "idCurso");
//        int jsoIdGrupo =jsonObjectToInt(jsoObj, "idGrupo");
        int jsoIdPortada = jsonObjectToInt(jsoObj, "idEncuesta");
        String jsoTipoClase = jsonObjectToString(jsoObj, "tipoClase");
        
        Encuesta encuesta = new Encuesta();
        encuesta.setIdUsuario(jsoIdUsuario);
        encuesta.setIdProfesor(jsoIdProfesor);
        encuesta.setIdAsignatura(jsoIdAsignatura);
        encuesta.setIdPortada(jsoIdPortada);
//        encuesta.setIdGrupo(jsoIdGrupo);
        encuesta.setTipoClase(jsoTipoClase);
       
        JsonArray jsoLstPreg = jsoObj.getJsonArray("listaPreguntas");
            Iterator<JsonValue> itePregunta = jsoLstPreg.iterator();
        
        List<Respuesta> lstRptas = new ArrayList<Respuesta>();
            
            while ( itePregunta.hasNext() ) {
                JsonObject pre = (JsonObject) itePregunta.next();
//                String numSeccion = pre.getString("numSeccion"); // AGREGADO AL JSON DE Jesús C.
//                String numPregunta = pre.getString("numPregunta"); // AGREGADO AL JSON DE Jesús C.
                        
                String idPregunta = pre.getString("idPregunta");
                String respuesta = pre.getString("respuesta");
                
                Respuesta rpta = new Respuesta();
                
                rpta.setIdPregunta(idPregunta);
                rpta.setRespuesta(respuesta);
                
                int idPreg = stringToInt(idPregunta);
                Cuestionario cue = cuesServ.buscarCuestionario(idPreg, jsoIdPortada);
                String numSeccion = intToString(cue.getPosId().getSecId().getSecNumero());
                String numPregunta = intToString(cue.getPreId().getPreNumero());
                rpta.setNumSeccion(numSeccion);
                rpta.setNumPregunta(numPregunta);
                
                lstRptas.add(rpta);
            }
            
        // Ordenar lista primero por N° de Seccion y luego por N° de Pregunta
        Collections.sort(lstRptas);
        mostrarListaEntReordenada(lstRptas);
                
        boolean guardarEncuesta = cabRptaServ.guardarEncuesta(encuesta, lstRptas);

        if ( guardarEncuesta ) {
            constructor.add("codigoRespuesta", "00")
                       .add("mensaje", "OK");
            return toJsonString(constructor.build());
            
        } else {
            constructor.add("codigoRespuesta", "01")
                       .add("mensaje", "Error al guardar la encuesta.");
            return toJsonString(constructor.build());
        }
    }
    
    private String intToString(int entero) {
        return String.valueOf(entero);
    }
    
    private int stringToInt(String cadena) {
        return Integer.parseInt(cadena);
    }
    
    private static void mostrarListaEntReordenada(List<Respuesta> lista) {
        System.out.println("Ini--------------------------------");
        for ( int i = 0; i < lista.size(); i++ ) {
            Respuesta r = (Respuesta)lista.get(i);
            System.out.println(r.getNumPregunta() + "--" + r.getNumSeccion());
        }
        System.out.println("Fin--------------------------------");
    }
    
    // X° Handler : Cerrar sesión en la Web
    @RequestMapping(value = "/session", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute(SESSION_ATTRIB_USER);
        return getJsonSuccessMsg("User logged out...");
    }
    
    private int jsonObjectToInt(JsonObject jsoObj, String etiqueta) {
        return Integer.parseInt(jsoObj.getString(etiqueta));
    }
    
    private String jsonObjectToString(JsonObject jsoObj, String etiqueta) {
        return jsoObj.getString(etiqueta);
    }
    
    private String formatearNull(JsonObject jsonObject, String etiqueta) {
        return "".equals(jsonObject.getString(etiqueta)) ? null : jsonObject.getString(etiqueta);
    }
    
    private String formatearVacioNotNull(JsonObject jsonObject, String etiqueta) {
        return "".equals(jsonObject.getString(etiqueta)) ? "" : jsonObject.getString(etiqueta);
    }
    
    private char jsonObjectToChar(JsonObject jsonObject, String etiqueta) {
        String cadena = jsonObject.getString(etiqueta);
        char caracter = ' ';
        if ( !"".equals(cadena) ) {
            caracter = cadena.charAt(0);
        }
        return caracter;
   }
    
   private Date jsonObjectToDate(JsonObject jsonObject, String etiqueta) {
        String cadena = jsonObject.getString(etiqueta);
        Date fecNacDate = null;
        if ( !"".equals(cadena) ) {
            try {
                DateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                fecNacDate = formato.parse(cadena);
                
            } catch (ParseException ex) {
                System.out.println("ex(conversion de String a Date):" + ex.getMessage());
                Logger.getLogger(SeguridadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fecNacDate;
   }
   
   private int jsonObjectToGradoInstruccion(JsonObject jsonObject) {
        String graInsString = jsonObject.getString("grado_instruccion");
        int graInsInt = 0;
        if ( !"".equals(graInsString) ) {
            switch ( graInsString ) {
                case "1":
                    graInsInt = 1;
                    break;

                case "2":
                    graInsInt = 2;
                    break;

                case "3":
                    graInsInt = 3;
                    break;
            }
        }
        return graInsInt;
   }
   
   /////////////////////////// ADICIONALES ///////////////////////////////
   private DateTime jsonObjectToDatetime(JsonObject jsonObject, String etiqueta) {
        String cadena = jsonObject.getString(etiqueta);
        DateTime fecDatetime = null;
        
        if ( !"".equals(cadena) ) {
            try {
                DateTimeFormatter formato = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
                fecDatetime = formato.parseDateTime(cadena);
                
            } catch ( Exception ex ) {
                System.out.println("ex(conversion de String a Date):" + ex.getMessage());
            }
        }
        return fecDatetime;
   }
   
   private Timestamp jsonObjectToTimestamp(JsonObject jsonObject, String etiqueta) {
       String cadena = jsonObject.getString(etiqueta);
       Timestamp timestamp = null;
       
       if ( !"".equals(etiqueta) ) {
           try { // 2017/01/14 00:15:37
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
               Date parsedDate = dateFormat.parse(cadena);
               timestamp = new java.sql.Timestamp(parsedDate.getTime());
                
           } catch( Exception ex ) {
               System.out.println("Excepcion : " + ex.getMessage());
           }
       }
       return timestamp;
   }
}