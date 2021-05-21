package Service;

import DelfinMain.DelfinMain;
import Member.Member;
import org.beryx.textio.*;

import java.awt.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Mark "Massive Legend" Larsen
 * spiced up @author Malthe Gram
 * modded @author Simon Gredal
 * 20/05/2021 10.41
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
public class UserInput {

    public static final TextIO textio = TextIoFactory.getTextIO();
    public static final TextTerminal<?> console = TextIoFactory.getTextTerminal();

    private static <T> List<Integer> getListIndices(List<T> list) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i<list.size(); i++) {
            indices.add(i);
        }
        return indices;
    }

    public static Integer askForMenuChoice(String menuText, List<String> menuOptions) {
        return textio.newIntInputReader()
                .withNumberedPossibleValues( getListIndices(menuOptions) )
                .withValueFormatter(menuOptions::get)
                .read(menuText);
    }

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
                .withMinLength(8)
                .withMaxLength(8)
                .read("Enter phone number");
    }

    public static Member askForMember() {
        String memberId = textio.newStringInputReader()
                .read("Enter member ID");

        Member member = DelfinMain.listOfMembers.getMemberByID(memberId);
        while (member == null){
            System.out.println("Invalid member ID, please try again");
            memberId = textio.newStringInputReader()
                    .read("Enter member ID");
            member = DelfinMain.listOfMembers.getMemberByID(memberId);
        }

        return member;
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

        return textio.newStringInputReader()
                .read("Enter name");
    }

    // TODO: Implement askForAddress
    public static String askForAddress() {
        return textio.newStringInputReader()
                .read("Enter address");
    }

    public static void clearConsole() {
        console.resetToBookmark("CLEAR");
    }

    public static void setupConsole() {
        UserInput.console.getProperties().setPaneBackgroundColor(Color.WHITE);
        UserInput.console.getProperties().setInputBackgroundColor(Color.WHITE);
        UserInput.console.getProperties().setPromptBackgroundColor(Color.WHITE);

        UserInput.console.getProperties().setPromptColor(Color.DARK_GRAY);
        UserInput.console.getProperties().setInputColor(Color.BLACK);

        UserInput.console.println(
                """
                                        ,-._
                                      _.-'  '--.
                                    .'      _  -`\\_
                                   / .----.`_.'----'
                                   ;/     `
                                  /_;
                """);
        UserInput.console.getProperties().setPromptColor(Color.BLUE);
        UserInput.console.println(
                """
                               ._      ._      ._      ._
                           _.-._)`\\_.-._)`\\_.-._)`\\_.-._)`\\_.-._
                """
        );
        UserInput.console.getProperties().setPromptColor(Color.DARK_GRAY);
        UserInput.console.setBookmark("CLEAR");
    }
}
