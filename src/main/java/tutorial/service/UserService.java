package tutorial.service;

import tutorial.model.User;
import tutorial.repository.UserRepository;
import tutorial.exception.UserDoesNotExistException;
import tutorial.model.Status;	
import tutorial.requests.CreateUserRequest;

//import java.util.List;
import java.util.Optional;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	

	public User loginUser(User user) throws UserDoesNotExistException {
		User userFound = userRepository.findByUsername(user.getUsername());
		
		
		if( user.getPassword().equals(userFound.getPassword())) {
			return userFound;
		}
		else {
			throw new UserDoesNotExistException("User doesn't exist");
		}
		
	}
	
	public Status logUserOut(User user) {
        Optional<User> dbUser = userRepository.findById(user.getId());
      
            if (dbUser.isPresent()) {
                dbUser.get().setLoggedIn(false);
                userRepository.save(dbUser.get());
                return Status.SUCCESS;
            }
        
// Changes for DAO - Database Level
        return Status.FAILURE;
    }

	@Transactional
	public User registerUser(CreateUserRequest createUserRequest) {
//		List<User> users = userRepository.findAll();
//
//        for (User user : users) {
//            if (user.equals(newUser)) {
//                System.out.println("User Already exists!");
//                return Status.USER_ALREADY_EXISTS;
//            }
		
		User user = new User();
		user.setUsername(createUserRequest.getUsername());
		if(createUserRequest.getPassword().length()<7 ||
				!createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())){
			//System.out.println("Error - Either length is less than 7 or pass and conf pass do not match. Unable to create ",
			//		createUserRequest.getUsername());
//			return ResponseEntity.badRequest().build();
		}
		user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
		User newUser = userRepository.save(user);
		return newUser;
//		return ResponseEntity.ok(user);
        }
}
// Custom 
// ** [IMP] Performance upgrade
     
	

