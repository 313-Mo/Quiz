let current = 0, score = 0, time = 30, timer, lives = 3;
const questionEl = document.getElementById('question');
const answersEl = document.getElementById('answers');
const nextBtn = document.getElementById('next');
const timerBar = document.getElementById('timer-bar');
const timerText = document.getElementById('timer');
const hearts = document.querySelectorAll('.heart');
const level = document.getElementById('level');

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
    resetTimer();
}

function checkAnswer(index, button) {
    const correctAnswer = questions[current].correctAnswer;
    const selectedAnswer = questions[current].options[index];
    const correctIndex = questions[current].options.indexOf(correctAnswer);

    const buttons = document.querySelectorAll(".btn-answer");

    buttons.forEach((btn, i) => {
        btn.disabled = true;
        if (i === correctIndex) btn.classList.add("correct");
        if (i === index && i !== correctIndex) btn.classList.add("incorrect");
    });

    nextBtn.classList.remove('hidden');
    if (index === correctIndex) {
        score++;
    } else {
        incorrect++;
        loseHeart();
    }
    resetTimer();
    
    
}

function nextQuestion() {
    current++;
    if (current >= questions.length || lives <= 0) return endQuiz();
    if (current % 3 === 0) level.textContent = Number(level.textContent) + 1;
    loadQuestion();
}

function resetTimer() {
    clearInterval(timer);
    time = 30;
    timerText.textContent = time;
    timerBar.style.width = '100%';
    timer = setInterval(() => {
        time--;
        timerText.textContent = time;
        timerBar.style.width = `${(time / 30) * 100}%`;
        if (time <= 0) {
            clearInterval(timer);
            loseHeart();
            nextBtn.classList.remove('hidden');
        }
    }, 1000);
}

function loseHeart() {
    lives--;
    if (lives >= 0 && hearts[lives]) hearts[lives].classList.add('lost');
    if (lives <= 0) endQuiz();
}

function endQuiz() {
    clearInterval(timer);
    document.querySelector('.quiz-container').innerHTML = `<h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
    <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
