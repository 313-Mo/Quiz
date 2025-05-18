package Quiz.Master.Group.QuizMaster.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class selectQuizController {

    @GetMapping("/selectQuiz")
    public String showSelectQuizPage() {
        return "selectQuiz"; 
    }
}
