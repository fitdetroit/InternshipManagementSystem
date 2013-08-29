package ims.actions;


import ims.business.UpdateStudent;
import ims.data.Student;
import ims.data.StudentComplitedProjects;
import ims.data.StudentOtherQulification;
import ims.data.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


// this class give details form database fo Edit Student Form
public class EditStudent extends ActionSupport{
	


	Map session;
	
	// to redirect direct access actions  without login
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session2=request.getSession();
	String str=(String)session2.getAttribute("userName");
	
	//private List<StudentComplitedProjects> studentComplitedProjects= new ArrayList<StudentComplitedProjects>();

	private Student student;
	private User user;

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
	private String workingExperience;
	private String projects;
	private String appliedCompany1;
	private String appliedCompany2;
	private String appliedCompany3;
	private String appliedCompany4;
	private String appliedCompany5;
	private String password;
	private String password2;
	
	
	





	private int projectId1=0;
	private int projectId2=0;;
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





	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	UpdateStudent updateStudent = (UpdateStudent) context.getBean("UpdateStudent");
	
	

	
	
	
	public String editDetails() {
		
		
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");

		setStudent(getUpdateStudent().getDetails(userName));
		setUser(getUpdateStudent().getDetails2(userName));
		

		//set action class varibale form dababase to view in jsp
		setStudentUserName(student.getStudentUserName());
		setNameInFull(student.getNameInFull());
		setNameWithInitials(student.getNameWithInitials());
		setGender(student.getGender());
		setDateOfBirth(student.getDateOfBirth());
		setMaritalStatus(student.getMaritalStatus());
		setPermanentAddress(student.getPermanentAddress());
		setMobile1(student.getMobile1());
		setMobile2(student.getMobile2());
		setTelephone(student.getTelephone());
		setEmail(student.getEmail());
		setSchool(student.getSchool());
		setAlSubject1(student.getAlSubject1());
		setAlSubject2(student.getAlSubject2());
		setAlSubject3(student.getAlSubject3());
		setAlResult1(student.getAlResult1());
		setAlResult2(student.getAlResult2());
		setAlResult3(student.getAlResult3());
		setDigreeTitle(student.getDigreeTitle());
		setYearOfAdmission(student.getYearOfAdmission());
		setGpaSemester1(student.getGpaSemester1());
		setGpaSemester2(student.getGpaSemester2());
		setGpaSemester3(student.getGpaSemester3());
		setPassword(user.getPassword());
		setPassword2(user.getPassword());
		
	
		//studentComplitedProjects.addAll(getStudent().getStudentComplitedProjects());
		
		int x=1;
		for(StudentComplitedProjects project:getStudent().getStudentComplitedProjects())
		{
			if(x==1)
			{
				setProjectId1(project.getProjectId());
				setProjectTitle1(project.getProjectTitle());
				setProjectDescription1(project.getProjectDescription());
				setProjectYear1(project.getProjectYear());
				
			}
			else if(x==2)
			{
				setProjectId2(project.getProjectId());
				setProjectTitle2(project.getProjectTitle());
				setProjectDescription2(project.getProjectDescription());
				setProjectYear2(project.getProjectYear());
				
			}
			else
			{
				
			}
			x++;
				
			
		}
		
		int y=1;
		for(StudentOtherQulification otherQulification:getStudent().getStudentOtherQulification())
		{
			if(y==1)
			{
				setOtherQulificationId1(otherQulification.getOtherQulificationId());
				setOtherQulification1(otherQulification.getDescription());
				
			}
			else if(y==2)
			{
				setOtherQulificationId2(otherQulification.getOtherQulificationId());
				setOtherQulification2(otherQulification.getDescription());
				
			}
			
			y++;
		}


/*		//set values to project
		if(getStudentComplitedProjects().isEmpty()!=true)
		{
			if(getStudentComplitedProjects().get(0)!=null)
			{
				setProjectId1(studentComplitedProjects.get(0).getProjectId());
				setProjectTitle1(studentComplitedProjects.get(0).getProjectTitle());
				setProjectDescription1(studentComplitedProjects.get(0).getProjectDescription());
				setProjectYear1(studentComplitedProjects.get(0).getProjectYear());
			}
			
			if(getStudentComplitedProjects().get(1)!=null)
			{
				setProjectId2(studentComplitedProjects.get(1).getProjectId());
				setProjectTitle2(studentComplitedProjects.get(1).getProjectTitle());
				setProjectDescription2(studentComplitedProjects.get(1).getProjectDescription());
				setProjectYear2(studentComplitedProjects.get(1).getProjectYear());
				
			}
			
		}*/
		



		return SUCCESS;
	}
	


	//this method is used to check student login and redirect to the password change jsp this mthod is not 
	//for this clz but updating unregister clz have validation so add to this clz
	public String execute()
	{
		// to redirect direct access actions  without login
		if (str==null) {			
			return ERROR;
				
		}
		
		
		return SUCCESS;
		
	}

	

	
	
	
	
	
	
	
	
	
	
	
	//getters and setters
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



	public String getWorkingExperience() {
		return workingExperience;
	}



	public void setWorkingExperience(String workingExperience) {
		this.workingExperience = workingExperience;
	}



	public String getProjects() {
		return projects;
	}



	public void setProjects(String projects) {
		this.projects = projects;
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

	public int getProjectId1() {
		return projectId1;
	}

	public void setProjectId1(int projectId1) {
		this.projectId1 = projectId1;
	}

	public int getProjectId2() {
		return projectId2;
	}

	public void setProjectId2(int projectId2) {
		this.projectId2 = projectId2;
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

/*	public List<StudentComplitedProjects> getStudentComplitedProjects() {
		return studentComplitedProjects;
	}

	public void setStudentComplitedProjects(
			List<StudentComplitedProjects> studentComplitedProjects) {
		this.studentComplitedProjects = studentComplitedProjects;
	}*/
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


	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Map getSession() {
		return session;
	}




	public void setSession(Map session) {
		this.session = session;
	}






	public ApplicationContext getContext() {
		return context;
	}




	public void setContext(ApplicationContext context) {
		this.context = context;
	}


	public UpdateStudent getUpdateStudent() {
		return updateStudent;
	}

	public void setUpdateStudent(UpdateStudent updateStudent) {
		this.updateStudent = updateStudent;
	}
	
	public Student getStudent() {
		return student;
	}




	public void setStudent(Student student) {
		this.student = student;
	}





}
