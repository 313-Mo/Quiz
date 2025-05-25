package Quiz.Master.Group.QuizMaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Quiz.Master.Group.QuizMaster.Entities.Category;
import Quiz.Master.Group.QuizMaster.Entities.MultipleChoiceQuiz;
import Quiz.Master.Group.QuizMaster.Entities.Question;
import Quiz.Master.Group.QuizMaster.Repositories.QuestionRepository;
import Quiz.Master.Group.QuizMaster.Repositories.QuizRepository;

@Configuration
public class DataInitializer {
       
    @Bean
    public CommandLineRunner initData(QuizRepository quizRepo, QuestionRepository questionRepo) {
        return args -> {
            if (quizRepo.count() == 0) {
            List<Question> chemistryQuiz = new ArrayList<>();
            Question Question1 = new Question("was ist das chemische Symbol für Wasserstoff?", List.of("H", "He", "O", "N"), "H");
            chemistryQuiz.add(Question1);
            questionRepo.save(Question1);

            Question question2 = new Question("wie viele Elektronen hat ein Sauerstoffatom?", List.of("6", "8", "10", "12"), "8");
            chemistryQuiz.add(question2);
            questionRepo.save(question2);

            Question question3 = new Question("was ist der pH-Wert von reinem Wasser?", List.of("0", "7", "14", "1"), "7");
            chemistryQuiz.add(question3);
            questionRepo.save(question3);

            Question question4 = new Question("Welches Teilchen bestimmt das chemische Element?", List.of("Proton", "Elektron", "Neutron", "Ion"), "Proton");
            chemistryQuiz.add(question4);
            questionRepo.save(question4);

            Question question5 = new Question("Was ist eine chemische Reaktion?", List.of("Ein physikalischer Vorgang", "Eine Umwandlung von Stoffen", "Eine Temperaturänderung", "Ein Aggregatzustandswechsel"), "Eine Umwandlung von Stoffen");
            chemistryQuiz.add(question5);
            questionRepo.save(question5);

            Question question6 = new Question("Was ist das häufigste Element im Universum?", List.of("Helium", "Kohlenstoff", "Sauerstoff", "Wasserstoff"), "Wasserstoff");
            chemistryQuiz.add(question6);
            questionRepo.save(question6);

            Question question7 = new Question("Welches Gas entsteht bei der Fotosynthese?", List.of("Kohlenstoffdioxid", "Wasserstoff", "Sauerstoff", "Stickstoff"), "Sauerstoff");
            chemistryQuiz.add(question7);
            questionRepo.save(question7);

            Question question8 = new Question("Was ist eine Base?", List.of("Eine saure Lösung", "Eine Lösung mit pH < 7", "Eine Lösung mit pH > 7", "Ein Neutrallösungsmittel"), "Eine Lösung mit pH > 7");

            chemistryQuiz.add(question8);
            questionRepo.save(question8);

            Question question9 = new Question("Welche Teilchen befinden sich im Atomkern?", List.of("Protonen und Elektronen", "Neutronen und Elektronen", "Protonen und Neutronen", "Nur Elektronen"), "Protonen und Neutronen");

            chemistryQuiz.add(question9);
            questionRepo.save(question9);

            Question question10 = new Question("Was ist eine Ionenbindung?", List.of("Bindung zwischen Metallen", "Bindung zwischen Nichtmetallen", "Bindung zwischen Ionen mit entgegengesetzter Ladung", "Bindung innerhalb eines Atoms"), "Bindung zwischen Ionen mit entgegengesetzter Ladung");

            chemistryQuiz.add(question10);
            questionRepo.save(question10);
            
            MultipleChoiceQuiz muChoQuizchem = new MultipleChoiceQuiz(Category.CHEMISTRY, 10, 10, chemistryQuiz);
            quizRepo.save(muChoQuizchem);
            

            List<Question> csQuiz = new ArrayList<>();

            Question csq1 = new Question("Was bedeutet \"HTML\"?" , List.of("HyperText Markup Language", "Home Tool Markup Language", "HyperTool Marked Language", "HighText Machine Language"), "HyperText Markup Language");

            csQuiz.add(csq1);
            questionRepo.save(csq1);

            Question csq2 = new Question("Welches dieser Geräte ist KEIN Ausgabegerät?", List.of("Monitor", "Drucker", "Maus", "Beamer"), "Maus");
            csQuiz.add(csq2);
            questionRepo.save(csq2);

            Question csq3 = new Question("Was ist ein Algorithmus?", List.of("Ein Computerprogramm", "Ein Datenbankmodell", "Eine Schritt-für-Schritt-Anleitung zur Lösung eines Problems", "Ein Softwarefehler"), "Eine Schritt-für-Schritt-Anleitung zur Lösung eines Problems");
            
            csQuiz.add(csq3);
            questionRepo.save(csq3);

            Question csq4 = new Question("Welche Programmiersprache wird oft für Webentwicklung verwendet?", List.of("Python", "JavaScript", "C++", "Java"), "JavaScript");

            csQuiz.add(csq4);
            questionRepo.save(csq4);

            Question csq5 = new Question("Was ist eine IP-Adresse?", List.of("Eine Internetplattform", "Eine eindeutige Kennung eines Geräts im Netzwerk", "Ein E-Mail-Protokoll", "Ein Sicherheitsstandard"), "Eine eindeutige Kennung eines Geräts im Netzwerk");

            csQuiz.add(csq5);
            questionRepo.save(csq5);

            Question csq6 = new Question("Was bedeutet \"Open Source\"?", List.of("Software mit offenem Quellcode", "Kostenlose Software", "Software, die nicht verändert werden kann", "Ein Verschlüsselungsalgorithmus"), "Software mit offenem Quellcode");

            csQuiz.add(csq6);
            questionRepo.save(csq6);

            Question csq7 = new Question("Was ist ein Betriebssystem?" , List.of("Ein Computerfehler", "Ein Programm zur Textbearbeitung", "Die Software, die die Hardware verwaltet und steuert", "Ein Internetdienst"), "Die Software, die die Hardware verwaltet und steuert");

            csQuiz.add(csq7);
            questionRepo.save(csq7);

            Question csq8 = new Question("Welche Zahl ist binär für 5?" , List.of("0101", "0011", "1010", "1001"), "0101");

            csQuiz.add(csq8);
            questionRepo.save(csq8);

            Question csq9 = new Question("Was ist ein Compiler?", List.of("Ein Gerät zur Codeausgabe", "Ein Code-Analysator", "Ein Programm, das Quellcode in Maschinencode umwandelt", "Ein Computerfehler"), "Ein Programm, das Quellcode in Maschinencode umwandelt");

            csQuiz.add(csq9);
            questionRepo.save(csq9);

            Question csq10 = new Question("Welche Speicherart ist flüchtig?", List.of("ROM", "RAM", "SSD", "Festplatte"), "RAM");

            csQuiz.add(csq10);
            questionRepo.save(csq10);

            MultipleChoiceQuiz muChoQuizcs = new MultipleChoiceQuiz(Category.COMPUTER_SCIENCE, 10, 10, csQuiz);
            quizRepo.save(muChoQuizcs);

            
            List<Question> geoQuiz = new ArrayList<>();

            Question gq1 = new Question("Was ist die Hauptstadt von Kanada?", List.of("Toronto", "Ottawa", "Vancouver", "Montreal"), "Ottawa");

            geoQuiz.add(gq1);
            questionRepo.save(gq1);

            Question gq2 = new Question("Welcher Fluss ist der längste der Welt?" , List.of("Amazonas", "Nil", "Yangtse", "Mississippi"), "Nil");

            geoQuiz.add(gq2);
            questionRepo.save(gq2);

            Question gq3 = new Question("Wie viele Kontinente gibt es?", List.of("5", "6", "7", "8"), "7");

            geoQuiz.add(gq3);
            questionRepo.save(gq3);

            Question gq4 = new Question("Welches Land hat die größte Bevölkerung?" , List.of("Indien", "China", "USA", "Indonesien"), "China");

            geoQuiz.add(gq4);
            questionRepo.save(gq4);

            Question gq5 = new Question("In welchem Kontinent liegt Argentinien?" , List.of("Afrika", "Asien", "Südamerika", "Europa"), "Südamerika");

            geoQuiz.add(gq5);
            questionRepo.save(gq5);

            Question gq6 = new Question("Wie heißt der höchste Berg der Erde?" , List.of("K2", "Mount Everest", "Mont Blanc", "Matterhorn"), "Mount Everest");

            geoQuiz.add(gq6);
            questionRepo.save(gq6);

            Question gq7 = new Question("Welche Meere umgeben Italien?" , List.of("Nordsee und Ostsee", "Adria und Mittelmeer", "Pazifik und Atlantik", "Schwarzes Meer und Kaspisches Meer"), "Adria und Mittelmeer");

            geoQuiz.add(gq7);
            questionRepo.save(gq7);

            Question gq8 = new Question("Welche Wüste ist die größte der Welt?", List.of("Sahara", "Gobi", "Antarktis", "Arabische Wüste"), "Antarktis");

            geoQuiz.add(gq8);
            questionRepo.save(gq8);

            Question gq9 = new Question("Welcher Staat hat die meisten Inseln?" , List.of("Philippinen", "Norwegen", "Schweden", "Indonesien"), "Schweden");

            geoQuiz.add(gq9);
            questionRepo.save(gq9);

            Question gq10 = new Question("Wo befindet sich das Tote Meer?" , List.of("Israel und Jordanien", "Ägypten und Sudan", "Türkei und Syrien", "Libanon und Irak"), "Israel und Jordanien");

            geoQuiz.add(gq10);
            questionRepo.save(gq10);

            MultipleChoiceQuiz muChoQuizgeo = new MultipleChoiceQuiz(Category.GEOGRAPHY, 10, 10, geoQuiz);
            quizRepo.save(muChoQuizgeo);

            
            List<Question> historyQuiz = new ArrayList<>();

            Question hq1 = new Question("Wann begann der Zweite Weltkrieg?", List.of("1933", "1939", "1941", "1945"), "1939");

            historyQuiz.add(hq1);
            questionRepo.save(hq1);

            Question hq2 = new Question("Wer war der erste Bundeskanzler der Bundesrepublik Deutschland?", List.of("Helmut Kohl", "Konrad Adenauer", "Willy Brandt", "Ludwig Erhard"), "Konrad Adenauer");

            historyQuiz.add(hq2);
            questionRepo.save(hq2);

            Question hq3 = new Question("Wann fiel die Berliner Mauer?", List.of("1989", "1990", "1987", "1991"), "1989");

            historyQuiz.add(hq3);
            questionRepo.save(hq3);

            Question hq4 = new Question("Was war die Weimarer Republik?", List.of("Ein Königreich", "Ein Kaiserreich", "Eine demokratische Republik", "Ein Bundesstaat"), "Eine demokratische Republik");

            historyQuiz.add(hq4);
            questionRepo.save(hq4);

            Question hq5 = new Question("Wer entdeckte Amerika im Jahr 1492?", List.of("Marco Polo", "Christoph Kolumbus", "Ferdinand Magellan", "James Cook"), "Christoph Kolumbus");

            historyQuiz.add(hq5);
            questionRepo.save(hq5);

            Question hq6 = new Question("Was war der Kalte Krieg?", List.of("Ein tatsächlicher Krieg", "Ein politischer Konflikt zwischen Ost und West", "Ein Bürgerkrieg in den USA", "Ein Konflikt zwischen Deutschland und Frankreich"), "Ein politischer Konflikt zwischen Ost und West");

            historyQuiz.add(hq6);
            questionRepo.save(hq6);

            Question hq7 = new Question("Wie hieß das römische Reich in der Spätantike?", List.of("Oströmisches Reich", "Heiliges Römisches Reich", "Kaiserreich Rom", "Byzantinisches Reich"), "Byzantinisches Reich");

            historyQuiz.add(hq7);
            questionRepo.save(hq7);

            Question hq8 = new Question("Wann wurde die DDR gegründet?", List.of("1949", "1945", "1950", "1955"), "1949");

            historyQuiz.add(hq8);
            questionRepo.save(hq8);

            Question hq9 = new Question("Wer war Martin Luther?", List.of("Ein König", "Ein Entdecker", "Ein Reformator", "Ein Kanzler"), "Ein Reformator");

            historyQuiz.add(hq9);
            questionRepo.save(hq9);

            Question hq10 = new Question("Was war die Industrielle Revolution?", List.of("Ein politischer Aufstand", "Ein wissenschaftlicher Durchbruch", "Eine Phase großer technischer Veränderungen", "Ein religiöser Wandel"), "Eine Phase großer technischer Veränderungen");

            historyQuiz.add(hq10);
            questionRepo.save(hq10);

            MultipleChoiceQuiz muChoQuizhistory = new MultipleChoiceQuiz(Category.HISTORY, 10, 10, historyQuiz);
            quizRepo.save(muChoQuizhistory);

            List<Question> generalKnowledgeQuiz = new ArrayList<>();

        Question q1 = new Question("Was ist die Hauptstadt von Spanien?", List.of("Madrid", "Barcelona", "Sevilla", "Valencia"), "Madrid");
        questionRepo.save(q1);
        generalKnowledgeQuiz.add(q1);

        Question q2 = new Question("Wie viele Beine hat eine Spinne?", List.of("6", "8", "10", "12"), "8");
        questionRepo.save(q2);
        generalKnowledgeQuiz.add(q2);

        Question q3 = new Question("Wer schrieb \"Faust\"?", List.of("Goethe", "Schiller", "Lessing", "Kafka"), "Goethe");
        questionRepo.save(q3);
        generalKnowledgeQuiz.add(q3);

        Question q4 = new Question("Wie viele Planeten hat unser Sonnensystem?", List.of("7", "8", "9", "10"), "8");
        questionRepo.save(q4);
        generalKnowledgeQuiz.add(q4);

        Question q5 = new Question("Was ist die Quadratwurzel von 64?", List.of("6", "7", "8", "9"), "8");
        questionRepo.save(q5);
        generalKnowledgeQuiz.add(q5);

        Question q6 = new Question("Welche Farbe ergibt Blau + Gelb?", List.of("Grün", "Lila", "Orange", "Braun"), "Grün");
        questionRepo.save(q6);
        generalKnowledgeQuiz.add(q6);

        Question q7 = new Question("Wie nennt man ein sechseckiges Vieleck?", List.of("Pentagon", "Hexagon", "Oktagon", "Trapez"), "Hexagon");
        questionRepo.save(q7);
        generalKnowledgeQuiz.add(q7);

        Question q8 = new Question("Welches Tier ist das größte Landraubtier?", List.of("Löwe", "Tiger", "Eisbär", "Wolf"), "Eisbär");
        questionRepo.save(q8);
        generalKnowledgeQuiz.add(q8);

        Question q9 = new Question("Welche Sprache spricht man in Brasilien?", List.of("Spanisch", "Portugiesisch", "Französisch", "Englisch"), "Portugiesisch");
        questionRepo.save(q9);
        generalKnowledgeQuiz.add(q9);

        Question q10 = new Question("Wie heißt das chemische Symbol für Gold?", List.of("Ag", "Au", "Fe", "Hg"), "Au");
        questionRepo.save(q10);
        generalKnowledgeQuiz.add(q10);

        MultipleChoiceQuiz muChoQuizgeneralKnowledge = new MultipleChoiceQuiz(Category.RANDOM, 10, 10, generalKnowledgeQuiz);
        quizRepo.save(muChoQuizgeneralKnowledge);

        List<Question> biologyQuiz = new ArrayList<>();

        Question bq1 = new Question("Welches Organ ist für die Produktion von Insulin verantwortlich?", List.of("Leber", "Niere", "Bauchspeicheldrüse", "Milz"), "Bauchspeicheldrüse");
        questionRepo.save(bq1);
        biologyQuiz.add(bq1);

        Question bq2 = new Question("Welche Zellorganelle ist das 'Kraftwerk' der Zelle?", List.of("Ribosomen", "Mitochondrien", "Golgi-Apparat", "Zellkern"), "Mitochondrien");
        questionRepo.save(bq2);
        biologyQuiz.add(bq2);

        Question bq3 = new Question("Welche Blutgruppe ist der Universalspender?", List.of("AB+", "O-", "A+", "B-"), "O-");
        questionRepo.save(bq3);
        biologyQuiz.add(bq3);

        Question bq4 = new Question("Was ist die Hauptfunktion der roten Blutkörperchen?", List.of("Hormonproduktion", "Immunabwehr", "Sauerstofftransport", "Verdauung"), "Sauerstofftransport");
        questionRepo.save(bq4);
        biologyQuiz.add(bq4);

        Question bq5 = new Question("Welches Organ ist für die Entgiftung des Körpers zuständig?", List.of("Herz", "Leber", "Magen", "Darm"), "Leber");
        questionRepo.save(bq5);
        biologyQuiz.add(bq5);

        Question bq6 = new Question("Was enthält die genetische Information einer Zelle?", List.of("Zellwand", "Zellplasma", "Zellkern", "Mitochondrien"), "Zellkern");
        questionRepo.save(bq6);
            biologyQuiz.add(bq6);

        Question bq7 = new Question("Wie nennt man den Prozess, bei dem Pflanzen Sonnenlicht in Energie umwandeln?", List.of("Fermentation", "Fotosynthese", "Oxidation", "Respiration"), "Fotosynthese");
        questionRepo.save(bq7);
        biologyQuiz.add(bq7);

        Question bq8 = new Question("Welche Funktion haben die weißen Blutkörperchen?", List.of("Blutgerinnung", "Sauerstofftransport", "Immunabwehr", "Nährstoffspeicherung"), "Immunabwehr");
        questionRepo.save(bq8);
        biologyQuiz.add(bq8);

        Question bq9 = new Question("Wie viele Chromosomen hat ein menschlicher Körper in der Regel?", List.of("23", "46", "22", "44"), "46");
        questionRepo.save(bq9);
        biologyQuiz.add(bq9);

        Question bq10 = new Question("Wie heißt das Hormon, das den Blutzuckerspiegel senkt?", List.of("Adrenalin", "Glukagon", "Insulin", "Melatonin"), "Insulin");
        questionRepo.save(bq10);
        biologyQuiz.add(bq10);

        MultipleChoiceQuiz muChoQuizbiology = new MultipleChoiceQuiz(Category.BIOLOGY, 10, 10, biologyQuiz);
        quizRepo.save(muChoQuizbiology);

        List<Question> financeQuiz = new ArrayList<>();

        Question fq1 = new Question("Was ist eine Dividende?", List.of("Ein Darlehen an eine Bank", "Eine Gewinnausschüttung an Aktionäre", "Eine Steuer auf Kapitalerträge", "Ein Kredit mit niedrigem Zinssatz"), "Eine Gewinnausschüttung an Aktionäre");
        questionRepo.save(fq1);
        financeQuiz.add(fq1);

        Question fq2 = new Question("Was bedeutet \"ROI\"?", List.of("Return On Investment", "Rate Of Interest", "Risk Of Inflation", "Revenue Over Income"), "Return On Investment");
        questionRepo.save(fq2);
        financeQuiz.add(fq2);

        Question fq3 = new Question("Eine Deflation bedeutet generell steigende Preise.", List.of("WAHR", "FALSCH"), "FALSCH");
        questionRepo.save(fq3);
        financeQuiz.add(fq3);

        Question fq4 = new Question("Was ist ein \"Bulle\" im Börsenkontext?", List.of("Ein Investor, der mit fallenden Kursen rechnet", "Ein Investor, der mit steigenden Kursen rechnet", "Ein unerfahrener Anleger", "Eine spezielle Art von Investmentfonds"), "Ein Investor, der mit steigenden Kursen rechnet");
        questionRepo.save(fq4);
        financeQuiz.add(fq4);

        Question fq5 = new Question("Eine hohe Inflation begünstigt in der Regel Sparguthaben.", List.of("WAHR", "FALSCH"), "FALSCH");
        questionRepo.save(fq5);
        financeQuiz.add(fq5);

        Question fq6 = new Question("Was ist ein ETF?", List.of("Eine europäische Handelszone", "Ein börsengehandelter Indexfonds", "Eine Form der Rentenversicherung", "Ein wirtschaftlicher Stresstest für Banken"), "Ein börsengehandelter Indexfonds");
        questionRepo.save(fq6);
        financeQuiz.add(fq6);

        Question fq7 = new Question("Die Börse in New York wird als \"Wall Street\" bezeichnet.", List.of("WAHR", "FALSCH"), "WAHR");
        questionRepo.save(fq7);
        financeQuiz.add(fq7);

        Question fq8 = new Question("Was ist das \"Eigenkapital\" eines Unternehmens?", List.of("Der monatliche Gewinn", "Das von Aktionären investierte Geld", "Die Differenz zwischen Vermögen und Schulden", "Der Wert aller physischen Vermögenswerte"), "Die Differenz zwischen Vermögen und Schulden");
        questionRepo.save(fq8);
        financeQuiz.add(fq8);

        Question fq9 = new Question("Ein \"Bear Market\" beschreibt eine Phase steigender Aktienkurse.", List.of("WAHR", "FALSCH"), "FALSCH");
        questionRepo.save(fq9);
        financeQuiz.add(fq9);

        Question fq10 = new Question("Was versteht man unter \"Liquidität\"?", List.of("Die Fähigkeit, Vermögenswerte schnell in Bargeld umzuwandeln", "Das Verhältnis von Schulden zu Eigenkapital", "Die gesetzliche Mindestreserve einer Bank", "Der Gewinn nach Steuern"), "Die Fähigkeit, Vermögenswerte schnell in Bargeld umzuwandeln");
        questionRepo.save(fq10);
        financeQuiz.add(fq10);

        MultipleChoiceQuiz muChoQuizfinance = new MultipleChoiceQuiz(Category.FINANCE, 10, 10, financeQuiz);
        quizRepo.save(muChoQuizfinance);

        List<Question> mathQuiz = new ArrayList<>();

        Question mq1 = new Question("Was ist das Ergebnis von 7 × 8?", List.of("42", "56", "49", "64"), "56");
        questionRepo.save(mq1);
        mathQuiz.add(mq1);

        Question mq2 = new Question("Was ist die Quadratwurzel von 144?", List.of("10", "12", "14", "16"), "12");
        questionRepo.save(mq2);
        mathQuiz.add(mq2);

        Question mq3 = new Question("Was ist das Ergebnis von 15 + 27?", List.of("32", "42", "52", "62"), "42");
        questionRepo.save(mq3);
        mathQuiz.add(mq3);

        Question mq4 = new Question("Was ist 3² + 4²?", List.of("7", "25", "49", "16"), "25");
        questionRepo.save(mq4);
        mathQuiz.add(mq4);

        Question mq5 = new Question("Was ist das kleinste gemeinsame Vielfache von 6 und 8?", List.of("12", "24", "36", "48"), "24");
        questionRepo.save(mq5);
        mathQuiz.add(mq5);

        Question mq6 = new Question("Was ist die Hälfte von 3/4?", List.of("3/8", "1/4", "6/8", "3/2"), "3/8");
        questionRepo.save(mq6);
        mathQuiz.add(mq6);

        Question mq7 = new Question("Ein rechter Winkel hat ... Grad?", List.of("45", "90", "180", "360"), "90");
        questionRepo.save(mq7);
        mathQuiz.add(mq7);

        Question mq8 = new Question("Was ist 5³?", List.of("25", "125", "75", "15"), "125");
        questionRepo.save(mq8);
        mathQuiz.add(mq8);

        Question mq9 = new Question("Was ist der Umfang eines Quadrats mit Seitenlänge 6cm?", List.of("24cm", "12cm", "36cm", "18cm"), "24cm");
        questionRepo.save(mq9);
        mathQuiz.add(mq9);

        Question mq10 = new Question("Wie viele Zentimeter sind 2,5 Meter?", List.of("250cm", "25cm", "2500cm", "205cm"), "250cm");
        questionRepo.save(mq10);
        mathQuiz.add(mq10);

        MultipleChoiceQuiz muChoQuizmath = new MultipleChoiceQuiz(Category.MATH, 10, 10, mathQuiz);
        quizRepo.save(muChoQuizmath);
        }
        else {
            System.out.println("Data already initialized"); }
        };
    }
}
