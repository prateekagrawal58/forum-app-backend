package tutorial.controller;
import tutorial.model.User;
import tutorial.dto.ApiResponse;
import tutorial.service.UserService;
import tutorial.util.StatusBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ApiResponse registerUser(@Valid @RequestBody User newUser) {
    	StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = userService.registerUser(newUser);
			apiResponse = statusBuilder.Status(data, "User Registered Successfully");
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
		}
		
		return apiResponse;
    }

    @PostMapping("/login")
    public ApiResponse loginUser(@Valid @RequestBody User user) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = userService.loginUser(user);
			apiResponse = statusBuilder.Status(data, "User Found");
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("User does not exist.");
		}
		
		return apiResponse;
    }
    
    @PostMapping("/logout")
    public ApiResponse logUserOut(@Valid @RequestBody User user) {
    	StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = userService.logUserOut(user);
			apiResponse = statusBuilder.Status(data, "Logged out Successfully!");
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception Occured.");
		}
		
		return apiResponse;
    }
    
}

