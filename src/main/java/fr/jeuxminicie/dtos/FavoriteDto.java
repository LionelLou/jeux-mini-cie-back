package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class FavoriteDto implements Serializable{

	private long id;
	
	private long userId;
	
	private long gameId;
	
	private int version;


	public FavoriteDto() {
		super();
	}

	public FavoriteDto(long id, long userId, long gameId, int version) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameId = gameId;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, id, userId, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteDto other = (FavoriteDto) obj;
		return gameId == other.gameId && id == other.id && userId == other.userId && version == other.version;
	}

	@Override
	public String toString() {
		return "FavoriteDto [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", version=" + version + "]";
	}
	
}
