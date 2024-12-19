package com.advspring.dto;

import lombok.Data;

@Data
public class DepartmentRequestDTO {
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}