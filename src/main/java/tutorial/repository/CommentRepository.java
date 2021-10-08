package tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tutorial.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByTopicId(Long topicId);
}

