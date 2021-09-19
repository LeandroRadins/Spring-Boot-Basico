package com.amigoscode.springboot.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private StudentRepository studentRepository;

	/**
	 * @param studentRepository
	 */
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("este email ya se encuentra registrado");
		} else {
			studentRepository.save(student);
		}
		System.out.println(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("No existe un usuario con el id: " + studentId);
		} else {
			studentRepository.deleteById(studentId);
		}
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("El usuario con el id: " + studentId + " no existe"));
		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentByEmail = studentRepository.findByEmail(email);
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("Este email ya se encuentra registrado");
			} else {
				student.setEmail(email);
			}
		}
	}
}
