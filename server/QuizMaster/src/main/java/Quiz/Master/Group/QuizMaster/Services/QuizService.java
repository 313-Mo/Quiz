package Quiz.Master.Group.QuizMaster.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Quiz.Master.Group.QuizMaster.Entities.Category;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

@Service
public class QuizService {
   private final QuizRepository quizRepository;
   private final QuestionRepository questionRepository;

   @Autowired
   public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
      this.quizRepository = quizRepository;
      this.questionRepository = questionRepository;
   }

   public List<Quiz> findByCategory(Category category) {
      
      return quizRepository.findByCategory(category);
   }

   public Quiz findById(Long id) {
      return quizRepository.findById(id).orElse(null);
   }

   public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

}