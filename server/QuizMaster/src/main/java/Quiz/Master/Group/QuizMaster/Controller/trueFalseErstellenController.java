package Quiz.Master.Group.QuizMaster.Controller;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;
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
            @RequestParam("answer") boolean answerValue) {
    Optional<TrFlQuiz> optionalQuiz = trFlQuizRepository.findByCategory(category);

TrFlQuiz quiz = optionalQuiz.orElseGet(() -> {
    TrFlQuiz newQuiz = new TrFlQuiz();
    newQuiz.setCategory(category);
    newQuiz.setTimeLimit(selectedTime);
    newQuiz.setQuestionList(new ArrayList<>());
    newQuiz.setAnswerList(new ArrayList<>());
    return newQuiz;
});

        quiz.getQuestionList().add(questionText);
        quiz.getAnswerList().add(answerValue);
        quiz.setNumberOfQuestions(quiz.getQuestionList().size());

        trFlQuizRepository.save(quiz);
        return "redirect:/add-truefalse-quiz";
    }

}
