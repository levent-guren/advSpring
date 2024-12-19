package com.advspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advspring.dto.AllEmployeesResponseDTO;
import com.advspring.dto.EmpsByNameRequestDTO;
import com.advspring.feign.EmployeesFeign;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesService {
	private final EmployeesFeign employeesFeign;

	public List<AllEmployeesResponseDTO> getAllEmployees() {
		return employeesFeign.getAllEmployees();
	}

	public List<AllEmployeesResponseDTO> getEmployeesByName(EmpsByNameRequestDTO dto) {
		return employeesFeign.getAllEmployeesByName(dto);
	}
}
