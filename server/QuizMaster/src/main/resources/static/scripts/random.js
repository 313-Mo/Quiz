const questions = [
    { text: 'Was ist die Hauptstadt von Spanien?', options: ['Madrid', 'Barcelona', 'Sevilla', 'Valencia'], correct: 0 },
    { text: 'Wie viele Beine hat eine Spinne?', options: ['6', '8', '10', '12'], correct: 1 },
    { text: 'Wer schrieb "Faust"?', options: ['Goethe', 'Schiller', 'Lessing', 'Kafka'], correct: 0 },
    { text: 'Wie viele Planeten hat unser Sonnensystem?', options: ['7', '8', '9', '10'], correct: 1 },
    { text: 'Was ist die Quadratwurzel von 64?', options: ['6', '7', '8', '9'], correct: 2 },
    { text: 'Welche Farbe ergibt Blau + Gelb?', options: ['Grün', 'Lila', 'Orange', 'Braun'], correct: 0 },
    { text: 'Wie nennt man ein sechseckiges Vieleck?', options: ['Pentagon', 'Hexagon', 'Oktagon', 'Trapez'], correct: 1 },
    { text: 'Welches Tier ist das größte Landraubtier?', options: ['Löwe', 'Tiger', 'Eisbär', 'Wolf'], correct: 2 },
    { text: 'Welche Sprache spricht man in Brasilien?', options: ['Spanisch', 'Portugiesisch', 'Französisch', 'Englisch'], correct: 1 },
    { text: 'Wie heißt das chemische Symbol für Gold?', options: ['Ag', 'Au', 'Fe', 'Hg'], correct: 1 }
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
    document.querySelector('.quiz-container').innerHTML = `<h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
    <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
