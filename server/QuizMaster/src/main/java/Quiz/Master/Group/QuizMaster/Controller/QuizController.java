package Quiz.Master.Group.QuizMaster.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Services.QuizService;
import Quiz.Master.Group.QuizMaster.Entities.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

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
        return VIEW_SHARE_QUIZ; 
    }

    @GetMapping("/selectQuiz")
    public String showSelectQuizPage() {
        return VIEW_SELECT_QUIZ; 
    }

    @GetMapping("/BiologieQuiz")
    public String BiologieQuiz() {
        return VIEW_BIOLOGIE_QUIZ; 
    }

    @GetMapping("/MatheQuiz")
    public String MatheQuiz() {
        return VIEW_MATHE_QUIZ; 
    }

    @GetMapping("/FinanzQuiz")
    public String FinanzQuiz() {
        return VIEW_FINANZ_QUIZ; 
    }

    @GetMapping("/ChemieQuiz")
    public String ChemieQuiz() {
        return VIEW_CHEMISTRY; 
    }

    @GetMapping("/GeoQuiz")
    public String GeoQuiz() {
        return VIEW_GEO; 
    }

    @GetMapping("/GeschichtsQuiz")
    public String GeschichtsQuiz() {
        return VIEW_HISTORY; 
    }

    @GetMapping("/InformatikQuiz")
    public String InformatikQuiz() {
        return VIEW_COMPUTER_SCIENCE; 
    }

    @GetMapping("/category/{name}")
    public String showQuizzesByCategory(@PathVariable String name, Model model) {
        //  Fehler 1 behoben: String → Category
        Category category = Category.fromLabel(name);
        List<Quiz> quizzes = quizService.findByCategory(category);

        model.addAttribute("category", category.getLabel()); // ❗ für Thymeleaf etc.
        model.addAttribute("quizzes", quizzes);
        return VIEW_QUIZ_SELECTION;
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
        
        Category category = quiz.getCategory(); 
         switch (category) {
            case BIOLOGY:
                return VIEW_BIOLOGIE_QUIZ;
            case MATH:
                return VIEW_MATHE_QUIZ; 
            case FINANCE:
                return VIEW_FINANZ_QUIZ;
            case CHEMISTRY:
                return VIEW_CHEMISTRY; 
            case GEOGRAPHY:
                return VIEW_GEO; 
            case HISTORY:
                return VIEW_HISTORY; 
            case COMPUTER_SCIENCE:
                return VIEW_COMPUTER_SCIENCE; 
            case RANDOM:
                return VIEW_RANDOM;
            default:
                return VIEW_CATEGORY_SELECTION;
        }
    }
}
// End of QuizController.java
        
        
