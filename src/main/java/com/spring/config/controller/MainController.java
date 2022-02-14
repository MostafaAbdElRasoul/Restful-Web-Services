package com.spring.config.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Student;
// http://localhost:8082/restful
@RestController
@RequestMapping("/main")
// http://localhost:8082/restful/main
public class MainController {
	
	// http://localhost:8082/restful/main/mainpage
	@GetMapping("/mainpage")
	public String mainPage() {
		return "hello mosta";
	}
	
	// http://localhost:8082/restful/main/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		Student s1 = new Student(1, "mosta", "0101");
		Student s2 = new Student(2, "momo", "0102");
		Student s3 = new Student(3, "mostafafafa", "0103");
		Student s4 = new Student(4, "mosalah", "0104");
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		return students;
	}
	
	// http://localhost:8082/restful/main/student
	@GetMapping("/student")
	public Student getStudent(){
		Student s1 = new Student(100, "one students", "011");
		return s1;
	}
	
}
