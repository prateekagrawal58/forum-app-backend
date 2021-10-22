package tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tutorial.dto.ApiResponse;
import tutorial.model.Comment;
import tutorial.service.CommentService;
import tutorial.util.StatusBuilder;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/comments")
public class CommentController {
	@Autowired
	CommentService commentService;

	@GetMapping("/{TopicId}")
	public ResponseEntity<Object> getComment(@Valid @PathVariable("topicId") String topicId) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = commentService.getComment(topicId);
			apiResponse = statusBuilder.Status(data, "Getting Comments!");
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add-comment")
	public ResponseEntity<Object> addComment(@Valid @RequestBody Comment comment) {
		StatusBuilder statusBuilder = new StatusBuilder();
		ApiResponse apiResponse;
		try {
			Object data = commentService.addComment(comment);
			apiResponse = statusBuilder.Status(data, "Comment Added.");
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			apiResponse = statusBuilder.Error("Exception occured.");
			return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

