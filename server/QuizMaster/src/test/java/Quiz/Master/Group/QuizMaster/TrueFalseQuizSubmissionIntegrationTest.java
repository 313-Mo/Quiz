package Quiz.Master.Group.QuizMaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrueFalseQuizSubmissionIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTrueFalseQuizSubmission() throws Exception {
        mockMvc.perform(post("/add-truefalse-quiz")
                .param("category", "Mathematics")
                .param("selectedTime", "10")
                .param("question", "Ist 2 + 2 = 4?")
                .param("answer", "true"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/add-truefalse-quiz"));
    }
}

