package Finance;

public enum PaymentPlan {
    // feature to be added later: possibility to make partial payments during the year
    ANNUAL("annual", 1.0),
    BIANNUAL("bi-annual", 0.5),
    QUARTERLY("quarterly", 0.25);

    private final String name;
    private final Double multiplier;

    PaymentPlan(String name, Double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public Double getMultiplier() {
        return multiplier;
    }

}
