package us.mn.state.health.example.constants;

public enum ColumnTypes {
    FIRST_NAME("first name"),
    LAST_NAME("last name"),
    DATE("date"),
    STREET_ADDRESS("street address"),
    STATE("state"),
    ZIP("zip");

    private final String displayName;

    ColumnTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
