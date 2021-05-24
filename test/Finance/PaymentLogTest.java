package Finance;
import Member.Member;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PaymentLogTest {

    @Test
    void writePaymentToLogTest() {
        Member member = new Member("kes", LocalDate.parse("2019-04-04"), "Enterprise deck 12", "12345678", true);
        var log = new PaymentLog();
        var payment = new Payment(member, 1000);
        log.writePaymentToLog(payment);

        Member member2 = new Member("Guinan", LocalDate.parse("2019-04-04"), "Enterprise deck 12", "12345678", true);
        var payment2 = new Payment(member2, 1600);
        log.writePaymentToLog(payment2);

        var actual = log.fetchAllPayments();

        assertTrue(actual.contains(payment));
        assertTrue(actual.contains(payment2));
    }

}