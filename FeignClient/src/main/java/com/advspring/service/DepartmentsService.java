package com.advspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advspring.dto.DepartmentRequestDTO;
import com.advspring.dto.DepartmentsResponseDTO;
import com.advspring.feign.DepartmentFeign;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentsService {
	private final DepartmentFeign departmentFeign;

	public DepartmentsResponseDTO saveDepartments(DepartmentRequestDTO departments) {
		return departmentFeign.saveDepartments(departments);
	}

	public List<DepartmentsResponseDTO> getAllDepartments() {
		return departmentFeign.getAllDepartments();
	}

	public void deleteDepartments(int departmentId) {
		departmentFeign.deleteDepartments(departmentId);
	}

}
