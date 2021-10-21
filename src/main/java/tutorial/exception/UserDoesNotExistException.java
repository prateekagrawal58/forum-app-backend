package tutorial.exception;

public class UserDoesNotExistException extends Exception{
	public UserDoesNotExistException(String error) {
		super(error);
	}
}
// Review on Exception Handling