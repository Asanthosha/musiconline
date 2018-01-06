package musiconlinebackend.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component 

@Entity
public class User implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String name;
	private String password;
	private String roll;
	private String address;
	private String phone;
	private String enabled;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
}
