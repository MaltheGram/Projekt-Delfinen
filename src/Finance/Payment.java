package Finance;

import java.time.LocalDate;
import Member.Member;

public class Payment {

    private Member member;
    private double amount;
    private LocalDate currentDate = LocalDate.now();

    Payment(Member member, double amount) {
        this.member = member;
        this.amount = amount;
    }

    public Member getMember() {
        return this.member;
    }

    public LocalDate getCurrentDate() {
        return this.currentDate;
    }

    public double getAmount() {
        return this.amount;
    }

 /*   @Override
    public String toString() {
        return member.getMemberId() + ", " + member.getName() + "," + getAmount() + ", " + currentDate;
    }*/
}
