package Finance;

import Member.Member;
import Member.MemberList;
import java.util.Collection;

public class Budget {
    private Collection<Member> members = new MemberList().getAllMembers(); // must use actual MemberList

    private double calculateAnnualBudget() {
        var total = 0.0;

        for (var member : members) {
            total += new MembershipFeeCalc().determinePrice(member);
        }
        return total;
    }

    // TODO: calculate budget part that comes from each member type, add to toString method


    @Override
    public String toString() {
        return "Total annual income: " + calculateAnnualBudget();
    }
}
