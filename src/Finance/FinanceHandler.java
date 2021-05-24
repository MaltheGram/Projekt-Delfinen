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
        Member member = UserInput.askForMember();
        Double amount = UserInput.askForPaymentAmount();

        paymentLog.writePaymentToLog(new Payment(member, amount));
    }

    public void displayAnnualBudget() {
        // do not print here, do it in FinanceReport instead.

    }

    public void displayAllPayments() {
        FinanceReport.printAllPayments(paymentLog.fetchAllPayments());
    }

    public void displayOverduePayments() {
        var allMembers = DelfinMain.listOfMembers.getAllMembers();
        var overduePayments = paymentLog.fetchOverdueAmounts(allMembers);
        FinanceReport.printOverduePayments(overduePayments);
    }
}
