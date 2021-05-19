package Finance;

import Member.Member;
import java.util.HashMap;
import java.util.Map;

public class Budget {
    private Map<Integer, Member> members = new HashMap<>(); // must use actual MemberList

    private double calculateAnnualBudget() {
        var total = 0.0;

        for (var member : members.values()) {
            total += MembershipFeeCalc.determinePrice(member);
        }
        return total;
    }

    // TODO: calculate budget part that comes from each member type, add to toString method


    @Override
    public String toString() {
        return "Total annual income: " + calculateAnnualBudget();
    }
}
