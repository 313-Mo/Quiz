package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Services.QuizService;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class QuizController {
    // Aussicht 
    private static final String VIEW_SHARE_QUIZ = "shareQuiz";
    private static final String VIEW_SELECT_QUIZ = "selectQuiz";
    private static final String VIEW_BIOLOGIE_QUIZ = "biologieQuiz";
    private static final String VIEW_MATHE_QUIZ= "matheQuiz";
    private static final String VIEW_FINANZ_QUIZ = "finanzQuiz";
    private static final String VIEW_CHEMISTRY= "chemistry";
    private static final String VIEW_GEO = "geography";
    private static final String VIEW_HISTORY= "history";
    private static final String VIEW_COMPUTER_SCIENCE = "computerScience";
    private static final String VIEW_RANDOM = "random";
    private static final String VIEW_CATEGORY_SELECTION = "categorySelection";
    private static final String VIEW_QUIZ_SELECTION = "quizSelection";


    // Category

    private static final String CATEGORY_BIOLOGY = "Biology";
    private static final String CATEGORY_MATHEMATICS = "Mathematics";
    private static final String CATEGORY_FINANCE = "Finance";
    private static final String CATEGORY_CHEMISTRY = "Chemistry";
    private static final String CATEGORY_GEOGRAPHY = "Geography";
    private static final String CATEGORY_HISTORY = "History";
    private static final String CATEGORY_COMPUTER_SCIENCE = "Computer Science";
    private static final String CATEGORY_GENERAL = "General Knowlege";





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
        List<Quiz> quizzes = quizService.findByCategory(name);
        model.addAttribute("category", name);
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
        }
        else if (quiz instanceof TrueFalseQuiz) {
            TrueFalseQuiz tfQuiz = (TrueFalseQuiz) quiz;
            List<String> questions = tfQuiz.getQuestionList();
            model.addAttribute("questions", questions);
        }
        
        String category = quiz.getCategory(); 
         switch (category) {
            case CATEGORY_BIOLOGY:
            return VIEW_BIOLOGIE_QUIZ;

            case CATEGORY_MATHEMATICS:
                return VIEW_MATHE_QUIZ; 
            case CATEGORY_FINANCE:
                return VIEW_FINANZ_QUIZ;
            case CATEGORY_CHEMISTRY:
                return VIEW_CHEMISTRY; 
            case CATEGORY_GEOGRAPHY:
                return VIEW_GEO; 
            case CATEGORY_HISTORY:
                return VIEW_HISTORY; 
            case CATEGORY_COMPUTER_SCIENCE:
                return VIEW_COMPUTER_SCIENCE; 
            case CATEGORY_GENERAL:
                return VIEW_RANDOM;
            default:
                return VIEW_CATEGORY_SELECTION;
        }
    }

}
