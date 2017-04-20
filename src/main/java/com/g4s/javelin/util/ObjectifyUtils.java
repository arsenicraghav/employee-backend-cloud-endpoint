package com.g4s.javelin.util;

import com.googlecode.objectify.Key;

public class ObjectifyUtils {

    public static <T> Key<T> createKey(Class<T> entityClass, String id) {
        return Key.create(entityClass, id);
    }
}
