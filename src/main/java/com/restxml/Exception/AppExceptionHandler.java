package com.restxml.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value =Exception.class)
	public ResponseEntity<ErrorInfo> globalError (Exception e){
		String message = e.getMessage();
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCode("XYZ10213");
		errorInfo.setErrormsg(message);
		errorInfo.setWhen(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);	
	}
}
