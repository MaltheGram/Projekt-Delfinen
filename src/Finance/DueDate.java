package Finance;

import java.time.LocalDate;

public class DueDate {
    private final LocalDate currentYear = LocalDate.parse(LocalDate.now().getYear() + "-01-01");
    private LocalDate firstDeadline = currentYear.plusMonths(2);
    private LocalDate secondDeadline = currentYear.plusMonths(4);
    private LocalDate thirdDeadline = currentYear.plusMonths(6);
    private LocalDate fourthDeadline = currentYear.plusMonths(8);

    public LocalDate getFirstDeadline() {
        return firstDeadline;
    }

    public void setFirstDeadline(LocalDate firstDeadline) {
        this.firstDeadline = firstDeadline;
    }

    public LocalDate getSecondDeadline() {
        return secondDeadline;
    }

    public void setSecondDeadline(LocalDate secondDeadline) {
        this.secondDeadline = secondDeadline;
    }

    public LocalDate getThirdDeadline() {
        return thirdDeadline;
    }

    public void setThirdDeadline(LocalDate thirdDeadline) {
        this.thirdDeadline = thirdDeadline;
    }

    public LocalDate getFourthDeadline() {
        return fourthDeadline;
    }

    public void setFourthDeadline(LocalDate fourthDeadline) {
        this.fourthDeadline = fourthDeadline;
    }


}
