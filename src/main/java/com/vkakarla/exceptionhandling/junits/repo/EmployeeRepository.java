package com.vkakarla.exceptionhandling.junits.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vkakarla.exceptionhandling.junits.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee getEmbloyeById(Long empId);
}
