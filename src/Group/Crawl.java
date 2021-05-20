package Group;

public class Crawl extends Group {

    private final String name;
    private final Discipline discipline;

    Crawl(String name, Discipline discipline) {
        super(name, discipline);
        this.name = name;
        this.discipline = discipline;
    }
}
