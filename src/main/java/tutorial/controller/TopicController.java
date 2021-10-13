package tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.dto.ApiResponse;
import tutorial.service.TopicService;
import tutorial.util.StatusBuilder;
import tutorial.model.Topic;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/topics")
public class TopicController {
	
	 @Autowired
	 TopicService topicService;
	 @GetMapping("/{userId}")
	 public ApiResponse getTopicByUserId(@Valid @PathVariable("userId") String userId){
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.getTopicByUserId(userId);
				apiResponse = statusBuilder.Status(data, "Getting topic");
			} catch (Exception e) {
				apiResponse = statusBuilder.Error("Exception occured.");
			}
			
			return apiResponse;
	 }
	 
	 @GetMapping("/display-all")
	 public ApiResponse getAllTopics(){
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.getAllTopics();
				apiResponse = statusBuilder.Status(data, "Fetching All Topics");
			} catch (Exception e) {
				apiResponse = statusBuilder.Error("Exception occured.");
			}
			
			return apiResponse;
	 }
	 
	 @PostMapping("/add")
	 public ApiResponse addTopic(@Valid @RequestBody Topic topic) {
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.addTopic(topic);
				apiResponse = statusBuilder.Status(data, "Topic Added.");
			} catch (Exception e) {
				apiResponse = statusBuilder.Error("Exception occured.");
			}
			
			return apiResponse;
	 }

}
