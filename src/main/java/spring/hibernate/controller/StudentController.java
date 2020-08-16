package spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.hibernate.entity.Student;
import spring.hibernate.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class StudentController 
{
	
	@Autowired
	ServiceInterface service;
	
	
	@GetMapping("/getStudent")
	public List<Student> getStudentDetail(){
		
		List<Student> student = service.getCustomer();
		
		return student;
	}
	
	@GetMapping("/getStudent/{studentId}")
	public Student getIndivStudentDetail(@PathVariable("studentId") int id) {
		Student student = service.getStudent(id);
		return student;
	}
	
	@PostMapping("/getStudent")
	public Student insertStudent(@RequestBody Student student) {
		
		student.setId(0);
		
		service.insertStudent(student);
		
		return student ;
	}
	
	@PutMapping("/getStudent")
	public Student updateStudent(@RequestBody Student student) {
		
		service.insertStudent(student);
		
		return student ;
	}

	@DeleteMapping("/getStudent/{studentId}")
	public String DeleteStudentDetail(@PathVariable("studentId") int id)  
	{
		Student student = service.getStudent(id);
		if(student == null ) {throw new RuntimeException("DATA NOT FOUND " + id );		}
		else {
			service.delete(id);
		}
		
		return "Deleted Student DATA " + id;
	}
	

}
