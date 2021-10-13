package tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tutorial.model.Topic;
import tutorial.repository.TopicRepository;

public class TopicService {
	@Autowired
	 TopicRepository topicRepository;
	 public List<Topic> getTopicByUserId( String userId){
		 List<Topic> topics = topicRepository.findByUserId(Long.parseLong(userId));
		return topics;
	 }
	 
	 public List<Topic> getAllTopics(){
		 List<Topic> topics = topicRepository.findAll();
		 System.out.println("Topics Found!");
		 return topics;
	 }
	 
	 @Transactional
	 public Topic addTopic(Topic topic) {
		 Topic addTopic = topicRepository.save(topic);
		 System.out.println("Topic Added.");
		 return addTopic;
	 }

}
