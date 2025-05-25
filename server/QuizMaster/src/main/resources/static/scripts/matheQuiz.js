//  Importiere das Quizmanager-Modul
import { quizManager } from './Quizmanager.js';

//  Initialisiere Variablen
let currentQuestion = 0;
let score = 0;
let incorrect = 0;

//  Greife auf HTML-Elemente zu
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const heartsContainer = document.getElementById('hearts');
const resultBox = document.getElementById('result');
const scoreDisplay = document.getElementById('score');

//  Starte das Quiz
quizManager.init(heartsContainer, timerBar, 120);
quizManager.start();

//  Zeige die aktuelle Frage
function loadQuestion() {
    const q = questions[currentQuestion];
    questionEl.textContent = q.text || q.questionText || "Keine Frage gefunden";
    answersEl.innerHTML = '';
    nextBtn.classList.add('hidden');

    //  TRUE/FALSE Frage
    if (typeof q.answer === 'boolean') {
        ['✅ Wahr', '❌ Falsch'].forEach((label, i) => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = label;
            btn.onclick = () => checkTFAnswer(i === 0, q.answer, btn);
            answersEl.appendChild(btn);
        });
    }

    //  MULTIPLE-CHOICE Frage
    else if (Array.isArray(q.options)) {
        q.options.forEach((opt, i) => {
            const btn = document.createElement('button');
            btn.className = 'btn-answer';
            btn.textContent = opt;
            btn.onclick = () => checkMCAnswer(opt, q.correctAnswer, btn);
            answersEl.appendChild(btn);
        });
    }
}

//  TRUE/FALSE Auswertung
function checkTFAnswer(selected, correct, btnClicked) {
    const allButtons = document.querySelectorAll('.btn-answer');
    allButtons.forEach(btn => {
        btn.disabled = true;
        if ((btn.textContent.includes('Wahr') && correct) || (btn.textContent.includes('Falsch') && !correct)) {
            btn.classList.add('correct');
        }
    });

    if (selected === correct) {
        score++;
        btnClicked.classList.add('correct');
    } else {
        incorrect++;
        btnClicked.classList.add('incorrect');
        loseHeart();
    }

    nextBtn.classList.remove('hidden');
}

//  MULTIPLE-CHOICE Auswertung
function checkMCAnswer(selected, correct, btnClicked) {
    const allButtons = document.querySelectorAll('.btn-answer');
    allButtons.forEach(btn => {
        btn.disabled = true;
        if (btn.textContent === correct) {
            btn.classList.add('correct');
        }
    });

    if (selected === correct) {
        score++;
        btnClicked.classList.add('correct');
    } else {
        incorrect++;
        btnClicked.classList.add('incorrect');
        loseHeart();
    }

    nextBtn.classList.remove('hidden');
}

//  Herz verlieren bei Fehler
function loseHeart() {
    if (quizManager.loseHeart()) endQuiz();
}

//  Nächste Frage anzeigen
function nextQuestion() {
    currentQuestion++;
    if (currentQuestion < questions.length) {
        loadQuestion();
    } else {
        endQuiz();
    }
}

//  Quiz beenden
function endQuiz() {
    quizManager.end();
    document.getElementById('question-area')?.classList.add('hidden');
    nextBtn.classList.add('hidden');
    resultBox.classList.remove('hidden');
    scoreDisplay.textContent = `Du hast ${score} von ${questions.length} Fragen richtig beantwortet. (${incorrect} falsch)`;
}

//  Event Listener für "Nächste Frage"
nextBtn.onclick = nextQuestion;

//  Starte mit der ersten Frage
loadQuestion();
