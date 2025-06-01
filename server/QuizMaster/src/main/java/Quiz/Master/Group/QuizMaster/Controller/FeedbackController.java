package Quiz.Master.Group.QuizMaster.Controller;

import Quiz.Master.Group.QuizMaster.Entities.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Quiz.Master.Group.QuizMaster.Services.FeedbackService;

@Controller
public class FeedbackController {
    
    @Autowired
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/rateQuiz")
    public String rateQuiz() {
        return "rateQuiz";
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestParam String feedbackText, @RequestParam int rating) {
        feedbackService.saveFeedback(feedbackText, rating);
        return "categorySelection";
    }
}
