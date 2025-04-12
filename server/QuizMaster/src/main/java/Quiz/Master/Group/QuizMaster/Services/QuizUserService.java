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

   public void createUser(String username, String password, String email, int age) {
        QuizUser user = new QuizUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAge(age);
    
        userRepository.save(user);
   }
}

