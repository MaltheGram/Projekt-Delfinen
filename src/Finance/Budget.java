/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import Member.Member;
import Member.MemberList;
import Service.UserInput;

import java.util.Collection;


public class Budget {
    private Collection<Member> members = new MemberList("memberlist").getAllMembers();

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
