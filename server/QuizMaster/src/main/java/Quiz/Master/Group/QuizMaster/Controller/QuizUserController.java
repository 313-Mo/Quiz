package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Services.QuizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizUserController {
   @Autowired
   private final QuizUserService userService;

   public QuizUserController(QuizUserService userService) {
      this.userService = userService;
   }

   @GetMapping("/signUp")
   public String signUp() {
      return "signUp"; 
   }

   @PostMapping("/checkSignUp")
   public String signUp(String firstName, String lastName, String username, String password, String email, int age) {
      try {
         userService.createUser(firstName, lastName, username, password, email, age);
         return "redirect:/logIn"; 
      } catch (IllegalArgumentException e) {
         return "signUp"; 
      }
   }

   @GetMapping("/logIn")
   public String logIn(String username, String password) {
         return "logIn";
   }

   @PostMapping("/checkLogIn")
   public String checkLogIn(String username, String password) {
      if (userService.checkLogin(username, password)) {
         return "redirect:/categorySelection"; 
      } else {
         return "logIn"; 
      }
   }

   @GetMapping("/")
   public String startPage() {
      return "startPage"; 
   }

   @GetMapping("/categorySelection")
   public String categorySelection() {
      return "categorySelection"; 
   }
}
