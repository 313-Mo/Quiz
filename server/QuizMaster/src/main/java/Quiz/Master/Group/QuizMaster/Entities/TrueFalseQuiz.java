package Quiz.Master.Group.QuizMaster.Entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;


@Entity
public class TrueFalseQuiz extends Quiz {
    @ElementCollection
    private List<String> questionList;
    @ElementCollection
    private List<Boolean> answerList;


    public TrueFalseQuiz() {
        super();
    }

    public TrueFalseQuiz(String name, String category, int timeLimit, int numberOfQuestions, List<String> questionList, List<Boolean> answerList) {
        super(name, category, timeLimit, numberOfQuestions);
        this.questionList = questionList;
        this.answerList = answerList;
    }

    public List<String> getQuestionList() {
        return questionList;
    }

    public List<Boolean> getAnswerList() {
        return answerList;
    }
    
}
