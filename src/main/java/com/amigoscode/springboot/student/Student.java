package com.amigoscode.springboot.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	@Transient
	private Integer age;

	public Student() {

	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param dob
	 * @param age
	 */
	public Student(Long id, String name, String email, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	/**
	 * @param name
	 * @param email
	 * @param dob
	 * @param age
	 */
	public Student(String name, String email, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.dob = dob;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}

}
