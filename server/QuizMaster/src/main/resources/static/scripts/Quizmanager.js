class QuizManager {
    constructor() {
        this.hearts = 3;
        this.timeLeft = 120;
        this.timer = null;
        this.timerBar = null;
        this.heartsContainer = null;
    }

    init(heartsContainer, timerBar, duration = 120) {
        this.hearts = 3;
        this.timeLeft = duration;
        this.timerBar = timerBar;
        this.heartsContainer = heartsContainer;
        this.renderHearts();
    }

    start() {
        this.startTimer();
    }

    startTimer() {
        this.timer = setInterval(() => {
            this.timeLeft--;
            this.updateTimerBar();
            if (this.timeLeft <= 0) this.end();
        }, 1000);
    }

    updateTimerBar() {
        if (this.timerBar) {
            this.timerBar.style.width = (this.timeLeft / 120) * 100 + "%";
        }
    }

    loseHeart() {
        this.hearts--;
        this.renderHearts();
        return this.hearts <= 0;
    }

    renderHearts() {
        if (!this.heartsContainer) return;
        this.heartsContainer.innerHTML = "";
        for (let i = 0; i < 3; i++) {
            const heart = document.createElement("span");
            heart.className = "heart";
            heart.textContent = i < this.hearts ? "❤️" : "💔";
            this.heartsContainer.appendChild(heart);
        }
    }

    getHearts() {
        return this.hearts;
    }

    end() {
        clearInterval(this.timer);
    }
}

export const quizManager = new QuizManager();
