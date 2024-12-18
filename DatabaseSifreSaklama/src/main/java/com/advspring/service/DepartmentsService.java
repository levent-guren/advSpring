package com.advspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advspring.entity.Departments;
import com.advspring.repository.DepartmentsRepository;

@Service
public class DepartmentsService {
	@Autowired
	private DepartmentsRepository departmentsRepository;

	public List<Departments> getAllDepartments() {
		return departmentsRepository.findAll();
	}

}
