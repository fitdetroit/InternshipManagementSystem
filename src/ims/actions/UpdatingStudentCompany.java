package ims.actions;

import java.util.Map;
import java.util.Properties;

import ims.business.UpdateStudent;
import ims.business.UpdateStudentComapny;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatingStudentCompany extends ActionSupport{
	
	
	private String studentUserName;
	


	// to redirect direct access actions without login
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	String str = (String) session.getAttribute("userName");
	

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	UpdateStudentComapny updateStudentComapny = (UpdateStudentComapny) context.getBean("UpdateStudentCompany");
	
	public String UpdateStateToInterview()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String comapnyUserName = (String) session.get("userName");

	
		
		updateStudentComapny.UpdateStudentStateToInterview(comapnyUserName,getStudentUserName());
		sendMailToStudentInfromInterview();
		
		
		
		return SUCCESS;
		
	}

	
	
	public String sendMailToStudentInfromInterview()
	{
		
		final String username = "dkithmalfit@gmail.com";
		final String password = "password";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dkithmalfit@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("dkithmal10@gmail.com"));
			message.setSubject("Selected For the interview");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done ");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return SUCCESS;
	}
	
	public String UpdateStateToSelected()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String comapnyUserName = (String) session.get("userName");

	
		
		updateStudentComapny.UpdateStudentStateToSelected(comapnyUserName,getStudentUserName());
		
		sendMailToStudentInfromSelectedToCompany();
		
		return SUCCESS;
		
	}
	
	public String sendMailToStudentInfromSelectedToCompany()
	{
		final String username = "dkithmalfit@gmail.com";
		final String password = "password";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dkithmalfit@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("dkithmal10@gmail.com"));
			message.setSubject("Selected for the Internship ");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done ");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return SUCCESS;
		
	}
	
	
	
	// getters and setters
	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}
	
	
	

}
