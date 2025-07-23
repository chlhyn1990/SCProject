package com.SCSystem.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.SCSystem.dto.ApiResult;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleException(Exception ex) {
    	if(ex.getClass().equals(MethodArgumentNotValidException.class)) {
            String apiResult = "result="+ApiResult.SUCCESS+"&result_msg="+ApiResult.SUCCESS_MSG;
	        return new ResponseEntity<>(
	        		apiResult,
	                HttpStatus.BAD_REQUEST
	        );
    	}else {
            String apiResult = "result="+ApiResult.SUCCESS+"&result_msg="+ApiResult.SUCCESS_MSG;
	        return new ResponseEntity<>(
	        		apiResult,
	                HttpStatus.BAD_REQUEST
	        );
    	}
    	
    }
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
    	ex.printStackTrace();
        String apiResult = "result="+ApiResult.SUCCESS+"&result_msg="+ApiResult.SUCCESS_MSG;
        return new ResponseEntity<>(
        		apiResult,
                HttpStatus.BAD_REQUEST
        );
    }
    
}