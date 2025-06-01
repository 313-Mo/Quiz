package Quiz.Master.Group.QuizMaster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Quiz.Master.Group.QuizMaster.Entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
