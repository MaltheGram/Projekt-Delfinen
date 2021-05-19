package Finance;

public enum PaymentPlan {

    ANNUAL(1),
    BIANNUAL(0.5),
    QUARTERLY(0.25);

    private final double multiplier;

    PaymentPlan(double multiplier) {
        this.multiplier = multiplier;
    }
}
