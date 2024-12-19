package com.advspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.advspring.entity.Departments;
import com.advspring.repository.DepartmentsRepository;

@Service
public class DepartmentsService {
	@Autowired
	private DepartmentsRepository departmentsRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Departments saveDepartments(Departments departments) {
		Departments dept = departmentsRepository.save(departments);
		dept.getEmployeess(); // kaydedilen departments bilgisinin employees'leri okunacağından şimdiden
								// okuyup içine koyuyoruz
		return dept;
	}

	public List<Departments> getAllDepartments() {
		return departmentsRepository.findAll();
	}

	@Transactional
	public void deleteDepartments(int departmentId) {
//		Departments d = departmentsRepository.findById(departmentId).get();
		departmentsRepository.deleteById(departmentId);
	}

}
