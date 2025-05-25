// Importiere das Quiz-Manager-Modul
import { quizManager } from './Quizmanager.js';

// Initiale Werte für aktuelle Frage und Punktestand
let current = 0, score = 0;

// Zugriff auf HTML-Elemente
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const timerText = document.getElementById('timer');
const level = document.getElementById('level');

// Initialisiere den Quizmanager mit Leben, Timer und Dauer (30 Sekunden)
quizManager.init(document.getElementById('hearts'), timerBar, 30);
quizManager.start(); // Starte den Timer

// Zeigt die aktuelle Frage auf der Seite an
function loadQuestion() {
    const q = questions[current]; // Hole aktuelle Frage aus dem Fragen-Array
    questionEl.textContent = q.questionText; // Zeige Fragetext
    answersEl.innerHTML = ''; // Leere vorherige Antworten

    // Für jede Antwortoption wird ein Button erzeugt
    q.options.forEach((opt, i) => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = opt;
        btn.onclick = () => checkAnswer(i, btn); // Überprüfe die Antwort bei Klick
        answersEl.appendChild(btn); // Füge den Button zum Container hinzu
    });

    nextBtn.classList.add('hidden'); // Verstecke „Nächste Frage“-Button
}

// Prüft die gegebene Antwort und markiert die Buttons entsprechend
function checkAnswer(index, button) {
    const correctAnswer = questions[current].correctAnswer;
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach((btn, i) => {
        btn.disabled = true; // Alle Buttons deaktivieren nach Auswahl

        // Wenn Button die richtige Antwort repräsentiert → grün
        if (i === questions[current].options.indexOf(correctAnswer)) {
            btn.classList.add('correct');
        }

        // Wenn gewählter Button falsch war → rot
        if (i === index && i !== questions[current].options.indexOf(correctAnswer)) {
            btn.classList.add('incorrect');
        }
    });

    nextBtn.classList.remove('hidden'); // Zeige „Nächste Frage“-Button

    if (index === questions[current].options.indexOf(correctAnswer)) {
        score++; // Erhöhe Punktestand bei richtiger Antwort
    } else {
        loseHeart(); // Herz verlieren bei falscher Antwort
    }
}

// Erhöhe Index der Frage oder beende Quiz wenn keine Fragen mehr
function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) return endQuiz();
    if (current % 3 === 0) level.textContent = Number(level.textContent) + 1; // Steige Level alle 3 Fragen
    loadQuestion(); // Lade nächste Frage
}

// Reduziere Leben bei falscher Antwort
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz(); // Beende Quiz wenn keine Leben mehr
}

// Zeige Endbildschirm mit Ergebnis
function endQuiz() {
    quizManager.end();
    document.querySelector('.quiz-container').innerHTML = `
        <h2 class="text-2xl font-bold text-center mb-4">Quiz beendet!</h2>
        <p class="text-center text-lg">Du hast ${score} von ${questions.length} richtig beantwortet.</p>
    `;
}

// Eventlistener für den „Nächste Frage“-Button
nextBtn.onclick = nextQuestion;

// Lade die erste Frage beim Start
loadQuestion();
