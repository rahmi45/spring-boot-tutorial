package net.rahmi.springboottutorial.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpringTutorialExceptionHandler 
{
	private final Logger LOGGER = LoggerFactory.getLogger(SpringTutorialExceptionHandler.class);

	  @ExceptionHandler(value = Exception.class)
	  public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
	    HttpHeaders responseHeaders = new HttpHeaders();

	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	    LOGGER.info("Appel Advice ExceptionHandler");

	    Map<String, String> map = new HashMap<>();
	    map.put("error type", httpStatus.getReasonPhrase());
	    map.put("code", "400");
	    map.put("message", "Une erreur s'est produite");

	    return new ResponseEntity<>(map, responseHeaders, httpStatus);
	  }
	  
	  @ExceptionHandler(value = SpringTutorialException.class)
	  public ResponseEntity<Map<String, String>> ExceptionHandler(SpringTutorialException e) {
	    HttpHeaders responseHeaders = new HttpHeaders();

	    Map<String, String> map = new HashMap<>();
	    map.put("error type", e.getHttpStatusType());
	    map.put("error code", Integer.toString(e.getHttpStatusCode())); 
	    map.put("message", e.getMessage());

	    return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
	  }
}
