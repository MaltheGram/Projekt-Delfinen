/*
 * @author He "Holy Warrior" Engelund
 * 25/05/2021 22:13
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import Member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PaymentLogTest {
    PaymentLog CUT;
    Member member1;
    Member member2;
    Payment payment1;
    Payment payment2;

    @BeforeEach
    void setup() {
        CUT = new PaymentLog();
        member1 = new Member("kes", LocalDate.parse("2019-04-04"), "Enterprise deck 12", "12345678", true);
        payment1 = new Payment(member1.getMemberId(), 900);
        member2 = new Member("Guinan", LocalDate.parse("2019-04-04"), "Enterprise deck 12", "12345678", true);
        payment2 = new Payment(member2.getMemberId(), 1600);
    }

    @Test
    void writePaymentToLogTest() {

        CUT.writePaymentToLog(member1, payment1);
        CUT.writePaymentToLog(member2, payment2);

        var actual = CUT.fetchAllPaymentsMap();

        assertTrue(actual.containsKey(member1));
        assertTrue(actual.containsKey(member2));

        var paymentList1 = actual.get(member1);
        assertTrue(paymentList1.contains(payment1));

        var paymentList2 = actual.get(member2);
        assertTrue(paymentList2.contains(payment2));

        assertFalse(paymentList1.contains(payment2));
    }

    @Test
    void writePaymentToLogTest_secondPayment() {
        var payment3 = new Payment(member1.getMemberId(), 700);
        CUT.writePaymentToLog(member1, payment1);
        CUT.writePaymentToLog(member1, payment3);
        var actual = CUT.fetchAllPaymentsMap();
        assertTrue(actual.containsKey(member1));
        var paymentList3 = actual.get(member1);
        assertTrue(paymentList3.contains(payment1));
        assertTrue(paymentList3.contains(payment3));
    }

    @Test
    void fetchOverduePaymentAmounts() {
        CUT.writePaymentToLog(member1, payment1);
        CUT.writePaymentToLog(member2, payment2);
        var member3 = new Member("Picard", LocalDate.parse("2020-04-04"), "Enterprise deck 12", "12345678", true);
        var actual = CUT.fetchOverduePaymentAmounts(Arrays.asList(member1, member2, member3));
        assertTrue(actual.containsKey(member1));
        assertTrue(actual.containsKey(member2));
        assertTrue((actual.containsKey(member3)));
        assertEquals(0.0, actual.get(member3).getPaid());
        assertEquals(payment1.getAmount(), actual.get(member1).getPaid());
    }
}