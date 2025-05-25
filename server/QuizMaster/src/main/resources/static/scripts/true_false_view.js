document.addEventListener("DOMContentLoaded", function () {
  const questionText = document.getElementById("question");
  const answersContainer = document.getElementById("answers");
  const nextBtn = document.getElementById("nextBtn");

  let currentIndex = 0;

  function renderQuestion() {
    const frage = questions[currentIndex];
    if (!frage) {
      questionText.textContent = "🎉 Keine weiteren Fragen!";
      answersContainer.innerHTML = "";
      nextBtn.disabled = true;
      return;
    }

    
    if (typeof frage === "object" && typeof frage.answer === "boolean") {
      questionText.textContent = frage.text;
      answersContainer.innerHTML = `
        <div class="flex justify-center gap-4 my-4">
          <button class="btn-primary" id="trueBtn">✅ Wahr</button>
          <button class="btn-primary" id="falseBtn">❌ Falsch</button>
        </div>
      `;

      document.getElementById("trueBtn").addEventListener("click", () =>
        checkTFAnswer(true, frage.answer)
      );
      document.getElementById("falseBtn").addEventListener("click", () =>
        checkTFAnswer(false, frage.answer)
      );
    }

    
    else if (typeof frage === "object" && Array.isArray(frage.answers)) {
      questionText.textContent = frage.text;
      answersContainer.innerHTML = "";

      frage.answers.forEach((antwort, index) => {
        const btn = document.createElement("button");
        btn.textContent = antwort;
        btn.className = "btn-primary w-full";
        btn.onclick = () => checkMCAnswer(index, frage.correct);
        answersContainer.appendChild(btn);
      });
    }

    
    else {
      questionText.textContent = "❓ Ungültige Frage!";
      answersContainer.innerHTML = "";
    }
  }

  function checkTFAnswer(userAnswer, correctAnswer) {
    if (userAnswer === correctAnswer) {
      alert("✅ Richtig!");
    } else {
      alert("❌ Falsch!");
    }
  }

  function checkMCAnswer(index, correctIndex) {
    if (index === correctIndex) {
      alert("✅ Richtig!");
    } else {
      alert("❌ Falsch!");
    }
  }

  nextBtn.addEventListener("click", () => {
    currentIndex++;
    renderQuestion();
  });

  renderQuestion();
});
