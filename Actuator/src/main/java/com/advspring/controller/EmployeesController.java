package com.advspring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advspring.dto.AllEmployeesResponseDTO;
import com.advspring.dto.EmpsByNameRequestDTO;
import com.advspring.entity.Employees;
import com.advspring.service.EmployeesService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;

	private final ModelMapper mapperResponse;

	public EmployeesController(@Qualifier("modelMapperResponse") ModelMapper mapperResponse) {
		this.mapperResponse = mapperResponse;
	}

	@GetMapping("/")
	public ResponseEntity<List<AllEmployeesResponseDTO>> getAllEmployees() {
		List<Employees> emps = employeesService.getAllEmployees();
//		List<AllEmployeesResponseDTO> result = emps.stream().map(e -> {
//			AllEmployeesResponseDTO dto = new AllEmployeesResponseDTO();
//			dto.setEmployeeId(e.getEmployeeId());
//			dto.setFirstName(e.getFirstName());
//			dto.setLastName(e.getLastName());
//			return dto;
//		}).toList();
		log.error("getAllEmployees");
		List<AllEmployeesResponseDTO> result = emps.stream()
				.map(e -> mapperResponse.map(e, AllEmployeesResponseDTO.class)).toList();
		return ResponseEntity.ok(result);
	}

	@PostMapping("/emp")
	public ResponseEntity<List<AllEmployeesResponseDTO>> getAllEmployeesByName(@RequestBody EmpsByNameRequestDTO dto) {
		List<Employees> emps = employeesService.getEmployeesByName(dto.getAdi());
		List<AllEmployeesResponseDTO> result = emps.stream()
				.map(e -> mapperResponse.map(e, AllEmployeesResponseDTO.class)).toList();
		return ResponseEntity.ok(result);
	}

}
