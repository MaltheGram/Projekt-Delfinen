package Finance;

import Member.Member;

public class MembershipFeeCalc {
    // TODO: read prices from a settings-file
    private static final double passive = 500;
    private static final double junior = 1000;
    private static final double normal = 1600;
    private static final double pensionist = normal * 0.75; // (1200)

    public static double determinePrice(Member member) {
        if(!member.isActiveMember()) {
            return passive;
        }
        if (member.getAge() < 18) {
            return junior;
        }
        if (member.getAge() >= 18 && member.getAge() < 60) {
            return normal;
        } else {
            return pensionist;
        }
    }
}
