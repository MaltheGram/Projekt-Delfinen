/*
 * @author He "Holy Warrior" Engelund
 * 25/05/2021 22:16
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;

import java.time.LocalDate;
import java.util.*;

import Member.Member;
import Service.UserInput;

public class FinanceReport {

    static void printAllPayments(Map<Member, List<Payment>> map) {
        UserInput.console.println("ALL REGISTERED PAYMENTS:\n");
        for(var entry : map.entrySet()) {
            UserInput.console.println(printMemberPayments(entry.getKey(), entry.getValue()));
        }
    }

    public static String printMemberPayments(Member member, List<Payment> list) {
        var report = "Payments of "+ member.getName() + "\n";
        for (var payment : list) {
            report += formatPayment(payment) + "\n";
        }
        return report;
    }


    private static String formatPayment(Payment payment) {
        return String.format("amount:%.2f payment date:%s ", payment.getAmount(), payment.getPaidDate());
    }

    public static void printAnnualBudget(Budget budget) {
        var newline = "\n";
        var builder = new StringBuilder();

        builder.append("EXPECTED ANNUAL INCOME").append(newline);
        builder.append("Total of passive members: ").append(budget.calculatePassiveTotal()).append(newline);
        builder.append("Total of junior members: ").append(budget.calculateJuniorTotal()).append(newline);
        builder.append("Total of senior members: ").append(budget.calculateSeniorTotal()).append(newline);
        builder.append("Total of pensionist members: ").append(budget.calculatePensionistTotal()).append(newline);
        builder.append("Total of all members: ").append(budget.calculateAnnualBudget());
        UserInput.console.println(builder.toString());
    }

    public static void printNoPaymentsFound() {
        UserInput.console.println("No payments have been registered.\n");
    }

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    static void printOverduePayments(Map<Member, Balance> map) {
        for(var entry : map.entrySet()) {
            var owed = entry.getValue().calculateOwed();

            if (owed < 0) {
            } else {
                UserInput.console.println(entry.getKey().getName() + " overdue amount: " + owed);
            }
        }
    }

    void printMemberPayments(Member member) {

    }
}
