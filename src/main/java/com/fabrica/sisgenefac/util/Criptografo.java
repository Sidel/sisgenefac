package com.fabrica.sisgenefac.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author Ledis Rivera Changra
 */

public class Criptografo {
    public static String encripta(String cadena) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("uniquekey");
        
        return s.encrypt(cadena);
    }

    public static String desencripta(String cadena) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("uniquekey");
        String devuelve = "";
        try {
            devuelve = s.decrypt(cadena);
        } catch (Exception e) {
        }
        return devuelve;
    }
}
