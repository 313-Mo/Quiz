package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;
import Quiz.Master.Group.QuizMaster.Services.TrFlQuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/truefalse")
public class TrFlQuizController {

    private final TrFlQuizService quizService;

    @Autowired
    public TrFlQuizController(TrFlQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/category/{name}")
    public String showQuizzesByCategory(@PathVariable String name, Model model) {
        List<TrFlQuiz> quizzes = quizService.findByCategory(name);
        model.addAttribute("category", name);
        model.addAttribute("quizzes", quizzes);
        return "quizSelection";  
    }

  @GetMapping("/quiz/{id}")
public String showQuiz(@PathVariable Long id, Model model) {
    TrFlQuiz quiz = quizService.findById(id);
    if (quiz == null) {
        model.addAttribute("message", "Quiz nicht gefunden.");
        return "quizSelection";
    }

   
    List<Map<String, Object>> questions = new ArrayList<>();
    for (int i = 0; i < quiz.getQuestionList().size(); i++) {
        String questionText = quiz.getQuestionList().get(i);
        Boolean answerBool = quiz.getAnswerList().get(i);
        String correctAnswer = answerBool ? "Wahr" : "Falsch";

        Map<String, Object> q = new HashMap<>();
        q.put("questionText", questionText);
        q.put("options", List.of("Wahr", "Falsch"));  
        q.put("correctAnswer", correctAnswer);

        questions.add(q);
    }

    model.addAttribute("questions", questions);
    model.addAttribute("category", quiz.getCategory());

    // Je nach Kategorie die View auswählen
    String category = quiz.getCategory();
    switch (category) {
        case "Biology":
            return "biologieQuiz";
        case "Mathematics":
            return "matheQuiz";
        case "Finance":
            return "finanzQuiz"; 
        case "Chemistry":
            return "chemistry";
        case "Geography":
            return "geography";
        case "History":
            return "history";
        case "Computer Science":
            return "computerScience";
        case "General Knowledge":
            return "random";
        default:
            return "categorySelection";
    }
}

}
