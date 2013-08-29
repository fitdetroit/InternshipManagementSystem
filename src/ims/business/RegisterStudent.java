package ims.business;


import java.util.List;

//import ims.data.Application;
import ims.data.Company;
import ims.data.Student;
import ims.data.StudentComplitedProjects;
import ims.data.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RegisterStudent {
	
	private SessionFactory sessionFactory;

	
	// this method is used to save student details in database in first time
	public void saveStudent(Student student)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(student);
		session.beginTransaction().commit();
		session.close();
		
	}
	
	

	

	
// this method is used to get company username from company name to save company username in application object in database	
	public String getCompanyUserName(String companyName)
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY ="from Company cm where cm.companyName='" + companyName + "'";
		Query query = session.createQuery(SQL_QUERY);
	
		List<Company> list = ((org.hibernate.Query) query).list();
		//List<String> list= ((org.hibernate.Query) query).list();
		return list.get(0).getCompanyUserName();
	}
	
	public Company getStudentAppliedCompanyObject(String companyName)
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY ="from Company cm where cm.companyName='" + companyName + "'";
		Query query = session.createQuery(SQL_QUERY);
	
		List<Company> list = ((org.hibernate.Query) query).list();
		//List<String> list= ((org.hibernate.Query) query).list();	
		
		

		
		
return list.get(0);
	
	}
			
	
	
	

	
	
	
	
	//getters and setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




}
