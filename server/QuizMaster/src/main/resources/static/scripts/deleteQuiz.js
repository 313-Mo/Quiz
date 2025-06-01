
function handleDeleteSubmit(event) {
  const select = document.getElementById("quizId");
  const selectedQuizId = select.value;

  if (!selectedQuizId) {
    event.preventDefault();
    alert("⚠️ Bitte wähle ein Quiz zum Löschen!");
    return false;
  }

  // Zeige nach dem Absenden eine Erfolgsmeldung (optional)
  alert("🗑️ Das Quiz wurde erfolgreich gelöscht!");
  return true;
}
