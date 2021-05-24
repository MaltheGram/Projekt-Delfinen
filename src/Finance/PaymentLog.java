/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import Member.Member;
import Service.FileControl;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PaymentLog {
    private List<Payment> payments = new ArrayList<>();
    private final String myDocuments = System.getenv("USERPROFILE") + "\\Documents\\";
    private final String dataDirectory = "delfinen_finance";
    private final String filename = "member_payments.txt";

    public void writePaymentToLog(Payment payment) {
        var paymentLog = Paths.get(myDocuments, dataDirectory, filename).toFile().toString();
        FileControl.writeSerializableToFile(payment, paymentLog);
        payments.add(payment);
    }

    public List<Payment> displayAllPayments() {
        // TODO: read overdue from file, return as list
        return new ArrayList<>();

    }

    boolean memberHasLoggedPayments(Member member) {

        return false;
    }

    public List<Payment> fetchListOfOverduePayments() {
        var overduePayments = new ArrayList<Payment>();
        // TODO: send list of overdue payments to FinanceReport
        return overduePayments;
    }
}
