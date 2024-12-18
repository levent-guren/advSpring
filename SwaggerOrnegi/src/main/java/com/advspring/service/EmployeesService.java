package com.advspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advspring.entity.Employees;
import com.advspring.repository.EmployeesRepository;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesRepository employeesRepository;

	public List<Employees> getAllEmployees() {
		List<Employees> sonuc = employeesRepository.findAll();
		return sonuc;
	}

	public List<Employees> getEmployeesByName(String name) {
		List<Employees> sonuc = employeesRepository.findByFirstNameContaining(name);
		return sonuc;
	}
}
