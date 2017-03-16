package com.fabrica.sisgenefac.dao;

import com.fabrica.sisgenefac.domain.Usuario;
import com.fabrica.sisgenefac.transformers.UsuarioRol;
import java.util.List;

/**
 * @author  : Ledis Rivera Changra
 * @date    : Martes 07/03/2017 (12:18 p.m.)
 */

public interface UsuarioDao extends GenericDao<Usuario, String> {

//    public UsuarioRol getUsuarioRol(String usuario, String clave);
    public Object[] getUsuarioRol(String usuario, String clave);
    
}