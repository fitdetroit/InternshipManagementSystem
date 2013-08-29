package ims.actions;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import ims.business.RegisterCompany;
import ims.business.UpdateCompany;
import ims.data.Company;
import ims.data.User;

public class CompanyRegistration extends ActionSupport{
	
	private String companyUserName;
	private String companyName;
	private String companyTelephone;
	private String contactPerson;
	private String companyAddress;
	private String companyWeb;
	private String noOfVacancies;
	private String password;
	private String conPassword;
	private boolean allowed;
	
	Company company = new Company();
	User user = new User();
		
	//to upload profile picture
	private File ProfilePicture;
	private String ProfilePictureFileName;
	private String ProfilePictureContentType;
	
	
	
	
	
	public String registration() throws NoSuchAlgorithmException
	{
		
		// uploading profile picture
		ServletContext servletContext = ServletActionContext.getServletContext(); 
		if (ProfilePicture != null) {
			String dataDir = servletContext.getRealPath("/WEB-INF/data"); 
			File savedFile = new File(dataDir, getCompanyUserName()+".gif"); 
			ProfilePicture.renameTo(savedFile); } 
		else {
			//System.out.println("its not working");
		}
		
	
		
		
		// set values to new company object
		company.setCompanyUserName(getCompanyUserName());
		company.setCompanyName(getCompanyName());
		company.setCompanyTelephone(getCompanyTelephone());
		company.setContactPerson(getContactPerson());
		company.setCompanyAddress(getCompanyAddress());
		company.setCompanyWeb(getCompanyWeb());
		company.setNoOfVacancies(getNoOfVacancies());
		company.setAllowed(false);
	
		
		
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
	
	 
	        
	    // set values to new user object
		user.setUserName(getCompanyUserName());
		user.setPassword(sb.toString());
		user.setType('c');
		
	
		
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		RegisterCompany registerCompany = (RegisterCompany)context.getBean("RegisterCompany");
		
		registerCompany.saveCompany(company,user);
		
		
		
		//create session for new company
		
		 Map session;
     	session = ActionContext.getContext().getSession();
			  session.put("userName",getCompanyUserName());
			  session.put("type","notAllowedCompany");
		
		return SUCCESS;
	}
	
	
	

	// this validate method is used to validate passwod and confrom passwod and check username allready in database
	public void validate()
	{
			
		if(!(getPassword().equals(getConPassword()))){
			addFieldError("conPassword", "password not match");
		}
		
	
		
		//for check username is allready in use
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		RegisterCompany registerCompany = (RegisterCompany)context.getBean("RegisterCompany");
		if(registerCompany.cheakUsernameAllreadyAvailable(getCompanyUserName()))
		{
			addFieldError("companyUserName", "User Name alreay in Use please use different one");
		}
		
		
	}
	





	
	
	
	
	
	// getters and setters	
	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public File getProfilePicture() {
		return ProfilePicture;
	}



	public void setProfilePicture(File profilePicture) {
		ProfilePicture = profilePicture;
	}



	public String getProfilePictureFileName() {
		return ProfilePictureFileName;
	}



	public void setProfilePictureFileName(String profilePictureFileName) {
		ProfilePictureFileName = profilePictureFileName;
	}



	public String getProfilePictureContentType() {
		return ProfilePictureContentType;
	}



	public void setProfilePictureContentType(String profilePictureContentType) {
		ProfilePictureContentType = profilePictureContentType;
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



	public String getPassword() {
		return password;
	}



	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}



	public String getCompanyUserName() {
		return companyUserName;
	}

	public void setCompanyUserName(String companyUserName) {
		this.companyUserName = companyUserName;
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyTelephone() {
		return companyTelephone;
	}

	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyWeb() {
		return companyWeb;
	}

	public void setCompanyWeb(String companyWeb) {
		this.companyWeb = companyWeb;
	}

	public String getNoOfVacancies() {
		return noOfVacancies;
	}

	public void setNoOfVacancies(String noOfVacancies) {
		this.noOfVacancies = noOfVacancies;
	}


}
