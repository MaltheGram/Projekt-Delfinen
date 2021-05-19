package Finance;

import Member.Member;
import Member.MemberAge;

public class MembershipFeeCalc {
    private static final double passive = 500;
    private static final double junior = 1000;
    private static final double normal = 1600;
    private static final double pensionist = normal * 0.75;

    public static double determinePrice(Member member) {
        int age = new MemberAge(member).getAge();
        if(!member.isActiveMember()) {
            return passive;
        }
        if (age < 18) {
            return junior;
        }
        if (age >= 18 && age < 60) {
            return normal;
        } else {
            return pensionist;
        }
    }
}
