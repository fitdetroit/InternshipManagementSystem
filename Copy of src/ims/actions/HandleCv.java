package ims.actions;

import ims.business.ViewCompanyDataSession;
import ims.data.Company;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;



public class HandleCv extends ActionSupport{

	private List<Company> list = null;
	private List<Company> list2 = null;
	



	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	ViewCompanyDataSession viewCompanyDataSession = (ViewCompanyDataSession) context.getBean("ViewCompany");
	
	
	

	public String allowAndRemoveCv()
	{
		setList(viewCompanyDataSession.CvNotRecivedCompanyToAdmin());
		setList2(viewCompanyDataSession.CvRecivedCompanyToAdmin());
		
		return SUCCESS;
	}

	
	
	
	//getters and setters
	public List<Company> getList() {
		return list;
	}


	public void setList(List<Company> list) {
		this.list = list;
	}


	public List<Company> getList2() {
		return list2;
	}


	public void setList2(List<Company> list2) {
		this.list2 = list2;
	}
}
