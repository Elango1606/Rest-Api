package spring.hibernate.service;

import java.util.List;

import spring.hibernate.entity.Student;

public interface ServiceInterface 
{
	public List<Student> getCustomer();
	
	public Student getStudent(int id);
	
	public void insertStudent(Student student);

	public void delete(int id);
}
