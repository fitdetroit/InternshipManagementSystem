package ims.data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name="Student_Professional_Exp")
public class StudentProfessionalExp {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int professionalExpId;

	private String companyName;
	private String workingPeriod;
	private String profession;
	private String briefDescription;
	
	
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="studentUserName")
	private Student student;
	
	
	
	
	
	
	
	
	
	//getters and setters
	
	public int getProfessionalExpId() {
		return professionalExpId;
	}
	public void setProfessionalExpId(int professionalExpId) {
		this.professionalExpId = professionalExpId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWorkingPeriod() {
		return workingPeriod;
	}
	public void setWorkingPeriod(String workingPeriod) {
		this.workingPeriod = workingPeriod;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getBriefDescription() {
		return briefDescription;
	}
	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}
	

}
