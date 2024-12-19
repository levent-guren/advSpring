package com.advspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advspring.entity.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
	public List<Employees> findByFirstNameContaining(String adi);
}
