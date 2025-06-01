package Quiz.Master.Group.QuizMaster.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Quiz.Master.Group.QuizMaster.Entities.TrueFalseQuiz;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

@Controller
public class trueFalseErstellenController {

    private static final String VIEW_TRUE_FALSE_QUIZ = "true_false_quiz";


    private static final String REDIRECT_TRUE_FALSE_QUIZ = "redirect:/add-truefalse-quiz";
    
    private static final int DEFAULT_QUIZ_VERSION = 1;




    @Autowired
    private QuizRepository trFlQuizRepository;

    @GetMapping("/add-truefalse-quiz")
    public String showTrueFalseQuizForm(Model model) {
        model.addAttribute("quiz", new TrueFalseQuiz());
        return VIEW_TRUE_FALSE_QUIZ;
    }

    @PostMapping("/add-truefalse-quiz")
    public String handleTrueFalseSubmission(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("selectedTime") int selectedTime,
            @RequestParam("question") String questionText,
            @RequestParam("answer") boolean answerValue) {
        
        //Hier fehlt die Logik für die Speicherung mehrerer Fragen in einem Quiz
        /* 
        List<Quiz> quizzes = trFlQuizRepository.findByCategory(category);

        TrueFalseQuiz quiz;
        if (quizzes.isEmpty()) {
            quiz = new TrueFalseQuiz(category, selectedTime, 1, new ArrayList<>(), new ArrayList<>());
        } else {
            quiz = (TrueFalseQuiz) quizzes.get(0);
        }

        quiz.getQuestionList().add(questionText);
        quiz.getAnswerList().add(answerValue);
        quiz.setNumberOfQuestions(quiz.getQuestionList().size());
        */

        // Für jede erstellte Frage wird, im Moment, ein neues Quiz erstellt
        List<String> questionList = new ArrayList<>();
        questionList.add(questionText);

        List<Boolean> answersList = new ArrayList<>();
        answersList.add(answerValue);

        TrueFalseQuiz quiz = new TrueFalseQuiz(category, selectedTime, DEFAULT_QUIZ_VERSION , questionList, answersList);
        trFlQuizRepository.save(quiz);
        return REDIRECT_TRUE_FALSE_QUIZ;
    }
}
