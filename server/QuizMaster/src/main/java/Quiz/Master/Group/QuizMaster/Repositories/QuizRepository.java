package Quiz.Master.Group.QuizMaster.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Quiz.Master.Group.QuizMaster.Entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(String category);
    Optional<Quiz> findById(Long id);
}