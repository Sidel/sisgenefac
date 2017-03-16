package com.fabrica.sisgenefac.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import com.fabrica.sisgenefac.vo.Result;
import javax.json.JsonObject;
import org.springframework.web.bind.annotation.PathVariable;
import static com.fabrica.sisgenefac.web.AbstractHandler.getJsonErrorMsg;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.json.JsonArray;
//import com.fabrica.sisgene.vo.Supervisor;
//import com.fabrica.sisgene.vo.Encuestador;
/**
 *
 * @author Ledis Rivera Changra
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioPersonaHandler extends AbstractHandler {
    
//    @Autowired
//    protected UsuarioPersonaService userPersonService;
    
    private String getClave(String nombres, String apPaterno, String apMaterno, int numCaracteres) {
        String clave = getCharRevert(nombres, numCaracteres) 
                        + getCharRevert(apPaterno, numCaracteres) 
                        + getCharRevert(apMaterno, numCaracteres);
        clave = quitarTildes(clave);
        return clave;
    }
    
    private String quitarTildes(String cadena) {
        cadena = cadena.replace("Á", "A");
        cadena = cadena.replace("É", "E");
        cadena = cadena.replace("Í", "I");
        cadena = cadena.replace("Ó", "O");
        cadena = cadena.replace("Ú", "U");
        return cadena;
    }
    
    private String getCharRevert(String cadena, int numCaracteres) {
        StringBuilder builder = new StringBuilder(cadena);
//        return builder.reverse().toString().substring(0, 3);
//        return builder.toString().substring(0, 3); // 3 primeras letras
        int longitud = cadena.length();
        return builder.reverse().substring(longitud - numCaracteres, longitud); // se invierte nombre y se extraen las ultimas 3 = 3 primeras letras al reves
    }
    
    private boolean esNombreCompuesto(String nombre) {
        Pattern patron = Pattern.compile("[A-ZÁÉÍÓÚÑ\\s]*");
        Matcher mat = patron.matcher(nombre);
        if ( mat.matches() ) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean conEspaciosIniFin(String cadena) {
        String sinEspacios = cadena.trim(); 
        int tamOriginal = cadena.length();
        int tamSinEspacios = sinEspacios.length();
        
        if ( tamOriginal == tamSinEspacios ) {
            return false;
            
        } else {
            return true;
        }
    }
    
    private String soloLetras(String valCelda, int fila, String cabExcel) {
        String result = "";
        if ( !"".equals(valCelda) ) {
            if ( !esNombreCompuesto(valCelda) ) {
                result += "\n" + cabExcel + " debe contener sólo letras en fila " + fila + " del Excel.";
            }
            if ( conEspaciosIniFin(valCelda) ) {
                result += "\n" + cabExcel + " tiene espacios en blanco al inicio y/o final en fila " + fila + " del Excel.";
            }
        }
        return result;
    }
    
    private String soloDigitos(String valCelda, int fila, String cabExcel) {
        String result = "";
        if ( !"".equals(valCelda) ) {
            if ( !esNumero(valCelda) ) {
                result += "\n" + cabExcel + " debe ser un número en fila " + fila + " del Excel.";
            }
        }
        return result;
    }
    
    private boolean esNumero(String cadena, int numDigitos) {
        String patron = "[0-9]{" + numDigitos + "}"; // "numDigitos": estrictamente el número debe tener "numDigitos" dígitos.
        if ( cadena.matches(patron) ) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean esNumero(String cadena) {
        String patron = "[0-9]*";
        if ( cadena.matches(patron) ) {
            return true;
        } else {
            return false;
        }
    }
}