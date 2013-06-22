package ims.business;

import ims.data.Application;
import ims.data.Company;
import ims.data.Student;
import ims.data.StudentComplitedProjects;
import ims.data.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateStudent {
	
	private SessionFactory sessionFactory;
	
	


// this method is used to get details before update 
		public Student getDetails(String userName)
		{
			

			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			Student student =(Student)session.get(Student.class, userName);
			session.getTransaction().commit();
			session.close();
			
			return student;
			
		}
		// this method is used to get details befor student update
		public User getDetails2(String userName)
		{
			

			Session session = getSessionFactory().openSession();
			session.beginTransaction();
			User user =(User)session.get(User.class, userName);
			session.getTransaction().commit();
			session.close();
			
			return user;
			
		}
		
		
/*		public List<StudentComplitedProjects>  getStudentComplitedProjectsFromDB(String userName)
		{
			Session session2 = getSessionFactory().openSession();
			String SQL_QUERY2 = "from StudentComplitedProjects as scp  where scp.student.studentUserName='"+userName+"' ";
			Query query2 = session2.createQuery(SQL_QUERY2);
			
		
			List<StudentComplitedProjects> list = ((org.hibernate.Query) query2).list();
			session2.close();
			
			return list;
			
		}*/
		
	// this method is used update student in database	
		public void updateStudent(String userName,Student studentUpdated,User userUpdated)
		{

			Session session = getSessionFactory().openSession();		
			session.beginTransaction();		
			session.update(studentUpdated);
			session.update(userUpdated);
			session.getTransaction().commit();
			session.close();
				
			
		}
		
		
		
		public void changeStudentPassword(String userName,User userUpdated)
		{
			Session session2 = getSessionFactory().openSession();
			session2.beginTransaction();
			User user = (User)session2.get(User.class, userName);
			user=userUpdated;
			session2.merge(user);
			session2.getTransaction().commit();
			session2.close();
			
		}
		
		
		
		

// getters and setters
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}


		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

}
