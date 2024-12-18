package com.advspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.advspring.entity.Departments;
import com.advspring.repository.DepartmentsRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Level2Denemeleri implements CommandLineRunner {
	private final DepartmentsRepository departmentsRepository;

	@Override
	public void run(String... args) throws Exception {
		level2CacheTest1();
	}

	private void level2CacheTest1() {
		Departments d1 = departmentsRepository.findByDepartmentName("Administration");
		Departments d2 = departmentsRepository.findByDepartmentName("Administration");
		System.out.println(d1);
		System.out.println(d2);
	}

	public void level2CacheTest2() {
		Departments d1 = departmentsRepository.findById(100).get();
		Departments d2 = departmentsRepository.findById(100).get();
		// findById metodu cache kullanırken artık level 2 cache'i kullanıyor. Ayrı
		// connection'larda bile cache işe yarıyor.
		System.out.println(d1);
		System.out.println(d2);
	}

	public void level2CacheTest3() {
		Departments d1 = departmentsRepository.departmentsBul(100);
		Departments d2 = departmentsRepository.departmentsBul(100);

		System.out.println(d1);
		System.out.println(d2);
	}
}
