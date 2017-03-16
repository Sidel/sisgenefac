package com.fabrica.sisgenefac.web;

import com.fabrica.sisgenefac.util.Criptografo;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ledis Rivera Changra
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> claves = new ArrayList<String>();
        claves.add("cq25fMntojahFnCpZJDHIQ==");
        claves.add("xChZw42BWutL8nOt7JEXyA==");
        claves.add("BdwH/OrYt8vSEK7IIAkN8w==");
        claves.add("VOdW8u25vf96HfiuahamUw==");
        claves.add("1RFm8pCzHUlJu7TRViEM0w==");
        claves.add("XhfCf85FfWwkcn25EtElJQ==");
        claves.add("l7g/xEZZOUmTA4prYCH8WA==");
        claves.add("O8Lfrgie/SAhXpNKqENJ+Q==");
        claves.add("MWktKsLaVnHZeI8dncw6SQ==");
        claves.add("AS2Eavwb3yqaU8KWMlGWqg==");
        claves.add("KNTE6gqFHt/qcPpW5LjSVg==");
        claves.add("bAbqqmCL6rLNOMGZL6hWGg==");
        claves.add("awVaTfMU3ovSMgjgqYBSvg==");

        for ( int i = 0; i < claves.size(); i++ ) {
            String clave = Criptografo.desencripta(claves.get(i));
            System.out.println(clave);
        }
        /*
        String clave = Criptografo.desencripta("5ptevNobR730HAsEwNESE3VRtMKnlyGt");
        System.out.println("desencriptado:" + clave);
        */
        /*
        String codUbigeo = "125689";
        String codDepUbi = codUbigeo.substring(0, 2);
        String codProvUbi = codUbigeo.substring(2, 4);
        String codDistUbi = codUbigeo.substring(4, 6);
        System.out.println("codDepUbi:" + codDepUbi);
        System.out.println("codProvUbi:" + codProvUbi);
        System.out.println("codDistUbi:" + codDistUbi);
        */
        /*
        String clave = getClave("ANTONIO", "GUEVARA", "CESPEDES", 2);
        System.out.println("Clave:" + clave); // NAUGEC
        */
        /*
        int a = 20;
        System.out.println("a(RAIZ):" + a);
        modificarSinRetorno(a);
        System.out.println("a(despues sin retorno):" + a);
        
        a = modificarConRetorno(a);
        System.out.println("a(despues con retorno):" + a);
        */
        /*
        boolean valor = esNombreCompuesto("BARRÓNÑ");
        System.out.println("valor:" + valor);
        */
        /*
        List<Integer> listaFilas = new ArrayList<Integer>();
        listaFilas.add(1);
//        listaFilas.add(2);
//        listaFilas.add(3);
        String lista = mostrarFilasSup(listaFilas);
        System.out.println("lista:" + lista);
        */
        /*
        conEspaciosIniFin(" Isaac Asimov ");
        conEspaciosIniFin("Del Toro ");
        conEspaciosIniFin(" La Mar");
        conEspaciosIniFin("De La Cruz");
        */
        /*
        esNombreCompuesto(" CARLOS "); // SI
        esNombreCompuesto("CARMEN"); // SI
        esNombreCompuesto("DEL PINO"); // SI
        esNombreCompuesto("LA ROSA"); // SI
        */
        /*
        String clave = asignarClave("Carlos", "Miranda", "Arteaga");
        System.out.println("clave:" + clave);
        */
        /*
        String contraseña = "JSP12345678";
        encriptar(contraseña);*/
        /*  
        pruebasDiana();*/
    }
    
    private static void desencriptar(String contraseña) {
        Criptografo cripto = new Criptografo();
        String desencriptado = cripto.desencripta(contraseña);
        System.out.println("desencriptado:" + desencriptado);
    }
    
    private static String getClave(String nombres, String apPaterno, String apMaterno, int numCaracteres) {
        return getCharRevert(nombres, numCaracteres) 
                + getCharRevert(apPaterno, numCaracteres) 
                + getCharRevert(apMaterno, numCaracteres);
    }
    
    private static String getCharRevert(String cadena, int numCaracteres) {
        StringBuilder builder = new StringBuilder(cadena);
//        return builder.reverse().toString().substring(0, 3);
//        return builder.toString().substring(0, 3); // 3 primeras letras
        int longitud = cadena.length();
        return builder.reverse().substring(longitud - numCaracteres, longitud);
        // se invierte nombre y se extraen las ultimas 3 = 3 primeras letras al reves
    }
    
    private static int modificarConRetorno(int ini) {
        ini = 33;
        return ini;
    }
    
    private static void modificarSinRetorno(int ini) {
        ini = 18;
    }
    
    private static boolean esNombreCompuesto(String nombre) {
        Pattern patron = Pattern.compile("[A-ZÁÉÍÓÚÑ\\s]*");
        Matcher mat = patron.matcher(nombre);
        if ( mat.matches() ) {
            return true;
        } else {
            return false;
        }
    }
    
    private static String mostrarFilasSup(List<Integer> lstFilas) {
        String todasFilas = "";
        if ( lstFilas.size() == 1 ) {
            todasFilas = String.valueOf(lstFilas.get(0));
        } else {
            for ( int fila : lstFilas ) {
                todasFilas = todasFilas + fila + ",";
            }
            todasFilas = todasFilas.substring(0, todasFilas.length() - 1);
        }
        return todasFilas;
    }
    
    private static void conEspaciosIniFin(String cadena) {
        String sinEspacios = cadena.trim(); 
        int tamOriginal = cadena.length();
        int tamSinEspacios = sinEspacios.length();
        
        if ( tamOriginal == tamSinEspacios ) {
            System.out.println(cadena + " NO tiene blancos al inicio y/o final.");
        } else {
            System.out.println(cadena + " SI tiene blancos al inicio y/o final.");
        }
    }
    
