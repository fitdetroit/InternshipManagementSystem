package ims.actions;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ims.business.RegisterStudent;
import ims.business.UpdateStudent;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.StudentComplitedProjects;
import ims.data.StudentOtherQulification;
import ims.data.User;

public class UpdatingStudentByStudent extends ActionSupport {

	
	private String studentUserName;
	private String nameInFull;
	private String nameWithInitials;
	private String gender;
	private String dateOfBirth;
	private String maritalStatus;
	private String permanentAddress;
	private String mobile1;
	private String mobile2;
	private String telephone;
	private String email;
	private String school;
	private String alSubject1;
	private String alSubject2;
	private String alSubject3;
	private String alResult1;
	private String alResult2;
	private String alResult3;
	private String digreeTitle;
	private int yearOfAdmission;
	private float gpaSemester1;
	private float gpaSemester2;
	private float gpaSemester3;
	private String appliedCompany1;
	private String appliedCompany2;
	private String appliedCompany3;
	private String appliedCompany4;
	private String appliedCompany5;
	private String password =null;
	private String password2;
	private String conPassword;
	
	
	private int projectId1=0;
	private int projectId2=0;
	private String projectTitle1;
	private String projectDescription1;
	private String projectYear1;
	private String projectTitle2;
	private String projectDescription2;
	private String projectYear2;

	private int otherQulificationId1;
	private int otherQulificationId2;
	private String otherQulification1;
	private String otherQulification2;



	//to upload profile picture
	private File ProfilePicture;
	private String ProfilePictureFileName;
	private String ProfilePictureContentType;
	
	
	
	
	


	





	Student student = new Student();
	User user = new User();

