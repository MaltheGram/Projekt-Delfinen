/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;

import java.time.LocalDate;
import Member.Member;

public class FinanceReport {

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    void printPaymentsAllTime() {

    }

    void printOverduePayments() {
        var paymentLog = new PaymentLog().fetchListOfOverduePayments();
        // TODO: print overdue payments
    }

    void printMemberPayments(Member member) {

    }
}
