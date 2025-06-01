function copyLink() {
  const input = document.getElementById("quizLink");
  input.select();
  input.setSelectionRange(0, 99999);
  navigator.clipboard.writeText(input.value);
  alert("Link kopiert!");
}

function shareWhatsApp() {
  const link = document.getElementById("quizLink").value;
  window.open(`https://wa.me/?text=${encodeURIComponent(link)}`, '_blank');
}

function shareTelegram() {
  const link = document.getElementById("quizLink").value;
  window.open(`https://t.me/share/url?url=${encodeURIComponent(link)}`, '_blank');
}

function shareEmail() {
  const link = document.getElementById("quizLink").value;
  window.location.href = `mailto:?subject=Mein Quiz&body=Hier ist der Link zu meinem Quiz: ${link}`;
}

