package com.vkakarla.exceptionhandling.junits.service;

import com.vkakarla.exceptionhandling.junits.entities.Employee;
import com.vkakarla.exceptionhandling.junits.exception.ServiceException;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(long id)throws ServiceException;
	
	

}
