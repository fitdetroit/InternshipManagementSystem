package ims.business;

import ims.data.Company;
import ims.data.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class UpdateCompany {
	
	private SessionFactory sessionFactory;
	
	


// this method is used to get details before update (for company table)
	public Company getDetails(String userName)
	{
		

		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return company;
		
	}

	// this method is used to get deatils before update (for user table )
	public User getDetails2(String userName)
	{
		

		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		User user =(User)session.get(User.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return user;
		
	}
	
	// this method is used to update company
	public void updateCompany(String userName,Company companyUpdated,User userUpdated)
	{
		
		Session session = getSessionFactory().openSession();		
		session.beginTransaction();		
		session.update(companyUpdated);
		session.update(userUpdated);
		session.getTransaction().commit();
		session.close();
		
			
	}
	
// this method is used to allow company in system by admin	
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
// this method is used to unregister company in system by admin	
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
	
	// this method is used to delete company from system by admin
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
	// this method is used to send cv's to company by admin
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
// this method is used to remove cv form company by admin	
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
