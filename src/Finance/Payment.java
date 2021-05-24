/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import Member.Member;
// TODO: dueDate according to PaymentPlan. Upon Member creation, add empty payments for each deadline
public class Payment implements Serializable {

    private Member member;
    private LocalDate dueDate = new DueDate().getFirstDeadline();
    private double amount;
    private LocalDate currentDate = LocalDate.now();

    Payment(Member member, double amount) {
        this.member = member;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getCurrentDate() {
        return this.currentDate;
    }

    public Member getMember() {
        return this.member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String toString() {
        return "Member: " + member +  ", " + getDueDate() + ", " + getCurrentDate() + ", " + getAmount(); // add amount to pay = membership fee
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Objects.equals(member, payment.member) && Objects.equals(dueDate, payment.dueDate) && Objects.equals(currentDate, payment.currentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, dueDate, amount, currentDate);
    }
}
