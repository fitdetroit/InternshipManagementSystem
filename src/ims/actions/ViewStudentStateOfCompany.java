package ims.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ims.business.ViewCompanyDataSession;
import ims.business.ViewStudentCompanyDataSession;
import ims.data.Company;
import ims.data.Student;
import ims.data.StudentCompany;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewStudentStateOfCompany extends ActionSupport{
	
	
	private String newAppliedCompnay1;
	private String newAppliedCompnay2;
	private String newAppliedCompnay3;
	private String newAppliedCompnay4;
	private String newAppliedCompnay5;
	
	private List<StudentCompany> studentCompanyList = null;
	private List<Company> allowdAllCompany=  new ArrayList<Company>();
	private List<String> allCompany=new ArrayList<String>();

	private List<String> studentCanAppliedCompany=new ArrayList<String>();
	
	

		// to redirect direct access actions  without login
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String str=(String)session.getAttribute("userName");
	
	
	public String viewStudentAppliedCompanyState()
	{
		// to redirect direct access actions  without login
		if (str==null) {
			return ERROR;
				
		}
		
		Map session;
		session = ActionContext.getContext().getSession();
		String userName = (String) session.get("userName");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ViewStudentCompanyDataSession viewStudentCompanyDataSession = (ViewStudentCompanyDataSession) context.getBean("ViewStudentCompany");
		
		setStudentCompanyList(viewStudentCompanyDataSession.toGetStatesofStudentAppliedCompany(userName));
		
		
		for(int x=0,y=1;x<studentCompanyList.size();x++)
		{
			if(studentCompanyList.get(x).getState().equals("Regected"))
			{
				

				if(y==1)
				{
					setNewAppliedCompnay1("newAppliedCompnay1");
					
				}
				if(y==2)
				{
					setNewAppliedCompnay2("newAppliedCompnay2");
					
				}
				if(y==3)
				{
					setNewAppliedCompnay3("newAppliedCompnay3");
					
				}
				if(y==5)
				{
					setNewAppliedCompnay4("newAppliedCompnay4");
					
				}
				if(y==5)
				{
					setNewAppliedCompnay5("newAppliedCompnay5");
					
				}
				
				y++;
				
				
				ApplicationContext context2 = new ClassPathXmlApplicationContext("Spring.xml");
				ViewCompanyDataSession viewCompanyDataSession = (ViewCompanyDataSession) context2.getBean("RemainingCompany");
				
				studentCanAppliedCompany=allCompany;
				setAllCompany(viewCompanyDataSession.remainingCompanyName());	
				
				for(StudentCompany stuCom:getStudentCompanyList())
				{
					studentCanAppliedCompany.remove(stuCom.getCompany().getCompanyName());
					
				}
				
				
			}
			
		}
		
		
		
		
		
/*		if(studentCompanyList.size()<5)
		{
			if(studentCompanyList.size()==0)
			{
				setNewAppliedCompnay1("newAppliedCompnay1");
				setNewAppliedCompnay2("newAppliedCompnay2");
				setNewAppliedCompnay3("newAppliedCompnay3");
				setNewAppliedCompnay4("newAppliedCompnay4");
				setNewAppliedCompnay5("newAppliedCompnay5");
				
			}
			
			if(studentCompanyList.size()==1)
			{
				setNewAppliedCompnay1("newAppliedCompnay1");
				setNewAppliedCompnay2("newAppliedCompnay2");
				setNewAppliedCompnay3("newAppliedCompnay3");
				setNewAppliedCompnay4("newAppliedCompnay4");
				if(studentCompanyList.get(0).getState()=="Regected")
				{
					setNewAppliedCompnay5("newAppliedCompnay5");
				}
				
				
			}
			if(studentCompanyList.size()==2)
			{
				setNewAppliedCompnay1("newAppliedCompnay1");
				setNewAppliedCompnay2("newAppliedCompnay2");
				setNewAppliedCompnay3("newAppliedCompnay3");
				if(studentCompanyList.get(0).getState()=="Regected")
				{
					setNewAppliedCompnay4("newAppliedCompnay4");
					
					if(studentCompanyList.get(1).getState()=="Regected")
					{
						setNewAppliedCompnay5("newAppliedCompnay5");
					}
				}
				else if(studentCompanyList.get(1).getState()=="Regected")
				{
					setNewAppliedCompnay4("newAppliedCompnay4");
					
				}
				
				
				
			}
			if(studentCompanyList.size()==3)
			{
				setNewAppliedCompnay1("newAppliedCompnay1");
				setNewAppliedCompnay2("newAppliedCompnay2");
				
			}
			if(studentCompanyList.size()==4)
			{
				setNewAppliedCompnay1("newAppliedCompnay1");
				
			}

		}*/
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	












	//getters and setters
	public List<String> getAllCompany() {
		return allCompany;
	}


	public void setAllCompany(List<String> allCompany) {
		this.allCompany = allCompany;
	}
	public List<Company> getAllowdAllCompany() {
		return allowdAllCompany;
	}




	public void setAllowdAllCompany(List<Company> allowdAllCompany) {
		this.allowdAllCompany = allowdAllCompany;
	}


	public List<String> getStudentCanAppliedCompany() {
		return studentCanAppliedCompany;
	}


	public void setStudentCanAppliedCompany(List<String> studentCanAppliedCompany) {
		this.studentCanAppliedCompany = studentCanAppliedCompany;
	}
	public List<StudentCompany> getStudentCompanyList() {
		return studentCompanyList;
	}

	public void setStudentCompanyList(List<StudentCompany> studentCompanyList) {
		this.studentCompanyList = studentCompanyList;
	}

	public String getNewAppliedCompnay1() {
		return newAppliedCompnay1;
	}
	public void setNewAppliedCompnay1(String newAppliedCompnay1) {
		this.newAppliedCompnay1 = newAppliedCompnay1;
	}
	public String getNewAppliedCompnay2() {
		return newAppliedCompnay2;
	}
	public void setNewAppliedCompnay2(String newAppliedCompnay2) {
		this.newAppliedCompnay2 = newAppliedCompnay2;
	}
	public String getNewAppliedCompnay3() {
		return newAppliedCompnay3;
	}
	public void setNewAppliedCompnay3(String newAppliedCompnay3) {
		this.newAppliedCompnay3 = newAppliedCompnay3;
	}
	public String getNewAppliedCompnay4() {
		return newAppliedCompnay4;
	}
	public void setNewAppliedCompnay4(String newAppliedCompnay4) {
		this.newAppliedCompnay4 = newAppliedCompnay4;
	}
	public String getNewAppliedCompnay5() {
		return newAppliedCompnay5;
	}
	public void setNewAppliedCompnay5(String newAppliedCompnay5) {
		this.newAppliedCompnay5 = newAppliedCompnay5;
	}
	
	
	


}
