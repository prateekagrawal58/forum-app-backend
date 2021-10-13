package tutorial.service;

import tutorial.model.User;
import tutorial.repository.UserRepository;
import tutorial.exception.UserNotExist;
import tutorial.model.Status;	

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User loginUser(User user) throws UserNotExist {
		User userFound = userRepository.findByUsername(user.getUsername());
		
		
		if( user.getPassword().equals(userFound.getPassword())) {
			return userFound;
		}
		else {
			throw new UserNotExist("User doesn't exist");
		}
		
	}
	
	public Status logUserOut(User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

	@Transactional
	public Status registerUser(User newUser) {
		List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
	}
}
