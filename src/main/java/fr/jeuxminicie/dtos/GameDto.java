package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class GameDto implements Serializable {

	
	private long id;
	
	private String name;
	
	private int version;
	
	
	public GameDto() {
		super();
	}


	public GameDto(long id, String name, int version) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDto other = (GameDto) obj;
		return id == other.id && Objects.equals(name, other.name) && version == other.version;
	}


	@Override
	public String toString() {
		return "GameDto [id=" + id + ", name=" + name + ", version=" + version + "]";
	}
	
	
	
}
