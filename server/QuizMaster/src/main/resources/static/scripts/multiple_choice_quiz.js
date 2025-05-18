function selectTime(button, minutes) {
  document.getElementById('selectedTime').value = minutes;

  document.querySelectorAll('.time-buttons button').forEach(btn => btn.classList.remove('active'));
  button.classList.add('active');
}

function handleSubmit(event) {
  const selectedTime = document.getElementById('selectedTime').value;

  if (!selectedTime) {
    event.preventDefault(); 
    alert("⏳ Bitte wähle eine Quiz-Zeit!");
    return false;
  }

  alert("🎉 Dein Quiz wurde erfolgreich gespeichert!");
  return true; 
}
