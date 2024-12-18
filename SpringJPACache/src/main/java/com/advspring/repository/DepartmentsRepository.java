package com.advspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advspring.entity.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
	@Query("from Departments d where d.departmentId = :departmentId")
	Departments departmentsBul(int departmentId);

	Departments findByDepartmentName(String name);
}
