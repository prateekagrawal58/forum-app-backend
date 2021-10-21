package tutorial.dto;
	
public class ApiResponse {

	private String message;
	private int statusCode;
	private Object data;
	
	public ApiResponse(String message, int statusCode, Object data) {
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	

}
//Response entity