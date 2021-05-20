import Member.Member;
import Member.MemberList;
import Menu.MainMenu;
import Service.MemberIdGenerator;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    private static final TextIO textio = TextIoFactory.getTextIO();
    private static final TextTerminal<?> console = textio.getTextTerminal();

    public static void main(String[] args) {
        //INIT MEMBER LIST
        HashMap<String,Member> listOfMembers = new HashMap<>();
        listOfMembers = FileControl.readMemberListfromFile("list");

        //
        //

       /* MemberIdGenerator memberIdGenerator = new MemberIdGenerator();
        MemberIdGenerator memberIdGenerator2 = new MemberIdGenerator();

        LocalDate MaltheDate = LocalDate.of(1998, 1, 30);
        LocalDate MarkDate = LocalDate.of(1996, 10, 30);

        Member Malthe = new Member("Malthe", MaltheDate, "Hoffmeyersvej 67", "61331776", true);
        Member Mark = new Member("Mark", MarkDate, "Lygten 37", "8888888", true);


        listOfMembers.put("1",Malthe);
        listOfMembers.put("2",Mark);

        */



        console.setBookmark("CLEAR");
        MainMenu.runMenu(textio, console);
        FileControl.writeObjectToFile(listOfMembers,"list");
        FileControl.readMemberListfromFile("list");
        textio.dispose();

    }
}