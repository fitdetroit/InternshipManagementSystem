package ims.business;

import ims.data.Company;
import ims.data.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class UpdateCompany {
	
	private SessionFactory sessionFactory;
	
	


// return list of details in company to EditCompany jsp
	public List<Company> getDetails(String userName)
	{
		

		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Company as com  where com.companyUserName='"+userName+"'";
		Query query = session.createQuery(SQL_QUERY);
	
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
		
	}
	
	public List<User> getDetails2(String userName)
	{
		

		Session session2 = getSessionFactory().openSession();
		String SQL_QUERY = "from User as usr  where usr.userName='"+userName+"'";
		Query query = session2.createQuery(SQL_QUERY);
	
		List<User> list = ((org.hibernate.Query) query).list();
		session2.close();

		return list;
		
	}
	
	
	public void updateCompany(String userName,Company companyUpdated,User userUpdated)
	{
		
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();		
		Company company2 = (Company)session.get(Company.class, userName);
		company2=companyUpdated;		
		session.merge(company2);
		session.getTransaction().commit();
		session.close();
		
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		User user = (User)session2.get(User.class, userName);
		user=userUpdated;
		session2.merge(user);
		session2.getTransaction().commit();
		session2.close();
		
		
	}
	
	
	public void AllowCompany(String userName)
	{
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();		
		Company company = (Company)session.get(Company.class, userName);
		company.setAllowed(true);	
		session.merge(company);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void UnRegister(String userName)
	{
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();		
		Company company = (Company)session.get(Company.class, userName);
		company.setAllowed(false);	
		session.merge(company);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void DeleteCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company2 = (Company)session.get(Company.class, userName);
		session.delete(company2);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = getSessionFactory().openSession();
		session2.beginTransaction();
		User user = (User)session2.get(User.class, userName);
		session2.delete(user);
		session2.getTransaction().commit();
		session2.close();
		
	}
	
	public void AllowCvToCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company2 = (Company)session.get(Company.class, userName);
		company2.setReceiveCv(true);
		session.merge(company2);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public void RemoveCvFromCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company2 = (Company)session.get(Company.class, userName);
		company2.setReceiveCv(false);
		session.merge(company2);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	
	
	
	
	// getters and setters
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
