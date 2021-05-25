package Finance;

public class Balance {
    private final Double fee;
    private final Double paid;

    public Balance(Double owedAmount, Double paidAmount) {
        this.fee = owedAmount;
        this.paid = paidAmount;
    }

    public Double getFee() {
        return fee;
    }

    public Double getPaid() {
        return paid;
    }

    public Double calculateOwed() {
        return fee - paid;
    }
}
