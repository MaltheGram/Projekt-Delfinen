package Service;

import Competition.ResultType;
import Competition.Team;
import DelfinMain.DelfinMain;
import Group.Discipline;
import Member.Member;
import org.beryx.textio.*;
import org.beryx.textio.swing.SwingTextTerminal;
import org.beryx.textio.swing.SwingTextTerminalProvider;

import java.awt.Color;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static final TextIO textio = new TextIO(new SwingTextTerminalProvider().getTextTerminal());
    public static final TextTerminal<?> console = textio.getTextTerminal();
    private static final String REGEXLETTERS = "(?i).*[a-z].";

    private static <T> List<Integer> getListIndices(List<T> list) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            indices.add(i);
        }
        return indices;
    }

    public static Integer askForMenuChoice(String menuText, List<String> menuOptions) {
        return textio.newIntInputReader()
                .withNumberedPossibleValues(getListIndices(menuOptions))
                .withValueFormatter(menuOptions::get)
                .read(menuText);
    }

    public static LocalDate askForBirthdate() {
        Year birthYear = Year.of(textio.newIntInputReader()
                .withMinVal(LocalDate.now().getYear() - 150)
                .withMaxVal(LocalDate.now().getYear())
                .read("Enter birth year")
        );
        YearMonth birthMonth = birthYear.atMonth(textio.newEnumInputReader(Month.class)
                .read("Enter birth month")
        );

        return birthMonth.atDay(textio.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(birthMonth.lengthOfMonth())
                .read("Enter birth day")
        );
    }

    public static Boolean askForActiveMembership() {
        return textio.newBooleanInputReader()
                .read("Active membership?");
    }

    public static Boolean askForCompetitiveStatus() {
        return textio.newBooleanInputReader().read("Competitive swimmer?");
    }

    public static String askForPhoneNumber() {
        return textio.newStringInputReader()
                .withMinLength(8)
                .withMaxLength(8)
                .read("Enter phone number");
    }

    public static Member askForMember() {
        UserInput.console.println("Select a member" + "\n" + "-");
        List<Member> members = DelfinMain.listOfMembers.getAllMembers().stream().toList();
        Integer index = textio.newIntInputReader()
                .withNumberedPossibleValues(getListIndices(members))
                .withValueFormatter(i -> members.get(i).getName())
                .read("List of members");
        return members.get(index);
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

    public static void lightMode() {
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

    public static void darkMode() {
        console.getProperties().setPaneBackgroundColor(Color.BLACK);
        console.getProperties().setInputBackgroundColor(Color.BLACK);
        console.getProperties().setPromptBackgroundColor(Color.BLACK);

        console.getProperties().setPromptColor(Color.WHITE);
        console.getProperties().setInputColor(Color.WHITE);

        console.println(
                """
                                                ,-._
                                              _.-'  '--.
                                            .'      _  -`\\_
                                           / .----.`_.'----'
                                           ;/     `
                                          /_;
                        """);
        console.getProperties().setPromptColor(Color.WHITE);
        console.println(
                """
                                       ._      ._      ._      ._
                                   _.-._)`\\_.-._)`\\_.-._)`\\_.-._)`\\_.-._
                        """
        );
        console.getProperties().setPromptColor(Color.WHITE);
        console.setBookmark("CLEAR");
    }

    public static void setupConsole() {
        console.setBookmark("START");
        console.getProperties().setPaneBackgroundColor(Color.BLACK);
        console.getProperties().setInputBackgroundColor(Color.BLACK);
        console.getProperties().setPromptBackgroundColor(Color.BLACK);

        console.getProperties().setPromptColor(Color.WHITE);
        console.getProperties().setInputColor(Color.WHITE);

        String menuText = "Choose light mode or dark mode";
        List<String> lightOrDarkMode = Arrays.asList(
                "Light Mode",
                "Dark Mode"
        );

        int chooseMode = askForMenuChoice(menuText, lightOrDarkMode);

        switch (chooseMode) {
            case 0 -> lightMode();
            default -> darkMode();
        }
        console.resetToBookmark("START");
    }

    public static Double askForPaymentAmount() {
        return textio.newDoubleInputReader()
                .withMinVal(0.0)
                .read("Enter payment amount");
    }

    public static LocalDate askForDate() {
        Year resultYear = Year.of(textio.newIntInputReader()
                .withMinVal(LocalDate.now().getYear() - 150)
                .withMaxVal(LocalDate.now().getYear())
                .withDefaultValue(LocalDate.now().getYear())
                .read("Enter result year")
        );

        YearMonth resultMonth = resultYear.atMonth(textio.newEnumInputReader(Month.class)
                .withDefaultValue(LocalDate.now().getMonth())
                .read("Enter result month")
        );

        return resultMonth.atDay(textio.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(resultMonth.lengthOfMonth())
                .withDefaultValue(LocalDate.now().getDayOfMonth())
                .read("Enter date of the result")
        );
    }

    public static <T> Integer askForIndexFromList(List<T> list) {
        return textio.newIntInputReader()
                .withNumberedPossibleValues(getListIndices(list))
                .withValueFormatter(index -> list.get(index).toString())
                .read("Choose from list");
    }

    // Competition or training
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
                .read("Enter x amounts of minutes");
        Double resultInSeconds = textio.newDoubleInputReader()
                .withMinVal(0.0)
                .read("Enter x amounts of seconds");

        return Duration.ofMinutes(resultInMinutes)
                .plusMillis((long) (resultInSeconds * 1000));
    }

    // Coach settings

    public static String askForTeamName(){
        return textio.newStringInputReader()
                .read("Enter team name");
    }

    public static Team askForAllTeams() {

        UserInput.console.println("Select a team" + "\n" + "-");
        List<Team> teams = DelfinMain.listOfTeams.getAllTeams().stream().toList();
        Integer index = textio.newIntInputReader()
                .withNumberedPossibleValues(getListIndices(teams))
                .withValueFormatter(i -> teams.get(i).getName())
                .read("List of teams");
        return teams.get(index);
    }
}
