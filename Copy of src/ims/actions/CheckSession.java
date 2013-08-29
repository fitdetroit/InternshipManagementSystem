package ims.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckSession extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session2 = request.getSession();
	String str = (String) session2.getAttribute("userName");

	// this method check allready user logged in or not
	public String execute() {
		
		

		if (str != null) {
			Map session;
			session = ActionContext.getContext().getSession();
			String type = (String) session.get("type");
			
			
			if (type == "admin") 
			{
				return "admin";

			} 
			else if (type == "regiStudent") 
			{
				return "regiStudent";

			} 
			else if (type == "notRegiStudent") {
				return "notRegiStudent";

			} 
			else if (type == "allowedCompany") 
			{
				return "allowedCompany";
			} 
			else if (type == "notAllowedCompany") 
			{
				return "notAllowedCompany";
			} 
			else 
			{
				return SUCCESS;
			}

		} else {
			
			return SUCCESS;
		}

	}

}
