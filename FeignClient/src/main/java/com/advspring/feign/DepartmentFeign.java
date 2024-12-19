package com.advspring.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.advspring.dto.DepartmentRequestDTO;
import com.advspring.dto.DepartmentsResponseDTO;
import com.advspring.dto.GlobalResponse;

@FeignClient(name = "DepartmentFeign", url = "http://localhost:8080", path = "/")
public interface DepartmentFeign {
	@PostMapping("/dept")
	public DepartmentsResponseDTO saveDepartments(@RequestBody DepartmentRequestDTO dto);

	@DeleteMapping("/dept/{id}")
	public GlobalResponse deleteDepartments(@PathVariable int id);

	@GetMapping("/dept")
	public List<DepartmentsResponseDTO> getAllDepartments();
}
