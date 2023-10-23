package net.rahmi.springboottutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
	private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	public String hello() 
	{
		return "Hello Rachid !";
	}
	
	@PostMapping("log-test")
	public void logTest()
	{
	    LOGGER.trace("Trace Log");
	    LOGGER.debug("Debug Log");
	    LOGGER.info("Info Log");
	    LOGGER.warn("Warn Log");
	    LOGGER.error("Error Log");
	}
	
	@PostMapping("/exception")
	public void exceptionTest() throws Exception 
	{
	    throw new Exception();
	}
	
//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) 
//	{
//	    HttpHeaders responseHeaders = new HttpHeaders();
//
//	    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//	    
//	    LOGGER.info(e.getLocalizedMessage());
//	    LOGGER.info("Controller Appel à ExceptionHandler ");
//
//	    Map<String, String> map = new HashMap<>();
//	    map.put("error type", httpStatus.getReasonPhrase());
//	    map.put("code", "400");
//	    map.put("message", "Une erreur s'est produite");
//
//	    return new ResponseEntity<>(map, responseHeaders, httpStatus);
//	}

}
