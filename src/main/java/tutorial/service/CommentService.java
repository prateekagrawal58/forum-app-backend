package tutorial.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.model.Comment;
import tutorial.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> getComment(String topicId) {
		List<Comment> comments = commentRepository.findByTopicId(Long.parseLong(topicId));
			
//			for (Comment comment : comments) {
//				if(comment.equals(newComment)) {
//					System.out.println("Getting the Comment");
//					return comments;			
//				}
//			}
			System.out.println("Comments Found!");
			return comments;
		}
		
	@Transactional
	public Comment addComment(Comment comment) {
		Comment comments = commentRepository.save(comment);
		System.out.println("Comment Added.");
		return comments;
		}	
}
