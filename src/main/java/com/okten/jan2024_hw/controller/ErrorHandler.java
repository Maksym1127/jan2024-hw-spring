package com.okten.jan2024_hw.controller;

import com.okten.jan2024_hw.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException e) {
        List<String> details = (e
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField().concat(" ").concat(error.getDefaultMessage()))
                .toList());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorDto.builder()
                        .details(details)
                        .build());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error ->
//                errors.put(error.getField(), error.getDefaultMessage()));
//        return ResponseEntity.badRequest().body(errors);
//    }

}