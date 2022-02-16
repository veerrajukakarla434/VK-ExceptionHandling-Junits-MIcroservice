package com.vkakarla.exceptionhandling.junits.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.exceptionhandling.junits.entities.Employee;
import com.vkakarla.exceptionhandling.junits.exception.ErrorCode;
import com.vkakarla.exceptionhandling.junits.exception.ServiceException;
import com.vkakarla.exceptionhandling.junits.repo.EmployeeRepository;
import com.vkakarla.exceptionhandling.junits.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(long id) throws ServiceException{
		Employee empResponse = null;
		
		empResponse = employeeRepository.getEmbloyeById(id);

		if (empResponse == null) {
			throw new ServiceException(ErrorCode.SERVICE_002, new Object[]{id});
			
		}
		return empResponse;
	}

	
	

}
