const questions = [
    { text: 'Was ist die Hauptstadt von Kanada?', options: ['Toronto', 'Ottawa', 'Vancouver', 'Montreal'], correct: 1 },
    { text: 'Welcher Fluss ist der längste der Welt?', options: ['Amazonas', 'Nil', 'Yangtse', 'Mississippi'], correct: 1 },
    { text: 'Wie viele Kontinente gibt es?', options: ['5', '6', '7', '8'], correct: 2 },
    { text: 'Welches Land hat die größte Bevölkerung?', options: ['Indien', 'China', 'USA', 'Indonesien'], correct: 1 },
    { text: 'In welchem Kontinent liegt Argentinien?', options: ['Afrika', 'Asien', 'Südamerika', 'Europa'], correct: 2 },
    { text: 'Wie heißt der höchste Berg der Erde?', options: ['K2', 'Mount Everest', 'Mont Blanc', 'Matterhorn'], correct: 1 },
    { text: 'Welche Meere umgeben Italien?', options: ['Nordsee und Ostsee', 'Adria und Mittelmeer', 'Pazifik und Atlantik', 'Schwarzes Meer und Kaspisches Meer'], correct: 1 },
    { text: 'Welche Wüste ist die größte der Welt?', options: ['Sahara', 'Gobi', 'Antarktis', 'Arabische Wüste'], correct: 2 },
    { text: 'Welcher Staat hat die meisten Inseln?', options: ['Philippinen', 'Norwegen', 'Schweden', 'Indonesien'], correct: 2 },
    { text: 'Wo befindet sich das Tote Meer?', options: ['Israel und Jordanien', 'Ägypten und Sudan', 'Türkei und Syrien', 'Libanon und Irak'], correct: 0 },
];

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
    questionEl.textContent = q.text;
    answersEl.innerHTML = '';
    q.options.forEach((opt, i) => {
        const btn = document.createElement('button');
        btn.className = 'btn-answer';
        btn.textContent = opt;
        btn.onclick = () => selectAnswer(i, btn);
        answersEl.appendChild(btn);
    });
    nextBtn.classList.add('hidden');
    resetTimer();
}

function selectAnswer(i, btn) {
    const correct = questions[current].correct;
    const buttons = document.querySelectorAll('.btn-answer');
    buttons.forEach((b, index) => {
        b.disabled = true;
        if (index === correct) b.classList.add('correct');
        if (index === i && index !== correct) b.classList.add('incorrect');
    });
    if (i === correct) score++;
    else loseHeart();
    clearInterval(timer);
    nextBtn.classList.remove('hidden');
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
    document.querySelector('.quiz-container').innerHTML = `
    <h2 class="text-2xl font-bold text-center mb-4">Quiz beendet!</h2>
    <p class="text-center text-lg">Du hast ${score} von ${questions.length} richtig beantwortet.</p>
  `;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
