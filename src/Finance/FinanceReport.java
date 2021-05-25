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

    static void printAllPayments(Map<Member, List<Payment>> map) {
        UserInput.console.println("ALL REGISTERED PAYMENTS:\n");
        for(var entry : map.entrySet()) {
            UserInput.console.println(printMemberPayments(entry.getKey(), entry.getValue()));
        }
    }

    private static String printMemberPayments(Member member, List<Payment> list) {
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

    void printPaymentsFromPeriod(LocalDate startDate) {

    }

    static void printOverduePayments(Map<Member, Balance> overduePayments) {
        for(var entry : overduePayments.entrySet()) {
            UserInput.console.println(entry.getKey().getName() + " overdue amount: " + entry.getValue().calculateOwed());
        }
    }

    void printMemberPayments(Member member) {

    }
}
