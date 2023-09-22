package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {
	private StudentService ss;
	public StudentController(StudentService ss) {
		super();
		this.ss = ss;
	}
	
//	handler method for list of students and return mode and view. 
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students",ss.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		//Create student object to hold student from data
		Student s=new Student();
		model.addAttribute("student",s);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
	ss.saveStudent(student);
	return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model)
	{
		model.addAttribute("student",ss.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student)
	{
		//get student from database by id
		Student existingStudent =ss.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setCgpa(student.getCgpa());
		ss.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	//handler method to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		ss.deleteStudentById(id);
		return"redirect:/students";
	}
}
