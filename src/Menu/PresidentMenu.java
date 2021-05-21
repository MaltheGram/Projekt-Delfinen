// * @author Malthe
// * 18/05/2021 15.07
// *
// * DAT21V2-Projekt-Delfinen
// *

package Menu;

import DelfinMain.DelfinMain;
import Member.MemberHandler;
import Service.UserInput;
import org.beryx.textio.TextIO;

import java.util.Arrays;

public class PresidentMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to President menu!";
    private static final String[] menuOptions = {
            "Add new member.",
            "Remove member.",
            "Update member information.",
            "See list of members",
            "Go back to main menu",
    };

    public static void runPresidentMenu() {
        isRunning = true;
        UserInput.clearConsole();

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, Arrays.asList(menuOptions));

            switch (menuChoice) {
                case 0 -> AddMember();
                case 1 -> RemoveMember();
                case 2 -> UpdateMember();
                case 3 -> showMemberList();
                case 4 -> ExitMenu();
            }
        }
    }

    private static void AddMember() {
       MemberHandler.addMember();
    }

    private static void RemoveMember() {
        MemberHandler.removeMember();
    }

    private static void UpdateMember() {
        MemberHandler.updateMemberInformation();
    }

    public static void showMemberList(){
        var listOfIds = DelfinMain.listOfMembers.getAllMembers();
        UserInput.console.println(String.valueOf(listOfIds));
    }

    private static void ExitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}

