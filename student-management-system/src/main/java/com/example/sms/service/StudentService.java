package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;


public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student s);
	Student updateStudent(Student s);
	Student getStudentById(Long id);
	void deleteStudentById(Long id);
	
}
