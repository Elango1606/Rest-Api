package spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.hibernate.DAO.DAOInterface;
import spring.hibernate.entity.Student;

@Service
public class ServiceImp implements ServiceInterface 
{
	@Autowired
	DAOInterface repository;
	
	@Override
	@Transactional
	public List<Student> getCustomer() 
	{		
		return repository.getStudent();
	}

	@Override
	@Transactional
	public Student getStudent(int id){
		// TODO Auto-generated method stub
		Student data =  repository.getIndivStudent(id);
		if(data == null) {
			throw new RuntimeException("Null Value");
		}
		
		return data;
	}

	@Override
	@Transactional
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		 repository.insertOrUpdate(student);

	}

	@Override
	@Transactional
	public void delete(int id) {
		repository.delete(id);
		
	}

}
