package com.fabrica.sisgenefac.dao;

public interface GenericDao<T, ID> {

    public T find(ID id);

    public void persist(T obj);

    public T merge(T obj);

    public void remove(T obj);
    
    public void eliminar(T obj);
}
