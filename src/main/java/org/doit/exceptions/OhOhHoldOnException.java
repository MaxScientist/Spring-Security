package org.doit.exceptions;

import org.springframework.security.core.AuthenticationException;

public class OhOhHoldOnException extends AuthenticationException {

    public OhOhHoldOnException(String message, Throwable cause) {
        super(message, cause);
    }

    public OhOhHoldOnException(String message) {
        super(message);
    }
}
