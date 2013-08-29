package ims.actions;

import ims.business.CheckUserToLogin;

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

public class Login extends ActionSupport{
	private String UserName;
	private String password;
	private String loginPageType=null;


	private Map session;
	


	//this method is used to check admin login username and password in database
	public String login() throws NoSuchAlgorithmException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		CheckUserToLogin checkUserToLogin = (CheckUserToLogin) context.getBean("CheckUser");

		//to haddle direct access exeption with Checklogin action
		if(UserName==null || password==null)
			return ERROR;
			
		
		///password encrptation
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
        byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		// System.out.println("Digest(in hex format):: " + sb.toString());

		//if (checkUserToLogin.findAdmin(getUserName(), sb.toString()) == "success") {
		if (checkUserToLogin.findUser(getUserName(),sb.toString())=="error") 
		{

			return ERROR;
		}
			
        else 
		 {
			 
			 if(getLoginPageType().equals("admin"))
			 {
				 if (checkUserToLogin.findUser(getUserName(),sb.toString())=="admin")
				 {
					 
						// creating session for admin
						session = ActionContext.getContext().getSession();
						session.put("userName", getUserName());
						session.put("type", "admin");
						return "admin";
					 
				 }
				 else
				 {
					 return "error";
					 
				 }
				 
			 }
			 
			 else 
			 {
				
				 if (checkUserToLogin.findUser(getUserName(),sb.toString())=="registedStudent")
				 {
			        	// create new session for registed student
			        	session = ActionContext.getContext().getSession();
						  session.put("userName",getUserName());
						  session.put("type","regiStudent");
						  
						  return "regiStudent";
					 
				 }
				 if (checkUserToLogin.findUser(getUserName(),sb.toString())=="notRegistedStudent")
				 {
			        	// create new session for unregisted student
			        	session = ActionContext.getContext().getSession();
						  session.put("userName",getUserName());
						  session.put("type","notRegiStudent");
						  
						  return "notRegiStudent";
					 
				 }
				 if (checkUserToLogin.findUser(getUserName(),sb.toString())=="allowedCompany")
				 {
			        	// create session for logged in allowed company
			        	session = ActionContext.getContext().getSession();
						  session.put("userName",getUserName());
						  session.put("type","allowedCompany");
						  
						  return "allowedCompany";
					 
				 }
				 if (checkUserToLogin.findUser(getUserName(),sb.toString())=="notallowedCompany")
				 {
			        	// create session for logged in not allowed company
			        	session = ActionContext.getContext().getSession();
						  session.put("userName",getUserName());
						  session.put("type","notAllowedCompany");
						  
						  return "notAllowedCompany";
					 
				 }
				 else
					 return "error";
				
			}
			


			

		 }
		
			
			
			

	}
	
	//log out function and session remove
		public String logOut() {
			session = ActionContext.getContext().getSession();
			session.remove("UserName");
			session.remove("type");
			if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
				((org.apache.struts2.dispatcher.SessionMap) session).invalidate();

			}

			return SUCCESS;

		}
		
		// check 
		public String execute()
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session2 = request.getSession();
			String str = (String) session2.getAttribute("userName");
			
			// to redirect direct access actions  without login
			if (str==null) {
				return ERROR;
					
			}
			
			return SUCCESS;
		}
	
	
	
	
	
	//getters and setters
		public String getLoginPageType() {
			return loginPageType;
		}

		public void setLoginPageType(String loginPageType) {
			this.loginPageType = loginPageType;
		}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

}
