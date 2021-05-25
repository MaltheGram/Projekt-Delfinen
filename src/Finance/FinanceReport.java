/*
 * @author He "Holy Warrior" Engelund
 * tweaks by @author Malthe
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;

import java.time.LocalDate;
import java.util.*;

import Member.Member;
import Service.UserInput;

public class FinanceReport {

    static void printAllPayments(Collection<List<Payment>> payments) {
        for(var payment : payments) {
            UserInput.console.println(payment.toString());
        }
    }

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    static void printOverduePayments(Map<Member, Balance> overduePayments) {
        UserInput.console.println(overduePayments.toString());
    }

    void printMemberPayments(Member member) {

    }
}
