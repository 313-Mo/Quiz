  document.addEventListener("DOMContentLoaded", function () {
    const starLabels = document.querySelectorAll("#starContainer label");

    starLabels.forEach((label, index) => {
      label.addEventListener("click", () => {
        // Alle Sterne zurücksetzen
        starLabels.forEach(l => l.querySelector("span").classList.remove("selected"));

        // Sterne bis zum geklickten aktivieren
        for (let i = 0; i <= index; i++) {
          starLabels[i].querySelector("span").classList.add("selected");
        }
      });
    });
  });