package Quiz.Master.Group.QuizMaster.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Feedback {
    
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long quizId;
    private String feedbackText;
    private int rating;

    public Feedback() {
        this.userId = null;
        this.quizId = null;
        this.feedbackText = null;
        this.rating = 0;
    }

    public Feedback(Long userId, Long quizId, String feedbackText, int rating) {
        this.userId = userId;
        this.quizId = quizId;
        this.feedbackText = feedbackText;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getquizId() {
        return quizId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public int getRating() {
        return rating;
    }
}