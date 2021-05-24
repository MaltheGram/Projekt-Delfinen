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
    // TODO: MAKE SURE YOU CANNOT PAY MORE THAN YOU'RE SUPPOSED TO! IF WE GOT TIME
    public static void makePayment() {
        Member member = UserInput.askForMember();
        Double amount = UserInput.askForPaymentAmount();

        new PaymentLog().writePaymentToLog(new Payment(member, amount));
    }

    public static void displayAnnualBudget() {
        UserInput.console.println(new Budget().toString());
    }

    public static void displayAllPayments() {
        new PaymentLog().displayAllPayments();
    }

    public static void displayOverduePayments() {
        new FinanceReport().printOverduePayments();
    }
}
