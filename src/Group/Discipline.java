package Group;

import java.io.Serializable;

public enum Discipline implements Serializable {
    // only first four are must have

    BACK_CRAWL("Back crawl"),
    CRAWL("Crawl"),
    BUTTERFLY("Butterfly"),
    BREAST_STROKE("Breast stroke");
    /*FREESTYLE(""),
    MEDLEY(""),
    MEDLEY_RELAY(""),
    OPEN_WATER("");*/

    private final String discName;

    Discipline(String discName) {
        this.discName = discName;
    }

    public String toString() {
        return this.discName;
    }
}
