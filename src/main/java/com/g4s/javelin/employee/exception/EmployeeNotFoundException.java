package com.g4s.javelin.employee.exception;

/**
 * Created by sromares on 3/17/16.
 */
public class EmployeeNotFoundException extends EmployeeException {

    public EmployeeNotFoundException(int statusCode, String message) {
        super(statusCode, message);
    }
}
