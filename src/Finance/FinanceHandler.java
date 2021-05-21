/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import Member.Member;

// ONLY CONNECT TO THIS CLASS TO INTERACT WITH FINANCE DEPT.
public class FinanceHandler {

    // use when new member is added, start value is zero
    public void addNewPayable(Member member) {
        new PaymentLog().addNewPayable(member);
    }

    public void makePayment(Member member, double amount) {
        var payment = new Payment(member, amount);
        new PaymentLog().makePayment(payment);
    }

    public void displayAnnualBudget() {
        System.out.println(new Budget().toString());
    }

    public void viewOverduePayments() {
        new FinanceReport().viewOverduePayments();
    }
}
