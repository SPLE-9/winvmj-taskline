package taskline.task.core;

public enum Status {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
