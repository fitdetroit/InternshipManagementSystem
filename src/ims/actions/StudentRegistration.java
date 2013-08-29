package ims.actions;

import java.io.File;

import javax.persistence.Column;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import ims.business.RegisterStudent;
//import ims.data.Application;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.StudentComplitedProjects;
import ims.data.StudentOtherQulification;
import ims.data.User;

public class StudentRegistration extends ActionSupport {
	
	private Student student = new Student();
	
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
	
	
	
	
	private String projectTitle1;
	private String projectDescription1;
	private String projectYear1;
	private String projectTitle2;
	private String projectDescription2;
	private String projectYear2;
	
	
	private String otherQulification1;
	private String otherQulification2;
	
	


	StudentCompany studentCompany1 = new StudentCompany();
	StudentCompany studentCompany2 = new StudentCompany();
	StudentCompany studentCompany3 = new StudentCompany();
	StudentCompany studentCompany4 = new StudentCompany();
	StudentCompany studentCompany5 = new StudentCompany();
	



	//to upload profile picture
	private File ProfilePicture;
	private String ProfilePictureFileName;
	private String ProfilePictureContentType;


	


	public String registration() {
		
		// uploading profile picture
		ServletContext servletContext = ServletActionContext.getServletContext(); 
		if (ProfilePicture != null) {
			String dataDir = servletContext.getRealPath("/WEB-INF/data"); 
			File savedFile = new File(dataDir, getStudentUserName()+".gif"); 
			ProfilePicture.renameTo(savedFile); } 
		else {
			System.out.println("its not working");
		}
		
		
		
		


		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		RegisterStudent registerStudent = (RegisterStudent) context.getBean("RegisterStudent");
		

		// set velues to new student object
		getStudent().setStudentUserName(getStudentUserName());
		getStudent().setNameInFull(getNameInFull());
		getStudent().setNameWithInitials(getNameWithInitials());
		getStudent().setGender(getGender());
		getStudent().setDateOfBirth(getDateOfBirth());
		getStudent().setMaritalStatus(getMaritalStatus());
		getStudent().setPermanentAddress(getPermanentAddress());
		getStudent().setMobile1(getMobile1());
		getStudent().setMobile2(getMobile2());
		getStudent().setTelephone(getTelephone());
		getStudent().setEmail(getEmail());
		getStudent().setSchool(getSchool());
		getStudent().setAlSubject1(getAlSubject1());
		getStudent().setAlSubject2(getAlSubject2());
		getStudent().setAlSubject3(getAlSubject3());
		getStudent().setAlResult1(getAlResult1());
		getStudent().setAlResult2(getAlResult2());
		getStudent().setAlResult3(getAlResult3());
		getStudent().setDigreeTitle(getDigreeTitle());
		getStudent().setYearOfAdmission(getYearOfAdmission());
		getStudent().setGpaSemester1(getGpaSemester1());
		getStudent().setGpaSemester2(getGpaSemester2());
		getStudent().setGpaSemester3(getGpaSemester3());
		getStudent().setSelected(false);

		
      //To save student done projects in studentComplitedProject table
		
		StudentComplitedProjects studentComplitedProjects1= new StudentComplitedProjects();
		studentComplitedProjects1.setProjectTitle(getProjectTitle1());
		studentComplitedProjects1.setProjectDescription(getProjectDescription1());
		studentComplitedProjects1.setProjectYear(getProjectYear1());
		studentComplitedProjects1.setStudent(getStudent());
		
		StudentComplitedProjects studentComplitedProjects2 = new StudentComplitedProjects();
		studentComplitedProjects2.setProjectTitle(getProjectTitle2());
		studentComplitedProjects2.setProjectDescription(getProjectDescription2());
		studentComplitedProjects2.setProjectYear(getProjectYear2());
		studentComplitedProjects2.setStudent(getStudent());
	

		getStudent().getStudentComplitedProjects().add(studentComplitedProjects1);
		getStudent().getStudentComplitedProjects().add(studentComplitedProjects2);
		
		// to save student other qulification
		
		StudentOtherQulification  studentOtherQulification1= new StudentOtherQulification();
		studentOtherQulification1.setDescription(otherQulification1);
		studentOtherQulification1.setStudent(getStudent());
		
		StudentOtherQulification  studentOtherQulification2= new StudentOtherQulification();
		studentOtherQulification2.setDescription(otherQulification2);
		studentOtherQulification2.setStudent(getStudent());
		
		
		getStudent().getStudentOtherQulification().add(studentOtherQulification1);
		getStudent().getStudentOtherQulification().add(studentOtherQulification2);
		

		StudentCompany studentCompany1 =new StudentCompany();
		studentCompany1.setStudent(getStudent());
		studentCompany1.setCompany(registerStudent.getStudentAppliedCompanyObject(getAppliedCompany1()));
		studentCompany1.setState("pending");
		
		StudentCompany studentCompany2 =new StudentCompany();
		studentCompany2.setStudent(getStudent());
		studentCompany2.setCompany(registerStudent.getStudentAppliedCompanyObject(getAppliedCompany2()));
		studentCompany2.setState("pending");
		
		StudentCompany studentCompany3 =new StudentCompany();
		studentCompany3.setStudent(getStudent());
		studentCompany3.setCompany(registerStudent.getStudentAppliedCompanyObject(getAppliedCompany3()));
		studentCompany3.setState("pending");
		
		StudentCompany studentCompany4 =new StudentCompany();
		studentCompany4.setStudent(getStudent());
		studentCompany4.setCompany(registerStudent.getStudentAppliedCompanyObject(getAppliedCompany4()));
		studentCompany4.setState("pending");
		
		StudentCompany studentCompany5 =new StudentCompany();
		studentCompany5.setStudent(getStudent());
		studentCompany5.setCompany(registerStudent.getStudentAppliedCompanyObject(getAppliedCompany5()));
		studentCompany5.setState("pending");
		
		
		getStudent().getStudentCompany().add(studentCompany1);
		getStudent().getStudentCompany().add(studentCompany2);
		getStudent().getStudentCompany().add(studentCompany3);
		getStudent().getStudentCompany().add(studentCompany4);
		getStudent().getStudentCompany().add(studentCompany5);
		
		
		
		// to save student in student table 
		registerStudent.saveStudent(student);
	
		
		
	
		return SUCCESS;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	// getters and setters
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

	public String getProjectYear2() {
		return projectYear2;
	}

	public void setProjectYear2(String projectYear2) {
		this.projectYear2 = projectYear2;
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



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}







}
