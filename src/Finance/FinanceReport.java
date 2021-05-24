/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import Member.Member;

public class FinanceReport {

    static void printAllPayments(List<Payment> payments) {
        for(var payment : payments) {
            System.out.println(payment.toString());
        }
    }

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    static void printOverduePayments(Map<Member, Double> overduePayments) {
        System.out.println(overduePayments);
    }

    void printMemberPayments(Member member) {

    }
}
