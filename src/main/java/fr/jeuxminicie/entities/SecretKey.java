package fr.jeuxminicie.entities;

import java.security.Key;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SecretKey implements Key {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8105220298184260169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(columnDefinition = "BLOB")
	private byte[] secretKey;


	@Override
	public String getAlgorithm() {
		return "HS512";
	}


	@Override
	public String getFormat() {
		return "byte[]";
	}


	@Override
	public byte[] getEncoded() {
		return this.secretKey;
	}
}

