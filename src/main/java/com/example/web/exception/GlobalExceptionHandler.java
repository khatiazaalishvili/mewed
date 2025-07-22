package com.example.web.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionBody> handleValidation(MethodArgumentNotValidException exception,
                                                          HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : exception.getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }
        ExceptionBody body = new ExceptionBody(
                errors,
                request.getRequestURI(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionBody> handleResponseStatusException(ResponseStatusException exception,
                                                                       HttpServletRequest request) {
        ExceptionBody body = new ExceptionBody(
                List.of(exception.getReason()),
                request.getRequestURI(),
                LocalDateTime.now(),
                exception.getStatusCode().value()
        );
        return ResponseEntity.status(exception.getStatusCode()).body(body);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionBody> handleRuntime(RuntimeException exception,
                                                       HttpServletRequest request) {
        ExceptionBody body = new ExceptionBody(
                List.of(exception.getMessage()),
                request.getRequestURI(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
