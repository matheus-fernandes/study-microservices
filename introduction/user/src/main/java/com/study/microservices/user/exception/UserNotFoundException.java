package com.study.microservices.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
public class UserNotFoundException extends ResponseStatusException {
    public UserNotFoundException() {
        super(NOT_FOUND, "user not found!");
        log.error(this.getMessage());
    }
}
