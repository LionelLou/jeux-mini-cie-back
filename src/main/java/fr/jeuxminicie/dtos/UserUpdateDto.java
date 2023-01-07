package fr.jeuxminicie.dtos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserUpdateDto implements Serializable {

	
	private long id;
	
	private String email;
	
	private String newEmail;
	
	private String login;
	
	private String password;
	
	private String newPassword;
	
	

	public UserUpdateDto() {
		super();
	}



	public UserUpdateDto(long id, String email, String newEmail, String login, String newLogin, String password,
			String newPassword) {
		super();
		this.id = id;
		this.email = email;
		this.newEmail = newEmail;
		this.login = login;
		this.password = password;
		this.newPassword = newPassword;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNewEmail() {
		return newEmail;
	}



	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNewPassword() {
		return newPassword;
	}



	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
	
	
}
