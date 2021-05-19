package Finance;

import java.time.LocalDate;

public class Payment {

    private String memberId;
    private double amount;
    private LocalDate currentDate = LocalDate.now();

    public void Payment(String memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }
}
