package ims.business;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ims.data.Company;
import ims.data.User;

public class RegisterCompany {
	
	
	private SessionFactory sessionFactory;
	
	
	// this method used to save company in database in first time 
	public void saveCompany(Company company,User user)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(company);
		session.beginTransaction().commit();
		session.close();
		
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		session2.save(user);
		session2.beginTransaction().commit();
		session2.close();
		
	}
	
	
	public boolean cheakUsernameAllreadyAvailable(String userName)
	{
		Session session = getSessionFactory().openSession();
		String hql = " from User u where u.userName='" + userName + "'";
		Query query = session.createQuery(hql);
		
		Iterator<User> it = ((org.hibernate.Query) query).iterate();
		List<User> list = ((org.hibernate.Query) query).list();

		if (list.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
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
