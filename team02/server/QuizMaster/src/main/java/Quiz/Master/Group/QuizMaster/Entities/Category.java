package Quiz.Master.Group.QuizMaster.Entities;

public enum Category {
    CHEMISTRY("Chemistry"),
    MATH("Mathematics"),
    GEOGRAPHY("Geography"),
    FINANCE("Finance"),
    RANDOM("General Knowledge"),
    BIOLOGY("Biology"),
    COMPUTER_SCIENCE("Computer Science"),
    HISTORY("History");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Category fromLabel(String label) {
        for (Category category : values()) {
            if (category.label.equalsIgnoreCase(label)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown category label: " + label);
    }

    @Override
    public String toString() {
        return label;
    }
} 
