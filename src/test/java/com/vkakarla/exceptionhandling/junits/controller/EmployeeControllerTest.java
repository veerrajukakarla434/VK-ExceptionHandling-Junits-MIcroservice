package com.vkakarla.exceptionhandling.junits.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkakarla.exceptionhandling.junits.app.Application;
import com.vkakarla.exceptionhandling.junits.entities.Employee;
import com.vkakarla.exceptionhandling.junits.exception.ErrorMessageGenerator;
import com.vkakarla.exceptionhandling.junits.exception.ServiceException;
import com.vkakarla.exceptionhandling.junits.exception.ServiceExceptionHandler;
import com.vkakarla.exceptionhandling.junits.repo.EmployeeRepository;
import com.vkakarla.exceptionhandling.junits.serviceImpl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource(locations = "classpath:application-mock.properties")
public class EmployeeControllerTest {
	
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Autowired 
	ObjectMapper objectMapper;
	
	@Autowired
	ServiceExceptionHandler serviceExceptionHandler;
	
	@Autowired
	ErrorMessageGenerator errorMessageGenerator;

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void given_ValidEmpId_when_calling_getEmployee_then_return_employeeDetails() {
		
		try {
			
			Employee employeeResponse = null;
			String empString = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("testdata/empResponse.json"), "UTF-8");
		
			employeeResponse = objectMapper.readValue(empString,new TypeReference<Employee>() {});
			
			when(employeeRepository.getEmbloyeById((long) 101)).thenReturn(employeeResponse);
			
			ResponseEntity<Object> response = employeeController.getEmployee((long)101);
			
			assertNotNull(response);
			assertEquals(HttpStatus.OK, response.getStatusCode());
		
		} catch (Exception ex) {
			
		}
		
	}
	
	
	@Test
	public void given_InValidEmpId_when_calling_getEmployee_then_return_ErrorDetails() {
		
		try {
			ResponseEntity<Object> rponse = employeeController.getEmployee((long)-101);
			
		} catch (ServiceException ex) { 
			assertNotNull(ex.getErrorCode());
		}
		
	}
	
	
	@Test
	public void given_ValidEmpIdButNoRecord_when_calling_getEmployee_then_return_ErrorDetails() {
		
		try {
			when(employeeRepository.getEmbloyeById((long) 104)).thenReturn(null);
			ResponseEntity<Object> rponse = employeeController.getEmployee((long)104);
			
		} catch (ServiceException ex) { 
			assertNotNull(ex.getErrorCode());
			//assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
			//assertEquals("Employee not found for given id 104", ex.getMessage());
		}
		
		
	}
	

}
