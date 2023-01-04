package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class UserDto implements Serializable {

	
	private long id;
	
	private String email;
	
	private String login;
	
	private int version;
	

	public UserDto() {
		super();
	}


	public UserDto(long id, String email, String login, int version) {
		super();
		this.id = id;
		this.email = email;
		this.login = login;
		this.version = version;
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


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, login, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(login, other.login)
				&& version == other.version;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", login=" + login + ", version=" + version + "]";
	}

}
