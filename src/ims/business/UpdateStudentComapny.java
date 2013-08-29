package ims.business;

import ims.data.Company;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.StudentCompanyId;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentComapny {
	
	private SessionFactory sessionFactory;

	
	
	
	
	
	public void UpdateStudentStateToInterview(String compnayUserName,String studentUserName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, studentUserName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x= student.getStudentCompany().size();
		
		Company company =(Company)session.get(Company.class, compnayUserName);
		int y= company.getStudentCompany().size();
		
		session.getTransaction().commit();
		session.close();
		
	
		
		StudentCompanyId studentCompanyId = new StudentCompanyId();
		studentCompanyId.setStudent(student);
		studentCompanyId.setCompany(company);
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		StudentCompany studentCompany =(StudentCompany)session2.get(StudentCompany.class, studentCompanyId);
		studentCompany.setState("interview");
		session2.update(studentCompany);
		session2.getTransaction().commit();
		session2.close();
		
	
		
	}
	
	public void UpdateStudentStateToSelected(String compnayUserName,String studentUserName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, studentUserName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x= student.getStudentCompany().size();
		student.setSelected(true);
		session.update(student);
		
		Company company =(Company)session.get(Company.class, compnayUserName);
		int y= company.getStudentCompany().size();
		
		session.getTransaction().commit();
		session.close();
		
	
		
		StudentCompanyId studentCompanyId = new StudentCompanyId();
		studentCompanyId.setStudent(student);
		studentCompanyId.setCompany(company);
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		StudentCompany studentCompany =(StudentCompany)session2.get(StudentCompany.class, studentCompanyId);
		studentCompany.setState("Selected");
		session2.update(studentCompany);
		session2.getTransaction().commit();
		session2.close();
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getters and setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
