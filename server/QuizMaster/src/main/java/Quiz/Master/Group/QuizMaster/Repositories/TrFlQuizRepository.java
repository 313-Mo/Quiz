package Quiz.Master.Group.QuizMaster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;
import java.util.List;

public interface TrFlQuizRepository extends JpaRepository<TrFlQuiz, Long> {
    List<TrFlQuiz> findByCategory(String category);
}
