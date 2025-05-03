package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MuChoQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Services.MuChoQuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class MuChoQuizController {
    @Autowired
    private final MuChoQuizService quizService;

    public MuChoQuizController(MuChoQuizService quizService) {
        this.quizService = quizService;
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
        List<MuChoQuiz> quizzes = quizService.findByCategory(name);
        model.addAttribute("category", name);
        model.addAttribute("quizzes", quizzes);
        return "quizSelection";
    }

    @GetMapping("/quiz/{id}")
    public String showQuiz(@PathVariable Long id, Model model) {
        MuChoQuiz quiz = quizService.findById(id);
        List<Question> questions = quiz.getQuestionList();
        model.addAttribute("quiz", quiz);
        model.addAttribute("questions", questions);
        String category = quiz.getCategory(); 
        switch (category) {
            case "Biology":
                return "biology"; 
            case "Math":
                return "math"; 
            case "Finance":
                return "finance"; 
            case "Chemistry":
                return "chemistry"; 
            case "Geography":
                return "geography"; 
            case "History":
                return "history"; 
            case "Computer Science":
                return "computerScience"; 
            default:
                return "categorySelection";
        }
    }

}