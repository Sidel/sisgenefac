package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.dao.UsuarioDao;
import com.fabrica.sisgenefac.service.AbstractService;
import com.fabrica.sisgenefac.service.UsuarioService;
import com.fabrica.sisgenefac.transformers.UsuarioRol;
import com.fabrica.sisgenefac.vo.Result;
import com.fabrica.sisgenefac.vo.ResultFactory;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;

@Transactional
@Service("userService")
public class UsuarioServiceImpl extends AbstractService implements UsuarioService {

    @Autowired
    private UsuarioDao usuDao;
    
    public UsuarioServiceImpl() {
        super();
    }

    @Override
    public Result<Object[]> getUsuarioRol(String usuario, String clave) {
//    public Result<UsuarioRol> getUsuarioRol(String usuario, String clave) {
//        UsuarioRol usuRol = usuDao.getUsuarioRol(usuario, clave);
        Object[] usuRol = usuDao.getUsuarioRol(usuario, clave);
        if ( usuRol != null ) {
            return ResultFactory.getSuccessResult(usuRol);
        } else {
            return ResultFactory.getFailResult(NOT_FOUND);
        }
    }
}