let currentQuestion = 0;
let score = 0;
let incorrect = 0;
let hearts = 3;
let timeLeft = 120;
let timer;

const questionText = document.getElementById("question");
const answersContainer = document.getElementById("answers");
const nextBtn = document.getElementById("next-btn");
const timerBar = document.getElementById("timer-bar");
const heartsContainer = document.getElementById("hearts");
const resultBox = document.getElementById("result");
const scoreDisplay = document.getElementById("score");

function loadQuestion() {
    const q = questions[currentQuestion];
    questionText.textContent = q.questionText;
    answersContainer.innerHTML = "";
    q.answers.forEach((ans, i) => {
        const btn = document.createElement("button");
        btn.textContent = ans;
        btn.className = "btn-answer";
        btn.onclick = () => checkAnswer(i, btn);
        answersContainer.appendChild(btn);
    });
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

function loseHeart() {
    if (hearts > 0) {
        hearts--;
        heartsContainer.children[hearts].classList.add("lost");
    }
    if (hearts === 0) {
        endQuiz();
    }
}

function nextQuestion() {
    currentQuestion++;
    if (currentQuestion < questions.length) {
        loadQuestion();
    } else {
        endQuiz();
    }
}

function startTimer() {
    timer = setInterval(() => {
        timeLeft--;
        timerBar.style.width = (timeLeft / 120) * 100 + "%";
        if (timeLeft <= 0) {
            clearInterval(timer);
            endQuiz();
        }
    }, 1000);
}

function endQuiz() {
    clearInterval(timer);
    document.getElementById("question-area").classList.add("hidden");
    nextBtn.classList.add("hidden");
    resultBox.classList.remove("hidden");
    scoreDisplay.textContent = `Du hast ${score} von ${questions.length} Fragen richtig beantwortet. (${incorrect} falsch)`;
}

nextBtn.onclick = nextQuestion;

loadQuestion();
startTimer();
