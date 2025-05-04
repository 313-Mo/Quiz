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
            quizRepo.save(muChoQuizcs);*/

            /* 
            List<Question> geoQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Was ist die Hauptstadt von Kanada?");
            q1.setOptions(List.of("Toronto", "Ottawa", "Vancouver", "Montreal"));
            q1.setCorrectAnswer("Ottawa");
            geoQuiz.add(q1);
            questionRepo.save(q1);

            Question q2 = new Question();
            q2.setQuestionText("Welcher Fluss ist der längste der Welt?");
            q2.setOptions(List.of("Amazonas", "Nil", "Yangtse", "Mississippi"));
            q2.setCorrectAnswer("Nil");
            geoQuiz.add(q2);
            questionRepo.save(q2);

            Question q3 = new Question();
            q3.setQuestionText("Wie viele Kontinente gibt es?");
            q3.setOptions(List.of("5", "6", "7", "8"));
            q3.setCorrectAnswer("7");
            geoQuiz.add(q3);
            questionRepo.save(q3);

            Question q4 = new Question();
            q4.setQuestionText("Welches Land hat die größte Bevölkerung?");
            q4.setOptions(List.of("Indien", "China", "USA", "Indonesien"));
            q4.setCorrectAnswer("China");
            geoQuiz.add(q4);
            questionRepo.save(q4);

            Question q5 = new Question();
            q5.setQuestionText("In welchem Kontinent liegt Argentinien?");
            q5.setOptions(List.of("Afrika", "Asien", "Südamerika", "Europa"));
            q5.setCorrectAnswer("Südamerika");
            geoQuiz.add(q5);
            questionRepo.save(q5);

            Question q6 = new Question();
            q6.setQuestionText("Wie heißt der höchste Berg der Erde?");
            q6.setOptions(List.of("K2", "Mount Everest", "Mont Blanc", "Matterhorn"));
            q6.setCorrectAnswer("Mount Everest");
            geoQuiz.add(q6);
            questionRepo.save(q6);

            Question q7 = new Question();
            q7.setQuestionText("Welche Meere umgeben Italien?");
            q7.setOptions(List.of("Nordsee und Ostsee", "Adria und Mittelmeer", "Pazifik und Atlantik", "Schwarzes Meer und Kaspisches Meer"));
            q7.setCorrectAnswer("Adria und Mittelmeer");
            geoQuiz.add(q7);
            questionRepo.save(q7);

            Question q8 = new Question();
            q8.setQuestionText("Welche Wüste ist die größte der Welt?");
            q8.setOptions(List.of("Sahara", "Gobi", "Antarktis", "Arabische Wüste"));
            q8.setCorrectAnswer("Antarktis");
            geoQuiz.add(q8);
            questionRepo.save(q8);

            Question q9 = new Question();
            q9.setQuestionText("Welcher Staat hat die meisten Inseln?");
            q9.setOptions(List.of("Philippinen", "Norwegen", "Schweden", "Indonesien"));
            q9.setCorrectAnswer("Schweden");
            geoQuiz.add(q9);
            questionRepo.save(q9);

            Question q10 = new Question();
            q10.setQuestionText("Wo befindet sich das Tote Meer?");
            q10.setOptions(List.of("Israel und Jordanien", "Ägypten und Sudan", "Türkei und Syrien", "Libanon und Irak"));
            q10.setCorrectAnswer("Israel und Jordanien");
            geoQuiz.add(q10);
            questionRepo.save(q10);

            MuChoQuiz muChoQuizgeo = new MuChoQuiz();
            muChoQuizgeo.setCategory("Geography");
            muChoQuizgeo.setTimeLimit(10);
            muChoQuizgeo.setNumberOfQuestions(10);
            muChoQuizgeo.setQuestionList(geoQuiz);
            quizRepo.save(muChoQuizgeo);

            
            List<Question> historyQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Wann begann der Zweite Weltkrieg?");
            q1.setOptions(List.of("1933", "1939", "1941", "1945"));
            q1.setCorrectAnswer("1939");
            historyQuiz.add(q1);
            questionRepo.save(q1);

            Question q2 = new Question();
            q2.setQuestionText("Wer war der erste Bundeskanzler der Bundesrepublik Deutschland?");
            q2.setOptions(List.of("Helmut Kohl", "Konrad Adenauer", "Willy Brandt", "Ludwig Erhard"));
            q2.setCorrectAnswer("Konrad Adenauer");
            historyQuiz.add(q2);
            questionRepo.save(q2);

            Question q3 = new Question();
            q3.setQuestionText("Wann fiel die Berliner Mauer?");
            q3.setOptions(List.of("1989", "1990", "1987", "1991"));
            q3.setCorrectAnswer("1989");
            historyQuiz.add(q3);
            questionRepo.save(q3);

            Question q4 = new Question();
            q4.setQuestionText("Was war die Weimarer Republik?");
            q4.setOptions(List.of("Ein Königreich", "Ein Kaiserreich", "Eine demokratische Republik", "Ein Bundesstaat"));
            q4.setCorrectAnswer("Eine demokratische Republik");
            historyQuiz.add(q4);
            questionRepo.save(q4);

            Question q5 = new Question();
            q5.setQuestionText("Wer entdeckte Amerika im Jahr 1492?");
            q5.setOptions(List.of("Marco Polo", "Christoph Kolumbus", "Ferdinand Magellan", "James Cook"));
            q5.setCorrectAnswer("Christoph Kolumbus");
            historyQuiz.add(q5);
            questionRepo.save(q5);

            Question q6 = new Question();
            q6.setQuestionText("Was war der Kalte Krieg?");
            q6.setOptions(List.of("Ein tatsächlicher Krieg", "Ein politischer Konflikt zwischen Ost und West", "Ein Bürgerkrieg in den USA", "Ein Konflikt zwischen Deutschland und Frankreich"));
            q6.setCorrectAnswer("Ein politischer Konflikt zwischen Ost und West");
            historyQuiz.add(q6);
            questionRepo.save(q6);

            Question q7 = new Question();
            q7.setQuestionText("Wie hieß das römische Reich in der Spätantike?");
            q7.setOptions(List.of("Oströmisches Reich", "Heiliges Römisches Reich", "Kaiserreich Rom", "Byzantinisches Reich"));
            q7.setCorrectAnswer("Byzantinisches Reich");
            historyQuiz.add(q7);
            questionRepo.save(q7);

            Question q8 = new Question();
            q8.setQuestionText("Wann wurde die DDR gegründet?");
            q8.setOptions(List.of("1949", "1945", "1950", "1955"));
            q8.setCorrectAnswer("1949");
            historyQuiz.add(q8);
            questionRepo.save(q8);

            Question q9 = new Question();
            q9.setQuestionText("Wer war Martin Luther?");
            q9.setOptions(List.of("Ein König", "Ein Entdecker", "Ein Reformator", "Ein Kanzler"));
            q9.setCorrectAnswer("Ein Reformator");
            historyQuiz.add(q9);
            questionRepo.save(q9);

            Question q10 = new Question();
            q10.setQuestionText("Was war die Industrielle Revolution?");
            q10.setOptions(List.of("Ein politischer Aufstand", "Ein wissenschaftlicher Durchbruch", "Eine Phase großer technischer Veränderungen", "Ein religiöser Wandel"));
            q10.setCorrectAnswer("Eine Phase großer technischer Veränderungen");
            historyQuiz.add(q10);
            questionRepo.save(q10);

            MuChoQuiz muChoQuizhistory = new MuChoQuiz();
            muChoQuizhistory.setCategory("History");
            muChoQuizhistory.setTimeLimit(10);
            muChoQuizhistory.setNumberOfQuestions(10);
            muChoQuizhistory.setQuestionList(historyQuiz);
            quizRepo.save(muChoQuizhistory);

            List<Question> generalKnowledgeQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Was ist die Hauptstadt von Spanien?");
            q1.setOptions(List.of("Madrid", "Barcelona", "Sevilla", "Valencia"));
            q1.setCorrectAnswer("Madrid");
            questionRepo.save(q1);
            generalKnowledgeQuiz.add(q1);

            Question q2 = new Question();
            q2.setQuestionText("Wie viele Beine hat eine Spinne?");
            q2.setOptions(List.of("6", "8", "10", "12"));
            q2.setCorrectAnswer("8");
            questionRepo.save(q2);
            generalKnowledgeQuiz.add(q2);

            Question q3 = new Question();
            q3.setQuestionText("Wer schrieb \"Faust\"?");
            q3.setOptions(List.of("Goethe", "Schiller", "Lessing", "Kafka"));
            q3.setCorrectAnswer("Goethe");
            questionRepo.save(q3);
            generalKnowledgeQuiz.add(q3);

            Question q4 = new Question();
            q4.setQuestionText("Wie viele Planeten hat unser Sonnensystem?");
            q4.setOptions(List.of("7", "8", "9", "10"));
            q4.setCorrectAnswer("8");
            questionRepo.save(q4);
            generalKnowledgeQuiz.add(q4);

            Question q5 = new Question();
            q5.setQuestionText("Was ist die Quadratwurzel von 64?");
            q5.setOptions(List.of("6", "7", "8", "9"));
            q5.setCorrectAnswer("8");
            questionRepo.save(q5);
            generalKnowledgeQuiz.add(q5);

            Question q6 = new Question();
            q6.setQuestionText("Welche Farbe ergibt Blau + Gelb?");
            q6.setOptions(List.of("Grün", "Lila", "Orange", "Braun"));
            q6.setCorrectAnswer("Grün");
            questionRepo.save(q6);
            generalKnowledgeQuiz.add(q6);

            Question q7 = new Question();
            q7.setQuestionText("Wie nennt man ein sechseckiges Vieleck?");
            q7.setOptions(List.of("Pentagon", "Hexagon", "Oktagon", "Trapez"));
            q7.setCorrectAnswer("Hexagon");
            questionRepo.save(q7);
            generalKnowledgeQuiz.add(q7);

            Question q8 = new Question();
            q8.setQuestionText("Welches Tier ist das größte Landraubtier?");
            q8.setOptions(List.of("Löwe", "Tiger", "Eisbär", "Wolf"));
            q8.setCorrectAnswer("Eisbär");
            questionRepo.save(q8);
            generalKnowledgeQuiz.add(q8);

            Question q9 = new Question();
            q9.setQuestionText("Welche Sprache spricht man in Brasilien?");
            q9.setOptions(List.of("Spanisch", "Portugiesisch", "Französisch", "Englisch"));
            q9.setCorrectAnswer("Portugiesisch");
            questionRepo.save(q9);
            generalKnowledgeQuiz.add(q9);

            Question q10 = new Question();
            q10.setQuestionText("Wie heißt das chemische Symbol für Gold?");
            q10.setOptions(List.of("Ag", "Au", "Fe", "Hg"));
            q10.setCorrectAnswer("Au");
            questionRepo.save(q10);
            generalKnowledgeQuiz.add(q10);
            
            MuChoQuiz muChoQuizgeneralKnowledge = new MuChoQuiz();
            muChoQuizgeneralKnowledge.setCategory("General Knowledge");
            muChoQuizgeneralKnowledge.setTimeLimit(10);
            muChoQuizgeneralKnowledge.setNumberOfQuestions(10);
            muChoQuizgeneralKnowledge.setQuestionList(generalKnowledgeQuiz);
            quizRepo.save(muChoQuizgeneralKnowledge);

            List<Question> biologyQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Welches Organ ist für die Produktion von Insulin verantwortlich?");
            q1.setOptions(List.of("Leber", "Niere", "Bauchspeicheldrüse", "Milz"));
            q1.setCorrectAnswer("Bauchspeicheldrüse");
            questionRepo.save(q1);
            biologyQuiz.add(q1);

            Question q2 = new Question();
            q2.setQuestionText("Welche Zellorganelle ist das 'Kraftwerk' der Zelle?");
            q2.setOptions(List.of("Ribosomen", "Mitochondrien", "Golgi-Apparat", "Zellkern"));
            q2.setCorrectAnswer("Mitochondrien");
            questionRepo.save(q2);
            biologyQuiz.add(q2);

            Question q3 = new Question();
            q3.setQuestionText("Welche Blutgruppe ist der Universalspender?");
            q3.setOptions(List.of("AB+", "O-", "A+", "B-"));
            q3.setCorrectAnswer("O-");
            questionRepo.save(q3);
            biologyQuiz.add(q3);

            Question q4 = new Question();
            q4.setQuestionText("Was ist die Hauptfunktion der roten Blutkörperchen?");
            q4.setOptions(List.of("Hormonproduktion", "Immunabwehr", "Sauerstofftransport", "Verdauung"));
            q4.setCorrectAnswer("Sauerstofftransport");
            questionRepo.save(q4);
            biologyQuiz.add(q4);

            Question q5 = new Question();
            q5.setQuestionText("Welches Organ ist für die Entgiftung des Körpers zuständig?");
            q5.setOptions(List.of("Herz", "Leber", "Magen", "Darm"));
            q5.setCorrectAnswer("Leber");
            questionRepo.save(q5);
            biologyQuiz.add(q5);

            Question q6 = new Question();
            q6.setQuestionText("Was enthält die genetische Information einer Zelle?");
            q6.setOptions(List.of("Zellwand", "Zellplasma", "Zellkern", "Mitochondrien"));
            q6.setCorrectAnswer("Zellkern");
            questionRepo.save(q6);
            biologyQuiz.add(q6);

            Question q7 = new Question();
            q7.setQuestionText("Wie nennt man den Prozess, bei dem Pflanzen Sonnenlicht in Energie umwandeln?");
            q7.setOptions(List.of("Fermentation", "Fotosynthese", "Oxidation", "Respiration"));
            q7.setCorrectAnswer("Fotosynthese");
            questionRepo.save(q7);
            biologyQuiz.add(q7);

            Question q8 = new Question();
            q8.setQuestionText("Welche Funktion haben die weißen Blutkörperchen?");
            q8.setOptions(List.of("Blutgerinnung", "Sauerstofftransport", "Immunabwehr", "Nährstoffspeicherung"));
            q8.setCorrectAnswer("Immunabwehr");
            questionRepo.save(q8);
            biologyQuiz.add(q8);

            Question q9 = new Question();
            q9.setQuestionText("Wie viele Chromosomen hat ein menschlicher Körper in der Regel?");
            q9.setOptions(List.of("23", "46", "22", "44"));
            q9.setCorrectAnswer("46");
            questionRepo.save(q9);
            biologyQuiz.add(q9);

            Question q10 = new Question();
            q10.setQuestionText("Wie heißt das Hormon, das den Blutzuckerspiegel senkt?");
            q10.setOptions(List.of("Adrenalin", "Glukagon", "Insulin", "Melatonin"));
            q10.setCorrectAnswer("Insulin");
            questionRepo.save(q10);
            biologyQuiz.add(q10);

            MuChoQuiz muChoQuizbiology = new MuChoQuiz();
            muChoQuizbiology.setCategory("Biology");
            muChoQuizbiology.setTimeLimit(10);
            muChoQuizbiology.setNumberOfQuestions(10);
            muChoQuizbiology.setQuestionList(biologyQuiz);
            quizRepo.save(muChoQuizbiology);

            List<Question> financeQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Was ist eine Dividende?");
            q1.setOptions(List.of("Ein Darlehen an eine Bank", "Eine Gewinnausschüttung an Aktionäre", "Eine Steuer auf Kapitalerträge", "Ein Kredit mit niedrigem Zinssatz"));
            q1.setCorrectAnswer("Eine Gewinnausschüttung an Aktionäre");
            questionRepo.save(q1);
            financeQuiz.add(q1);

            Question q2 = new Question();
            q2.setQuestionText("Was bedeutet \"ROI\"?");
            q2.setOptions(List.of("Return On Investment", "Rate Of Interest", "Risk Of Inflation", "Revenue Over Income"));
            q2.setCorrectAnswer("Return On Investment");
            questionRepo.save(q2);
            financeQuiz.add(q2);

            Question q3 = new Question();
            q3.setQuestionText("Eine Deflation bedeutet generell steigende Preise.");
            q3.setOptions(List.of("WAHR", "FALSCH"));
            q3.setCorrectAnswer("FALSCH");
            questionRepo.save(q3);
            financeQuiz.add(q3);

            Question q4 = new Question();
            q4.setQuestionText("Was ist ein \"Bulle\" im Börsenkontext?");
            q4.setOptions(List.of("Ein Investor, der mit fallenden Kursen rechnet", "Ein Investor, der mit steigenden Kursen rechnet", "Ein unerfahrener Anleger", "Eine spezielle Art von Investmentfonds"));
            q4.setCorrectAnswer("Ein Investor, der mit steigenden Kursen rechnet");
            questionRepo.save(q4);
            financeQuiz.add(q4);

            Question q5 = new Question();
            q5.setQuestionText("Eine hohe Inflation begünstigt in der Regel Sparguthaben.");
            q5.setOptions(List.of("WAHR", "FALSCH"));
            q5.setCorrectAnswer("FALSCH");
            questionRepo.save(q5);
            financeQuiz.add(q5);

            Question q6 = new Question();
            q6.setQuestionText("Was ist ein ETF?");
            q6.setOptions(List.of("Eine europäische Handelszone", "Ein börsengehandelter Indexfonds", "Eine Form der Rentenversicherung", "Ein wirtschaftlicher Stresstest für Banken"));
            q6.setCorrectAnswer("Ein börsengehandelter Indexfonds");
            questionRepo.save(q6);
            financeQuiz.add(q6);

            Question q7 = new Question();
            q7.setQuestionText("Die Börse in New York wird als \"Wall Street\" bezeichnet.");
            q7.setOptions(List.of("WAHR", "FALSCH"));
            q7.setCorrectAnswer("WAHR");
            questionRepo.save(q7);
            financeQuiz.add(q7);

            Question q8 = new Question();
            q8.setQuestionText("Was ist das \"Eigenkapital\" eines Unternehmens?");
            q8.setOptions(List.of("Der monatliche Gewinn", "Das von Aktionären investierte Geld", "Die Differenz zwischen Vermögen und Schulden", "Der Wert aller physischen Vermögenswerte"));
            q8.setCorrectAnswer("Die Differenz zwischen Vermögen und Schulden");
            questionRepo.save(q8);
            financeQuiz.add(q8);

            Question q9 = new Question();
            q9.setQuestionText("Ein \"Bear Market\" beschreibt eine Phase steigender Aktienkurse.");
            q9.setOptions(List.of("WAHR", "FALSCH"));
            q9.setCorrectAnswer("FALSCH");
            questionRepo.save(q9);
            financeQuiz.add(q9);

            Question q10 = new Question();
            q10.setQuestionText("Was versteht man unter \"Liquidität\"?");
            q10.setOptions(List.of("Die Fähigkeit, Vermögenswerte schnell in Bargeld umzuwandeln", "Das Verhältnis von Schulden zu Eigenkapital", "Die gesetzliche Mindestreserve einer Bank", "Der Gewinn nach Steuern"));
            q10.setCorrectAnswer("Die Fähigkeit, Vermögenswerte schnell in Bargeld umzuwandeln");
            questionRepo.save(q10);
            financeQuiz.add(q10);

            MuChoQuiz muChoQuizfinance = new MuChoQuiz();
            muChoQuizfinance.setCategory("Finance");
            muChoQuizfinance.setTimeLimit(10);
            muChoQuizfinance.setNumberOfQuestions(10);
            muChoQuizfinance.setQuestionList(financeQuiz);
            quizRepo.save(muChoQuizfinance);

            List<Question> mathQuiz = new ArrayList<>();

            Question q1 = new Question();
            q1.setQuestionText("Was ist das Ergebnis von 7 × 8?");
            q1.setOptions(List.of("42", "56", "49", "64"));
            q1.setCorrectAnswer("56");
            questionRepo.save(q1);
            mathQuiz.add(q1);

            Question q2 = new Question();
            q2.setQuestionText("Was ist die Quadratwurzel von 144?");
            q2.setOptions(List.of("10", "12", "14", "16"));
            q2.setCorrectAnswer("12");
            questionRepo.save(q2);
            mathQuiz.add(q2);

            Question q3 = new Question();
            q3.setQuestionText("Was ist das Ergebnis von 15 + 27?");
            q3.setOptions(List.of("32", "42", "52", "62"));
            q3.setCorrectAnswer("42");
            questionRepo.save(q3);
            mathQuiz.add(q3);

            Question q4 = new Question();
            q4.setQuestionText("Was ist 3² + 4²?");
            q4.setOptions(List.of("7", "25", "49", "16"));
            q4.setCorrectAnswer("25");
            questionRepo.save(q4);
            mathQuiz.add(q4);

            Question q5 = new Question();
            q5.setQuestionText("Was ist das kleinste gemeinsame Vielfache von 6 und 8?");
            q5.setOptions(List.of("12", "24", "36", "48"));
            q5.setCorrectAnswer("24");
            questionRepo.save(q5);
            mathQuiz.add(q5);

            Question q6 = new Question();
            q6.setQuestionText("Was ist die Hälfte von 3/4?");
            q6.setOptions(List.of("3/8", "1/4", "6/8", "3/2"));
            q6.setCorrectAnswer("3/8");
            questionRepo.save(q6);
            mathQuiz.add(q6);

            Question q7 = new Question();
            q7.setQuestionText("Ein rechter Winkel hat ... Grad?");
            q7.setOptions(List.of("45", "90", "180", "360"));
            q7.setCorrectAnswer("90");
            questionRepo.save(q7);
            mathQuiz.add(q7);

            Question q8 = new Question();
            q8.setQuestionText("Was ist 5³?");
            q8.setOptions(List.of("25", "125", "75", "15"));
            q8.setCorrectAnswer("125");
            questionRepo.save(q8);
            mathQuiz.add(q8);

            Question q9 = new Question();
            q9.setQuestionText("Was ist der Umfang eines Quadrats mit Seitenlänge 6cm?");
            q9.setOptions(List.of("24cm", "12cm", "36cm", "18cm"));
            q9.setCorrectAnswer("24cm");
            questionRepo.save(q9);
            mathQuiz.add(q9);

            Question q10 = new Question();
            q10.setQuestionText("Wie viele Zentimeter sind 2,5 Meter?");
            q10.setOptions(List.of("250cm", "25cm", "2500cm", "205cm"));
            q10.setCorrectAnswer("250cm");
            questionRepo.save(q10);
            mathQuiz.add(q10);
            
            MuChoQuiz muChoQuizmath = new MuChoQuiz();
            muChoQuizmath.setCategory("Mathematics");
            muChoQuizmath.setTimeLimit(10);
            muChoQuizmath.setNumberOfQuestions(10);
            muChoQuizmath.setQuestionList(mathQuiz);
            quizRepo.save(muChoQuizmath);
            
        };
    }*/
}
