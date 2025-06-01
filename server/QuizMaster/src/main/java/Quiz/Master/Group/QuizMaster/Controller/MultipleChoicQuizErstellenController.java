package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultipleChoicQuizErstellenController {

    @Autowired
    private QuizRepository muChoQuizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private static final List<Question> tempQuestionList = new ArrayList<>();
    private static String tempCategory = "";
    private static int tempSelectedTime = 0;

    @GetMapping("/add-quiz")
    public String showAddQuizPage(org.springframework.ui.Model model) {
        model.addAttribute("quiz", new MultipleChoiceQuiz());
        return "multiple_choice_quiz";
    }

    @PostMapping("/add-mc-question")
    @ResponseBody
    public String addQuestion(
            @RequestParam("category") String category,
            @RequestParam("selectedTime") int selectedTime,
            @RequestParam("question") String questionText,
            @RequestParam("option1") String option1,
            @RequestParam("option2") String option2,
            @RequestParam("option3") String option3,
            @RequestParam("option4") String option4,
            @RequestParam("correct-answer") String correctAnswerKey) {

        if (!category.equals(tempCategory) || selectedTime != tempSelectedTime) {
            tempCategory = category;
            tempSelectedTime = selectedTime;
            tempQuestionList.clear();
        }

        List<String> options = List.of(option1, option2, option3, option4);
        String correctAnswer = switch (correctAnswerKey) {
            case "option1" -> option1;
            case "option2" -> option2;
            case "option3" -> option3;
            case "option4" -> option4;
            default -> null;
        };

        if (correctAnswer == null) {
            return "Ungültige Antwort";
        }

        Question question = new Question(questionText, options, correctAnswer);
        tempQuestionList.add(question);

        return "Frage gespeichert";
    }

    @PostMapping("/finalize-mc-quiz")
    @ResponseBody
    public String finalizeQuiz(
            @RequestParam("category") String category,
            @RequestParam("selectedTime") int selectedTime) {

        if (tempQuestionList.isEmpty()) {
            return "Keine Fragen zum Speichern";
        }

        MultipleChoiceQuiz quiz = new MultipleChoiceQuiz(category, selectedTime, tempQuestionList.size(), new ArrayList<>(tempQuestionList));

        for (Question q : tempQuestionList) {
            questionRepository.save(q);
        }
        muChoQuizRepository.save(quiz);

        tempQuestionList.clear();
        tempCategory = "";
        tempSelectedTime = 0;

        return "Quiz erfolgreich gespeichert";
    }
}
