package com.advspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advspring.entity.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
}
