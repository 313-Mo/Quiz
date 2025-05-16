package Quiz.Master.Group.QuizMaster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;

import java.util.List;
import java.util.Optional;
public interface TrFlQuizRepository extends JpaRepository<TrFlQuiz, Long> {
    Optional<TrFlQuiz> findByCategory(String category);

}
