package fr.jeuxminicie.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends Exception{

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String message, Throwable cause) {
		super("NotFoundException : " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String message) {
		super("NotFoundException : " + message);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
