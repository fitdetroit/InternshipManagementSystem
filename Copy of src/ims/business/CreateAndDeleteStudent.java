package ims.business;

import java.util.List;

//import ims.data.Application;
import ims.data.Company;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateAndDeleteStudent {
	
	
	private SessionFactory sessionFactory;
	
	// this method is used to create students
	public void createStudentProfiles(User user)
	{
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		session2.save(user);
		session2.beginTransaction().commit();
		session2.close();
	}
	
	
	
	
	// this method is used to delete specific student form system
	public void deleteStudentProfile(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student = (Student)session.get(Student.class, userName);
		if(student!=null)
		session.delete(student);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		User user = (User)session2.get(User.class, userName);
		session2.delete(user);
		session2.getTransaction().commit();
		session2.close();
		

	}	
		

	
	
	
// this method is used to delete all student form system	
	public void deleteAllStudentFromSystem()
	{
		//student delet form student table
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Student";
		Query query = session.createQuery(SQL_QUERY);
		List<Student> list = ((org.hibernate.Query) query).list();
		
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		for(int x=0;x<list.size();x++)
		{
			Student student = (Student)session.get(Student.class, list.get(x).getStudentUserName());
			if(student!=null)
			session2.delete(student);
			
		}
		session2.getTransaction().commit();
		session2.close();
		
		//student delet from User table
		Session session3 = getSessionFactory().openSession();
		String SQL_QUERY2 = "from User u where  u.type='s'";
		Query query2 = session3.createQuery(SQL_QUERY2);
		List<User> list2 = ((org.hibernate.Query) query2).list();
		
		Session session4 = getSessionFactory().openSession();
		session4.beginTransaction();
		for(int x=0;x<list2.size();x++)
		{
			User user = (User)session.get(User.class, list2.get(x).getUserName());
			if(user.getUserName()!=null)
			session4.delete(user);
			
		}
		session4.getTransaction().commit();
		session4.close();
		
		
		
		

		
		
		
		
	}


	
	
	
	
	// getters and setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
