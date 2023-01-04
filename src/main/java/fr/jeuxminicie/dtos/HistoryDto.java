package fr.jeuxminicie.dtos;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class HistoryDto implements Serializable {

	
	private long id;
	
	private long userId;
	
	private long gameId;
	
	private long bestScoreId;
	
	private int totalTimeSpent;
	
	private int totalTimesPlayed;
	
	private int version;
	

	public HistoryDto() {
		super();
	}

	public HistoryDto(long id, long userId, long gameId, long bestScoreId, int totalTimeSpent, int totalTimesPlayed,
			int version) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameId = gameId;
		this.bestScoreId = bestScoreId;
		this.totalTimeSpent = totalTimeSpent;
		this.totalTimesPlayed = totalTimesPlayed;
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

	public long getBestScoreId() {
		return bestScoreId;
	}

	public void setBestScoreId(long bestScoreId) {
		this.bestScoreId = bestScoreId;
	}

	public int getTotalTimeSpent() {
		return totalTimeSpent;
	}

	public void setTotalTimeSpent(int totalTimeSpent) {
		this.totalTimeSpent = totalTimeSpent;
	}

	public int getTotalTimesPlayed() {
		return totalTimesPlayed;
	}

	public void setTotalTimesPlayed(int totalTimesPlayed) {
		this.totalTimesPlayed = totalTimesPlayed;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bestScoreId, gameId, id, totalTimeSpent, totalTimesPlayed, userId, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryDto other = (HistoryDto) obj;
		return bestScoreId == other.bestScoreId && gameId == other.gameId && id == other.id
				&& totalTimeSpent == other.totalTimeSpent && totalTimesPlayed == other.totalTimesPlayed
				&& userId == other.userId && version == other.version;
	}

	@Override
	public String toString() {
		return "HistoryDto [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", bestScoreId=" + bestScoreId
				+ ", totalTimeSpent=" + totalTimeSpent + ", totalTimesPlayed=" + totalTimesPlayed + ", version="
				+ version + "]";
	}
	
	
	
}
