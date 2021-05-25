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
// TODO: Remove member from payment, use payment hashmap's key value (Member)
public class Payment implements Serializable {

    private String memberID;
    private LocalDate dueDate = new DueDate().getFirstDeadline();
    private double amount;
    private LocalDate currentDate = LocalDate.now();

    Payment(String memberID, double amount) {
        this.memberID = memberID;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getCurrentDate() {
        return this.currentDate;
    }

    public String getMemberID() {
        return this.memberID;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "MemberID: " + getMemberID() +  ", " + getDueDate() + ", " + getCurrentDate() + ", " + getAmount(); // add amount to pay = membership fee
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Objects.equals(memberID, payment.memberID) && Objects.equals(dueDate, payment.dueDate) && Objects.equals(currentDate, payment.currentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, dueDate, amount, currentDate);
    }
}
