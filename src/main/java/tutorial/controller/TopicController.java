package tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tutorial.model.Comment;
import tutorial.model.Topic;
import tutorial.repository.CommentRepository;
import tutorial.repository.UserRepository;
import tutorial.repository.TopicRepository;
import tutorial.model.Status;
import tutorial.model.User;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/topics")
public class TopicController {
	
	 @Autowired
	 TopicRepository topicRepository;
	 
	 public List<Topic> getTopicByUserId(@Valid @PathVariable("userId") String userId){
		 List<Topic> topics = topicRepository.findTopicById(Long.parseLong(userId));
		return topics;
	 }
	 
	 public List<Topic> getAllTopics(@Valid @RequestBody Topic topic){
		 List<Topic> topics = topicRepository.findAll();
		 return topics;
	 }
	 
	 public Topic addTopic(@RequestBody Topic topic) {
		 Topic addTopic = topicRepository.save(topic);
		 return addTopic;
	 }

}
