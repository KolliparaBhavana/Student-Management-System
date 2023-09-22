package com.example.sms.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository sr;
	
	public StudentServiceImpl(StudentRepository sr) {
		super();
		this.sr = sr;
	}

	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
	}

	@Override
	public Student saveStudent(Student s) {
		// TODO Auto-generated method stub
		return sr.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		return sr.save(s);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		sr.deleteById(id);
	}

	


}
