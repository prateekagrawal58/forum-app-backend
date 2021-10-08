package tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorial.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{

	List<Topic> findTopicById(long userId);
	
}
