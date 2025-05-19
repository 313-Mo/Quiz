package Quiz.Master.Group.QuizMaster.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Quiz.Master.Group.QuizMaster.Repositories.QuizUserRepository;
import Quiz.Master.Group.QuizMaster.Entities.QuizUser;

@Service
public class QuizUserService {
   private final QuizUserRepository userRepository;

   @Autowired
   public QuizUserService(QuizUserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public void createUser(String firstName, String lastName, String username, String password, String email, int age) {
        QuizUser user = new QuizUser(firstName, lastName, username, password, email, age);
        
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (age < 10) {
            throw new IllegalArgumentException("Too Young to Register");
        }
        if (age > 100) {
            throw new IllegalArgumentException("Reached Maximum Age Limit");
        }

        userRepository.save(user);
   }

   public boolean checkLogin(String username, String password) {
         QuizUser user = userRepository.findByUsername(username);
         if (user != null && user.getPassword().equals(password)) {
            return true;
         }
         return false;
    }
}

