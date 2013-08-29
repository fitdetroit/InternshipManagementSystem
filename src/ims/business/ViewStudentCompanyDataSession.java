package ims.business;



import ims.data.Student;
import ims.data.StudentCompany;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ViewStudentCompanyDataSession {
	
	private SessionFactory sessionFactory;


	
	
	
	public List<StudentCompany> toGetStatesofStudentAppliedCompany(String userName)
	{
		
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Student student =(Student)session.get(Student.class, userName);
		// this x , y initialize becose othervise its not fetch the object from this tables
		int x =student.getStudentCompany().size();
		System.out.println(x+"size of student company");
		
/*		StudentCompany  studentCompany = new StudentCompany();
		studentCompany.setStudent(student);
		studentCompany.setCompany(null);
		String SQL_QUERY = "from StudentCompany as stucom  where stucom.pk='" + studentCompany + "'";
		Query query = session.createQuery(SQL_QUERY);
		List<StudentCompany> list = ((org.hibernate.Query) query).list();*/
		session.getTransaction().commit();
		session.close();
		List<StudentCompany> list = new ArrayList<StudentCompany>();
		list.addAll(student.getStudentCompany());
		
		if(list.size()==0)
		{
			System.out.println("mala not working");
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
