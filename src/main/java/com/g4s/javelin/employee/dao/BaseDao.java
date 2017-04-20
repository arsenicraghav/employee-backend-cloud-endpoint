package com.g4s.javelin.employee.dao;

import com.googlecode.objectify.Key;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseDao<T, ID extends Serializable> extends CrudRepository<T, ID> {

    T findByKey(Key<T> key);
}
