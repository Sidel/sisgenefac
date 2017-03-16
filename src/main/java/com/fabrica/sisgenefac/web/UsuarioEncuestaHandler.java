package com.fabrica.sisgenefac.web;

//import com.fabrica.sisgenefac.service.UsuarioEncuestaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarioEncuesta")
public class UsuarioEncuestaHandler extends AbstractHandler {

//    @Autowired
//    protected UsuarioEncuestaService userService;

//    @RequestMapping(value = "/store", method = RequestMethod.POST, produces = {"application/json"})
//    @ResponseBody
//    public String store(
//            @RequestBody String jsonData,
//            HttpServletRequest request) {
//        System.out.println("entro a guardar usuario handler 0");
//        Usuario sessionUser = getSessionUser(request);
//
//        JsonObject jsonObj = parseJsonObject(jsonData);
//        System.out.println("entro a guardar usuario handler");
//        Result<UsuarioEncuesta> ar = userService.store(
//                jsonObj.getInt("carEncuestaId"),
//                jsonObj.getString("perNumDocumento"),
//                jsonObj.getString("perNombres"),
//                jsonObj.getString("perApPaterno"),
//                jsonObj.getString("perApMaterno"),
//                jsonObj.getInt("idTipDoc"),
//                jsonObj.getInt("encuestasDesde"),
//                jsonObj.getInt("encuestasHasta"),
//                jsonObj.getInt("ubigeoId"),
//                jsonObj.getString("usuEstado"),
//                jsonObj.getInt("grupo"),
//                jsonObj.getInt("idRol"),
//                jsonObj.getString("equipo"),
//                jsonObj.getString("equipoMarca"),
//                jsonObj.getString("equipoNroSerie"),
//                jsonObj.getString("clave"),
//                jsonObj.getString("username"));
//
//        if (ar.isSuccess()) {
//
//            return getJsonSuccessData(ar.getData());
//
//        } else {
//
//            return getJsonErrorMsg(ar.getMsg());
//
//        }
//    }
//
//    @RequestMapping(value = "/{idUsuarioEnc}", method = RequestMethod.DELETE, produces = {"application/json"})
//    @ResponseBody
//    public String remove(
//            @PathVariable(value = "idUsuarioEnc") Integer idUsuarioEnc,
//            HttpServletRequest request) {
//
//        Usuario sessionUser = getSessionUser(request);
//
//        Result<UsuarioEncuesta> ar = userService.remove(idUsuarioEnc);
//        if (ar.isSuccess()) {
//            return getJsonSuccessMsg(ar.getMsg());
//        } else {
//            return getJsonErrorMsg(ar.getMsg());
//        }
//    }
//
//    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.PUT, produces = {"application/json"})
//    @ResponseBody
//    public String update(
//            @RequestBody String jsonData,
//            @PathVariable(value = "idUsuario") Integer idUsuario,
//            HttpServletRequest request) {
//        System.out.println("mod encuesta 1");
//        Usuario sessionUser = getSessionUser(request);
//        System.out.println("mod encuesta");
//        JsonObject jsonObj = parseJsonObject(jsonData);
//
//        Result<UsuarioEncuesta> ar = userService.update(
//                idUsuario,
//                jsonObj.getString("perNumDocumento"),
//                jsonObj.getString("perNombres"),
//                jsonObj.getString("perApPaterno"),
//                jsonObj.getString("perApMaterno"),
//                jsonObj.getInt("ubigeoId"),
//                jsonObj.getInt("grupo"),
//                jsonObj.getInt("idRol"),
//                jsonObj.getString("equipo"),
//                jsonObj.getString("equipoMarca"),
//                jsonObj.getString("equipoNroSerie"),
//                jsonObj.getString("clave"));
//
//        if (ar.isSuccess()) {
//
//            return getJsonSuccessData(ar.getData());
//
//        } else {
//
//            return getJsonErrorMsg(ar.getMsg());
//
//        }
//    }
//
//    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = {"application/json"})
//    @ResponseBody
//    public String remove(
//            @RequestParam(value = "data", required = true) String jsonData,
//            HttpServletRequest request) {
//
//        Usuario sessionUser = getSessionUser(request);
//
//        JsonObject jsonObj = parseJsonObject(jsonData);
//
//        Result<UsuarioEncuesta> ar = userService.remove(jsonObj.getString("usuUsuario"), sessionUser.getUsuUsuario());
//
//        if (ar.isSuccess()) {
//
//            return getJsonSuccessMsg(ar.getMsg());
//
//        } else {
//
//            return getJsonErrorMsg(ar.getMsg());
//
//        }
//    }
//    
    
    
    /*
     @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = {"application/json"})
     @ResponseBody
     public String findAll(HttpServletRequest request) {

     Usuario sessionUser = getSessionUser(request);

     Result<List<UsuarioEncuesta>> ar = userService.(sessionUser.getUsuUsuario());

     if (ar.isSuccess()) {

     return getJsonSuccessData(ar.getData());

     } else {

     return getJsonErrorMsg(ar.getMsg());

     }
     }*/
}
