package ims.actions;

import ims.business.ViewStudentDataSession;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.StudentComplitedProjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewStudent extends ActionSupport {

	private List<Student> list = null;
	private List<String> companyNames= new ArrayList<String>();
	private List<StudentComplitedProjects> studentComplitedProjects=null;
	
	
	
	
	private Student student= new Student();
	


	// to get informatin to admin and company
	private String studentUserName= null;

	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
	ViewStudentDataSession viewStudentDataSession = (ViewStudentDataSession) context.getBean("ViewStudent");

	
	// to redirect direct access actions  without login
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	String str=(String)session.getAttribute("userName");
	
	
	
	
	
	public String allStudentToAdmin()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		setList(getViewStudentDataSession().allStudentToAdmin());
		
		return SUCCESS;
	}
	
	

	
	
	
	public String viewStudentToStudent()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		setStudent(viewStudentDataSession.viewStudentToStudent(userName));
		
	
		
		
		for(StudentCompany studentAppliedCompany:getStudent().getStudentCompany())
		{
			//System.out.println(studentAppliedCompany.getCompany().getCompanyName()+"company name");
			companyNames.add(studentAppliedCompany.getCompany().getCompanyName());
			
		}
		

		
		return SUCCESS;
		
	}
	
	
	public String appliedStudentToCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		System.out.println(userName);
		if(viewStudentDataSession.appliedStudentToCompany(userName)==null)
		{
			return "NoAccess";
		}
		else
		{
			
			setList(viewStudentDataSession.appliedStudentToCompany(userName));
		}
		
		
		
		return SUCCESS;
	}

	//this method is used get still not select for interview to specific company
	public String notSelectedForInterview()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		setList(getViewStudentDataSession().notSelectForInterview(userName));
		

		
		
		
		return SUCCESS;
		
	}
	
	//this method is used get still selected for interview to specific company
	public String selctedForInterview()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		setList(getViewStudentDataSession().selectedForInterview(userName));
		
		return SUCCESS;
		
	}
	
	
	public String studentCvToAdmin()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		

		student=getViewStudentDataSession().studentCvToAdmin(getStudentUserName());
		
		for(StudentCompany studentAppliedCompany:getStudent().getStudentCompany())
		{
			//System.out.println(studentAppliedCompany.getCompany().getCompanyName()+"company name");
			companyNames.add(studentAppliedCompany.getCompany().getCompanyName());
			
		}

		
		

	
		return SUCCESS;
	}
	
	public String selctedForInternship()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		setList(getViewStudentDataSession().selectedForInternship(userName));
		
		return SUCCESS;
		
	}
	
	

	
	
	

	public String studentCvToCompany()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		if(getStudentUserName()==null)
		{
			return ERROR;
		}
		
		
		setStudent(viewStudentDataSession.studentCvToCompany(getStudentUserName()));
		
		
	
		return SUCCESS;
	}
	
	

	
	
	





	// getters and setters

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<StudentComplitedProjects> getStudentComplitedProjects() {
		return studentComplitedProjects;
	}

	public void setStudentComplitedProjects(
			List<StudentComplitedProjects> studentComplitedProjects) {
		this.studentComplitedProjects = studentComplitedProjects;
	}
	public List<String> getCompanyNames() {
		return companyNames;
	}




	public void setCompanyNames(List<String> companyNames) {
		this.companyNames = companyNames;
	}
	
	public String getStudentUserName() {
		return studentUserName;
	}




	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public ViewStudentDataSession getViewStudentDataSession() {
		return viewStudentDataSession;
	}

	public void setViewStudentDataSession(
			ViewStudentDataSession viewStudentDataSession) {
		this.viewStudentDataSession = viewStudentDataSession;
	}

}
