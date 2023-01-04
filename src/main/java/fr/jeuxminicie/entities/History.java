package fr.jeuxminicie.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class History {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Game game;
	
	@OneToOne
	private Score bestScore;
	
	private int totalTimeSpent;
	
	private int totalTimesPlayed;
	
	@Version
	private int version;
	

	public History() {
		super();
	}

	public History(long id, User user, Game game, Score bestScore, int totalTimeSpent, int totalTimesPlayed,
			int version) {
		super();
		this.id = id;
		this.user = user;
		this.game = game;
		this.bestScore = bestScore;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Score getBestScore() {
		return bestScore;
	}

	public void setBestScore(Score bestScore) {
		this.bestScore = bestScore;
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
		return Objects.hash(bestScore, game, id, totalTimeSpent, totalTimesPlayed, user, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return Objects.equals(bestScore, other.bestScore) && Objects.equals(game, other.game) && id == other.id
				&& totalTimeSpent == other.totalTimeSpent && totalTimesPlayed == other.totalTimesPlayed
				&& Objects.equals(user, other.user) && version == other.version;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", user=" + user + ", game=" + game + ", bestScore=" + bestScore
				+ ", totalTimeSpent=" + totalTimeSpent + ", totalTimesPlayed=" + totalTimesPlayed + ", version="
				+ version + "]";
	}
	
	
}
