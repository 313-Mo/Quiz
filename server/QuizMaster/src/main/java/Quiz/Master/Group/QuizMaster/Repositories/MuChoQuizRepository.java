package Quiz.Master.Group.QuizMaster.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import Quiz.Master.Group.QuizMaster.Entities.MuChoQuiz;

public interface MuChoQuizRepository extends JpaRepository<MuChoQuiz, Long> {
    List<MuChoQuiz> findByCategory(String category);

    Optional<MuChoQuiz> findById(Long id);
}
