package ims.actions;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ims.business.UpdateCompany;
import ims.data.Company;
import ims.data.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatingCompany extends ActionSupport{
	
	
	
	private String companyUserName=null;

	
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	UpdateCompany updateCompany = (UpdateCompany)context.getBean("UpdateCompany");
	
	// to redirect direct access actions  without login
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	String str=(String)session.getAttribute("userName");
	

	
	
 // this method is used to allow company by admin
	public String AllowCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}

		
		updateCompany.AllowCompany(getCompanyUserName());
		return SUCCESS;
	}
	
	
	// this method is used to unregister company by admin
	public String UnRegister()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}

		
		updateCompany.UnRegister(getCompanyUserName());
		return SUCCESS;
		
	}
	
	
	
	// this mehtod is used to delete company by admin
	public String DeleteCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}

		
		updateCompany.DeleteCompany(getCompanyUserName());
		return SUCCESS;
		
	}
	
	
	// this method is used to allow view student cv To company
	public String AllowCvToCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
			
		
		updateCompany.AllowCvToCompany(getCompanyUserName());
		
		return SUCCESS;
	}
	
	
	// this method is used to remove student cv form company
	public String RemoveCvFromCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
			
		updateCompany.RemoveCvFromCompany(getCompanyUserName());
		
		return SUCCESS;
	}


	
	//getters and setters
	public String getCompanyUserName() {
		return companyUserName;
	}


	public void setCompanyUserName(String companyUserName) {
		this.companyUserName = companyUserName;
	}
}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

