import { quizManager } from './Quizmanager.js';

//  Initialisierung von Zustand
let current = 0, score = 0;

//  Referenzen auf HTML-Elemente holen
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const timerText = document.getElementById('timer');
const heartsContainer = document.getElementById('hearts');
const level = document.getElementById('level');

//  QuizManager initialisieren (Leben, Timer, etc.)
quizManager.init(heartsContainer, timerBar, 30); // 30 Sekunden pro Frage
quizManager.start();

//  Frage laden
function loadQuestion() {
    const q = questions[current]; // aktuelle Frage aus Array
    questionEl.textContent = q.questionText; // Frage anzeigen
    answersEl.innerHTML = ''; // alte Antworten löschen
    nextBtn.classList.add('hidden'); // Nächste-Button ausblenden

    //  Antwortmöglichkeiten dynamisch generieren
    q.options.forEach((opt, i) => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = opt;
        btn.onclick = () => checkAnswer(i, btn); // bei Klick prüfen
        answersEl.appendChild(btn);
    });
}

//  Antwort überprüfen und farblich markieren
function checkAnswer(index, button) {
    const correctAnswer = questions[current].correctAnswer;
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach((btn, i) => {
        btn.disabled = true; // alle Buttons deaktivieren
        // richtige Antwort → grün
        if (i === questions[current].options.indexOf(correctAnswer)) {
            btn.classList.add('correct');
        }
        // falsche Auswahl → rot
        if (i === index && i !== questions[current].options.indexOf(correctAnswer)) {
            btn.classList.add('incorrect');
        }
    });

    nextBtn.classList.remove('hidden'); // „Nächste Frage“-Button zeigen

    // Punkte + Leben aktualisieren
    if (index === questions[current].options.indexOf(correctAnswer)) {
        score++;
    } else {
        loseHeart();
    }
}

//  Leben verlieren (wenn falsch beantwortet)
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz(); // Wenn alle Leben weg, beende Quiz
}

//  Zur nächsten Frage wechseln
function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) {
        return endQuiz(); // Ende erreicht?
    }
    if (current % 3 === 0) {
        level.textContent = Number(level.textContent) + 1; // Level hochzählen
    }
    loadQuestion(); // nächste Frage anzeigen
}

//  Quiz abschließen und Ergebnis zeigen
function endQuiz() {
    quizManager.end(); // Timer stoppen
    document.querySelector('.quiz-container').innerHTML = `
        <h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
        <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>
    `;
}

//  Button-Verhalten setzen
nextBtn.onclick = nextQuestion;

// Spiel starten mit erster Frage
loadQuestion();
