package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MultipleChoicQuizErstellenController {

    private static final String VIEW_MULTIPLE_CHOICE_QUIZ = "multiple_choice_quiz";
    private static final String REDIRECT_ADD_QUIZ = "redirect:/add-quiz";

    private static final String Option_1 = "option1";
    private static final String Option_2 = "option2";
    private static final String Option_3 = "option3";
    private static final String Option_4 = "option4";

    private static final int DEFAULT_QUIZ_VERSION = 1;


    @Autowired
    private QuizRepository muChoQuizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/add-quiz")
    public String showAddQuizPage(org.springframework.ui.Model model) {
        model.addAttribute("quiz", new MultipleChoiceQuiz());
        return VIEW_MULTIPLE_CHOICE_QUIZ;
    }
    @PostMapping("/add-quiz")
    public String handleQuizSubmission(
        @RequestParam("name") String name,
        @RequestParam("category") String category,
        @RequestParam("selectedTime") int selectedTime,
        @RequestParam("question") String questionText,
        @RequestParam("option1") String option1,
        @RequestParam("option2") String option2,
        @RequestParam("option3") String option3,
        @RequestParam("option4") String option4,
        @RequestParam("correct-answer") String correctAnswerKey) {
    
    List<String> options = List.of(option1, option2, option3, option4);
    String correctAnswer = switch (correctAnswerKey) {
        case Option_1 -> option1;
        case Option_2 -> option2;
        case Option_3 -> option3;
        case Option_4 -> option4;
        default -> null;
    };

    if (correctAnswer == null) {
    throw new IllegalArgumentException("Ungültige Auswahl für die richtige Antwort");
    }


    Question question = new Question(questionText, options, correctAnswer);

    //Hier fehlt die Logik für die Speicherung mehrerer Fragen in einem Quiz
    /* 
    List<Quiz> quizzes = muChoQuizRepository.findByCategory(category);

    MultipleChoiceQuiz quiz;
    
    if (quizzes.isEmpty() || !((quizzes.get(0)) instanceof MultipleChoiceQuiz)) {
        quiz = new MultipleChoiceQuiz(category, selectedTime, 0, new ArrayList<>());
    }   
    else {
        quiz = (MultipleChoiceQuiz) quizzes.get(0);
    }

    quiz.getQuestionList().add(question);
    quiz.setNumberOfQuestions(quiz.getQuestionList().size());

    */

    // Für jede erstellte Frage wird, im Moment, ein neues Quiz erstellt
    List<Question> questionList = new ArrayList<>();
    questionList.add(question);
    MultipleChoiceQuiz quiz = new MultipleChoiceQuiz(category, selectedTime, DEFAULT_QUIZ_VERSION, questionList);

    questionRepository.save(question);
    muChoQuizRepository.save(quiz);
    return REDIRECT_ADD_QUIZ;
}


}
