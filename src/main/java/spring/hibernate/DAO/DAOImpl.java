package spring.hibernate.DAO;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.hibernate.entity.Student;

@Repository
public class DAOImpl implements DAOInterface {
	
	private Logger logger = Logger.getLogger(DAOImpl.class.getName());

	@Autowired
	SessionFactory session;
	
	@Override
	public List<Student> getStudent() {
		
		Session currentSession = session.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Student> list = currentSession.createQuery("from Student").getResultList();
		
		logger.info("The list has " + list.size());
		
		if(list.isEmpty()) {
			list.add(null);
		}
		
		return list;
	}

	@Override
	public Student getIndivStudent(int id) 
	{
		Session currentSession = session.getCurrentSession();
		
		Student data = currentSession.get(Student.class, id);
		
		logger.info("Data is " + data);
		return data;
	}

	@Override
	public void insertOrUpdate(Student student) {
		
		Session currentSession = session.getCurrentSession();
		
		currentSession.saveOrUpdate(student);
		
	}

	@Override
	public void delete(int id) {
		Session currentSession = session.getCurrentSession();
		
		Student data = currentSession.get(Student.class, id);
		currentSession.delete(data);
		
	}

}
