package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Services.QuizService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; // ✅ Wichtig: Map importieren!

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class QuizController {

    @Autowired
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/shareQuiz")
    public String showShareQuizPage() {
        return "shareQuiz";
    }

    @GetMapping("/selectQuiz")
    public String showSelectQuizPage() {
        return "selectQuiz";
    }

    @GetMapping("/BiologieQuiz")
    public String BiologieQuiz() {
        return "biologieQuiz";
    }

    @GetMapping("/MatheQuiz")
    public String MatheQuiz() {
        return "matheQuiz";
    }

    @GetMapping("/FinanzQuiz")
    public String FinanzQuiz() {
        return "finanzQuiz";
    }

    @GetMapping("/ChemieQuiz")
    public String ChemieQuiz() {
        return "chemistry";
    }

    @GetMapping("/GeoQuiz")
    public String GeoQuiz() {
        return "geography";
    }

    @GetMapping("/GeschichtsQuiz")
    public String GeschichtsQuiz() {
        return "history";
    }

    @GetMapping("/InformatikQuiz")
    public String InformatikQuiz() {
        return "computerScience";
    }

    @GetMapping("/category/{name}")
    public String showQuizzesByCategory(@PathVariable String name, Model model) {
        List<Quiz> quizzes = quizService.findByCategory(name);
        model.addAttribute("category", name);
        model.addAttribute("quizzes", quizzes);
        return "quizSelection";
    }

    @GetMapping("/quiz/{id}")
    public String showQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.findById(id);

        if (quiz instanceof MultipleChoiceQuiz) {
            MultipleChoiceQuiz muChoQuiz = (MultipleChoiceQuiz) quiz;
            List<Question> questions = muChoQuiz.getQuestionList();
            model.addAttribute("questions", questions);
        } else if (quiz instanceof TrueFalseQuiz) {
            TrueFalseQuiz tfQuiz = (TrueFalseQuiz) quiz;
            List<String> questionTexts = tfQuiz.getQuestionList();
            List<Boolean> answers = tfQuiz.getAnswerList();

            List<Map<String, Object>> combined = new ArrayList<>();
            for (int i = 0; i < questionTexts.size(); i++) {
                Map<String, Object> item = new HashMap<>();
                item.put("text", questionTexts.get(i));
                item.put("answer", answers.get(i));
                combined.add(item);
            }

            model.addAttribute("questions", combined);
        }

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
