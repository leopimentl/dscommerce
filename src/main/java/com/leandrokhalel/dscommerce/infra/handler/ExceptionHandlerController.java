package com.leandrokhalel.dscommerce.infra.handler;

import com.leandrokhalel.dscommerce.api.CustomError;
import com.leandrokhalel.dscommerce.api.ValidationError;
import com.leandrokhalel.dscommerce.service.exception.DatabaseException;
import com.leandrokhalel.dscommerce.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        CustomError err = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> handleResourceNotFound(DatabaseException ex, HttpServletRequest request) {
        CustomError err = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> handleMethodNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<FieldError> errors = ex.getFieldErrors();

        return ResponseEntity.badRequest()
                .body( errors.stream()
                .map(ValidationError::new).toList());
    }
}
