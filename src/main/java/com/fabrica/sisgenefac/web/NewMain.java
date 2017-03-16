package com.fabrica.sisgenefac.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Administrator
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTime dt = jsonObjectToDatetime("2017/01/14 00:15:03");
        System.out.println("dt:" + dt);
        
        Timestamp ts = jsonObjectToTimestamp("2017/01/14 00:15:37");
        System.out.println("ts:" + ts);
    }
    
    private static DateTime jsonObjectToDatetime(
//            JsonObject jsonObject, 
            String etiqueta) {
//        String cadena = jsonObject.getString(etiqueta);
        DateTime fecDatetime = null;
        
        if ( !"".equals(etiqueta) ) {
            try {
                DateTimeFormatter formato = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
                fecDatetime = formato.parseDateTime(etiqueta);
                
            } catch ( Exception ex ) {
                System.out.println("ex(conversion de String a Date):" + ex.getMessage());
                Logger.getLogger(SeguridadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fecDatetime;
   }
   
   private static Timestamp jsonObjectToTimestamp(
//           JsonObject jsonObject, 
           String etiqueta) {
//       String cadena = jsonObject.getString(etiqueta);
       Timestamp timestamp = null;
       
       if ( !"".equals(etiqueta) ) {
           try {
               // 2017/01/14 00:15:37
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
               Date parsedDate = dateFormat.parse(etiqueta);
               timestamp = new java.sql.Timestamp(parsedDate.getTime());
               
//               DateTimeFormatter formato = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
//               fecTimestamp = formato.parseDateTime(cadena);
                
           } catch( Exception ex ) {
               System.out.println("Excepcion : " + ex.getMessage());
                Logger.getLogger(SeguridadHandler.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return timestamp;
   }
}