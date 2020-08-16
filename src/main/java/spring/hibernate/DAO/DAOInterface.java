package spring.hibernate.DAO;

import java.util.List;

import spring.hibernate.entity.Student;

public interface DAOInterface 
{
	public List<Student> getStudent();
	public Student getIndivStudent(int id);
	public void insertOrUpdate(Student student);
	public void delete(int id);
}
