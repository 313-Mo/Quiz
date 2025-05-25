import { quizManager } from './Quizmanager.js';

let current = 0, score = 0;

// DOM-Elemente abrufen
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const level = document.getElementById('level');

// Initialisiere Quiz (Leben, Zeitbalken)
quizManager.init(document.getElementById('hearts'), timerBar, 30);
quizManager.start();

// Lädt die aktuelle Frage – erkennt automatisch Typ
function loadQuestion() {
    const q = questions[current];
    questionEl.textContent = q.questionText || q.text || "❓ Keine gültige Frage";
    answersEl.innerHTML = '';
    nextBtn.classList.add('hidden');

    // TRUE/FALSE-Fragen
    if (typeof q.answer === 'boolean') {
        ['✅ Wahr', '❌ Falsch'].forEach((label, i) => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = label;
            btn.onclick = () => checkAnswer(i === 0, q.answer, btn); // Wahr = true
            answersEl.appendChild(btn);
        });
    }

    // Multiple-Choice-Fragen
    else if (Array.isArray(q.options)) {
        q.options.forEach(opt => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = opt;
            btn.onclick = () => checkAnswer(opt, q.correctAnswer, btn);
            answersEl.appendChild(btn);
        });
    }
}

// Antwort prüfen und einfärben
function checkAnswer(selected, correct, clickedBtn) {
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach(btn => {
        btn.disabled = true;

        // richtige Antwort grün markieren
        if (
            btn.textContent === correct ||
            (btn.textContent.includes('Wahr') && correct === true) ||
            (btn.textContent.includes('Falsch') && correct === false)
        ) {
            btn.classList.add('correct');
        }
    });

    // Bewertung
    if (selected === correct) {
        score++;
        clickedBtn.classList.add('correct');
    } else {
        clickedBtn.classList.add('incorrect');
        loseHeart();
    }

    nextBtn.classList.remove('hidden');
}

// Leben abziehen
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz();
}

// Nächste Frage laden
function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) return endQuiz();
    if (current % 3 === 0) level.textContent = Number(level.textContent) + 1;
    loadQuestion();
}

// Quiz beenden
function endQuiz() {
    quizManager.end();
    document.querySelector('.quiz-container').innerHTML = `
        <h2 class="text-2xl font-bold text-center mb-4">Quiz beendet!</h2>
        <p class="text-center text-lg">Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

// Start
nextBtn.onclick = nextQuestion;
loadQuestion();
