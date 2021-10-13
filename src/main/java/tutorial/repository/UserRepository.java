package tutorial.repository;

//public interface UserRepository {
//
//}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tutorial.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}