	// to redirect direct access actions without login
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	String str = (String) session.getAttribute("userName");
	

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	UpdateStudent updateStudent = (UpdateStudent) context.getBean("UpdateStudent");
	
	

	
	// this method is used to update student profile 
	public String updateStudent() throws NoSuchAlgorithmException  {
		
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		
		
//System.out.println("its herer now");
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");

		setStudent(updateStudent.getDetails(userName));
		
		
		
		// uploading updatad profile picture
		ServletContext servletContext = ServletActionContext.getServletContext(); 
		if (ProfilePicture != null) {
			String dataDir = servletContext.getRealPath("/WEB-INF/data");
			File existingFile = new File(dataDir, getStudentUserName()+".gif");
			existingFile.delete();
			File savedFile = new File(dataDir, getStudentUserName()+".gif"); 
			ProfilePicture.renameTo(savedFile); } 
		else {
			System.out.println("its not working");
		}
		
		

		if(getStudentUserName().length()!=0)
		student.setStudentUserName(getStudentUserName());
		if(getNameInFull().length()!=0)
		student.setNameInFull(getNameInFull());
		if(getNameWithInitials().length()!=0)
		student.setNameWithInitials(getNameWithInitials());
		if(getGender().length()!=0)
		student.setGender(getGender());
		if(getDateOfBirth().length()!=0)
		student.setDateOfBirth(getDateOfBirth());
		if(getMaritalStatus().length()!=0)
		student.setMaritalStatus(getMaritalStatus());
		if(getPermanentAddress().length()!=0)
		student.setPermanentAddress(getPermanentAddress());
		if(getMobile1().length()!=0)
		student.setMobile1(getMobile1());
		if(getMobile2().length()!=0)
		student.setMobile2(getMobile2());
		if(getTelephone().length()!=0)
		student.setTelephone(getTelephone());
		if(getEmail().length()!=0)
		student.setEmail(getEmail());
		if(getSchool().length()!=0)
		student.setSchool(getSchool());
		if(getAlSubject1().length()!=0)
		student.setAlSubject1(getAlSubject1());
		if(getAlSubject2().length()!=0)
		student.setAlSubject2(getAlSubject2());
		if(getAlSubject3().length()!=0)
		student.setAlSubject3(getAlSubject3());
		if(getAlResult1().length()!=0)
		student.setAlResult1(getAlResult1());
		if(getAlResult2().length()!=0)
		student.setAlResult2(getAlResult2());
		if(getAlResult3().length()!=0)
		student.setAlResult3(getAlResult3());
		if(getDigreeTitle().length()!=0)
		student.setDigreeTitle(getDigreeTitle());
		if(getYearOfAdmission()!=0)
		student.setYearOfAdmission(getYearOfAdmission());
		//if(getGpaSemester1()!=0)
		student.setGpaSemester1(getGpaSemester1());
		//if(getGpaSemester2()!=0)
		student.setGpaSemester2(getGpaSemester2());
		//if(getGpaSemester3()!=0)
		student.setGpaSemester3(getGpaSemester3());



		user.setUserName(getStudentUserName());
		user.setType('s');

		if (getPassword().length() == 0) {
			user.setPassword(getPassword2());
		} else {
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
		}
		
		
		
	      //To save student done projects in studentComplitedProject table
		
/*			StudentComplitedProjects studentComplitedProjects1= new StudentComplitedProjects();
			//studentComplitedProjects1.setProjectId(getProjectId1());
			studentComplitedProjects1.setProjectTitle(getProjectTitle1());
			studentComplitedProjects1.setProjectDescription(getProjectDescription1());
			studentComplitedProjects1.setProjectYear(getProjectYear1());
			studentComplitedProjects1.setStudent(getStudent());
	
			StudentComplitedProjects studentComplitedProjects2 = new StudentComplitedProjects();
			//studentComplitedProjects2.setProjectId(getProjectId2());
			studentComplitedProjects2.setProjectTitle(getProjectTitle2());
			studentComplitedProjects2.setProjectDescription(getProjectDescription2());
			studentComplitedProjects2.setProjectYear(getProjectYear2());
			studentComplitedProjects2.setStudent(getStudent());*/
		
			
			
			for (StudentComplitedProjects project : getStudent().getStudentComplitedProjects()) {
				
				if(project.getProjectId()==getProjectId1())
				{
					project.setProjectTitle(getProjectTitle1());
					project.setProjectDescription(getProjectDescription1());
					project.setProjectYear(getProjectYear1());
					project.setStudent(getStudent());
					
				}
				if(project.getProjectId()==getProjectId2())
				{
					project.setProjectTitle(getProjectTitle2());
					project.setProjectDescription(getProjectDescription2());
					project.setProjectYear(getProjectYear2());
					project.setStudent(getStudent());
				}
				
			}
			
			
			
			
			for (StudentOtherQulification otherQulification :getStudent().getStudentOtherQulification())
			{
				if(otherQulification.getOtherQulificationId()==getOtherQulificationId1())
				{
					otherQulification.setDescription(otherQulification1);
					otherQulification.setStudent(getStudent());
					
				}
				
				if(otherQulification.getOtherQulificationId()==getOtherQulificationId2())
				{
					otherQulification.setDescription(otherQulification2);
					otherQulification.setStudent(getStudent());
					
				}
				
				
			}
			
			
			

			

		
/*		
			StudentOtherQulification  studentOtherQulification1= new StudentOtherQulification();
			studentOtherQulification1.setDescription(otherQulification1);
			studentOtherQulification1.setStudent(getStudent());
			
			StudentOtherQulification  studentOtherQulification2= new StudentOtherQulification();
			studentOtherQulification2.setDescription(otherQulification2);
			studentOtherQulification2.setStudent(getStudent());*/
			
			//getStudent().getStudentOtherQulification().add(studentOtherQulification1);
			//getStudent().getStudentOtherQulification().add(studentOtherQulification2);
		
		


		updateStudent.updateStudent(getStudentUserName(), student, user);
		
		
/*		if(getProjectId1()!=0)
		updateStudent.updateStudentComplitedProjects(getProjectId1(),studentComplitedProjects1);
		else {
			updateStudent.studentCompliteProjectsSave(studentComplitedProjects1);
		}
		if(getProjectId2()!=0)
		updateStudent.updateStudentComplitedProjects(getProjectId2(),studentComplitedProjects2);
		else {
			updateStudent.studentCompliteProjectsSave(studentComplitedProjects2);
		}*/
		

		return SUCCESS;

	}
	

	public void validate()  {
		

		if (getPassword().length() != 0) {
		

			if (!(getPassword().equals(getConPassword()))) {
				addFieldError("conPassword", "password not match");

			}

		}

	}
	
	
	

	

//gettser and setter
	public int getOtherQulificationId1() {
		return otherQulificationId1;
	}


	public void setOtherQulificationId1(int otherQulificationId1) {
		this.otherQulificationId1 = otherQulificationId1;
	}


	public int getOtherQulificationId2() {
		return otherQulificationId2;
	}


	public void setOtherQulificationId2(int otherQulificationId2) {
		this.otherQulificationId2 = otherQulificationId2;
	}
	public String getOtherQulification1() {
		return otherQulification1;
	}


	public void setOtherQulification1(String otherQulification1) {
		this.otherQulification1 = otherQulification1;
	}


