package Quiz.Master.Group.QuizMaster.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Quiz {
    @Id
    @GeneratedValue
    protected Long id;

    @Enumerated(EnumType.STRING)  // <-- Das ist wichtig!
    protected Category category;

    protected int timeLimit;
    protected int numberOfQuestions;

    protected Quiz() {
        this.category = null;
        this.timeLimit = 0;
        this.numberOfQuestions = 0;
    }

    public Quiz(Category category, int timeLimit, int numberOfQuestions) {
        this.category = category;
        this.timeLimit = timeLimit;
        this.numberOfQuestions = numberOfQuestions;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}
