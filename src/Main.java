import Member.Member;
import Service.MemberIdGenerator;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        MemberIdGenerator memberIdGenerator = new MemberIdGenerator();
        LocalDate localDate = LocalDate.of(1998,1,30);

        Member test = new Member("Malthe",localDate,"Hoffmeyersvej 67","61331776",true, memberIdGenerator);
        System.out.println(test);

    }



    public static Boolean myMethod() {
        return true;
    }
}
