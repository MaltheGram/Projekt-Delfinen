package Competition;

import java.io.Serializable;

public enum ResultType implements Serializable {
    COMPETITION("Competition"),
    TRAINING("Training");

    private final String type;

    ResultType(String type) {
        this.type = type;
    }
}
