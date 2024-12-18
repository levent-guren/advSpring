package com.advspring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.advspring.entity.Employees;
import com.advspring.repository.EmployeesRepository;

import jakarta.transaction.Transactional;

public class EmployeesTest implements CommandLineRunner {
	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Employees emp = employeesRepository.findById(100).orElseThrow();
		System.out.println(emp);
		System.out.println(emp.getDepartments().getDepartmentName());
		emp.getDepartments().getEmployeess().forEach(System.out::println);
	}

}
