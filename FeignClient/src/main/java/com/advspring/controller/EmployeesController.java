package com.advspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.AllEmployeesResponseDTO;
import com.advspring.dto.EmpsByNameRequestDTO;
import com.advspring.service.EmployeesService;

@RestController
public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;

	@GetMapping("/")
	public ResponseEntity<List<AllEmployeesResponseDTO>> getAllEmployees() {
		List<AllEmployeesResponseDTO> result = employeesService.getAllEmployees();
		return ResponseEntity.ok(result);
	}

	@PostMapping("/emp")
	public ResponseEntity<List<AllEmployeesResponseDTO>> getAllEmployeesByName(@RequestBody EmpsByNameRequestDTO dto) {
		List<AllEmployeesResponseDTO> result = employeesService.getEmployeesByName(dto);
		return ResponseEntity.ok(result);
	}

}
