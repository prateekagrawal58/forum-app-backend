package tutorial.controller;
import tutorial.model.User;
import tutorial.requests.CreateUserRequest;
import tutorial.dto.ApiResponse;
import tutorial.service.UserService;
import tutorial.util.StatusBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
//Response Entity Utility: Body, Header,  HTTP Status Code
    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
    	StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
//			Object data = userService.registerUser(createUserRequest);
			apiResponse = statusBuilder.Status(userService.registerUser(createUserRequest), "User Registered Successfully");
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
// apiResponse --> returns only body
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody User user) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = userService.loginUser(user);
			apiResponse = statusBuilder.Status(data, "User Found");
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("User does not exist.");
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/logout")
    public ResponseEntity<Object> logUserOut(@Valid @RequestBody User user) {
    	StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = userService.logUserOut(user);
			apiResponse = statusBuilder.Status(data, "Logged out Successfully!");
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception Occured.");
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}

