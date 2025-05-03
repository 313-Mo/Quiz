package Quiz.Master.Group.QuizMaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Quiz.Master.Group.QuizMaster.Entities.MuChoQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.MuChoQuizRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;

@Configuration
public class DataInitializer {
    /* 
    @Bean
    public CommandLineRunner initData(MuChoQuizRepository quizRepo, QuestionRepository questionRepo) {
        return args -> {
            
            List<Question> chemistryQuiz = new ArrayList<>();
            Question Question1 = new Question();
            Question1.setQuestionText("Was ist das chemische Symbol für Wasserstoff?");
            Question1.setOptions(List.of("H", "He", "O", "N"));
            Question1.setCorrectAnswer("H");
            chemistryQuiz.add(Question1);
            questionRepo.save(Question1);

            Question question2 = new Question();
            question2.setQuestionText("Wie viele Elektronen hat ein Sauerstoffatom?");
            question2.setOptions(List.of("6", "8", "10", "12"));
            question2.setCorrectAnswer("8");
            chemistryQuiz.add(question2);
            questionRepo.save(question2);

            Question question3 = new Question();
            question3.setQuestionText("Was ist der pH-Wert von reinem Wasser?");
            question3.setOptions(List.of("0", "7", "14", "1"));
            question3.setCorrectAnswer("7");
            chemistryQuiz.add(question3);
            questionRepo.save(question3);

            Question question4 = new Question();
            question4.setQuestionText("Welches Teilchen bestimmt das chemische Element?");
            question4.setOptions(List.of("Proton", "Elektron", "Neutron", "Ion"));
            question4.setCorrectAnswer("Proton");
            chemistryQuiz.add(question4);
            questionRepo.save(question4);

            Question question5 = new Question();
            question5.setQuestionText("Was ist eine chemische Reaktion?");
            question5.setOptions(List.of("Ein physikalischer Vorgang", "Eine Umwandlung von Stoffen", "Eine Temperaturänderung", "Ein Aggregatzustandswechsel"));
            question5.setCorrectAnswer("Eine Umwandlung von Stoffen");
            chemistryQuiz.add(question5);
            questionRepo.save(question5);

            Question question6 = new Question();
            question6.setQuestionText("Was ist das häufigste Element im Universum?");
            question6.setOptions(List.of("Helium", "Kohlenstoff", "Sauerstoff", "Wasserstoff"));
            question6.setCorrectAnswer("Wasserstoff");
            chemistryQuiz.add(question6);
            questionRepo.save(question6);

            Question question7 = new Question();
            question7.setQuestionText("Welches Gas entsteht bei der Fotosynthese?");
            question7.setOptions(List.of("Kohlenstoffdioxid", "Wasserstoff", "Sauerstoff", "Stickstoff"));
            question7.setCorrectAnswer("Sauerstoff");
            chemistryQuiz.add(question7);
            questionRepo.save(question7);

            Question question8 = new Question();
            question8.setQuestionText("Was ist eine Base?");
            question8.setOptions(List.of("Eine saure Lösung", "Eine Lösung mit pH < 7", "Eine Lösung mit pH > 7", "Ein Neutrallösungsmittel"));
            question8.setCorrectAnswer("Eine Lösung mit pH > 7");
            chemistryQuiz.add(question8);
            questionRepo.save(question8);

            Question question9 = new Question();
            question9.setQuestionText("Welche Teilchen befinden sich im Atomkern?");
            question9.setOptions(List.of("Protonen und Elektronen", "Neutronen und Elektronen", "Protonen und Neutronen", "Nur Elektronen"));
            question9.setCorrectAnswer("Protonen und Neutronen");
            chemistryQuiz.add(question9);
            questionRepo.save(question9);

            Question question10 = new Question();
            question10.setQuestionText("Was ist eine Ionenbindung?");
            question10.setOptions(List.of("Bindung zwischen Metallen", "Bindung zwischen Nichtmetallen", "Bindung zwischen Ionen mit entgegengesetzter Ladung", "Bindung innerhalb eines Atoms"));
            question10.setCorrectAnswer("Bindung zwischen Ionen mit entgegengesetzter Ladung");
            chemistryQuiz.add(question10);
            questionRepo.save(question10);
            
            MuChoQuiz muChoQuizchem = new MuChoQuiz();
            muChoQuizchem.setCategory("Chemistry");
            muChoQuizchem.setTimeLimit(10);
            muChoQuizchem.setNumberOfQuestions(10);
            muChoQuizchem.setQuestionList(chemistryQuiz);
            quizRepo.save(muChoQuizchem);
            

            List<Question> csQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Was bedeutet \"HTML\"?");
            q1.setOptions(List.of("HyperText Markup Language", "Home Tool Markup Language", "HyperTool Marked Language", "HighText Machine Language"));
            q1.setCorrectAnswer("HyperText Markup Language");
            csQuiz.add(q1);
            questionRepo.save(q1);

            Question q2 = new Question();
            q2.setQuestionText("Welches dieser Geräte ist KEIN Ausgabegerät?");
            q2.setOptions(List.of("Monitor", "Drucker", "Maus", "Beamer"));
            q2.setCorrectAnswer("Maus");
            csQuiz.add(q2);
            questionRepo.save(q2);

            Question q3 = new Question();
            q3.setQuestionText("Was ist ein Algorithmus?");
            q3.setOptions(List.of("Ein Computerprogramm", "Ein Datenbankmodell", "Eine Schritt-für-Schritt-Anleitung zur Lösung eines Problems", "Ein Softwarefehler"));
            q3.setCorrectAnswer("Eine Schritt-für-Schritt-Anleitung zur Lösung eines Problems");
            csQuiz.add(q3);
            questionRepo.save(q3);

            Question q4 = new Question();
            q4.setQuestionText("Welche Programmiersprache wird oft für Webentwicklung verwendet?");
            q4.setOptions(List.of("Python", "JavaScript", "C++", "Java"));
            q4.setCorrectAnswer("JavaScript");
            csQuiz.add(q4);
            questionRepo.save(q4);

            Question q5 = new Question();
            q5.setQuestionText("Was ist eine IP-Adresse?");
            q5.setOptions(List.of("Eine Internetplattform", "Eine eindeutige Kennung eines Geräts im Netzwerk", "Ein E-Mail-Protokoll", "Ein Sicherheitsstandard"));
            q5.setCorrectAnswer("Eine eindeutige Kennung eines Geräts im Netzwerk");
            csQuiz.add(q5);
            questionRepo.save(q5);

            Question q6 = new Question();
            q6.setQuestionText("Was bedeutet \"Open Source\"?");
            q6.setOptions(List.of("Software mit offenem Quellcode", "Kostenlose Software", "Software, die nicht verändert werden kann", "Ein Verschlüsselungsalgorithmus"));
            q6.setCorrectAnswer("Software mit offenem Quellcode");
            csQuiz.add(q6);
            questionRepo.save(q6);

            Question q7 = new Question();
            q7.setQuestionText("Was ist ein Betriebssystem?");
            q7.setOptions(List.of("Ein Computerfehler", "Ein Programm zur Textbearbeitung", "Die Software, die die Hardware verwaltet und steuert", "Ein Internetdienst"));
            q7.setCorrectAnswer("Die Software, die die Hardware verwaltet und steuert");
            csQuiz.add(q7);
            questionRepo.save(q7);

            Question q8 = new Question();
            q8.setQuestionText("Welche Zahl ist binär für 5?");
            q8.setOptions(List.of("0101", "0011", "1010", "1001"));
            q8.setCorrectAnswer("0101");
            csQuiz.add(q8);
            questionRepo.save(q8);

            Question q9 = new Question();
            q9.setQuestionText("Was ist ein Compiler?");
            q9.setOptions(List.of("Ein Gerät zur Codeausgabe", "Ein Code-Analysator", "Ein Programm, das Quellcode in Maschinencode umwandelt", "Ein Computerfehler"));
            q9.setCorrectAnswer("Ein Programm, das Quellcode in Maschinencode umwandelt");
            csQuiz.add(q9);
            questionRepo.save(q9);

            Question q10 = new Question();
            q10.setQuestionText("Welche Speicherart ist flüchtig?");
            q10.setOptions(List.of("ROM", "RAM", "SSD", "Festplatte"));
            q10.setCorrectAnswer("RAM");
            csQuiz.add(q10);
            questionRepo.save(q10);

            MuChoQuiz muChoQuizcs = new MuChoQuiz();
            muChoQuizcs.setCategory("Computer Science");
            muChoQuizcs.setTimeLimit(10);
            muChoQuizcs.setNumberOfQuestions(10);
            muChoQuizcs.setQuestionList(csQuiz);
            quizRepo.save(muChoQuizcs);
        };
    }*/
}
