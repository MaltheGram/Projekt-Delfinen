/*
 * @author He "Holy Warrior" Engelund
 * 25/05/2021 22:16
 *
 * DAT21V2-Projekt-Delfinen
 */

package Finance;
import Member.Member;
import Member.MemberList;

import java.util.Collection;


public class Budget {
    private MembershipFeeCalc calc = new MembershipFeeCalc();
    private Collection<Member> members = new MemberList("memberlist").getAllMembers();
    private int nrPassive;
    private int nrJuniors;
    private int nrSeniors;
    private int nrPensionists;

    public Budget() {
        initialize();
    }

    private void initialize() {
        for (var member : members) {
            if(!member.isActiveMember()) {
                nrPassive ++;
            } else {
                if(calc.isJunior(member)) {
                    nrJuniors ++;
                }
                if(calc.isSenior(member)) {
                    nrSeniors ++;
                }
                if(calc.isPensioner(member)) {
                    nrPensionists ++;
                }
            }
        }
    }

    Double calculateAnnualBudget() {

        var total = 0.0;

        for (var member : members) {
            total += calc.determinePrice(member);
        }
        return total;
    }

    public Double calculatePassiveTotal() {
        return nrPassive * calc.getPassiveFee();
    }

    public Double calculateJuniorTotal() {
        return nrJuniors * calc.getJuniorFee();
    }

    public Double calculateSeniorTotal() {
        return nrSeniors * calc.getSeniorFee();
    }

    public Double calculatePensionistTotal() {
        return nrPensionists * calc.getPensionerFee();
    }
    // TODO: calculate budget part that comes from each member type, add to toString method

}
