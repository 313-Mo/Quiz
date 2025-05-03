function switchLang(lang) {
    const addBtn = document.querySelector(".add-button");
    if (addBtn) {
        addBtn.textContent = lang === "en" ? "➕ Add New Quiz" : "➕ Neues Quiz hinzufügen";
    }

    const title = document.getElementById("main-title");
    title.textContent = lang === "en" ? "Choose a Category" : "Wähle eine Kategorie";

    const buttons = document.querySelectorAll(".category-button");
    buttons.forEach(btn => {
        const label = lang === "en" ? btn.dataset.en : btn.dataset.de;
        const icon = btn.innerHTML.split("<br>")[0];
        btn.innerHTML = icon + "<br>" + label;
    });
}
