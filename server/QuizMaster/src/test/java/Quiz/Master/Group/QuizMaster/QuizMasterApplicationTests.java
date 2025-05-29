package Quiz.Master.Group.QuizMaster;


import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Entities.Quiz;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Services.QuizService;
import Quiz.Master.Group.QuizMaster.Services.QuizUserService;

@SpringBootTest
@AutoConfigureMockMvc
class QuizMasterApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private QuizService quizService;

	@Autowired
    private QuestionRepository questionRepository;

	@MockBean
    private QuizUserService userService;

	@Test
    void testStartPageLoads() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("startPage"));
    }

	@Test
    void testCategorySelectionLoads() throws Exception {
        mockMvc.perform(get("/categorySelection"))
                .andExpect(status().isOk())
                .andExpect(view().name("categorySelection"));
    }

    @Test
    void testQuizSelectionViewByCategory() throws Exception {
        Quiz chemistryQuiz = new MultipleChoiceQuiz("test Chemistry", "Chemistry", 10, 0, List.of());
        quizService.save(chemistryQuiz);

        mockMvc.perform(get("/category/Chemistry"))
                .andExpect(status().isOk())
                .andExpect(view().name("quizSelection"))
                .andExpect(model().attributeExists("quizzes"))
                .andExpect(model().attribute("category", "Chemistry"));
    }

    @Test
    void testRedirectToCorrectQuizTemplate() throws Exception {
        Question q1 = new Question("Was ist H2O?", List.of("Wasser", "Säure", "Luft"), "Wasser");
		questionRepository.save(q1); 
        Quiz chemistryQuiz = new MultipleChoiceQuiz("test Chemistry", "Chemistry", 10 , 1, List.of(q1));
        quizService.save(chemistryQuiz); 

        mockMvc.perform(get("/quiz/" + chemistryQuiz.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("chemistry"))
                .andExpect(model().attributeExists("questions"));
    }

    @Test
    void testInvalidQuizCategoryFallsBackToCategorySelection() throws Exception {
        Quiz quiz = new MultipleChoiceQuiz("test unbekannt", "Unbekannt", 10, 0, List.of());
        quizService.save(quiz);

        mockMvc.perform(get("/quiz/" + quiz.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("categorySelection"));
    }

	@Test
    void testSignUpPageLoads() throws Exception {
        mockMvc.perform(get("/signUp"))
                .andExpect(status().isOk())
                .andExpect(view().name("signUp"));
    }

	@Test
    void testSuccessfulSignUpRedirectsToLogin() throws Exception {
        mockMvc.perform(post("/checkSignUp")
                .param("firstName", "Max")
                .param("lastName", "Mustermann")
                .param("username", "max123")
                .param("password", "password")
                .param("email", "max@example.com")
                .param("age", "25"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/logIn"));
    }

	@Test
    void testLogInPageLoads() throws Exception {
        mockMvc.perform(get("/logIn"))
                .andExpect(status().isOk())
                .andExpect(view().name("logIn"));
    }

	@Test
    void testSuccessfulLoginRedirectsToCategorySelection() throws Exception {
        when(userService.checkLogin("max123", "password")).thenReturn(true);

        mockMvc.perform(post("/checkLogIn")
                .param("username", "max123")
                .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/categorySelection"));
    }

	@Test
    void testFailedLoginReturnsLoginPage() throws Exception {
        when(userService.checkLogin("max123", "wrongpass")).thenReturn(false);

        mockMvc.perform(post("/checkLogIn")
                .param("username", "max123")
                .param("password", "wrongpass"))
                .andExpect(status().isOk())
                .andExpect(view().name("logIn"));
    }

}

