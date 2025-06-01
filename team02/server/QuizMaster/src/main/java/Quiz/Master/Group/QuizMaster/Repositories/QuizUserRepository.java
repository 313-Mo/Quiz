package Quiz.Master.Group.QuizMaster.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Quiz.Master.Group.QuizMaster.Entities.QuizUser;

public interface QuizUserRepository extends JpaRepository<QuizUser, Long> {
    QuizUser findByUsername(String username);
}
