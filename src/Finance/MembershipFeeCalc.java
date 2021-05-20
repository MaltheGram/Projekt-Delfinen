package Finance;
import Member.Member;

public class MembershipFeeCalc {
    private double passiveFee = 500;
    private double juniorFee = 1000;
    private double seniorFee = 1600;
    private double pensionistFee = seniorFee * 0.75;

    public double getPassiveFee() {
        return passiveFee;
    }

    public void setPassiveFee(double passiveFee) {
        this.passiveFee = passiveFee;
    }

    public double getJuniorFee() {
        return juniorFee;
    }

    public void setJuniorFee(double juniorFee) {
        this.juniorFee = juniorFee;
    }

    public double getSeniorFee() {
        return seniorFee;
    }

    public void setSeniorFee(double seniorFee) {
        this.seniorFee = seniorFee;
    }

    public double getPensionistFee() {
        return pensionistFee;
    }

    public void setPensionistFee(double pensionistFee) {
        this.pensionistFee = pensionistFee;
    }

    public double determinePrice(Member member) {
        int age = member.getAge();
        if(!member.isActiveMember()) {
            return passiveFee;
        }
        if (age < 18) {
            return juniorFee;
        }
        if (age >= 18 && age < 60) {
            return seniorFee;
        } else {
            return pensionistFee;
        }
    }
}
