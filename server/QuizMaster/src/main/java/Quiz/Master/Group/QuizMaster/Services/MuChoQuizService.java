package Quiz.Master.Group.QuizMaster.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Quiz.Master.Group.QuizMaster.Entities.MuChoQuiz;
import Quiz.Master.Group.QuizMaster.Repositories.MuChoQuizRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;

@Service
public class MuChoQuizService {
   private final MuChoQuizRepository quizRepository;
   private final QuestionRepository questionRepository;

   @Autowired
   public MuChoQuizService(MuChoQuizRepository quizRepository, QuestionRepository questionRepository) {
      this.quizRepository = quizRepository;
      this.questionRepository = questionRepository;
   }

   public List<MuChoQuiz> findByCategory(String category) {
      return quizRepository.findByCategory(category);
   }
   public MuChoQuiz findById(Long id) {
      return quizRepository.findById(id).orElse(null);
   }
}
