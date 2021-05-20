package Group;

public class Butterfly extends Group {

    private final String name;
    private final Discipline discipline;

    Butterfly(String name, Discipline discipline) {
        super(name, discipline);
        this.name = name;
        this.discipline = discipline;
    }
}
