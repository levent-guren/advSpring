package com.advspring.entity;

import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = { "employeess" })
@EqualsAndHashCode(exclude = { "employeess" })
@Cacheable
public class Departments {
	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq1")
	@SequenceGenerator(sequenceName = "departments_seq", name = "dep_seq1", allocationSize = 10)
	private int departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "manager_id")
	private Integer managerId;

	@Column(name = "location_id")
	private Integer locationId;

	@OneToMany(mappedBy = "departments")
	private List<Employees> employeess;
}
