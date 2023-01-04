package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class NewUserDto implements Serializable {

	private String email;
	
	private String login;
	
	private String password;
	

	public NewUserDto() {
		super();
	}

	public NewUserDto(String email, String login, String password) {
		super();
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewUserDto other = (NewUserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password);
	}
	
}
