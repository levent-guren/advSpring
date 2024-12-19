package com.advspring.dto;

import lombok.Data;

@Data
public class DepartmentsResponseDTO {
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
	private int employeeCount;
}
