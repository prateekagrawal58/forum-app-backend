package tutorial.exception;

public class UserNotExist extends Exception{
	public UserNotExist(String error) {
		super(error);
	}
}
