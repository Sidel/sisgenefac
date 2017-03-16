package com.fabrica.sisgenefac.web;

//import com.fabrica.sisgenefac.domain.UsuarioPersona;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityHelper {

    static final String SESSION_ATTRIB_USER = "sessionuser";

//    public static UsuarioPersona getSessionUser(HttpServletRequest request) {
//        UsuarioPersona user = null;
//        HttpSession session = request.getSession(true);
//        Object obj = session.getAttribute(SESSION_ATTRIB_USER);
//
//        if ( obj != null && obj instanceof UsuarioPersona ) {
//            user = (UsuarioPersona) obj;
//        }
//        return user;
//    }
}