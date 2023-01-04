package fr.jeuxminicie.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class ScoreDto implements Serializable {

	
	private long id;
	
	private long userId;
	
	private long gameId;
	
	private int score;
	
	private int time;
	
	private int version;
	

	public ScoreDto() {
		super();
	}

	public ScoreDto(long id, long userId, long gameId, int score, int time, int version) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameId = gameId;
		this.score = score;
		this.time = time;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, id, score, time, userId, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreDto other = (ScoreDto) obj;
		return gameId == other.gameId && id == other.id && score == other.score && time == other.time
				&& userId == other.userId && version == other.version;
	}

	@Override
	public String toString() {
		return "ScoreDto [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", score=" + score + ", time="
				+ time + ", version=" + version + "]";
	}
	
}
