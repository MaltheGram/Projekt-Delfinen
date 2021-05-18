package Membership;

import java.time.LocalDate;

public class MembershipFee {
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private Boolean isPaid;

    public MembershipFee(LocalDate startDate, LocalDate endDate, Double price) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.isPaid = false;
    }

    public Boolean isOverdue() {
        return ( this.startDate.compareTo(LocalDate.now()) <= 0 &&  // currentDate is after or on startDate
                 !this.isPaid );                                // and fee is not paid
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
}
