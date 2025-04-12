package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Services.QuizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuizUserController {
   @Autowired
   private final QuizUserService userService;

   public QuizUserController(QuizUserService userService) {
      this.userService = userService;
   }
}