	public String getOtherQulification2() {
		return otherQulification2;
	}


	public void setOtherQulification2(String otherQulification2) {
		this.otherQulification2 = otherQulification2;
	}

	public int getProjectId2() {
		return projectId2;
	}

	public int getProjectId1() {
		return projectId1;
	}


	public void setProjectId1(int projectId1) {
		this.projectId1 = projectId1;
	}


	public void setProjectId2(int projectId2) {
		this.projectId2 = projectId2;
	}
	public String getProjectYear2() {
		return projectYear2;
	}

	public void setProjectYear2(String projectYear2) {
		this.projectYear2 = projectYear2;
	}


	public String getProjectTitle1() {
		return projectTitle1;
	}

	public void setProjectTitle1(String projectTitle1) {
		this.projectTitle1 = projectTitle1;
	}

	public String getProjectDescription1() {
		return projectDescription1;
	}

	public void setProjectDescription1(String projectDescription1) {
		this.projectDescription1 = projectDescription1;
	}

	public String getProjectYear1() {
		return projectYear1;
	}

	public void setProjectYear1(String projectYear1) {
		this.projectYear1 = projectYear1;
	}

	public String getProjectTitle2() {
		return projectTitle2;
	}

	public void setProjectTitle2(String projectTitle2) {
		this.projectTitle2 = projectTitle2;
	}

	public String getProjectDescription2() {
		return projectDescription2;
	}

	public void setProjectDescription2(String projectDescription2) {
		this.projectDescription2 = projectDescription2;
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


	public String getStudentUserName() {
		return studentUserName;
	}

	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}

	public String getNameInFull() {
		return nameInFull;
	}

	public void setNameInFull(String nameInFull) {
		this.nameInFull = nameInFull;
	}

	public String getNameWithInitials() {
		return nameWithInitials;
	}

	public void setNameWithInitials(String nameWithInitials) {
		this.nameWithInitials = nameWithInitials;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAlSubject1() {
		return alSubject1;
	}

	public void setAlSubject1(String alSubject1) {
		this.alSubject1 = alSubject1;
	}

	public String getAlSubject2() {
		return alSubject2;
	}

	public void setAlSubject2(String alSubject2) {
		this.alSubject2 = alSubject2;
	}

	public String getAlSubject3() {
		return alSubject3;
	}

	public void setAlSubject3(String alSubject3) {
		this.alSubject3 = alSubject3;
	}

	public String getAlResult1() {
		return alResult1;
	}

	public void setAlResult1(String alResult1) {
		this.alResult1 = alResult1;
	}

	public String getAlResult2() {
		return alResult2;
	}

	public void setAlResult2(String alResult2) {
		this.alResult2 = alResult2;
	}

	public String getAlResult3() {
		return alResult3;
	}

	public void setAlResult3(String alResult3) {
		this.alResult3 = alResult3;
	}

	public String getDigreeTitle() {
		return digreeTitle;
	}

	public void setDigreeTitle(String digreeTitle) {
		this.digreeTitle = digreeTitle;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public float getGpaSemester1() {
		return gpaSemester1;
	}

	public void setGpaSemester1(float gpaSemester1) {
		this.gpaSemester1 = gpaSemester1;
	}

	public float getGpaSemester2() {
		return gpaSemester2;
	}

	public void setGpaSemester2(float gpaSemester2) {
		this.gpaSemester2 = gpaSemester2;
	}

	public float getGpaSemester3() {
		return gpaSemester3;
	}

	public void setGpaSemester3(float gpaSemester3) {
		this.gpaSemester3 = gpaSemester3;
	}



	public String getAppliedCompany1() {
		return appliedCompany1;
	}

	public void setAppliedCompany1(String appliedCompany1) {
		this.appliedCompany1 = appliedCompany1;
	}

	public String getAppliedCompany2() {
		return appliedCompany2;
	}

	public void setAppliedCompany2(String appliedCompany2) {
		this.appliedCompany2 = appliedCompany2;
	}

	public String getAppliedCompany3() {
		return appliedCompany3;
	}

	public void setAppliedCompany3(String appliedCompany3) {
		this.appliedCompany3 = appliedCompany3;
	}

	public String getAppliedCompany4() {
		return appliedCompany4;
	}

	public void setAppliedCompany4(String appliedCompany4) {
		this.appliedCompany4 = appliedCompany4;
	}

	public String getAppliedCompany5() {
		return appliedCompany5;
	}

	public void setAppliedCompany5(String appliedCompany5) {
		this.appliedCompany5 = appliedCompany5;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
