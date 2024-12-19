package com.advspring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.DepartmentsResponseDTO;
import com.advspring.entity.Departments;
import com.advspring.service.DepartmentsService;

@RestController
public class DepartmentsController {
	@Autowired
	private DepartmentsService departmentsService;
	@Autowired
	@Qualifier("modelMapperResponse")
	private ModelMapper mapper;

	@GetMapping("/dept")
	@CrossOrigin(originPatterns = "http://localhost:8080")
	public ResponseEntity<List<DepartmentsResponseDTO>> getAllDepartments() {
		List<Departments> departments = departmentsService.getAllDepartments();
		List<DepartmentsResponseDTO> result = departments.stream().map(d -> mapper.map(d, DepartmentsResponseDTO.class))
				.toList();
		return ResponseEntity.ok(result);
	}
}
