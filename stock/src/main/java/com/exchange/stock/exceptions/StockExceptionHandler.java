package com.exchange.stock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockExceptionHandler {

    @ExceptionHandler
    public ResponseEntity stockException(StockException theStockException){
        CustomStockResponse theResponse = new CustomStockResponse();
        theResponse.setStatus(HttpStatus.NO_CONTENT.value());
        theResponse.setMessage(theStockException.getMessage());
        theResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity(theResponse, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity genericException(Exception theException){
        CustomStockResponse theResponse = new CustomStockResponse();
        theResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        theResponse.setMessage(theException.getMessage());
        theResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity(theResponse, HttpStatus.BAD_REQUEST);
    }
}
