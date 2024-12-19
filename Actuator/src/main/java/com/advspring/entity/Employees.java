package com.advspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "employees")
@Data
@ToString(exclude = { "departments" })
@EqualsAndHashCode(exclude = { "departments" })
public class Employees {
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq1")
	@SequenceGenerator(sequenceName = "employees_seq", name = "emp_seq1", allocationSize = 1)
	private int employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Departments departments;

}
