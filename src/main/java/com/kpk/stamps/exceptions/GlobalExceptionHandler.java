package com.kpk.stamps.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConcernNotFoundexception.class)
    public ResponseEntity<ErrorResponse> handleConcernNotFoundException(ConcernNotFoundexception ex){

        ErrorResponse error=new ErrorResponse(ex.getMessage(),404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e){

        ErrorResponse error=new ErrorResponse("Something went wrong",500);
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CostingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCostingNotFoundException(CostingNotFoundException ex){

        ErrorResponse error =new ErrorResponse(ex.getMessage(), 404);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }




}
