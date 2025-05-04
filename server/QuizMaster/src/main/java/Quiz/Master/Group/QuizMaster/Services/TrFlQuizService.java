package Quiz.Master.Group.QuizMaster.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Quiz.Master.Group.QuizMaster.Repositories.TrFlQuizRepository;

@Service
public class TrFlQuizService {
   private final TrFlQuizRepository quizRepository;

   @Autowired
   public TrFlQuizService(TrFlQuizRepository quizRepository) {
      this.quizRepository = quizRepository;
   }
}