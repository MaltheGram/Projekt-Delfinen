package Group;

public class Brystsvømning extends Group {

    private final String name;
    private final Discipline discipline;

    Brystsvømning(String name, Discipline discipline) {
        super(name, discipline);
        this.name = name;
        this.discipline = discipline;
    }
}
