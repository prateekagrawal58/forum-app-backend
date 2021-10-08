package tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tutorial.model.Comment;
import tutorial.model.Topic;
import tutorial.repository.CommentRepository;
import tutorial.repository.UserRepository;
import tutorial.model.Status;
import tutorial.model.User;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
    CommentRepository commentRepository;
	@GetMapping("{topicId}")

	public List<Comment> getComment(@Valid @PathVariable("topicId") String topicId) {
	List<Comment> comments = commentRepository.findByTopicId(Long.parseLong(topicId));
		
//		for (Comment comment : comments) {
//			if(comment.equals(newComment)) {
//				System.out.println("Getting the Comment");
//				return comments;			
//			}
//		}
			return comments;
	}
	
	@PostMapping
	public Comment addComment(@Valid @RequestBody Comment comment) {
		Comment comments = commentRepository.save(comment);
		return comments;
	}	
}