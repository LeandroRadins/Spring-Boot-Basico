package com.amigoscode.springboot.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

	private StudentService studentservice;

	/**
	 * @param studentservice
	 */
	@Autowired
	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@GetMapping
	public List<Student> getStudents() {

		return studentservice.getStudents();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		studentservice.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentservice.deleteStudent(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentservice.updateStudent(studentId, name, email);
	}

	/**
	 * @return the studentservice
	 */
	public StudentService getStudentservice() {
		return studentservice;
	}

	/**
	 * @param studentservice the studentservice to set
	 */
	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

}
