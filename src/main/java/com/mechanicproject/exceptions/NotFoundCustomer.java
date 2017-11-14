package com.mechanicproject.exceptions;

import org.springframework.security.core.AuthenticationException;

public class NotFoundCustomer extends AuthenticationException {

    public NotFoundCustomer(String msg, Throwable t) {
        super(msg, t);
    }

    public NotFoundCustomer(String msg) {
        super(msg);
    }
}
