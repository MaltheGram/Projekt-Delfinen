package Group;

import java.io.Serializable;

public enum Discipline implements Serializable {
    // only first four are must have

    BACK_CRAWL("Rygcrawl"),
    CRAWL("Crawl"),
    BUTTERFLY("Butterfly"),
    BREAST_STROKE("Brystsvømning");
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
