package com.leanstacks.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanstacks.ws.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
