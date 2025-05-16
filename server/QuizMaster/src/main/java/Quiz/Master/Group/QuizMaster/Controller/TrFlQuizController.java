package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Services.TrFlQuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class TrFlQuizController {
    @Autowired
    private final TrFlQuizService quizService;

    public TrFlQuizController(TrFlQuizService quizService) {
        this.quizService = quizService;
    }
    
}