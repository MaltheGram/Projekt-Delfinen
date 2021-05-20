package Service;

import org.beryx.textio.*;
import java.time.*;

/*
 * @author Mark "Massive Legend" Larsen
 * spiced up @author Malthe
 * 20/05/2021 10.41
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
public class UserInput {

    public static final TextIO textio = TextIoFactory.getTextIO();
    public static final TextTerminal<?> console = TextIoFactory.getTextTerminal();

    public static LocalDate askForBirthdate() {
        Year birthYear = Year.of( textio.newIntInputReader()
                .withMinVal(LocalDate.now().getYear() - 150)
                .withMaxVal(LocalDate.now().getYear())
                .read("Enter birth year")
        );

        YearMonth birthMonth = birthYear.atMonth( textio.newEnumInputReader(Month.class)
                .read("Enter birth month")
        );

        return birthMonth.atDay( textio.newIntInputReader()
                .withMinVal(1)
                .withMaxVal( birthMonth.lengthOfMonth() )
                .read("Enter birth day")
        );
    }

    public static Boolean askForActiveMembership() {
        return textio.newBooleanInputReader()
                .read("Active membership?");
    }

    public static String askForPhoneNumber() {
        return textio.newStringInputReader()
                .withValueChecker(new DanishPhoneNumberValueChecker<String>())
                .withPattern("\\d{8}")
                .read("Enter phone number");
    }

    public static Boolean isYes(String str) {
        return (str.equalsIgnoreCase("yes") ||
                str.equalsIgnoreCase("ye") ||
                str.equalsIgnoreCase("y") ||
                str.equalsIgnoreCase("ja") ||
                str.equalsIgnoreCase("ok") ||
                str.equalsIgnoreCase("jep")
        );
    }

    public static Boolean isNo(String str) {
        return ( str.toLowerCase().contains("No") ||
                str.toLowerCase().contains("x") ||
                str.toLowerCase().contains("stop") ||
                str.isBlank() ||
                str.isEmpty()
        );
    }

    // TODO: Implement askForName
    public static String askForName() {
        return "UserInput.askForName() not implemented";
    }

    // TODO: Implement askForAddress
    public static String askForAddress() {
        return "UserInput.askForAddress() not implemented";
    }
}
