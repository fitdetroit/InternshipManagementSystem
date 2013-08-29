package ims.actions;




import ims.business.ViewCompanyDataSession;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class NewStudent extends ActionSupport{
	
	private List<String> list = null;
	
	// to redirect direct access actions without login
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	String str = (String) session.getAttribute("userName");

	
	
	// this method used to show compnay details to unregisted student
	public String execute()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ViewCompanyDataSession viewCompanyDataSession = (ViewCompanyDataSession) context.getBean("RemainingCompany");
		
		
		setList(viewCompanyDataSession.remainingCompanyName());
		
		
		return SUCCESS;
	}

	
	
	//getters and setters
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
