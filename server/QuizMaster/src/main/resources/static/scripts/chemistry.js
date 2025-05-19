import { quizManager } from './Quizmanager.js';

let current = 0, score = 0;
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('nextBtn');
const timerBar = document.getElementById('timer-bar');
const timerText = document.getElementById('timer');
const level = document.getElementById('level');

quizManager.init(document.getElementById('hearts-container'), timerBar, 30);
quizManager.start();

function loadQuestion() {
    const q = questions[current];
    questionEl.textContent = q.questionText;
    answersEl.innerHTML = '';
    q.options.forEach((opt, i) => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = opt;
        btn.onclick = () => checkAnswer(i, btn);
        answersEl.appendChild(btn);
    });
    nextBtn.classList.add('hidden');
}

function checkAnswer(index, button) {
    const correctAnswer = questions[current].correctAnswer;
    const buttons = document.querySelectorAll('.btn-answer');

    buttons.forEach((btn, i) => {
        btn.disabled = true;
        if (i === questions[current].options.indexOf(correctAnswer)) btn.classList.add('correct');
        if (i === index && i !== questions[current].options.indexOf(correctAnswer)) btn.classList.add('incorrect');
    });

    nextBtn.classList.remove('hidden');
    if (index === questions[current].options.indexOf(correctAnswer)) {
        score++;
    } else {
        loseHeart();
    }
}

function nextQuestion() {
    current++;
    if (current >= questions.length || quizManager.getHearts() <= 0) return endQuiz();
    if (current % 3 === 0) level.textContent = Number(level.textContent) + 1;
    loadQuestion();
}

function loseHeart() {
    if (quizManager.loseHeart()) endQuiz();
}

function endQuiz() {
    quizManager.end();
    document.querySelector('.quiz-container').innerHTML = `
    <h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
    <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
