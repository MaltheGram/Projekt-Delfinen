package Competition;

public enum ResultType {

    COMPETITION("competition"),
    TRAINING("training");

    private final String type;

    ResultType(String type) {
        this.type = type;
    }
}
