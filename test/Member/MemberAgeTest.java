package Member;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class MemberAgeTest {

    @Test
    public void acceptableAgeTest() {
        LocalDate tenYrsPrior = LocalDate.of(2011, 5, 19);
        Member member = new Member(null, tenYrsPrior, null, null, true);
        assertEquals(10, member.getAge());
    }

    @Test
    public void ageIsZero() {

    }

    @Test
    public void ageIsTooHigh() {
        // age is over 120
    }

    @Test
   public void ageIsNegative() {

    }

        // bd is after today's date

}