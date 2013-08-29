package ims.actions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ims.business.CreateAndDeleteStudent;
import ims.business.UpdateCompany;
import ims.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAndDeleteStudentProfiles extends ActionSupport {

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session2 = request.getSession();
	String str = (String) session2.getAttribute("userName");

	private String studentList;
	private String password;
	private String userName;

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	CreateAndDeleteStudent createAndDeleteStudent = (CreateAndDeleteStudent) context.getBean("CreateStudent");

	// this method is used to check admin login and redirect to to the called jsp

	public String execute() {
		// to redirect direct access actions without login
		if (str == null) {
			return ERROR;

		}

		return SUCCESS;

	}
	
	
	
	

	// this function is used to crate student profiles in the usertable
	public String createStudentProfiles() throws NoSuchAlgorithmException {
		// to redirect direct access actions without login
		if (str == null) {
			return ERROR;

		}

		// /password encrptation
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

		String[] studentUserNameList = getStudentList().split(",");

		for (int i = 0; i < studentUserNameList.length; i++) {
			User user = new User();

			user.setUserName(studentUserNameList[i]);
			user.setPassword(sb.toString());
			user.setType('s');
			createAndDeleteStudent.createStudentProfiles(user);

		}

		return SUCCESS;
	}
	
	
	
	
	

	// this method is used to delete one student form database from admin
	public String deleteStudentProfile() {
		// to redirect direct access actions without login
		if (str == null) {
			return ERROR;

		}

		createAndDeleteStudent.deleteStudentProfile(getUserName());

		return SUCCESS;

	}

	
	
	
	
	// this method is used to delete all student's profile in system
	public String deleteAllStudentsFormSystem() {
		// to redirect direct access actions without login
		if (str == null) {
			return ERROR;

		}
		createAndDeleteStudent.deleteAllStudentFromSystem();

		return SUCCESS;
	}

	
	
	
	
	
	
	// getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStudentList() {
		return studentList;
	}

	public void setStudentList(String studentList) {
		this.studentList = studentList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
