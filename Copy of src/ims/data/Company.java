package ims.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name="Company")
public class Company {
	
	@Id
	private String companyUserName;
	private String companyName;
	private String companyTelephone;
	private String contactPerson;
	private String companyAddress;
	private String companyWeb;
	private String noOfVacancies;
	private boolean allowed;
	private boolean state;
	private boolean receiveCv;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.company", cascade=CascadeType.ALL)
	private Collection<StudentCompany> studentCompany = new ArrayList<StudentCompany>();
	
	

	//getters and setters
	public Collection<StudentCompany> getStudentCompany() {
		return studentCompany;
	}
	public void setStudentCompany(Collection<StudentCompany> studentCompany) {
		this.studentCompany = studentCompany;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public boolean isReceiveCv() {
		return receiveCv;
	}
	public void setReceiveCv(boolean receiveCv) {
		this.receiveCv = receiveCv;
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
