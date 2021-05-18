public enum Discipline {

    // only first four are must have

    BACK_CRAWL("rygcrawl"),
    CRAWL("crawl"),
    BUTTERFLY("butterfly"),
    BREAST_STROKE("brystsvømning"),
    FREESTYLE(""),
    MEDLEY(""),
    MEDLEY_RELAY(""),
    OPEN_WATER("");

    private final String discName;

    Discipline(String discName) {
        this.discName = discName;
    }

    public String getDisciplineName() {
        return this.discName;
    }
}
