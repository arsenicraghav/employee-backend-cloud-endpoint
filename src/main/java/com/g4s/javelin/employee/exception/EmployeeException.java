package com.g4s.javelin.employee.exception;

import com.google.api.server.spi.ServiceException;

/**
 * Created by sromares on 3/15/16.
 */
public class EmployeeException extends ServiceException {

    public EmployeeException(int statusCode, String message) {
        super(statusCode, message);
    }

}