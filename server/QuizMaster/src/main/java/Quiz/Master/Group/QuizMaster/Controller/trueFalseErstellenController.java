package Quiz.Master.Group.QuizMaster.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

@Controller
public class trueFalseErstellenController {

    @Autowired
    private QuizRepository trFlQuizRepository;

    private static final List<String> tempQuestionList = new ArrayList<>();
    private static final List<Boolean> tempAnswerList = new ArrayList<>();

    @GetMapping("/add-truefalse-quiz")
    public String showTrueFalseQuizForm(Model model) {
        model.addAttribute("quiz", new TrueFalseQuiz());
        return "true_false_quiz";
    }

    @PostMapping("/add-tf-question")
    @ResponseBody
    public String addTFQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") boolean answer
    ) {
        tempQuestionList.add(question);
        tempAnswerList.add(answer);
        return "Frage gespeichert";
    }

    @PostMapping("/finalize-truefalse-quiz")
    @ResponseBody
    public String finalizeTFQuiz(
            @RequestParam("category") String category,
            @RequestParam("selectedTime") int selectedTime
    ) {
        if (tempQuestionList.isEmpty()) {
            return "Keine Fragen vorhanden";
        }

        TrueFalseQuiz quiz = new TrueFalseQuiz(
                category,
                selectedTime,
                tempQuestionList.size(),
                new ArrayList<>(tempQuestionList),
                new ArrayList<>(tempAnswerList)
        );

        trFlQuizRepository.save(quiz);
        tempQuestionList.clear();
        tempAnswerList.clear();

        return "Quiz erfolgreich gespeichert";
    }
}
