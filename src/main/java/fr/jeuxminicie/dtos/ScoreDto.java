package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("serial")
public class ScoreDto implements Serializable {

	
	private long id;
	
	private long userId;
	
	private long gameId;
	
	private int score;
	
	private int time;
	
	private LocalDate date;
	
	private int version;
	

	public ScoreDto() {
		super();
	}
	
	
	public ScoreDto(long id, long userId, long gameId, int score, int time, LocalDate date, int version) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameId = gameId;
		this.score = score;
		this.time = time;
		this.date = date;
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

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, gameId, id, score, time, userId, version);
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
		return Objects.equals(date, other.date) && gameId == other.gameId && id == other.id && score == other.score
				&& time == other.time && userId == other.userId && version == other.version;
	}


	@Override
	public String toString() {
		return "ScoreDto [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", score=" + score + ", time="
				+ time + ", date=" + date + ", version=" + version + "]";
	}


}
