package Quiz.Master.Group.QuizMaster.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.TrFlQuizRepository;

@Controller
public class trueFalseErstellenController {

    @Autowired
    private TrFlQuizRepository trFlQuizRepository;

    @GetMapping("/add-truefalse-quiz")
    public String showTrueFalseQuizForm(Model model) {
        model.addAttribute("quiz", new TrFlQuiz());
        return "true_false_quiz";
    }

    
    @PostMapping("/add-truefalse-quiz")
public String handleTrueFalseSubmission(
        @RequestParam("category") String category,
        @RequestParam("selectedTime") int selectedTime,
        @RequestParam("question") String questionText,
        @RequestParam("answer") boolean answerValue
) {
    TrFlQuiz quiz = new TrFlQuiz();
    quiz.setCategory(category);
    quiz.setTimeLimit(selectedTime);
    quiz.setNumberOfQuestions(1);
    quiz.setQuestionList(List.of(questionText));
    quiz.setAnswerList(List.of(answerValue));

    trFlQuizRepository.save(quiz);
    return "redirect:/add-truefalse-quiz";
}

}
