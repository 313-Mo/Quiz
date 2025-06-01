package Quiz.Master.Group.QuizMaster.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Quiz.Master.Group.QuizMaster.Services.QuizUserService;


@Controller
public class QuizUserController {

   //Aussicht ---> Pages
   private static final String VIEW_SIGN_UP = "signUp";
   private static final String VIEW_LOGIN = "logIn";
   private static final String VIEW_START_PAGE = "startPage";
   private static final String VIEW_CATEGORY_SELECTION = "categorySelection";

   private static final String REDIRECT_LOGIN = "redirect:/logIn";

   private static final String REDIRECT_CATEGORY_SELECTION = "redirect:/categorySelection";


   private static final String  ATTR_ERROR = "error";


   @Autowired
   private final QuizUserService userService;

   public QuizUserController(QuizUserService userService) {
      this.userService = userService;
   }

   @GetMapping("/signUp")
   public String signUp() {
      return VIEW_SIGN_UP; 
   }

   @PostMapping("/checkSignUp")
   public String signUp(String firstName, String lastName, String username, String password, String email, int age, Model model) {
      try {
         userService.createUser(firstName, lastName, username, password, email, age);
         return REDIRECT_LOGIN; 
      } catch (IllegalArgumentException e) {
         model.addAttribute(ATTR_ERROR, e.getMessage());
         return VIEW_SIGN_UP; 
      }
   }

   @GetMapping("/logIn")
   public String logIn(String username, String password) {
         return VIEW_LOGIN;
   }

   @PostMapping("/checkLogIn")
   public String checkLogIn(String username, String password) {
      if (userService.checkLogin(username, password)) {
         return REDIRECT_CATEGORY_SELECTION; 
      } else {
         return VIEW_LOGIN; 
      }
   }

   @GetMapping("/")
   public String startPage() {
      return VIEW_START_PAGE; 
   }

   @GetMapping("/categorySelection")
   public String categorySelection() {
      return VIEW_CATEGORY_SELECTION; 
   }
}
