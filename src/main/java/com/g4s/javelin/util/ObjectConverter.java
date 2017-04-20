package com.g4s.javelin.util;

import org.modelmapper.ModelMapper;

/**
 * Created by sromares on 3/15/16.
 */
public class ObjectConverter {

    private ObjectConverter() {
    }

    /**
     * Converts the data from {@code fromObject} to the specified {@code toObject}class.
     *
     * @param fromObject The source object with data
     * @param toObject   The destination object of fromObject
     * @return The instantiated object from the {@code toObject} class with the data from {@code fromObject}.
     */
    public static <T> T convert(final Object fromObject, final Class<T> toObject) {
        return new ModelMapper().map(fromObject, toObject);
    }
}
