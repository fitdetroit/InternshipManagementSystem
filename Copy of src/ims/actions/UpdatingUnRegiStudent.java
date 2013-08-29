package ims.actions;

import ims.business.UpdateStudent;
import ims.data.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatingUnRegiStudent extends ActionSupport{
	
	// to redirect direct access actions without login
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	String str = (String) session.getAttribute("userName");
	
	User user = new User();
	
	private String studentUserName;
	private String password;
	private String conPassword;
	

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	UpdateStudent updateStudent = (UpdateStudent) context.getBean("UpdateStudent");
	
	
	

	// this method is used to change password by unregisterd student
	public String changeStudentPassword() throws NoSuchAlgorithmException
	{
		// to redirect direct access actions  without login
		if (str==null) {
			System.out.println("its here");
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		user.setUserName(userName);
		user.setType('s');


			///password encrptation
			 MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(password.getBytes());
		 
		        byte byteData[] = md.digest();
		 
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < byteData.length; i++) {
		         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
		 
		       // System.out.println("Digest(in hex format):: " + sb.toString());
			user.setPassword(sb.toString());
		
		
		
		updateStudent.changeStudentPassword(userName, user);
		
		return SUCCESS;
	}
	
	
	
	//password and confrom passowrd check by this method
	public void validate() {
		
		if(getPassword().length()==0)
		{
			addFieldError("password", "please enter password");
			
			
		}
		if(getConPassword().length()==0)
		{
			addFieldError("conPassword", "please enter conform password");
			
		}
		
		

		if (getPassword().length() != 0) {

			if (!(getPassword().equals(getConPassword()))) {
				addFieldError("conPassword", "password not match");

			}

		}

	}
	
	
	
	
	
	
	//getters and setters
	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
}
