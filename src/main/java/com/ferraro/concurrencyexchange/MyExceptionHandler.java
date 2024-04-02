package com.ferraro.concurrencyexchange;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

   @ExceptionHandler(IllegalStateException.class)
   public ResponseEntity<String> handleException(IllegalStateException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sorry we are unable to process your request, try again later.");
    }
}
