package Finance;
import Member.Member;

// ONLY CONNECT TO THIS CLASS TO INTERACT WITH FINANCE DEPT.
public class FinanceHandler {

    public static void addNewPayable(Member member) {
        new PaymentLog().addNewPayable(member);
    }

    public static void viewAnnualBudget() {
        System.out.println(new Budget().toString());
    }

    public static void makePayment(Payment payment) {
        new PaymentLog().makePayment(payment);
    }

    public static void viewOverduePayments() {
        new FinanceReport().viewOverduePayments();
    }
}
