import { quizManager } from './Quizmanager.js';

let currentQuestion = 0;
let score = 0;
let incorrect = 0;

const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const heartsContainer = document.getElementById('hearts');
const resultBox = document.getElementById('result');
const scoreDisplay = document.getElementById('score');


quizManager.init(heartsContainer, timerBar, 120);
quizManager.start();

function loadQuestion() {
    const q = questions[currentQuestion];
    questionEl.textContent = q.questionText;
    answersEl.innerHTML = '';
    q.answers.forEach((ans, i) => {
        const btn = document.createElement('button');
        btn.textContent = ans;
        btn.className = 'btn-answer';
        btn.onclick = () => checkAnswer(i, btn);
        answersEl.appendChild(btn);
    });
}

function checkAnswer(index, button) {
    const correctAnswer = questions[currentQuestion].correctAnswer;
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach((btn, i) => {
        btn.disabled = true;
        if (i === questions[currentQuestion].options.indexOf(correctAnswer)) btn.classList.add('correct');
        if (i === index && i !== questions[currentQuestion].options.indexOf(correctAnswer)) btn.classList.add('incorrect');
    });

    nextBtn.classList.remove('hidden');
    if (index === questions[currentQuestion].options.indexOf(correctAnswer)) {
        score++;
    } else {
        incorrect++;
        loseHeart();
    }
}

function loseHeart() {
    if (quizManager.loseHeart()) endQuiz();
}

function nextQuestion() {
    currentQuestion++;
    if (currentQuestion < questions.length) {
        loadQuestion();
    } else {
        endQuiz();
    }
}

function endQuiz() {
    quizManager.end();
    document.getElementById('question-area').classList.add('hidden');
    nextBtn.classList.add('hidden');
    resultBox.classList.remove('hidden');
    scoreDisplay.textContent = `Du hast ${score} von ${questions.length} Fragen richtig beantwortet. (${incorrect} falsch)`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();