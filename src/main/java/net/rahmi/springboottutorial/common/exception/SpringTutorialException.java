package net.rahmi.springboottutorial.common.exception;

import org.springframework.http.HttpStatus;

import net.rahmi.springboottutorial.common.Constants;

public class SpringTutorialException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -27861716212863358L;
	
	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;

	public SpringTutorialException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message)
	{
	    super(exceptionClass.toString() + message);
	    this.exceptionClass = exceptionClass;
	    this.httpStatus = httpStatus;
	}
	
	public Constants.ExceptionClass getExceptionClass() 
	{
	    return exceptionClass;
	}
	
	public int getHttpStatusCode() 
	{
	    return httpStatus.value();
	}
	
	public String getHttpStatusType() 
	{
	    return httpStatus.getReasonPhrase();
	}
	
	public HttpStatus getHttpStatus()
	{
	    return httpStatus;
	}

}
