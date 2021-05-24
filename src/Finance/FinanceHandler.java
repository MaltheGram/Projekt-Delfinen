/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import Member.Member;
import Service.UserInput;

// ONLY CONNECT TO THIS CLASS TO INTERACT WITH FINANCE DEPT.
public class FinanceHandler {

    public void makePayment(Member member, double amount) {
        new PaymentLog().writePaymentToLog(new Payment(member, amount));
    }

    public void displayAnnualBudget() {
        UserInput.console.println(new Budget().toString());
    }

    public void viewOverduePayments() {
        new FinanceReport().viewOverduePayments();
    }
}
