package com.demo.Ex42.w3.advice;

import com.demo.Ex42.w3.DTO.Api;

import com.demo.Ex42.w3.exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdviseHandler {

    Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Api> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        logger.info("message");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Api> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        logger.info("message");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        logger.info("message");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Api> handleException(Exception exception){
        logger.error(exception.getCause().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("SERVER ERROR PLS TRY AGAIN LATER!",500));
    }

}
