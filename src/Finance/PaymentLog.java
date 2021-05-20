package Finance;
import Member.Member;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PaymentLog {
    private final String myDocuments = System.getenv("USERPROFILE") + "\\Documents\\";
    private final String dataDirectory = "delfinen-finans";
    private final String filename = "kontingenter.txt";

    // use when new member is added, start value is zero
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
        var template = "ID%s;NAME%s;AMOUNT%.2f;DATE%s\n";
        var filled = String.format(template, p.getMember().getMemberId(), p.getMember().getName(), p.getAmount(), p.getCurrentDate());

        return filled;
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
