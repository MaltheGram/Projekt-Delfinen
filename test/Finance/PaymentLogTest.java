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
        log.writePaymentToLog(new Payment(member, 1000));

        member = new Member("Guinan", LocalDate.parse("2019-04-04"), "Enterprise deck 12", "12345678", true);
        log.writePaymentToLog(new Payment(member, 1600));


        // read same file, must contain these payments


    }
}