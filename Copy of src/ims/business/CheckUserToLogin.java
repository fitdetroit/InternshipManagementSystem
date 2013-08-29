package ims.business;

import ims.data.Student;
import ims.data.User;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CheckUserToLogin {

	private SessionFactory sessionFactory;
	
	

	
	
	public String findUser(String userName,String password)
	{
		Session session = getSessionFactory().openSession();
		String hql = " from User u where u.userName=? and u.password=? ";
		Query query = session.createQuery(hql);
		

		List<User> list = query.setString(0, userName).setString(1, password).list();
		if(list.size()>0)
		{
			if(list.get(0).getType()=='a')
			{
				return "admin";
				
			}
			else if(list.get(0).getType()=='s')
			{
				

				String hql2 = " from Student st where st.studentUserName='" + userName + "'";
				Query query2 = session.createQuery(hql2);
				List<Student> list2 = ((org.hibernate.Query) query2).list();
				if (list2.size() > 0) {
					session.close();

					return "registedStudent";
				}

				return "notRegistedStudent";
				
			}
			else 
			{
				String hql2 = " from Company cm where cm.companyUserName='" + userName + "'and cm.allowed='1'";
				Query query2 = session.createQuery(hql2);
				List<Student> list2 = ((org.hibernate.Query) query2).list();
				if (list2.size() > 0) {
					session.close();

					return "allowedCompany";
				}

				return "notallowedCompany";
				
			}
			
		}
		else
		{
			return "error";
			
		}
		
	}
	
	
	
	
	
	
	
	

	// getters and setters

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
