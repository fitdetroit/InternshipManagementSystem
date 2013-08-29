package ims.business;

//import ims.data.Application;
import ims.data.Company;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.StudentComplitedProjects;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class ViewStudentDataSession {
	
	SessionFactory sessionFactory;
	// to get student list to company

	

// this method is used to get all student details to admin
	public List<Student> allStudentToAdmin()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Student";
		Query query = session.createQuery(SQL_QUERY);
		List<Student> list = ((org.hibernate.Query) query).list();

		return list;
		
	}
	
// this method is used to get student profile to specific student	
	public Student viewStudentToStudent(String userName)
	{

		
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, userName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x =student.getStudentOtherQulification().size();
		int y =student.getStudentComplitedProjects().size();
		int z= student.getStudentCompany().size();


		session.getTransaction().commit();
		session.close();
	
		return student;
		
	}


	
	
	// this method is used to get sutdent cv details to admin
	public Student studentCvToAdmin(String userName)
	{


		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, userName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x =student.getStudentOtherQulification().size();
		int y =student.getStudentComplitedProjects().size();
		int z= student.getStudentCompany().size();
		session.getTransaction().commit();
		session.close();
		
		return student;
		
		
	}
	// this method is used to get student cv to compnay 
	public Student studentCvToCompany(String userName)
	{

		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, userName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x =student.getStudentOtherQulification().size();
		int y =student.getStudentComplitedProjects().size();
		session.getTransaction().commit();
		session.close();
		
		return student;
		
	}
	
	public List<Student> appliedStudentToCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		int x= company.getStudentCompany().size();
		session.getTransaction().commit();
		session.close();
		
		List<Student> list= new ArrayList<Student>();
		if(company.isReceiveCv()==true)
		{
			for(StudentCompany studentAppliedCompany:company.getStudentCompany())
			{
				list.add(studentAppliedCompany.getStudent());
				
			}
			
		}
		else
		{
			list= null;
		}
		

		
		return list;
		
	}
	
	public List<Student> notSelectForInterview(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		int x= company.getStudentCompany().size();
		session.getTransaction().commit();
		session.close();
		
		List<Student> list= new ArrayList<Student>();
		if(company.isReceiveCv()==true)
		{
			for(StudentCompany studentAppliedCompany:company.getStudentCompany())
			{
				if(studentAppliedCompany.getState().equals("pending"))
				list.add(studentAppliedCompany.getStudent());
				
			}
			
		}
		else
		{
			list= null;
		}
		

		
		return list;
		
	}
	
	public List<Student> selectedForInterview(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		int x= company.getStudentCompany().size();
		session.getTransaction().commit();
		session.close();
		
		List<Student> list= new ArrayList<Student>();
		if(company.isReceiveCv()==true)
		{
			for(StudentCompany studentAppliedCompany:company.getStudentCompany())
			{
				
				if(studentAppliedCompany.getState().equals("interview"))
				{
					list.add(studentAppliedCompany.getStudent());
					
					
				}
				
				
			}
			
		}
		else
		{
			list= null;
		}
		

		
		return list;
		
	}
	
	public List<Student> selectedForInternship(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		int x= company.getStudentCompany().size();
		session.getTransaction().commit();
		session.close();
		
		List<Student> list= new ArrayList<Student>();
		if(company.isReceiveCv()==true)
		{
			for(StudentCompany studentAppliedCompany:company.getStudentCompany())
			{
				
				if(studentAppliedCompany.getState().equals("Selected"))
				{
					list.add(studentAppliedCompany.getStudent());
					
					
				}
				
				
			}
			
		}
		else
		{
			list= null;
		}
		

		
		return list;
		
	}


	
	

	
	
	
	
	
	
	
	//getters and setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
