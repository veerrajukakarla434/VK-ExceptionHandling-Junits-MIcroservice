package com.vkakarla.exceptionhandling.junits.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	SERVICE_001, SERVICE_002, SERVICE_003,SERVICE_004,SERVICE_005;

	public static HttpStatus httpStatusCode(ErrorCode errorCode) {

		HttpStatus statusCode;
		switch (errorCode) {
		case SERVICE_001:
		case SERVICE_005:	
			statusCode = HttpStatus.BAD_REQUEST;
			break;
		case SERVICE_002:
		case SERVICE_003:
			statusCode = HttpStatus.NOT_FOUND;
			break;
		default:
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		}
		return statusCode;
	}

}
