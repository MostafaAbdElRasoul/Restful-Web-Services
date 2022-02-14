package com.spring.config.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.StudentException;
import com.spring.model.Student;

//http://localhost:8082/restful
@RestController
@RequestMapping("/main2")
//http://localhost:8082/restful/main2
public class MainController2 {
	private List<Student> students = new ArrayList<Student>();

	@PostConstruct
	public void start() {
		Student s1 = new Student(1, "mosta", "0101");
		Student s2 = new Student(2, "momo", "0102");
		Student s3 = new Student(3, "mostafafafa", "0103");
		Student s4 = new Student(4, "mosalah", "0104");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
	}

	// http://localhost:8082/restful/main2/getStudent/1
	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		if (id <= 0 || id > students.size()) {
			throw new StudentException("Students not found .. id : " + id);
		}
		return students.get(id - 1);
	}
}
