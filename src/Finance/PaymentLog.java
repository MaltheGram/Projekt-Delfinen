/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import DelfinMain.DelfinMain;
import Member.Member;
import Service.FileControl;
import java.nio.file.Paths;
import java.util.ArrayList;
import Member.MemberList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentLog {
    private List<Payment> payments = new ArrayList<>();
    private final String myDocuments = System.getenv("USERPROFILE") + "\\Documents\\";
    private final String dataDirectory = "delfinen_finance";
    private final String filename = "member_payments.txt";
    private final String completeFilePath = Paths.get(myDocuments, dataDirectory, filename).toFile().toString();

    public void writePaymentToLog(Payment payment) {
        payments.add(payment);
        System.out.println(payments);
        FileControl.writeSerializableToFile((ArrayList<Payment>) payments, completeFilePath);

    }

    boolean hasNoLoggedPayments(Member member) {

        return false;
    }

    public Map<Member, Double> fetchOverdueAmounts() {
        var allMembers = DelfinMain.listOfMembers.getAllMembers();
        var overduePayments = new HashMap<Member, Double>();

        for (var member : allMembers) {
            if (hasNoLoggedPayments(member)) {
                overduePayments.put(member, 0.0);
            } else {
                overduePayments.put(member, calculateBalance(member));
            }

        }
        return overduePayments;
    }

    private Double calculateBalance(Member member) {
        // TODO: find payments for this member, add together, return result

        return 0.0;
    }

    public List<Payment> fetchAllPayments() {
        // TODO: try catch file not found, is empty
        var allPayments = FileControl.readSerializableFromFile(completeFilePath, new ArrayList<Payment>());

        return allPayments;
    }
}
