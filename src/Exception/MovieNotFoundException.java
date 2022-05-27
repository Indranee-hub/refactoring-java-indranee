package Exception;

public class MovieNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public MovieNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MovieNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public MovieNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
