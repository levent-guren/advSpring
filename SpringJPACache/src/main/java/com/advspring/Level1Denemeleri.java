package com.advspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.advspring.entity.Departments;
import com.advspring.repository.DepartmentsRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Level1Denemeleri implements CommandLineRunner {
	private final DepartmentsRepository departmentsRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		level1CacheTest3();
	}

	public void level1CacheTest() {
		Departments d1 = departmentsRepository.findById(100).get();
		Departments d2 = departmentsRepository.findById(100).get();
		// Metodun başına @Transactional yazarak connection'ı kapatmadığımızda Level 1
		// cache kullanılıyor ve aynı kayıt ikinci defa okunmuyor.
		System.out.println(d1);
		System.out.println(d2);
	}

	public void level1CacheTest2() {
		Departments d1 = departmentsRepository.departmentsBul(100);
		Departments d2 = departmentsRepository.departmentsBul(100);
		// findById yerine kendi yazdığımız Query ile çalıştığımızda sonuçlar cache'e
		// atılmıyor. Query'ler her seferinde tekrar çalıştırılıyorlar.
		System.out.println(d1);
		System.out.println(d2);
	}

	public void level1CacheTest3() {
		Departments d1 = departmentsRepository.findByDepartmentName("Administration");
		Departments d2 = departmentsRepository.findByDepartmentName("Administration");
		// findById yerine kendi yazdığımız metodları kullandığımızda da sonuçlar
		// cache'e atılmıyor. Query'ler her seferinde tekrar çalıştırılıyorlar.
		System.out.println(d1);
		System.out.println(d2);
	}

}
