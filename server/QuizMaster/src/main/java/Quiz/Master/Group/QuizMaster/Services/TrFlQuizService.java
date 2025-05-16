package Quiz.Master.Group.QuizMaster.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Quiz.Master.Group.QuizMaster.Entities.TrFlQuiz;
import Quiz.Master.Group.QuizMaster.Repositories.TrFlQuizRepository;

@Service
public class TrFlQuizService {
   private final TrFlQuizRepository quizRepository;

   @Autowired
   public TrFlQuizService(TrFlQuizRepository quizRepository) {
      this.quizRepository = quizRepository;
   }

   public TrFlQuiz findById(Long id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'findById'");
   }

   public List<TrFlQuiz> findByCategory(String name) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findByCategory'");
   }
}