
package Quiz.Master.Group.QuizMaster;

import Quiz.Master.Group.QuizMaster.Controller.QuizUserController;
import Quiz.Master.Group.QuizMaster.Services.QuizUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = QuizUserController.class)
public class LoginIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizUserService userService;

    @Test
    void loginPageShouldReturn200() throws Exception {
        mockMvc.perform(get("/logIn"))
               .andExpect(status().isOk())
               .andExpect(view().name("logIn"));
    }
}
