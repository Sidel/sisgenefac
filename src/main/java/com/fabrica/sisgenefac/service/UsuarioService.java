package com.fabrica.sisgenefac.service;

import com.fabrica.sisgenefac.transformers.UsuarioRol;
import com.fabrica.sisgenefac.vo.Result;

/**
 *
 * @author Ledis Rivera Changra
 */
public interface UsuarioService {

//    public Result<UsuarioRol> getUsuarioRol(String usuario, String clave);
    public Result<Object[]> getUsuarioRol(String usuario, String clave);
}