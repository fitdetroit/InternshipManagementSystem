package ims.actions;

import java.util.Map;

import ims.business.RegisterStudent;
import ims.business.UpdateStudent;
import ims.data.Student;
import ims.data.StudentCompany;
import ims.data.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateNewlyAppliedCompany extends ActionSupport{

		//to update new applied companyies
		private String newAppliedCompnay1 = null;
		private String newAppliedCompnay2 = null;
		private String newAppliedCompnay3 = null;
		private String newAppliedCompnay4 = null;
		private String newAppliedCompnay5 = null;

		
		





		Student student = new Student();
		

		// to redirect direct access actions without login
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("userName");
		

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		UpdateStudent updateStudent = (UpdateStudent) context.getBean("UpdateStudent");
		

		public String updateNewlyAppliedCompany()
		{
			// to redirect direct access actions  without login
			if (str==null) {
				return ERROR;
					
			}
			
			
			

			
			Map session;
			session = ActionContext.getContext().getSession();
			String userName = (String) session.get("userName");

			setStudent(updateStudent.getDetails(userName));
			
			ApplicationContext context2 = new ClassPathXmlApplicationContext("Spring.xml");
			RegisterStudent registerStudent = (RegisterStudent) context2.getBean("RegisterStudent");
			
			if(!(getNewAppliedCompnay1().equals(null)))
			{
				
				StudentCompany studentCompany1 =new StudentCompany();
				studentCompany1.setStudent(getStudent());				
				studentCompany1.setCompany(registerStudent.getStudentAppliedCompanyObject(getNewAppliedCompnay1()));
				System.out.println("berfor initiadfdfdfdfdfd");
				studentCompany1.setState("pending");
				getStudent().getStudentCompany().add(studentCompany1);
			}
			if(!(getNewAppliedCompnay2()==null))
			{
				StudentCompany studentCompany2 =new StudentCompany();
				studentCompany2.setStudent(getStudent());
				studentCompany2.setCompany(registerStudent.getStudentAppliedCompanyObject(getNewAppliedCompnay2()));
				studentCompany2.setState("pending");
				getStudent().getStudentCompany().add(studentCompany2);
				
			}
			if(!(getNewAppliedCompnay3()==null))
			{
				StudentCompany studentCompany3 =new StudentCompany();
				studentCompany3.setStudent(getStudent());
				studentCompany3.setCompany(registerStudent.getStudentAppliedCompanyObject(getNewAppliedCompnay3()));
				studentCompany3.setState("pending");
				getStudent().getStudentCompany().add(studentCompany3);
			}
			if(!(getNewAppliedCompnay4()==null))
			{
				StudentCompany studentCompany4 =new StudentCompany();
				studentCompany4.setStudent(getStudent());
				studentCompany4.setCompany(registerStudent.getStudentAppliedCompanyObject(getNewAppliedCompnay4()));
				studentCompany4.setState("pending");
				getStudent().getStudentCompany().add(studentCompany4);
			}
			if(!(getNewAppliedCompnay5()==null))
			{
				StudentCompany studentCompany5 =new StudentCompany();
				studentCompany5.setStudent(getStudent());
				studentCompany5.setCompany(registerStudent.getStudentAppliedCompanyObject(getNewAppliedCompnay5()));
				studentCompany5.setState("pending");
				getStudent().getStudentCompany().add(studentCompany5);
			}
			
			for(StudentCompany stuCom:getStudent().getStudentCompany())
			{
				if(stuCom.getState().equals("Regected"))
				{
					System.out.println("its here");
					stuCom.setState("Applied");
				}
			}
			
			
			updateStudent.updateStudentNewAppliedCompany(getStudent());
			
			return SUCCESS;
		}

		
		
		
		
		// getters and setters
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//getters and setters
		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
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
