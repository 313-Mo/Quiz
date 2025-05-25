package Quiz.Master.Group.QuizMaster.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Quiz.Master.Group.QuizMaster.Entities.Category;
import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Services.QuizService;



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
        //  Fehler 1 behoben: String → Category
        Category category = Category.fromLabel(name);
        List<Quiz> quizzes = quizService.findByCategory(category);

        model.addAttribute("category", category.getLabel()); // ❗ für Thymeleaf etc.
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
        }
        else if (quiz instanceof TrueFalseQuiz) {
            TrueFalseQuiz tfQuiz = (TrueFalseQuiz) quiz;
            List<String> questions = tfQuiz.getQuestionList();
            model.addAttribute("questions", questions);
        }
        
        Category category = quiz.getCategory(); // Typ: Category

        // Fehler 2 behoben: Category ist kein String → verwende getLabel()
        switch (category.getLabel()) {
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
// End of QuizController.java
        
        