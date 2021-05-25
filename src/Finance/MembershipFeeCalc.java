package Finance;
import Member.Member;

public class MembershipFeeCalc {
    private double passiveFee = 500;
    private double juniorFee = 1000;
    private double seniorFee = 1600;
    private double pensionistFee = seniorFee * 0.75;
    private final int juniorAge = 18;
    private final int pensionistAge = 60;

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

        if(!member.isActiveMember()) {
            return passiveFee;
        }
        if (isJunior(member)) {
            return juniorFee;
        }
        if (isSenior(member)) {
            return seniorFee;
        } else {
            return pensionistFee;
        }
    }

    public boolean isSenior(Member member) {
        return member.getAge() >= juniorAge && member.getAge() < pensionistAge;
    }

    public boolean isJunior(Member member) {
        return member.getAge() < juniorAge;
    }

    public boolean isPensionist(Member member) {
        return member.getAge() >= pensionistAge;
    }
}
