package Service;

import Competition.ResultType;
import DelfinMain.DelfinMain;
import Group.Discipline;
import Member.Member;
import org.beryx.textio.*;

import java.awt.Color;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Mark "Massive Legend" Larsen
 * spiced by @author Malthe Gram
 * modded @author Simon Gredal
 * 20/05/2021 10.41
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
public class UserInput {

    public static final TextIO textio = TextIoFactory.getTextIO();
    public static final TextTerminal<?> console = TextIoFactory.getTextTerminal();
    private static final String REGEXLETTERS = "(?i).*[a-z].";

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

    public static String askForName() {
        return textio.newStringInputReader()
                .withPattern(REGEXLETTERS)
                .read("Enter name");
    }

    public static String askForAddress() {
        return textio.newStringInputReader()
                .read("Enter address");
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
        return (str.equalsIgnoreCase("no") ||
                str.equalsIgnoreCase("x") ||
                str.equalsIgnoreCase("stop") ||
                str.isBlank() ||
                str.isEmpty()
        );
    }

    public static void clearConsole() {
        console.resetToBookmark("CLEAR");
    }

    public static void setupConsole() {
        console.getProperties().setPaneBackgroundColor(Color.WHITE);
        console.getProperties().setInputBackgroundColor(Color.WHITE);
        console.getProperties().setPromptBackgroundColor(Color.WHITE);

        console.getProperties().setPromptColor(Color.DARK_GRAY);
        console.getProperties().setInputColor(Color.BLACK);

        console.println(
                """
                                        ,-._
                                      _.-'  '--.
                                    .'      _  -`\\_
                                   / .----.`_.'----'
                                   ;/     `
                                  /_;
                """);
        console.getProperties().setPromptColor(Color.BLUE);
        console.println(
                """
                               ._      ._      ._      ._
                           _.-._)`\\_.-._)`\\_.-._)`\\_.-._)`\\_.-._
                """
        );
        console.getProperties().setPromptColor(Color.DARK_GRAY);
        console.setBookmark("CLEAR");
    }

    public static Double askForPaymentAmount() {
        return textio.newDoubleInputReader()
                .withMinVal(0.0)
                .read("Enter payment amount");

    }

    public static LocalDate askForDate() {
        Year resultYear = Year.of(textio.newIntInputReader()
                .withMinVal(LocalDate.now().getYear())
                .withMaxVal(LocalDate.now().getYear())
                .read("Enter result year")
        );

        YearMonth resultMonth = resultYear.atMonth(textio.newEnumInputReader(Month.class)
                .read("Enter result month")
        );

        return resultMonth.atDay(textio.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(resultMonth.lengthOfMonth() )
                .read("Enter date of the result")
        );

    }

    public static ResultType askForResultType() {
        return textio.newEnumInputReader(ResultType.class)
                .read("Enter result type");
    }

    public static Discipline askForDiscipline() {
        return textio.newEnumInputReader(Discipline.class)
                .read("Enter swimming discipline");
    }

    public static Duration askForResultTime() {
        Integer resultInMinutes = textio.newIntInputReader()
                .withMinVal(0)
                .read("Enter result");
        Long resultInSeconds = textio.newLongInputReader()
                .withMinVal(0L)
                .read("Result in seconds");


        return Duration.ofMinutes(resultInMinutes).plusSeconds(resultInSeconds);

    }
}
