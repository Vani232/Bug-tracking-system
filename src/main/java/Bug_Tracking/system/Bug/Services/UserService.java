package Bug_Tracking.system.Bug.Services;
import Bug_Tracking.system.Bug.Entities.User;
import Bug_Tracking.system.Bug.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo= userRepo;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public boolean deleteUserById(int id) {
        //Check if the user with the given ID exists in the database
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()) {
            //Delete the user from the database
            userRepo.deleteById(id);
            return true;
        } else {
            //Return false if the user with the given ID is not found in the database
            return false;
        }
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(int id, User updatedUser) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            // Set other properties to be updated
            // ...

            return userRepo.save(existingUser);
        } else {
            return null;
        }
    }
}
