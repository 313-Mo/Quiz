package Quiz.Master.Group.QuizMaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class TrueFalseQuizIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTrueFalseQuizPageLoads() throws Exception {
        mockMvc.perform(get("/add-truefalse-quiz"))
                .andExpect(status().isOk()) // Prüft: Server antwortet mit 200 OK
                .andExpect(view().name("true_false_quiz")); // Prüft: Viewname ist korrekt
    }
}

