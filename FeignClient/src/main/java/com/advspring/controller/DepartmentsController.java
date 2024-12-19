package com.advspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.DepartmentRequestDTO;
import com.advspring.dto.DepartmentsResponseDTO;
import com.advspring.dto.GlobalResponse;
import com.advspring.service.DepartmentsService;

@RestController
public class DepartmentsController {
	@Autowired
	private DepartmentsService departmentsService;

	@PostMapping("/dept")
	public ResponseEntity<DepartmentsResponseDTO> saveDepartments(@RequestBody DepartmentRequestDTO dto) {
		DepartmentsResponseDTO result = departmentsService.saveDepartments(dto);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/dept/{id}")
	public ResponseEntity<GlobalResponse> deleteDepartments(@PathVariable int id) {
		departmentsService.deleteDepartments(id);
		return ResponseEntity.ok(new GlobalResponse());
	}

	@GetMapping("/dept")
	public ResponseEntity<List<DepartmentsResponseDTO>> getAllDepartments() {
		List<DepartmentsResponseDTO> result = departmentsService.getAllDepartments();
		return ResponseEntity.ok(result);
	}
}
