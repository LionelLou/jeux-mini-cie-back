package fr.jeuxminicie.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Game game;
	
	private int score;
	
	@Column(nullable = true)
	private int time; 
	
	@Version
	private int version;
	
	

	public Score() {
		super();
	}


	public Score(long id, User user, Game game, int score, int time, int version) {
		super();
		this.id = id;
		this.user = user;
		this.game = game;
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
		return Objects.hash(game, id, score, time, user, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(game, other.game) && id == other.id && score == other.score && time == other.time
				&& Objects.equals(user, other.user) && version == other.version;
	}


	@Override
	public String toString() {
		return "Score [id=" + id + ", user=" + user + ", game=" + game + ", score=" + score + ", time=" + time
				+ ", version=" + version + "]";
	}
	
}
