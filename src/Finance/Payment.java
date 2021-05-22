/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import java.io.Serializable;
import java.time.LocalDate;
import Member.Member;
// TODO: dueDate according to PaymentPlan. Upon Member creation, add empty payments for each deadline
public class Payment implements Serializable {

    private transient Member member;
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
}
