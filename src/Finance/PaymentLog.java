/*
 * @author He "Holy Warrior" Engelund
 * 20/05/2021 18:53
 *
 * DAT21V2-Projekt-Delfinen
 */
package Finance;
import Member.Member;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PaymentLog {
    private final String myDocuments = System.getenv("USERPROFILE") + "\\Documents\\";
    private final String dataDirectory = "delfinen_finance";
    private final String filename = "member_payments.txt";

    public void addNewPayable(Member member) {
        Payment open = new Payment(member, 0.0);
        saveTransaction(open);
    }

    public void makePayment(Payment payment) {
        saveTransaction(payment);
    }

    private void saveTransaction(Payment payment) {
        writePaymentToLog(payment);
    }

    private void writePaymentToLog(Payment payment) {
        File paymentLog = Paths.get(myDocuments, dataDirectory, filename).toFile();
        fileExistsCheck(paymentLog);

        try {
            var stringToAppend = formatLine(payment);
            Files.write(paymentLog.toPath(), stringToAppend.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatLine(Payment p) {
        var template = "ID%s;NAME%s;AMOUNT%.2f;DUE_DATE%s;DATE_OF_PAYMENT%s\n";
        var formatted = String.format(template, p.getMember().getMemberId(), p.getMember().getName(), p.getAmount(), p.getDueDate(), p.getCurrentDate());

        return formatted;
    }

    private void fileExistsCheck(File file) {
        try {
            if(!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
