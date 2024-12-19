package com.advspring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.DepartmentsResponseDTO;
import com.advspring.dto.GlobalResponse;
import com.advspring.entity.Departments;
import com.advspring.service.DepartmentsService;

@RestController
public class DepartmentsController {
	@Autowired
	private DepartmentsService departmentsService;
	@Autowired
	@Qualifier("modelMapperResponse")
	private ModelMapper mapper;

	@PostMapping("/dept")
	public ResponseEntity<DepartmentsResponseDTO> saveDepartments(@RequestBody Departments dto) {
		Departments dbDept = departmentsService.saveDepartments(dto);
		DepartmentsResponseDTO result = mapper.map(dbDept, DepartmentsResponseDTO.class);
		if (dbDept.getEmployeess() != null) {
			// yeni kayıt eklemede veritabanında heniz kayıt oluşturulmadığı için
			// getEmployees() metodu boş liste değil, null döndürüyor.
			result.setEmployeeCount(dbDept.getEmployeess().size());
		}
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/dept/{id}")
	public ResponseEntity<GlobalResponse> deleteDepartments(@PathVariable int id) {
		departmentsService.deleteDepartments(id);
		return ResponseEntity.ok(new GlobalResponse());
	}

	@GetMapping("/dept")
	public ResponseEntity<List<DepartmentsResponseDTO>> getAllDepartments() {
		List<Departments> departments = departmentsService.getAllDepartments();
		List<DepartmentsResponseDTO> result = departments.stream().map(d -> {
			DepartmentsResponseDTO dto = mapper.map(d, DepartmentsResponseDTO.class);
			dto.setEmployeeCount(d.getEmployeess().size());
			return dto;
		}).toList();
		return ResponseEntity.ok(result);
	}
}
