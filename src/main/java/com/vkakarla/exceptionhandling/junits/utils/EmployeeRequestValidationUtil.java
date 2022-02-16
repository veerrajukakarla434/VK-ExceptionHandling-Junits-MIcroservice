package com.vkakarla.exceptionhandling.junits.utils;

import org.springframework.stereotype.Component;

import com.vkakarla.exceptionhandling.junits.exception.ErrorCode;
import com.vkakarla.exceptionhandling.junits.exception.ServiceException;

@Component
public class EmployeeRequestValidationUtil {

	public void validateEmployeeId(long id)throws ServiceException {
		if(id <= 0) {
			throw new ServiceException(ErrorCode.SERVICE_001, new Object[] {id}); 
		 }
	}
	
}