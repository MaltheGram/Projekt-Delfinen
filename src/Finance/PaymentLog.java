/*
 * @author He "Holy Warrior" Engelund
 * 24/05/2021 21:04
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import Member.Member;
import Service.FileControl;
import java.nio.file.Paths;
import java.util.*;


public class PaymentLog {
    private Map<Member, List<Payment>> paymentsMap = new HashMap<>();
    private final MembershipFeeCalc feeCalc = new MembershipFeeCalc();
    private final String fileName = "member_payments";
    private final String filePath = Paths.get(fileName).toFile().toString();

    void initialize() {
        paymentsMap = fetchAllPaymentsMap();
    }

    public void writePaymentToLog(Member member, Payment payment) {
        if (paymentsMap.containsKey(member)) {
            paymentsMap.get(member).add(payment);
        } else {
            var list = new ArrayList<Payment>();
            list.add(payment);
            paymentsMap.put(member, list);
        }
        FileControl.writeSerializableToFile((HashMap<Member, List<Payment>>) paymentsMap, filePath);
    }

    public Map<Member, Balance> fetchOverduePaymentAmounts(Collection<Member> members) {
        var totals = new HashMap<Member, Balance>();
        for (var member : members) {
            if (!paymentsMap.containsKey(member)) {
                totals.put(member, new Balance(feeCalc.determinePrice(member), 0.0));
            } else {
                var fee = feeCalc.determinePrice(member);
                var paid = calculatePaid(paymentsMap.get(member));
                totals.put(member, new Balance(fee, paid));
            }
        }
        return totals;
    }

    private Double calculatePaid(List<Payment> payments) {
        var total = 0.0;
        for (var payment : payments) {
            total += payment.getAmount();
        }
        return total;
    }

    public Map<Member, List<Payment>> fetchAllPaymentsMap() {
        return FileControl.readSerializableFromFile(filePath, new HashMap<>());
    }
}
