/*
 * @author He "Holy Warrior" Engelund
 * 25/05/2021 22:16
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Payment implements Serializable {

    private String memberID;
    private LocalDate dueDate = new DueDate().getFirstDeadline();
    private double amount;
    private final LocalDate paidDate = LocalDate.now();

    Payment(String memberID, double amount) {
        this.memberID = memberID;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getPaidDate() {
        return this.paidDate;
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



    @Override
    public String toString() {
        return "Payment{" +
                "memberID='" + memberID + '\'' +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", currentDate=" + paidDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Objects.equals(memberID, payment.memberID) && Objects.equals(dueDate, payment.dueDate) && Objects.equals(paidDate, payment.paidDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, dueDate, amount, paidDate);
    }
}
