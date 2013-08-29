package ims.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name="User")
public class User {
	
	@Id
	private String userName;
	private String password;
	private char type;
	
	
	
	
	
	

	// getters and setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	


}