//    private static void esNombreCompuesto(String cadena) {
//        Pattern pat = Pattern.compile("[A-Z\\s]*");
//        Matcher mat = pat.matcher(cadena);
//        if ( mat.matches() ) {
//            System.out.println(cadena + " SI es válido.");
//        } else {
//            System.out.println(cadena + " NO es válido.");
//        }
//    }
    
    private static String asignarClave(String nombres, String apPaterno, String apMaterno) {
        return get3CharRevert(nombres) + get3CharRevert(apPaterno) + get3CharRevert(apMaterno);
    }
    
    private static String get3CharRevert(String cadena) {
        StringBuilder builder = new StringBuilder(cadena);
//        return builder.reverse().toString().substring(0, 3);
//        return builder.toString().substring(0, 3); // 3 primeras letras
        int longitud = cadena.length();
        return builder.reverse().substring(longitud - 3, longitud); // se invierte nombre y se extraen las ultimas 3 = 3 primeras letras al reves
    }
    
    private static void encriptar(String contraseña) {
        Criptografo cripto = new Criptografo();
        String encriptado = cripto.encripta(contraseña);
        System.out.println("encriptado:" + encriptado);
    }
    
    private static void pruebasDiana() {
        String separador = "\\%";
        String separador2 = "\\$";
        String concatenado = "1\\$2";
        String[] separados = null;
        separados = concatenado.split(separador2);
        
        for ( String s : separados ) {
            System.out.println("sep:" + s);
        }
        
        String sBuscar = separador.substring(1,1);
        System.out.println("sBuscar:" + sBuscar);
        
//        String sTexto = "1$3$4";
//        String sTextoBuscado = "$";
        String sTexto = "Tuenti%null%null%null";
        String sTextoBuscado = "\\%";
        System.out.println("(*)buscar inicial:" + sTextoBuscado);
        sTextoBuscado = sTextoBuscado.substring(1,2);
        System.out.println("(*)buscar nuevo:" + sTextoBuscado);
        
        int ocurrencias = sTexto.indexOf(sTextoBuscado);
        System.out.println("Indice de 1° ocurencia del $ en " + sTexto + " : " + ocurrencias);
        
        ocurrencias = 0;
        while (sTexto.indexOf(sTextoBuscado) > -1) {
            sTexto = sTexto.substring(sTexto.indexOf(
            sTextoBuscado)+sTextoBuscado.length(),sTexto.length());
            ocurrencias++; 
        }
        System.out.println("N° ocurrencias del " + sTextoBuscado + " en " + sTexto + ":" + ocurrencias);
    }
}