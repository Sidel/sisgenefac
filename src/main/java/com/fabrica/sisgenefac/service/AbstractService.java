package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.UsuarioDao;
import com.fabrica.sisgenefac.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    final protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected UsuarioDao userDao;

    protected final String USER_INVALID = "Not a valid user";
    protected final String USER_NOT_ADMIN = "Not an admin user";
    protected final String NOT_FOUND = "not found";
    
//    protected boolean isValidUser(String usuUsuario){
//
//        Usuario user = userDao.findByUsername(usuUsuario);
//        return user != null;
//    }
}