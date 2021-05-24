/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;

import java.time.LocalDate;
import java.util.List;

import Member.Member;

public class FinanceReport {

    void printAllPayments() {
        printList(new PaymentLog().fetchAllPayments());
    }

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    void printOverduePayments() {

    }

    void printMemberPayments(Member member) {

    }

    private void printList(List<Payment> payments) {
        for(var payment : payments) {
            System.out.println(payment.toString());
        }
    }
}
