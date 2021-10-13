package tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tutorial.dto.ApiResponse;
import tutorial.model.Comment;
import tutorial.service.CommentService;
import tutorial.util.StatusBuilder;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	CommentService commentService;

	@GetMapping("/{TopicId}")
	public ApiResponse getComment(@Valid @PathVariable("topicId") String topicId) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = commentService.getComment(topicId);
			apiResponse = statusBuilder.Status(data, "Getting topic");
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
		}
		
		return apiResponse;
	}
	
	@PostMapping("/add")
	public ApiResponse addComment(@Valid @RequestBody Comment comment) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = commentService.addComment(comment);
			apiResponse = statusBuilder.Status(data, "Comment Added.");
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
		}
		
		return apiResponse;
	}
}

