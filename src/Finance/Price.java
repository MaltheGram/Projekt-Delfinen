package Finance;

public class Price {

    private int age;
    private boolean isActive;
    private final double basic = 500;
    private final double junior = 1000;
    private final double normal = 1600;
    private final double senior = normal * 0.75;

    Price(int age, boolean isActive) {
        this.age = age;
        this.isActive = isActive;
    }

    public double getPrice(int age, boolean isActive) {
        if(!isActive) {
            return basic;
        }
        if (age < 18) {
            return junior;
        }
        if (age >= 18 && age < 60) {
            return normal;
        } else {
            return senior;
        }
    }
}
