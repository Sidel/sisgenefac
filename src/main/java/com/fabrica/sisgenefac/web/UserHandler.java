package com.fabrica.sisgenefac.web;

import com.fabrica.sisgenefac.domain.*;
import com.fabrica.sisgenefac.util.Criptografo;
import com.fabrica.sisgenefac.vo.Result;
import static com.fabrica.sisgenefac.web.AbstractHandler.getJsonErrorMsg;
import static com.fabrica.sisgenefac.web.AbstractHandler.getJsonSuccessData;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuarios")
public class UserHandler extends AbstractHandler {

//    @Autowired
//    protected RolService rolService;

    @RequestMapping(value = "/{encuesta}", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String store(
            @RequestBody String jsonData,
            @PathVariable(value = "encuesta") String encuesta,
            HttpServletRequest request) {

        System.out.println("usuarios-store");
        JsonObject jsonObj = parseJsonObject(jsonData);

//        String tipo = jsonObj.getString("tipo");
        int desde = 0;
        int hasta = 0;

        try {
            desde = jsonObj.getJsonObject("encuestas").getInt("desde");
        } catch (Exception e) {
            desde = 0;
        }

        try {
            hasta = jsonObj.getJsonObject("encuestas").getInt("hasta");
        } catch (Exception e) {
            hasta = 0;
        }
        int grupo = 0;
        try {
            grupo = jsonObj.getInt("grupo");
        } catch (Exception e) {
            grupo = 0;
        }
        String tipoEq;
        try {
            tipoEq = jsonObj.getJsonObject("equipo").getString("tipo");
        } catch (Exception e) {
            tipoEq = "";
        }

        String marca;
        try {
            marca = jsonObj.getJsonObject("equipo").getString("marca");
        } catch (Exception e) {
            marca = "";
        }

        String serie;
        try {
            serie = jsonObj.getJsonObject("equipo").getString("serie");
        } catch (Exception e) {
            serie = "";
        }

        String departamento = "", provincia = "", distrito = "";
        String rolUsuario = jsonObj.getString("tipo");
        
        if ( !"ADMINISTRADOR".equals(rolUsuario) ) {
            departamento = jsonObj.getJsonObject("zonificacion").getString("departamento");
            provincia = jsonObj.getJsonObject("zonificacion").getString("provincia");
            distrito = jsonObj.getJsonObject("zonificacion").getString("distrito");
        }

        System.out.println("clave:" + jsonObj.getString("clave"));
        System.out.println("dni:" + jsonObj.getString("dni"));
        System.out.println("apellido paterno:" + jsonObj.getJsonObject("apellidos").getString("paterno"));
        System.out.println("apellido materno:" + jsonObj.getJsonObject("apellidos").getString("materno"));
        System.out.println("nombres:" + jsonObj.getString("nombres"));
        System.out.println("tipo:" + jsonObj.getString("tipo"));
        System.out.println("grupo:" + grupo);
        System.out.println("desde:" + desde);
        System.out.println("hasta:" + hasta);
        System.out.println("departamento:" + departamento);
        System.out.println("provincia:" + provincia);
        System.out.println("tipoEq:" + tipoEq);
        System.out.println("marca:" + marca);
        System.out.println("serie:" + serie);
        
//        try {
//            Result<Usuario> ar = userService.store(
//                    encuesta,
//                    jsonObj.getString("clave"),
//                    jsonObj.getString("dni"),
//                    jsonObj.getJsonObject("apellidos").getString("paterno"),
//                    jsonObj.getJsonObject("apellidos").getString("materno"),
//                    jsonObj.getString("nombres"),
//                    jsonObj.getString("tipo"),
//                    grupo,
//                    desde,
//                    hasta,
//                    departamento,
//                    provincia,
//                    distrito,
//                    tipoEq,
//                    marca,
//                    serie);
//
//            if (ar.isSuccess()) {
//                return getJsonSuccessData(ar.getData());
//            } else {
//                return getJsonErrorMsg(ar.getMsg());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return getJsonErrorMsg("Error. No se agrego usuario de encuesta. "+ e);
//        }
        return "";
    }

    @RequestMapping(value = "/{encuesta}/{usuario}", method = RequestMethod.PUT, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String update(
            @RequestBody String jsonData,
            @PathVariable(value = "encuesta") String encuesta,
            @PathVariable(value = "usuario") String usuario,
            HttpServletRequest request) {
        JsonObject jsonObj = parseJsonObject(jsonData);

        String tipo = jsonObj.getString("tipo");

        int desde = 0;
        int hasta = 0;

        try {
            desde = jsonObj.getJsonObject("encuestas").getInt("desde");
        } catch (Exception e) {
            desde = 0;
        }

        try {
            hasta = jsonObj.getJsonObject("encuestas").getInt("hasta");
        } catch (Exception e) {
            hasta = 0;
        }

//        Result<Usuario> ar = userService.actualizar(
//                encuesta,
//                usuario,
//                jsonObj.getString("dni"),
//                jsonObj.getJsonObject("apellidos").getString("paterno"),
//                jsonObj.getJsonObject("apellidos").getString("materno"),
//                jsonObj.getString("nombres"),
//                jsonObj.getString("tipo"),
//                jsonObj.getInt("grupo"),
//                //tipo.toUpperCase().equals("ENCUESTADOR") ? jsonObj.getJsonObject("encuestas").getInt("desde") : 0,
//                //tipo.toUpperCase().equals("ENCUESTADOR") ? jsonObj.getJsonObject("encuestas").getInt("hasta") : 0,
//                desde,
//                hasta,
//                jsonObj.getJsonObject("zonificacion").getString("departamento"),
//                jsonObj.getJsonObject("zonificacion").getString("provincia"),
//                jsonObj.getJsonObject("zonificacion").getString("distrito"),
//                jsonObj.getJsonObject("equipo").getString("tipo"),
//                jsonObj.getJsonObject("equipo").getString("marca"),
//                jsonObj.getJsonObject("equipo").getString("serie"));
//        
//        if ( ar.isSuccess() ) {
//            return getJsonSuccessMsg("Usuario de encuesta modificado exitosamente");
//            
//        } else {
//            return getJsonErrorMsg(ar.getMsg());
//        }
        return "";
    }

    @RequestMapping(value = "/{idEnc}/{idUser}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String remove(
            @PathVariable(value = "idUser") String idUser,
            @PathVariable(value = "idEnc") String idEnc,
            HttpServletRequest request) {
//        try {
//            Result<Usuario> ar = userService.remove(idUser, idEnc);
//            if (ar.isSuccess()) {
//                return getJsonSuccessMsg(ar.getMsg());
//
//            } else {
//                return getJsonErrorMsg(ar.getMsg());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return getJsonErrorMsg("Error. Usuario de Encuesta no fue eliminado. "+e);
//        }
        return "";
    }

    // CUS : Listar todos los usuarios después de la importación masiva de usuarios.
    // Problema 1: En la Web se puede visualizar la clave del usuario, esto debería ocultarse pues no se necesita,
    // Problema 2: Este servicio debería dividirse en dos, donde el primero retorne todos los supervisores y otro servicio que retorne 
    //             los usuarios de dicho supervisor(parámetro) seleccionado en anterior combo en la Web (COMBO DEPENDIENTE).
    // Descripción: Carga supervisores(+ administrador) y usuarios
    // Request URL: http://localhost:8080/sisgene/api/usuarios/PRU201/
    // Request Method:GET
    // Response: {"success":true,"usuarios":[{"usuario":"79435993PRU201","clave":"vam79435993","dni":"79435993","apellidos":{"paterno":"VENTOCILLA","materno":"ALOR"},"nombres":"MOISES","tipo":"ADMINISTRADOR","grupo":0,"encuestas":{"desde":0,"hasta":0},"zonificacion":{"ubigeo":"","departamento":"","provincia":"","distrito":""},"equipo":{}},{"usuario":"70435994PRU201","clave":"gqs70435994","dni":"70435994","apellidos":{"paterno":"Gonzales","materno":"Quispe"},"nombres":"Silvana Celia","tipo":"SUPERVISOR","grupo":1,"encuestas":{"desde":0,"hasta":0},"zonificacion":{"ubigeo":"150101","departamento":"LIMA","provincia":"LIMA ","distrito":"LIMA"},"equipo":{}},{"usuario":"75256356PRU201","clave":"ecm75256356","dni":"75256356","apellidos":{"paterno":"Estrada","materno":"Camacho"},"nombres":"Mauricio Gabriel","tipo":"SUPERVISOR","grupo":2,"encuestas":{"desde":0,"hasta":0},"zonificacion":{"ubigeo":"020801","departamento":"ANCASH","provincia":"CASMA","distrito":"CASMA"},"equipo":{}},{"usuario":"73512234PRU201","clave":"gcs73512234","dni":"73512234","apellidos":{"paterno":"Guevara","materno":"Cordero"},"nombres":"Sebastian","tipo":"SUPERVISOR","grupo":3,"encuestas":{"desde":0,"hasta":0},"zonificacion":{"ubigeo":"080101","departamento":"CUSCO","provincia":"CUSCO","distrito":"CUSCO"},"equipo":{}},{"usuario":"50835678PRU201","clave":"dsc50835678","supervisor":{"usuario":"70435994PRU201","nombreCompleto":"Gonzales Quispe Silvana Celia"},"dni":"50835678","apellidos":{"paterno":"De la Cruz","materno":"Santa"},"nombres":"Carmen","tipo":"ENCUESTADOR","grupo":1,"encuestas":{"desde":1,"hasta":3},"zonificacion":{"ubigeo":"150101","departamento":"LIMA","provincia":"LIMA ","distrito":"LIMA"},"equipo":{}},{"usuario":"50487739PRU201","clave":"cms50487739","supervisor":{"usuario":"70435994PRU201","nombreCompleto":"Gonzales Quispe Silvana Celia"},"dni":"50487739","apellidos":{"paterno":"Capcha","materno":"Martinez"},"nombres":"Sergio","tipo":"ENCUESTADOR","grupo":1,"encuestas":{"desde":4,"hasta":6},"zonificacion":{"ubigeo":"150101","departamento":"LIMA","provincia":"LIMA ","distrito":"LIMA"},"equipo":{}},{"usuario":"50368739PRU201","clave":"cmr50368739","supervisor":{"usuario":"70435994PRU201","nombreCompleto":"Gonzales Quispe Silvana Celia"},"dni":"50368739","apellidos":{"paterno":"Cisneros","materno":"Martinez"},"nombres":"Ramón","tipo":"ENCUESTADOR","grupo":1,"encuestas":{"desde":7,"hasta":9},"zonificacion":{"ubigeo":"150101","departamento":"LIMA","provincia":"LIMA ","distrito":"LIMA"},"equipo":{}},{"usuario":"51537648PRU201","clave":"hmg51537648","supervisor":{"usuario":"75256356PRU201","nombreCompleto":"Estrada Camacho Mauricio Gabriel"},"dni":"51537648","apellidos":{"paterno":"Hinostroza","materno":"Mora"},"nombres":"Guillermo","tipo":"ENCUESTADOR","grupo":2,"encuestas":{"desde":10,"hasta":12},"zonificacion":{"ubigeo":"020801","departamento":"ANCASH","provincia":"CASMA","distrito":"CASMA"},"equipo":{}},{"usuario":"51523456PRU201","clave":"bra51523456","supervisor":{"usuario":"75256356PRU201","nombreCompleto":"Estrada Camacho Mauricio Gabriel"},"dni":"51523456","apellidos":{"paterno":"Bernal","materno":"Ramirez"},"nombres":"Alexander","tipo":"ENCUESTADOR","grupo":2,"encuestas":{"desde":13,"hasta":15},"zonificacion":{"ubigeo":"020801","departamento":"ANCASH","provincia":"CASMA","distrito":"CASMA"},"equipo":{}},{"usuario":"59364897PRU201","clave":"brr59364897","supervisor":{"usuario":"75256356PRU201","nombreCompleto":"Estrada Camacho Mauricio Gabriel"},"dni":"59364897","apellidos":{"paterno":"Burgos","materno":"Ramirez"},"nombres":"Ricardo","tipo":"ENCUESTADOR","grupo":2,"encuestas":{"desde":16,"hasta":18},"zonificacion":{"ubigeo":"020801","departamento":"ANCASH","provincia":"CASMA","distrito":"CASMA"},"equipo":{}},{"usuario":"56577423PRU201","clave":"chb56577423","supervisor":{"usuario":"73512234PRU201","nombreCompleto":"Guevara Cordero Sebastian"},"dni":"56577423","apellidos":{"paterno":"Chauca","materno":"Huayra"},"nombres":"Benedicto","tipo":"ENCUESTADOR","grupo":3,"encuestas":{"desde":19,"hasta":21},"zonificacion":{"ubigeo":"080101","departamento":"CUSCO","provincia":"CUSCO","distrito":"CUSCO"},"equipo":{}},{"usuario":"51123459PRU201","clave":"cml51123459","supervisor":{"usuario":"73512234PRU201","nombreCompleto":"Guevara Cordero Sebastian"},"dni":"51123459","apellidos":{"paterno":"Cravero","materno":"Morocho"},"nombres":"Luis","tipo":"ENCUESTADOR","grupo":3,"encuestas":{"desde":22,"hasta":24},"zonificacion":{"ubigeo":"080101","departamento":"CUSCO","provincia":"CUSCO","distrito":"CUSCO"},"equipo":{}},{"usuario":"51147896PRU201","clave":"hmm51147896","supervisor":{"usuario":"73512234PRU201","nombreCompleto":"Guevara Cordero Sebastian"},"dni":"51147896","apellidos":{"paterno":"Herrera","materno":"Maguiña"},"nombres":"Margarita","tipo":"ENCUESTADOR","grupo":3,"encuestas":{"desde":25,"hasta":27},"zonificacion":{"ubigeo":"080101","departamento":"CUSCO","provincia":"CUSCO","distrito":"CUSCO"},"equipo":{}},{"usuario":"51142536PRU201","clave":"mgc51142536","supervisor":{"usuario":"73512234PRU201","nombreCompleto":"Guevara Cordero Sebastian"},"dni":"51142536","apellidos":{"paterno":"Mackenzie","materno":"Guerrero"},"nombres":"Carlos","tipo":"ENCUESTADOR","grupo":3,"encuestas":{"desde":28,"hasta":30},"zonificacion":{"ubigeo":"080101","departamento":"CUSCO","provincia":"CUSCO","distrito":"CUSCO"},"equipo":{}}]}
    @RequestMapping(value = "/{encuesta}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String findAll(
            @RequestBody String jsonData,
            @PathVariable(value = "encuesta") String encuesta,
            HttpServletRequest request) {

//        System.out.println("usuarios-findAll");
//        System.out.println("AJA:: " + jsonData);
        Criptografo cr = new Criptografo();
//        CaratulaEncuesta car = carService.findByCodigo(encuesta).getData();

//        if ( car == null ) {
//            return getJsonErrorMsg("No se encontró la encuesta de la que se lista los usuarios");
//            
//        } else {
//            System.out.println("cae_id::" + car.getCaeId());
//            int caeId = car.getCaeId();
//            List<TablaUsuario> lstUsuAdm = usuPerService.obtenerTablaUsuarioAdm(caeId);
//            List<TablaUsuario> lstUsuSup = usuPerService.obtenerTablaUsuarioSup(caeId);
//            List<TablaUsuario> lstUsuEnc = usuPerService.obtenerTablaUsuarioEnc(caeId);
//            
//            if ( lstUsuAdm.isEmpty() && lstUsuSup.isEmpty() && lstUsuEnc.isEmpty() ) {
//                return getJsonErrorMsg("No existen usuarios registrados para la encuesta " + car.getCaeCodigo());
//                
//            } else {
//                JsonObjectBuilder builder = Json.createObjectBuilder();
//                builder.add("success", true);
//                
//                // 1° Agregar Administrador de Encuesta
//                JsonArrayBuilder usuarioArrayBuilder = Json.createArrayBuilder();
//                usuarioArrayBuilder = getUsuarios(lstUsuAdm, usuarioArrayBuilder, cr);
//                
//                // 2° Agregar Supervisores
//                usuarioArrayBuilder = getUsuarios(lstUsuSup, usuarioArrayBuilder, cr);
//                
//                // 3° Agregar Encuestadores
//                usuarioArrayBuilder = getUsuarios(lstUsuEnc, usuarioArrayBuilder, cr);
//                
//                builder.add("usuarios", usuarioArrayBuilder);
//                return toJsonString(builder.build());
//            }
//        }
        return "";
    }

//    private JsonArrayBuilder getUsuarios(List<TablaUsuario> lstUsuarios, JsonArrayBuilder usuarioArrayBuilder, Criptografo cr) {
//
//        for ( TablaUsuario usuTbl : lstUsuarios ) {
//            JsonObjectBuilder apellidosArrayBuilder = Json.createObjectBuilder();
//            apellidosArrayBuilder.add("paterno", usuTbl.getApPaterno())
//                                 .add("materno", usuTbl.getApMaterno());
//
//            JsonObjectBuilder encuestasArrayBuilder = Json.createObjectBuilder();
//            if ( usuTbl.getDesde() != null && usuTbl.getHasta() != null ) {
//                encuestasArrayBuilder.add("desde", usuTbl.getDesde());
//                encuestasArrayBuilder.add("hasta", usuTbl.getHasta());
//            }
//            
//            JsonObjectBuilder zonaArrayBuilder = Json.createObjectBuilder();
//            if ( usuTbl.getCodigoUbiCcpp() != null ) {
//                zonaArrayBuilder.add("ubigeo", usuTbl.getCodigoUbiCcpp())
//                                .add("departamento", usuTbl.getDpto())
//                                .add("provincia", usuTbl.getProv())
//                                .add("distrito", usuTbl.getDist());
//            }
//            
//            String conglomerado = "";
//            if ( usuTbl.getConglomerado() != null ) {
//                conglomerado = usuTbl.getConglomerado();
//            }
//
//            JsonObjectBuilder equipoArrayBuilder = Json.createObjectBuilder();
//            
//            usuarioArrayBuilder.add(
//                                Json.createObjectBuilder()
//                                .add("usuario", usuTbl.getUsuario())
//                                .add("clave", cr.desencripta(usuTbl.getClave()))
//                                .add("dni", usuTbl.getDni())
//                                .add("apellidos", apellidosArrayBuilder)
//                                .add("nombres", usuTbl.getNombres())
//                                .add("tipo", usuTbl.getRol().toUpperCase())
//                                .add("grupo", conglomerado)
//                                .add("encuestas", encuestasArrayBuilder)
//                                .add("zonificacion", zonaArrayBuilder)
//                                .add("equipo", equipoArrayBuilder));
//        }
//        return usuarioArrayBuilder;
//    }
}