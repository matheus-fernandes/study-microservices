package com.study.microservice.department.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
public class DepartmentNotFoundException extends ResponseStatusException {

    public DepartmentNotFoundException() {
        super(NOT_FOUND, "department not found!");
        log.error(this.getMessage());
    }
}
