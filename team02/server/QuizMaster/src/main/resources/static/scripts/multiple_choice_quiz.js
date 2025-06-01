function selectTime(button, minutes) {
  document.getElementById('selectedTime').value = minutes;
  document.querySelectorAll('.time-buttons button').forEach(btn => btn.classList.remove('active'));
  button.classList.add('active');
}

function addAnotherQuestion() {
  const category = document.getElementById("quizCategory").value;
  const selectedTime = document.getElementById("selectedTime").value;
  const questionText = document.getElementById("questionText").value.trim();
  const options = [
    document.getElementById("opt1").value.trim(),
    document.getElementById("opt2").value.trim(),
    document.getElementById("opt3").value.trim(),
    document.getElementById("opt4").value.trim()
  ];
  const correctAnswerIndex = document.getElementById("correctAnswer").value;

  if (!category || !selectedTime || !questionText || options.includes("") || correctAnswerIndex === "") {
    alert("Bitte alle Felder ausfüllen!");
    return;
  }

  fetch("/add-mc-question", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      category: category,
      selectedTime: selectedTime,
      question: questionText,
      option1: options[0],
      option2: options[1],
      option3: options[2],
      option4: options[3],
      "correct-answer": `option${parseInt(correctAnswerIndex) + 1}`
    })
  })
  .then(res => res.text())
  .then(msg => {
    alert(msg);
    document.getElementById("questionText").value = "";
    document.getElementById("opt1").value = "";
    document.getElementById("opt2").value = "";
    document.getElementById("opt3").value = "";
    document.getElementById("opt4").value = "";
    document.getElementById("correctAnswer").value = "";
  });
}

function finishQuiz() {
  const category = document.getElementById("quizCategory").value;
  const selectedTime = document.getElementById("selectedTime").value;

  if (!category || !selectedTime) {
    alert("Bitte alle Felder ausfüllen!");
    return;
  }

  fetch("/finalize-mc-quiz", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: new URLSearchParams({
      category: category,
      selectedTime: selectedTime
    })
  })
  .then(res => res.text())
  .then(msg => {
    alert(msg);
    window.location.href = "/category/" + category.toLowerCase();
  });
}
