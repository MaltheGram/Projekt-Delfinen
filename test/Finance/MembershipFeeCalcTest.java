package Finance;

import Member.Member;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MembershipFeeCalcTest {

    Member active_2 = new Member("Kes", LocalDate.parse("2019-10-15"), "Starship Enterprise deck 12", "12345678", true);
    Member active_20 = new Member("Geordi", LocalDate.parse("2001-10-15"), "Starship Enterprise deck 12", "12345678", true);
    Member active_100 = new Member("Guinan", LocalDate.parse("1921-10-15"), "Starship Enterprise deck 12", "12345678", true);
    Member inactive_20 = new Member("Guinan", LocalDate.parse("2001-10-15"), "Starship Enterprise deck 12", "12345678", false);

}