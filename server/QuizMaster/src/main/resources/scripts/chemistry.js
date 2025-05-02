// quiz.js
const questions = [
    { text: 'Was ist das chemische Symbol für Wasserstoff?', options: ['H', 'He', 'O', 'N'], correct: 0 },
    { text: 'Wie viele Elektronen hat ein Sauerstoffatom?', options: ['6', '8', '10', '12'], correct: 1 },
    { text: 'Was ist der pH-Wert von reinem Wasser?', options: ['0', '7', '14', '1'], correct: 1 },
    { text: 'Welches Teilchen bestimmt das chemische Element?', options: ['Proton', 'Elektron', 'Neutron', 'Ion'], correct: 0 },
    { text: 'Was ist eine chemische Reaktion?', options: ['Ein physikalischer Vorgang', 'Eine Umwandlung von Stoffen', 'Eine Temperaturänderung', 'Ein Aggregatzustandswechsel'], correct: 1 },
    { text: 'Was ist das häufigste Element im Universum?', options: ['Helium', 'Kohlenstoff', 'Sauerstoff', 'Wasserstoff'], correct: 3 },
    { text: 'Welches Gas entsteht bei der Fotosynthese?', options: ['Kohlenstoffdioxid', 'Wasserstoff', 'Sauerstoff', 'Stickstoff'], correct: 2 },
    { text: 'Was ist eine Base?', options: ['Eine saure Lösung', 'Eine Lösung mit pH < 7', 'Eine Lösung mit pH > 7', 'Ein Neutrallösungsmittel'], correct: 2 },
    { text: 'Welche Teilchen befinden sich im Atomkern?', options: ['Protonen und Elektronen', 'Neutronen und Elektronen', 'Protonen und Neutronen', 'Nur Elektronen'], correct: 2 },
    { text: 'Was ist eine Ionenbindung?', options: ['Bindung zwischen Metallen', 'Bindung zwischen Nichtmetallen', 'Bindung zwischen Ionen mit entgegengesetzter Ladung', 'Bindung innerhalb eines Atoms'], correct: 2 }
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
    <h2 class='text-2xl font-bold text-center mb-4'>Quiz beendet!</h2>
    <p class='text-center text-lg'>Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
