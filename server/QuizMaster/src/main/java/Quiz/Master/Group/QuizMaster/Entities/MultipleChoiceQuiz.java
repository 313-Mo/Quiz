package Quiz.Master.Group.QuizMaster.Entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;


@Entity
public class MultipleChoiceQuiz extends Quiz {
    @ElementCollection
    private List<Question> questionList;

    public MultipleChoiceQuiz() {
        super();
    }

    public MultipleChoiceQuiz(String category, int timeLimit, int numberOfQuestions, List<Question> questionList) {
        super(category, timeLimit, numberOfQuestions);
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
