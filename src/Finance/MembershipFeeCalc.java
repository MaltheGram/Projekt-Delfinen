package Finance;
import Member.Member;

public class MembershipFeeCalc {
    private double passiveFee = 500;
    private double juniorFee = 1000;
    private double seniorFee = 1600;
    private double pensionerFee = seniorFee * 0.75; // 1200
    private final int juniorAge = 18;
    private final int pensionerAge = 60;

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
            return pensionerFee;
        }
    }

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

    public double getPensionerFee() {
        return pensionerFee;
    }

    public void setPensionerFee(double pensionerFee) {
        this.pensionerFee = pensionerFee;
    }

    public boolean isSenior(Member member) {
        return member.getAge() >= juniorAge && member.getAge() < pensionerAge;
    }

    public boolean isJunior(Member member) {
        return member.getAge() < juniorAge;
    }

    public boolean isPensioner(Member member) {
        return member.getAge() >= pensionerAge;
    }
}
