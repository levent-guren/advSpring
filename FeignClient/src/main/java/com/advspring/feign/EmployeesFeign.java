package com.advspring.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.advspring.dto.AllEmployeesResponseDTO;
import com.advspring.dto.EmpsByNameRequestDTO;

@FeignClient(name = "EmployeesFeign", url = "http://localhost:8080", path = "/")
public interface EmployeesFeign {
	@GetMapping("/")
	public List<AllEmployeesResponseDTO> getAllEmployees();

	@PostMapping("/emp")
	public List<AllEmployeesResponseDTO> getAllEmployeesByName(@RequestBody EmpsByNameRequestDTO dto);
}
