function selectTime(button, minutes) {
  document.getElementById('selectedTime').value = minutes;
  document.querySelectorAll('.time-buttons button').forEach(btn => btn.classList.remove('active'));
  button.classList.add('active');
}

function addTFQuestion() {
  const question = document.getElementById("question").value.trim();
  const answer = document.getElementById("answer").value;

  if (!question || answer === "") {
    alert("Bitte Frage und Antwort eingeben!");
    return;
  }

  fetch("/add-tf-question", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      question: question,
      answer: answer
    })
  })
    .then(res => res.text())
    .then(msg => {
      alert("✅ Frage gespeichert: " + msg);
      document.getElementById("question").value = "";
      document.getElementById("answer").value = "";
    });
}

function finalizeTFQuiz() {
  const category = document.getElementById("quizCategory").value;
  const selectedTime = document.getElementById("selectedTime").value;

  if (!category || !selectedTime) {
    alert("Bitte alle Felder ausfüllen!");
    return;
  }

  fetch("/finalize-truefalse-quiz", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      category: category,
      selectedTime: selectedTime
    })
  })
    .then(res => res.text())
    .then(msg => {
      alert("🎉 " + msg);
      window.location.href = "/category/" + category.toLowerCase();
    });
}
