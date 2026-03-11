package com.lpu.mobileApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFounddException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotFoundExcep(ResourceNotFounddException excep) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidExcep(MethodArgumentNotValidException excep) {
		Map<String, String> map = new HashMap<String, String>();
		excep.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllExceptions(Exception excep) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", excep.getMessage());
		return map;
	}
}
