package com.inditex.visibilidad.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inditex.visibilidad.core.usecase.getvisibilidad.NotFoundException;

@ControllerAdvice
public final class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    private ExceptionControllerAdvice() {
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<Object> handle(final RuntimeException exception, final WebRequest request) {
        final var httpStatus = HttpStatus.NO_CONTENT;
        final var errorAttributes = ErrorAttributes.getErrorAttributes(httpStatus, exception.getMessage(), request);
        return handleExceptionInternal(exception, errorAttributes, new HttpHeaders(), httpStatus, request);
    }
}
