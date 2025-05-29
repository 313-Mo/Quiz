package Quiz.Master.Group.QuizMaster;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import Quiz.Master.Group.QuizMaster.Entities.Category;
import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

@ActiveProfiles("test")
@SpringBootTest
public class QuizIntegrationTest {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void testSaveAndRetrieveMultipleChoiceQuiz() {
        // Arrange
        Question q = new Question(
            "Was ist die Hauptstadt von Deutschland?",
            List.of("Berlin", "München", "Hamburg", "Köln"),
            "Berlin"
        );
        questionRepository.save(q);

        MultipleChoiceQuiz quiz = new MultipleChoiceQuiz(
            Category.GEOGRAPHY, // Verwendung des ENUMS
            60,
            1,
            List.of(q)
        );

        // Act
        quizRepository.save(quiz);
        MultipleChoiceQuiz retrieved = quizRepository.findWithQuestionsById(quiz.getId()).orElse(null);


        // Assert
        assertThat(retrieved).isNotNull();
        assertThat(retrieved.getCategory()).isEqualTo(Category.GEOGRAPHY);
        assertThat(retrieved.getQuestionList()).hasSize(1);
        assertThat(retrieved.getQuestionList().get(0).getCorrectAnswer()).isEqualTo("Berlin");
    }
 

}
