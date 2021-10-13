package tutorial.util;
import tutorial.dto.ApiResponse;

public class StatusBuilder {
	public ApiResponse Status(Object data, String message) {
		ApiResponse response = new ApiResponse(message, 1, data);
		return response;
	}
	
	public ApiResponse Error(String message) {
		ApiResponse response = new ApiResponse(message, 0, null);
		return response;
	}
}
