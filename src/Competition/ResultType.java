package Competition;

public enum ResultType {
    COMPETITION("Competition"),
    TRAINING("Training");

    private final String type;

    ResultType(String type) {
        this.type = type;
    }
}
