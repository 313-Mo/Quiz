package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MuChoQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.MuChoQuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MultipleChoicQuizErstellenController {

    @Autowired
    private MuChoQuizRepository muChoQuizRepository;

    @GetMapping("/add-quiz")
    public String showAddQuizPage(org.springframework.ui.Model model) {
        model.addAttribute("quiz", new MuChoQuiz());
        return "multiple_choice_quiz";
    }

    @PostMapping("/add-quiz")
    public String handleQuizSubmission(
            @RequestParam("category") String category,
            @RequestParam("selectedTime") int selectedTime,
            @RequestParam("question") String questionText,
            @RequestParam("option1") String option1,
            @RequestParam("option2") String option2,
            @RequestParam("option3") String option3,
            @RequestParam("option4") String option4,
            @RequestParam("correct-answer") String correctAnswerKey
    ) {
        
        List<String> options = List.of(option1, option2, option3, option4);

        
        String correctAnswer = switch (correctAnswerKey) {
            case "option1" -> option1;
            case "option2" -> option2;
            case "option3" -> option3;
            case "option4" -> option4;
            default -> null;
        };

        Question question = new Question();
        question.setQuestionText(questionText);
        question.setOptions(options);
        question.setCorrectAnswer(correctAnswer);

        MuChoQuiz quiz = new MuChoQuiz();
        quiz.setCategory(category);
        quiz.setTimeLimit(selectedTime);
        quiz.setNumberOfQuestions(1);
        quiz.setQuestionList(List.of(question));

        muChoQuizRepository.save(quiz);
        return "redirect:/add-quiz";
 
    }
}