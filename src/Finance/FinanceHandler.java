package Finance;
import Member.Member;

// ONLY CONNECT TO THIS CLASS TO INTERACT WITH FINANCE DEPT.
public class FinanceHandler {

    public void addNewPayable(Member member) {
        new PaymentLog().addNewPayable(member);
    }

    public void displayAnnualBudget() {
        System.out.println(new Budget().toString());
    }

    public void makePayment(Payment payment) {
        new PaymentLog().makePayment(payment);
    }

    public void viewOverduePayments() {
        new FinanceReport().viewOverduePayments();
    }
}
