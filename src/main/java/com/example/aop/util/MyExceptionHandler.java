package com.example.aop.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        System.out.println(e.getMessage());
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> allErrors = ex.getAllErrors();
            ObjectError error = allErrors.get(0);
            String defaultMessage = error.getDefaultMessage();
            return defaultMessage;
        } else {
            return "error";
        }
    }
}

