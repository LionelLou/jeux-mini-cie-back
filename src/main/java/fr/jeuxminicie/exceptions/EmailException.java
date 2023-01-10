package fr.jeuxminicie.exceptions;

@SuppressWarnings("serial")
public class EmailException extends Exception {

	public EmailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailException(String message, Throwable cause) {
		super("EmailException : " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmailException(String message) {
		super("EmailException : " + message);
		// TODO Auto-generated constructor stub
	}

	public EmailException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
