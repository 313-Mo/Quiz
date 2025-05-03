const questions = [
    { text: 'Wann begann der Zweite Weltkrieg?', options: ['1933', '1939', '1941', '1945'], correct: 1 },
    { text: 'Wer war der erste Bundeskanzler der Bundesrepublik Deutschland?', options: ['Helmut Kohl', 'Konrad Adenauer', 'Willy Brandt', 'Ludwig Erhard'], correct: 1 },
    { text: 'Wann fiel die Berliner Mauer?', options: ['1989', '1990', '1987', '1991'], correct: 0 },
    { text: 'Was war die Weimarer Republik?', options: ['Ein Königreich', 'Ein Kaiserreich', 'Eine demokratische Republik', 'Ein Bundesstaat'], correct: 2 },
    { text: 'Wer entdeckte Amerika im Jahr 1492?', options: ['Marco Polo', 'Christoph Kolumbus', 'Ferdinand Magellan', 'James Cook'], correct: 1 },
    { text: 'Was war der Kalte Krieg?', options: ['Ein tatsächlicher Krieg', 'Ein politischer Konflikt zwischen Ost und West', 'Ein Bürgerkrieg in den USA', 'Ein Konflikt zwischen Deutschland und Frankreich'], correct: 1 },
    { text: 'Wie hieß das römische Reich in der Spätantike?', options: ['Oströmisches Reich', 'Heiliges Römisches Reich', 'Kaiserreich Rom', 'Byzantinisches Reich'], correct: 3 },
    { text: 'Wann wurde die DDR gegründet?', options: ['1949', '1945', '1950', '1955'], correct: 0 },
    { text: 'Wer war Martin Luther?', options: ['Ein König', 'Ein Entdecker', 'Ein Reformator', 'Ein Kanzler'], correct: 2 },
    { text: 'Was war die Industrielle Revolution?', options: ['Ein politischer Aufstand', 'Ein wissenschaftlicher Durchbruch', 'Eine Phase großer technischer Veränderungen', 'Ein religiöser Wandel'], correct: 2 },
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
