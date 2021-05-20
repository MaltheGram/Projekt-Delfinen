// * @author Malthe
// * 18/05/2021 15.07
// *
// * DAT21V2-Projekt-Delfinen
// *

package Menu;

import Member.MemberHandler;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.Scanner;

public class PresidentMenu {
    static Scanner sc = new Scanner(System.in);
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to President menu!";
    private static final String[] menuOptions = {
            "Add new member.",
            "Remove member.",
            "Update member information.",
            "Go back to main menu",
    };

    public static void runPresidentMenu(TextIO textio, TextTerminal<?> console) {

        isRunning = true;
        console.resetToBookmark("CLEAR");

        while (isRunning) {
            Integer menuChoice = textio.newIntInputReader()
                    .withNumberedPossibleValues(0, 1, 2, 3)
                    .withValueFormatter(index -> menuOptions[index])
                    .read(menuText);

            switch (menuChoice) {
                case 0 -> AddMember();
                case 1 -> RemoveMember(textio, console);
                case 2 -> UpdateMember(textio, console);
                case 3 -> ExitMenu(textio, console);
            }
        }
    }

    private static void AddMember() {
       MemberHandler.addMember();
    }

    // TODO: Implement RemoveMember
    private static void RemoveMember(TextIO textio, TextTerminal<?> console) {
        MemberHandler.removeMember();
        /*
        if (input == 3) {
            System.out.println("Input member ID update");
            sc.nextLine();
            String memberId = sc.nextLine();
            MemberHandler.updateMemberInformation(memberId);
        }
         */
    }

    // TODO: Implement UpdateMember
    private static void UpdateMember(TextIO textio, TextTerminal<?> console) {
        MemberHandler.updateMemberInformation();
        /*
        if (input == 3) {
            System.out.println("Input member ID update");
            sc.nextLine();
            String memberId = sc.nextLine();
            MemberHandler.updateMemberInformation(memberId);
        }
         */
    }

    private static void ExitMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = false;
    }
}

