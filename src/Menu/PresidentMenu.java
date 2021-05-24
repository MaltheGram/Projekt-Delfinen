// * @author Malthe
// * 18/05/2021 15.07
// *
// * DAT21V2-Projekt-Delfinen
// *

package Menu;

import Member.MemberHandler;
import Service.UserInput;

import java.util.Arrays;
import java.util.List;

public class PresidentMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to President menu!";
    private static final List<String> menuOptions = Arrays.asList(
            "Add new member.",
            "Remove member.",
            "Update member information.",
            "See list of members",
            "Go back to main menu"
    );

    public static void runPresidentMenu() {
        isRunning = true;
        UserInput.clearConsole();

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);

            switch (menuChoice) {
                case 0 -> MemberHandler.addMember();
                case 1 -> MemberHandler.removeMember();
                case 2 -> MemberHandler.updateMember();
                case 3 -> MemberHandler.displayMemberList();
                case 4 -> ExitMenu();
            }
        }
    }

    private static void ExitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}

