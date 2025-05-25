import { quizManager } from './Quizmanager.js';

let current = 0;
let score = 0;

const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const level = document.getElementById('level');
const timerBar = document.getElementById('timer-bar');

// 🧠 Initialisieren
quizManager.init(document.getElementById('hearts-container'), timerBar, 30);
quizManager.start();

// 🎯 Frage laden
function loadQuestion() {
    const q = questions[current];
    questionEl.textContent = q.text || q.questionText || '❓ Ungültige Frage!';
    answersEl.innerHTML = '';
    nextBtn.classList.add('hidden');

    // ✅ TRUE/FALSE
    if (typeof q.answer === 'boolean') {
        ['Wahr', 'Falsch'].forEach((label, i) => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = i === 0 ? '✅ Wahr' : '❌ Falsch';
            btn.onclick = () => checkAnswer(i === 0, q.answer, btn);
            answersEl.appendChild(btn);
        });
    }
    // ✅ MULTIPLE CHOICE
    else if (Array.isArray(q.options) && typeof q.correctAnswer !== 'undefined') {
        q.options.forEach(opt => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = opt;
            btn.onclick = () => checkAnswer(opt, q.correctAnswer, btn);
            answersEl.appendChild(btn);
        });
    }
}

// ✅ Antwort überprüfen
function checkAnswer(selected, correct, clickedBtn) {
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach(btn => {
        btn.disabled = true;
        if (
            btn.textContent === correct ||
            (btn.textContent === '✅ Wahr' && correct === true) ||
            (btn.textContent === '❌ Falsch' && correct === false)
        ) {
            btn.classList.add('correct');
        }
    });

    if (selected === correct) {
        score++;
        clickedBtn.classList.add('correct');
    } else {
        clickedBtn.classList.add('incorrect');
        loseHeart();
    }

    nextBtn.classList.remove('hidden');
}

// 💔 Herz verlieren
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz();
}

// ➡️ Nächste Frage
function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) return endQuiz();
    if (current % 3 === 0) level.textContent = Number(level.textContent) + 1;
    loadQuestion();
}

// 🛑 Quiz beenden
function endQuiz() {
    quizManager.end();
    document.querySelector('.quiz-container').innerHTML = `
      <h2 class="text-2xl font-bold text-center mb-4">Quiz beendet!</h2>
      <p class="text-center text-lg">Du hast ${score} von ${questions.length} richtig beantwortet.</p>
    `;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
