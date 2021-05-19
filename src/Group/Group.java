package Group;
import Member.Member;
import java.util.ArrayList;

// not to be implemented first iteration!
public class Group {
    private String name;
    private Discipline discipline;
    private ArrayList<Member> groupMembers = new ArrayList<>();
    // keep this info saved in a file (

    Group(String name, Discipline discipline) {
        this.name = name;
        this.discipline = discipline;
    }

    public void addGroupMember(Member member) {
        // add member to list
        // update file
    }

    public void removeGroupMember(Member member) {
        // remove member from list and file
    }

}
