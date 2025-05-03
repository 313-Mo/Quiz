const questions = [
    { text: 'Was bedeutet "HTML"?', options: ['HyperText Markup Language', 'Home Tool Markup Language', 'HyperTool Marked Language', 'HighText Machine Language'], correct: 0 },
    { text: 'Welches dieser Geräte ist KEIN Ausgabegerät?', options: ['Monitor', 'Drucker', 'Maus', 'Beamer'], correct: 2 },
    { text: 'Was ist ein Algorithmus?', options: ['Ein Computerprogramm', 'Ein Datenbankmodell', 'Eine Schritt-für-Schritt-Anleitung zur Lösung eines Problems', 'Ein Softwarefehler'], correct: 2 },
    { text: 'Welche Programmiersprache wird oft für Webentwicklung verwendet?', options: ['Python', 'JavaScript', 'C++', 'Java'], correct: 1 },
    { text: 'Was ist eine IP-Adresse?', options: ['Eine Internetplattform', 'Eine eindeutige Kennung eines Geräts im Netzwerk', 'Ein E-Mail-Protokoll', 'Ein Sicherheitsstandard'], correct: 1 },
    { text: 'Was bedeutet "Open Source"?', options: ['Software mit offenem Quellcode', 'Kostenlose Software', 'Software, die nicht verändert werden kann', 'Ein Verschlüsselungsalgorithmus'], correct: 0 },
    { text: 'Was ist ein Betriebssystem?', options: ['Ein Computerfehler', 'Ein Programm zur Textbearbeitung', 'Die Software, die die Hardware verwaltet und steuert', 'Ein Internetdienst'], correct: 2 },
    { text: 'Welche Zahl ist binär für 5?', options: ['0101', '0011', '1010', '1001'], correct: 0 },
    { text: 'Was ist ein Compiler?', options: ['Ein Gerät zur Codeausgabe', 'Ein Code-Analysator', 'Ein Programm, das Quellcode in Maschinencode umwandelt', 'Ein Computerfehler'], correct: 2 },
    { text: 'Welche Speicherart ist flüchtig?', options: ['ROM', 'RAM', 'SSD', 'Festplatte'], correct: 1 }
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
    document.querySelectorAll('.btn-answer').forEach((b, index) => {
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
    <p class="text-center text-lg">Du hast ${score} von ${questions.length} richtig beantwortet.</p>`;
}

nextBtn.onclick = nextQuestion;
loadQuestion();
