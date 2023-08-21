package ru.oorzhak.electronicsstore.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.oorzhak.electronicsstore.exception.ProductWithIdNotExists;
import ru.oorzhak.electronicsstore.exception.WindowWithIdNotExists;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({
            ProductWithIdNotExists.class,
            WindowWithIdNotExists.class
    })
    public ResponseEntity<?> handleExceptions(Exception e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
