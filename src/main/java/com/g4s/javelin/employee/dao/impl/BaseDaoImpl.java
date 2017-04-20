package com.g4s.javelin.employee.dao.impl;

import com.g4s.javelin.employee.dao.BaseDao;
import com.g4s.javelin.employee.dao.DaoManager;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

public class BaseDaoImpl<T> implements BaseDao<T, String> {

    private final DaoManager DAO_MANAGER = DaoManager.getInstance();
    private Class<T> entityClass;

    public BaseDaoImpl(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public <S extends T> S save(S s) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        ofy.save()
           .entity(s)
           .now()
           .getId();
        return s;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        //TODO: Implement when needed
        return null;
    }

    @Override
    public T findOne(String s) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load()
                  .type(entityClass)
                  .id(s)
                  .now();
    }

    @Override
    public T findByKey(Key<T> key) {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load().key(key).now();
    }

    @Override
    public boolean exists(String s) {
        //TODO: Implement when needed
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        final Objectify ofy = DAO_MANAGER.getObjectify();
        return ofy.load()
                  .type(entityClass)
                  .list();

    }

    @Override
    public Iterable<T> findAll(Iterable<String> iterable) {
        //TODO: Implement when needed
        return null;
    }

    @Override
    public long count() {
        //TODO: Implement when needed
        return 0;
    }

    @Override
    public void delete(String s) {
        //TODO: Implement when needed
    }

    @Override
    public void delete(T t) {
        //TODO: Implement when needed
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        //TODO: Implement when needed
    }

    @Override
    public void deleteAll() {
        //TODO: Implement when needed
    }
}
