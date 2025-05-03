package Quiz.Master.Group.QuizMaster.Entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;  

import jakarta.persistence.Id;  

@Entity
public class TrFlQuiz {
    @Id
    @GeneratedValue
    private Long id;
    private String category;
    private int timeLimit;
    private int numberOfQuestions;
    @ElementCollection
    private List<String> questionList;
    @ElementCollection
    private List<Boolean> answerList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
    public List<String> getQuestionList() {
        return questionList;
    }
    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }
    public List<Boolean> getAnswerList() {
        return answerList;
    }
    public void setAnswerList(List<Boolean> answerList) {
        this.answerList = answerList;
    }
}
