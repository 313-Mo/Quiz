package Quiz.Master.Group.QuizMaster.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Quiz.Master.Group.QuizMaster.Entities.Feedback;
import Quiz.Master.Group.QuizMaster.Repositories.FeedbackRepository;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void saveFeedback(String feedbackText, int rating) {
        Feedback feedback = new Feedback(null, null, feedbackText, rating);
        feedbackRepository.save(feedback);
    }
}