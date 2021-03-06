package com.fabrica.sisgenefac.web;

//import com.fabrica.sisgene.domain.Usuario;
//import com.fabrica.sisgene.domain.UsuarioPersona;
//import static com.fabrica.sisgenefac.web.SecurityHelper.getSessionUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInSessionInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        logger.info("calling preHandle with url=" + request.getRequestURI());

//        UsuarioPersona sessionUser = getSessionUser(request);
//        response.setHeader("Content-Type", "application/json");
//        response.setCharacterEncoding("UTF-8");
//        if (sessionUser == null) {
//            String json = "{\"success\":false,\"msg\":\"A valid user is not logged on!\"}";
//            response.setStatus(401);
//            response.getOutputStream().write(json.getBytes());
//            return false;
//        } else {
//            logger.info("OK" );
            return true;
//        }
    }
}
