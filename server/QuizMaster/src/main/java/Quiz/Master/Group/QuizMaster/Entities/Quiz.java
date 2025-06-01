package Quiz.Master.Group.QuizMaster.Entities;

import jakarta.persistence.Entity;
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

    public String name;
    protected String category;
    protected int timeLimit;
    protected int numberOfQuestions;

    protected Quiz() {
        this.name = null;
        this.category = null;
        this.timeLimit = 0;
        this.numberOfQuestions = 0;
    }

    public Quiz(String name, String category, int timeLimit, int numberOfQuestions) {
        this.name = name;
        this.category = category;
        this.timeLimit = timeLimit;
        this.numberOfQuestions = numberOfQuestions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}
