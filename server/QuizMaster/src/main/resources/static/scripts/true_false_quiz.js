function selectTime(button, minutes) {
  document.getElementById('selectedTime').value = minutes;
  document.querySelectorAll('.time-buttons button').forEach(btn => btn.classList.remove('active'));
  button.classList.add('active');
}

function handleSubmit(event) {
  event.preventDefault();
  const selectedTime = document.getElementById('selectedTime').value;
  if (!selectedTime) {
    alert("⏳ Bitte wähle eine Quiz-Zeit aus!");
    return;
  }
  alert("🎉 Dein True/False Quiz wurde erfolgreich gespeichert!");
}
