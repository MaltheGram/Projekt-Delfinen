package Membership;

import java.util.ArrayList;
import java.util.List;


public class Membership {
    private final List<MembershipFee> membershipFees;

    public Membership() {
         this.membershipFees = new ArrayList<>();
    }

    public Boolean isOverdue() {
        return membershipFees.stream().anyMatch( membershipFee -> membershipFee.isOverdue() );
    }


}
