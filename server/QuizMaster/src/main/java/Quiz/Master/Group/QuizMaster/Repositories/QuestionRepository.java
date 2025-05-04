package Quiz.Master.Group.QuizMaster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Quiz.Master.Group.QuizMaster.Entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
