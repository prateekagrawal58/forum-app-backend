package tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutorial.dto.ApiResponse;
import tutorial.service.TopicService;
import tutorial.util.StatusBuilder;
import tutorial.model.Topic;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/topics")
public class TopicController {
	
	 @Autowired
	 TopicService topicService;
	 @GetMapping("/{userId}")
	 public ResponseEntity<Object> getTopicByUserId(@Valid @PathVariable("userId") String userId){
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.getTopicByUserId(userId);
				apiResponse = statusBuilder.Status(data, "Getting topic");
				return new ResponseEntity<>(apiResponse, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				apiResponse = statusBuilder.Error("Exception occured.");
				return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	 }
	 @ResponseBody
	 @GetMapping("/display-all")
	 public ResponseEntity<Object> getAllTopics(){
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.getAllTopics();
				apiResponse = statusBuilder.Status(data, "Fetching All Topics");
				return new ResponseEntity<>(apiResponse, HttpStatus.OK);
			} catch (Exception e) {
				apiResponse = statusBuilder.Error("Exception occured.");
				return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	 }
	 
	 @PostMapping("/add")
	 public ResponseEntity<Object> addTopic(@Valid @RequestBody Topic topic) {
		 StatusBuilder statusBuilder = new StatusBuilder();
			ApiResponse apiResponse;
			try {
				Object data = topicService.addTopic(topic);
				apiResponse = statusBuilder.Status(data, "Topic Added.");
				return new ResponseEntity<>(apiResponse, HttpStatus.OK);
			} catch (Exception e) {
				apiResponse = statusBuilder.Error("Exception occured.");
				return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	 }

}
