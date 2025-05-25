//  Importiere das QuizManager-Modul
import { quizManager } from './Quizmanager.js';

//  Initiale Zustände
let current = 0; // aktuelle Frage-Index
let score = 0;   // Punktestand

//  HTML-Elemente selektieren
const questionEl = document.getElementById('question');     // Frage-Text
const answersEl = document.getElementById('answers');       // Antwortcontainer
const nextBtn = document.getElementById('nextBtn');         // Button für nächste Frage
const level = document.getElementById('level');             // Level-Anzeige
const timerBar = document.getElementById('timer-bar');      // Zeitbalken

//  Quiz starten
quizManager.init(document.getElementById('hearts'), timerBar, 30); // Initialisiere mit 3 Leben, 30 Sekunden
quizManager.start(); // Starte den Timer

//  Zeige die aktuelle Frage
function renderQuestion() {
    const q = questions[current]; // Frage aus dem Array holen

    // Text anzeigen oder Standardtext bei Fehler
    questionEl.textContent = q.text || q.questionText || '❓ Ungültige Frage!';
    
    // Antworten zurücksetzen
    answersEl.innerHTML = '';
    nextBtn.classList.add('hidden'); // "Nächste Frage"-Button ausblenden

    //  Falls True/False-Frage
    if (typeof q.answer === 'boolean') {
        renderTrueFalse(q);
    } 
    //  Falls Multiple-Choice-Frage
    else if (Array.isArray(q.options) && typeof q.correctAnswer !== 'undefined') {
        renderMultipleChoice(q);
    }
}

//  True/False Buttons erzeugen
function renderTrueFalse(q) {
    ['Wahr', 'Falsch'].forEach((label, i) => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = i === 0 ? '✅ Wahr' : '❌ Falsch';
        btn.onclick = () => checkAnswer(i === 0, q.answer, btn); // true wenn "Wahr", false wenn "Falsch"
        answersEl.appendChild(btn);
    });
}

// Multiple-Choice Buttons erzeugen
function renderMultipleChoice(q) {
    q.options.forEach(opt => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = opt;
        btn.onclick = () => checkAnswer(opt, q.correctAnswer, btn); // Überprüfe Antwort
        answersEl.appendChild(btn);
    });
}

// Antwort prüfen & einfärben
function checkAnswer(selected, correct, clickedBtn) {
    const buttons = document.querySelectorAll('.btn-answer');

    // Alle Buttons deaktivieren und den richtigen markieren
    buttons.forEach(btn => {
        btn.disabled = true;

        // Richtige Antwort markieren
        if (
            btn.textContent === correct || 
            (btn.textContent === '✅ Wahr' && correct === true) || 
            (btn.textContent === '❌ Falsch' && correct === false)
        ) {
            btn.classList.add('correct');
        }
    });

    // Wenn Antwort korrekt
    if (
        selected === correct ||
        (typeof correct === 'boolean' && selected === correct)
    ) {
        score++; // Punkte erhöhen
        clickedBtn.classList.add('correct'); // Grün färben
    } else {
        clickedBtn.classList.add('incorrect'); // Rot färben
        loseHeart(); // Leben verlieren
    }

    // Zeige "Nächste Frage"-Button
    nextBtn.classList.remove('hidden');
}

//  Nächste Frage anzeigen oder Quiz beenden
function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) return endQuiz();

    // Alle 3 Fragen steigt das Level
    if (current % 3 === 0) {
        level.textContent = Number(level.textContent) + 1;
    }

    renderQuestion(); // neue Frage laden
}

//  Leben verlieren
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz(); // Wenn keine Leben mehr → Quiz beenden
}

// Quiz beenden
function endQuiz() {
    quizManager.end(); // Timer stoppen

    // Zeige Ergebnis
    document.querySelector('.quiz-container').innerHTML = `
        <h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
        <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

//  Starte Quiz mit erster Frage
nextBtn.onclick = nextQuestion;
renderQuestion();
