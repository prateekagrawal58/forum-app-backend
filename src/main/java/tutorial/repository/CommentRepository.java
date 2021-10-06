package tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tutorial.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
}

