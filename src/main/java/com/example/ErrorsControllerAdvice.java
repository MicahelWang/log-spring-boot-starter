package com.example;

import com.example.domain.ExceptionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorsControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ErrorsControllerAdvice.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ExceptionResult errorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("enter error-handler",e);
        ExceptionResult result = new ExceptionResult(req, e);
        return result;
    }
}
