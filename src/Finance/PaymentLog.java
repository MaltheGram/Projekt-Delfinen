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
    private List<Payment> payments = new ArrayList<>();
    private final String myDocuments = System.getenv("USERPROFILE") + "\\Documents\\";
    private final String dataDirectory = "delfinen_finance";
    private final String filename = "member_payments.txt";
    private final String completeFilePath = Paths.get(myDocuments, dataDirectory, filename).toFile().toString();

    void initialize() {
        payments = fetchAllPayments();
    }

    public void writePaymentToLog(Payment payment) {
        payments.add(payment);
        System.out.println(payments);
        FileControl.writeSerializableToFile((ArrayList<Payment>) payments, completeFilePath);
    }

    boolean hasNoLoggedPayments(Member member) {
        for (var payment : payments) {
            if (payment.getMember().equals(member)) {
                return false;
            }
        }
        return true;
    }

    public Map<Member, Double> fetchOverdueAmounts(Collection<Member> allMembers) {
        var overduePayments = new HashMap<Member, Double>();

        for (var member : allMembers) {
            if (hasNoLoggedPayments(member)) {
                overduePayments.put(member,0.0);
            } else {
                if (feeNotFullyPaid(member)) {
                    overduePayments.put(member, calculateBalance(member));
                }
            }
        }
        return overduePayments;
    }

    private boolean feeNotFullyPaid(Member member) {
        return calculateBalance(member) < new MembershipFeeCalc().determinePrice(member);
    }

    private Double calculateBalance(Member member) {
        var total = 0.0;

        for (var payment : payments) {
            if (payment.getMember().equals(member)) {
                total += payment.getAmount();
            }
        }
        return total;
    }

    public List<Payment> fetchAllPayments() {
        return FileControl.readSerializableFromFile(completeFilePath, new ArrayList<>());
    }
}
