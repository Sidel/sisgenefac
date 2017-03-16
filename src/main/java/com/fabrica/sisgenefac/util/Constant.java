/*Constant.java*/
package com.fabrica.sisgenefac.util;

/**
 * Clase con valores constantes a usar en el servicio web
 *
 * @version 1.0 25 Mayo 2015
 * @author jmonzalve
 */
public abstract class Constant {

    // 1. Constantes de nombre de archivos .properties
    public static final String FILE_SISGENE
            = "sisgene.properties"; // nombre de archivo de configuracion

    /**
     * Constantes para la conexion a base de datos
     */
    public static final String DRIVER_SQL = "DRIVER_SQL"; // parametro de driver para conexion a BD
    public static final String URL_SQL = "URL_SQL"; // parametro de url para conexion a BD
    public static final String USER_SQL = "USER_SQL"; // parametro de usuario para conexion a BD
    public static final String PSW_SQL = "PW_SQL"; // parametro de password para conexion a BD
    public static final String IP = "IP_SQL"; //
    public static final String PUERTO = "PUERTO_SQL";
    public static final String NAME_BD = "NAMEBD_SQL";

    /**
     * Constante para responde mensaje de error al validar Admisnitrador
     */
    public static final String MNSJEERRORINSERTARENCUESTA = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR ENCUESTA EN BD\"}";
    public static final String MNSJEERRORVALIDARADMINISTRADOR = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"USUARIO Y/O PASSWORD DE ADMINISTRADOR INCORRECTOS\"}";
    public static final String MNSJEERRORVALIDARADMINISTRADOR2 = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR EN TRANSACCION VALIDAR ADMINISTRADOR\"}";
    public static final String MNSJEERRORVALIDARADMINISTRADOR3 = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR EN LA CARGA DE DATOS\"}";
    public static final String MNSJEERRORVALIDARBD = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR DE CONEXION CON LA BD\"}";
    public static final String MNSJEERRORINSERTARPERSONA = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR PERSONA EN BD\"}";
    public static final String MNSJEERRORINSERTARDIRECCION = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR DIRECCION EN BD\"}";
    public static final String MNSJEERRORINSERTARALLEGADO = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR ALLEGADOS EN BD\"}";
    public static final String MNSJEERRORINSERTARCABDETRPTA = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR CABDETRPTA EN BD\"}";
    public static final String MNSJEERRORINSERTARDETENCRPTA = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL GRABAR DETENCRPTA EN BD\"}";
    public static final String MNSJEERRORENVIARJSON = "{\"codigo_respuesta\":\"01\",\"mensaje\":\"ERROR AL ENVIAR MENSAJE\"}";
    public static final String MNSJECONFIRMACIONOK = "{\"codigo_respuesta\":\"00\",\"mensaje\":\"\"}";

    /**
     * Constante para definir numeros
     */
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int TRES = 3;
    public static final int CUATRO = 4;
    public static final int CINCO = 5;
    public static final int SEIS = 6;
    public static final int SIETE = 7;
    public static final int OCHO = 8;
    public static final int NUEVE = 9;
    public static final int DIEZ = 10;
    public static final int ONCE = 11;
    public static final int DOCE = 12;
    public static final int TRECE = 13;
    public static final int CATORCE = 14;
    public static final int QUINCE = 15;
    public static final int DIECISEIS = 16;
    public static final int DIECISIETE = 17;
    public static final int DIECIOCHO = 18;
    public static final int DIECINUEVE = 19;
    public static final int VEINTE = 20;
    public static final int VEINTIUNO = 21;
    public static final int VEINTIDOS = 22;
    public static final int VEINTITRES = 23;
    public static final int VEINTICUATRO = 24;
    public static final int VEINTICINCO = 25;

    public static final String OK = "00";
    public static final String ERROR = "01";

    public static String getFILE_SISGENE() {
        return FILE_SISGENE;
    }

    public static String getDRIVER_SQL() {
        return DRIVER_SQL;
    }

    public static String getURL_SQL() {
        return URL_SQL;
    }

    public static String getUSER_SQL() {
        return USER_SQL;
    }

    public static String getPSW_SQL() {
        return PSW_SQL;
    }

    public static String getIP() {
        return IP;
    }

    public static String getPUERTO() {
        return PUERTO;
    }

    public static String getNAME_BD() {
        return NAME_BD;
    }

    public static String getMNSJEERRORVALIDARADMINISTRADOR() {
        return MNSJEERRORVALIDARADMINISTRADOR;
    }

    public static String getMNSJEERRORVALIDARADMINISTRADOR2() {
        return MNSJEERRORVALIDARADMINISTRADOR2;
    }

    public static String getMNSJEERRORVALIDARADMINISTRADOR3() {
        return MNSJEERRORVALIDARADMINISTRADOR3;
    }

    public static int getUNO() {
        return UNO;
    }

    public static int getDOS() {
        return DOS;
    }

    public static int getTRES() {
        return TRES;
    }

    public static int getCUATRO() {
        return CUATRO;
    }

    public static int getCINCO() {
        return CINCO;
    }

    public static int getSEIS() {
        return SEIS;
    }

    public static int getSIETE() {
        return SIETE;
    }

    public static int getOCHO() {
        return OCHO;
    }

    public static int getNUEVE() {
        return NUEVE;
    }

    public static int getDIEZ() {
        return DIEZ;
    }

    public static int getONCE() {
        return ONCE;
    }

    public static int getDOCE() {
        return DOCE;
    }

    public static int getTRECE() {
        return TRECE;
    }

    public static int getCATORCE() {
        return CATORCE;
    }

    public static int getQUINCE() {
        return QUINCE;
    }

    public static int getDIECISEIS() {
        return DIECISEIS;
    }

    public static int getDIECISIETE() {
        return DIECISIETE;
    }

    public static int getDIECIOCHO() {
        return DIECIOCHO;
    }

    public static int getDIECINUEVE() {
        return DIECINUEVE;
    }

    public static int getVEINTE() {
        return VEINTE;
    }

    public static int getVEINTIUNO() {
        return VEINTIUNO;
    }

    public static int getVEINTIDOS() {
        return VEINTIDOS;
    }

    public static int getVEINTITRES() {
        return VEINTITRES;
    }

    public static int getVEINTICUATRO() {
        return VEINTICUATRO;
    }

    public static int getVEINTICINCO() {
        return VEINTICINCO;
    }

    public static String getOK() {
        return OK;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static String getMNSJEERRORVALIDARBD() {
        return MNSJEERRORVALIDARBD;
    }

    public static String getMNSJEERRORINSERTARPERSONA() {
        return MNSJEERRORINSERTARPERSONA;
    }

    public static String getMNSJEERRORINSERTARDIRECCION() {
        return MNSJEERRORINSERTARDIRECCION;
    }

    public static String getMNSJEERRORINSERTARALLEGADO() {
        return MNSJEERRORINSERTARALLEGADO;
    }

    public static String getMNSJEERRORINSERTARCABDETRPTA() {
        return MNSJEERRORINSERTARCABDETRPTA;
    }

    public static String getMNSJEERRORINSERTARDETENCRPTA() {
        return MNSJEERRORINSERTARDETENCRPTA;
    }

    public static String getMNSJEERRORENVIARJSON() {
        return MNSJEERRORENVIARJSON;
    }

}
