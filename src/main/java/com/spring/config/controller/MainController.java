package com.spring.config.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.StudentException;
import com.spring.model.Student;
import com.spring.model.StudentError;

// http://localhost:8082/restful
@RestController
@RequestMapping("/main")
// http://localhost:8082/restful/main
public class MainController {

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

	// http://localhost:8082/restful/main/mainpage
	@GetMapping("/mainpage")
	public String mainPage() {
		return "hello mosta";
	}

	// http://localhost:8082/restful/main/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	// http://localhost:8082/restful/main/student
	@GetMapping("/student")
	public Student getStudent() {
		Student s1 = new Student(100, "one students", "011");
		return s1;
	}

	// http://localhost:8082/restful/main/getStudent/1
	@GetMapping("/getStudent/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		if(id <= 0 || id > students.size()) {
			throw new StudentException("Students not found .. id : "+id);
		}
		return students.get(id - 1);
	}

	// http://localhost:8082/restful/main/getStudentbyRequestParam?id=1
	@GetMapping("/getStudentbyRequestParam")
	public Student getStudentByIdRequestParam(@RequestParam int id) {
		if(id <= 0 || id > students.size()) {
			throw new StudentException("Students not found .. id : "+id);
		}
		return students.get(id - 1);
	}

}
