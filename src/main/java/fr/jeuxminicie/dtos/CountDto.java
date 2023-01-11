package fr.jeuxminicie.dtos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CountDto implements Serializable {
	
	private int nb;
	
	public int getNb() {
		return nb;
	}
	
	public void setNb(int nb) {
		this.nb = nb;
	}

}
