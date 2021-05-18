import Member.Member;
import Menu.MainMenu;
import Service.MemberIdGenerator;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        MemberIdGenerator memberIdGenerator = new MemberIdGenerator();
        MemberIdGenerator memberIdGenerator2 = new MemberIdGenerator();

        LocalDate MaltheDate = LocalDate.of(1998, 1, 30);
        LocalDate MarkDate = LocalDate.of(1996, 10, 30);
        FileHandler fileHandler = new FileHandler();

        Member Malthe = new Member("Malthe", MaltheDate, "Hoffmeyersvej 67", "61331776", true, memberIdGenerator);
        Member Mark = new Member("Mark", MarkDate, "Lygten 37", "8888888", true, memberIdGenerator2);

        HashMap<Integer,Member> hashMap = new HashMap<>();
        hashMap.put(1,Malthe);
        hashMap.put(2,Mark);

        fileHandler.writeFile(hashMap,"list");
        MainMenu.runMenu();




    }
        public static Boolean myMethod() {
            return true;
        }


}