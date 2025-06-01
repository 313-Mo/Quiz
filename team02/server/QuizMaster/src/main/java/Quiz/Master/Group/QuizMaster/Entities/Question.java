package Quiz.Master.Group.QuizMaster.Entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String questionText;
    @ElementCollection
    private List<String> options;
    private String correctAnswer;

    protected Question() {
        this.questionText = null;
        this.options = null;
        this.correctAnswer = null;
    }

    public Question(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }
    public List<String> getOptions() {
        return options;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
