/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import DelfinMain.DelfinMain;
import Member.Member;
import Service.UserInput;

// ONLY CONNECT TO THIS CLASS TO INTERACT WITH FINANCE DEPT.
public class FinanceHandler {
    private final PaymentLog paymentLog;

    public FinanceHandler() {
        paymentLog = new PaymentLog();
        paymentLog.initialize();
    }

    // TODO: MAKE SURE YOU CANNOT PAY MORE THAN YOU'RE SUPPOSED TO! IF WE GOT TIME
    public void makePayment() {
        UserInput.clearConsole();
        Member member = UserInput.askForMember();
        Double amount = UserInput.askForPaymentAmount();

        paymentLog.writePaymentToLog(member, new Payment(member.getMemberId(), amount));
    }

    public void displayAnnualBudget() {
        var budget = new Budget();
        FinanceReport.printAnnualBudget(budget);

    }

    public void displayAllPayments() {
        UserInput.clearConsole();
        FinanceReport.printAllPayments(paymentLog.fetchAllPaymentsMap());
    }

    public void displayOverduePayments() {
        UserInput.clearConsole();
        var allMembers = DelfinMain.listOfMembers.getAllMembers();
        var overduePayments = paymentLog.fetchOverduePaymentAmounts(allMembers);
        FinanceReport.printOverduePayments(overduePayments);
    }
}
