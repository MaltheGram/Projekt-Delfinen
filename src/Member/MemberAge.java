package Member;

import java.time.LocalDate;
import java.time.Period;

public class MemberAge {
    private int age;

    public MemberAge(Member member) {
        this.age = calculateAge(member.getBirthDate());
    }

     int calculateAge(LocalDate birthday) {
        // try catch if age 0, over 120
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }

    public int getAge() {
        return age;
    }
}
