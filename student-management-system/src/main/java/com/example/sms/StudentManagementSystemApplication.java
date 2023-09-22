package com.example.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository sr;
	@Override
	public void run(String... args) throws Exception {
		//TODO Auto-generated method stub
		Student s1=new Student("V","K","vk@gmail.com",9.21);
		sr.save(s1);
		Student s2=new Student("B","K","bk@gmail.com",9.22);
		sr.save(s2);
		Student s3=new Student("J","K","jk@gmail.com",9.23);
		sr.save(s3);
		
		
		
	}

}
