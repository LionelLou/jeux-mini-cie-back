package fr.jeuxminicie.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String login;
	
	private String password;
	
	@Version
	private int version;
	

	public User() {
		super();
	}

	
	public User(long id, String firstName, String email, String login, String password, int version) {
		super();
		this.id = id;
		this.email = email;
		this.login = login;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, login, password, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(login, other.login)
				&& Objects.equals(password, other.password) && version == other.version;
	}


}
