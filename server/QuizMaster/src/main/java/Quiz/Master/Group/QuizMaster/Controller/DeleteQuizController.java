package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeleteQuizController {

  
    private static final String VIEW_DELETE_QUIZ = "deleteQuiz";
    private static final String REDIRECT_CATEGORY_SELECTION = "redirect:/categorySelection";
    private static final String PARAM_QUIZ_ID = "quizId";

    private static final String MODEL_QUIZZES = "quizzes";

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/deleteQuiz")
    public String showDeleteQuizPage(Model model) {
        List<Quiz> quizzes = quizRepository.findAll();
        model.addAttribute(MODEL_QUIZZES, quizzes);
        return VIEW_DELETE_QUIZ;
    }

    @PostMapping("/deleteQuiz")
    public String deleteQuiz(@RequestParam(PARAM_QUIZ_ID) Long quizId) {
        quizRepository.deleteById(quizId);
        return REDIRECT_CATEGORY_SELECTION;
    }
}
