package com.vkakarla.exceptionhandling.junits.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;
	
	private String shortMessage;      
	
	private String detailedMessage; 
	
    private HttpStatus status;
	
    Object[] args = null;
    


	public ServiceException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	
	public ServiceException(ErrorCode errorCode, Object[] args) {
	    this.errorCode = errorCode;
	    this.args = args;
	  }


	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}


	public String getShortMessage() {
		return shortMessage;
	}


	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}


	public String getDetailedMessage() {
		return detailedMessage;
	}


	public void setDetailedMessage(String detailedMessage) {
		this.detailedMessage = detailedMessage;
	}



	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public Object[] getArgs() {
		return args;
	}


	public void setArgs(Object[] args) {
		this.args = args;
	}

}
