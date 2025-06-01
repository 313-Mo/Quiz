package Quiz.Master.Group.QuizMaster.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Quiz.Master.Group.QuizMaster.Entities.Category;
import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(Category category);
    Optional<Quiz> findById(Long id);
    // 🔥 Das hier ist NEU – nur für MultipleChoiceQuiz!
    @Query("SELECT q FROM MultipleChoiceQuiz q JOIN FETCH q.questionList WHERE q.id = :id")
    Optional<MultipleChoiceQuiz> findWithQuestionsById(@Param("id") Long id);

}