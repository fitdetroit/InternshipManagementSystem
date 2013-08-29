package ims.business;

import ims.data.Company;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ViewCompanyDataSession {
	
	
	SessionFactory sessionFactory;
	
	
// this method is used to get still remainig company to give internsip
	public List<String> remainingCompanyName()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "select companyName from Company as com  where com.allowed='1'";
		Query query = session.createQuery(SQL_QUERY);
		 List<String> list =  ((org.hibernate.Query) query).list();
		 list.add("NOT Select");
		session.close();

		return list;
		
	}
	
// this method is used to get list of details of allowd compny to admin	
	public List<Company> allowedCompanyToAdmin()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Company as com  where com.allowed='1'";
		Query query = session.createQuery(SQL_QUERY);
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
		
	}
	
// this method is used to get details about not allowd company to admin	
	public List<Company> notAllowedCompanyToAdmin()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Company as com  where com.allowed='0'";
		Query query = session.createQuery(SQL_QUERY);
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
		
	}
	
	//this method is used to view company details to company
	public Company viewCompanyToCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return company;
	}
	// this method is used to get detials about allowd company to admin
	public List<Company> allowedCompanyToStudent()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Company as com  where com.allowed='1'";
		Query query = session.createQuery(SQL_QUERY);
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
		
	}
	// this method is used to get deatils to company all registed company deails 
	public List<Company> allowedCompanyToCompany()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY = "from Company as com  where com.allowed='1'";
		Query query = session.createQuery(SQL_QUERY);
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
		
	}
	// this method is used to give full profile to student form database
	public Company FullProfileToStudent(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return company;
	}
// this method is used to give full information about company to compny form database	
	public Company FullProfileToCompany(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return company;
	}
	// this method is used to give full information to admin about compies form database
	public Company FullProfileToAdmin(String userName)
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Company company =(Company)session.get(Company.class, userName);
		session.getTransaction().commit();
		session.close();
		
		return company;
	}
// this method is used to get list of company names are allowd to view cv form student	
	public List<Company> CvRecivedCompanyToAdmin()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY ="from Company as com  where com.receiveCv='1'and com.allowed='1'";
		Query query = session.createQuery(SQL_QUERY);
	
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

		return list;
	}
	// this method is used to get all not allowd to view  cv form student
	public List<Company> CvNotRecivedCompanyToAdmin()
	{
		Session session = getSessionFactory().openSession();
		String SQL_QUERY ="from Company as com  where com.receiveCv='0'and com.allowed='1'and com.state='0'";
		Query query = session.createQuery(SQL_QUERY);
	
		List<Company> list = ((org.hibernate.Query) query).list();
		session.close();

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
