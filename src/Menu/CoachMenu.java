/*
 * @author Malthe
 * 18/05/2021 15.32
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Competition.ResultHandler;
import DelfinMain.DelfinMain;
import Service.UserInput;
import java.util.Arrays;
import java.util.List;

public class CoachMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Coach menu!";
    private static final List<String> menuOptions = Arrays.asList(
            "See leaderboard",
            "Add result",
            "Manage teams",
            "Go back to main menu."
    );

    public static void runCoachMenu() {
        isRunning = true;
        UserInput.clearConsole();

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);

            switch (menuChoice) {
                case 0 -> viewLeaderboards();
                case 1 -> addResult();
                case 2 -> manageTeams();
                case 3 -> exitMenu();
            }
        }
    }

    // TODO: implement viewLeaderboards
    private static void viewLeaderboards() {
        ResultHandler.viewLeaderboards();
    }

    private static void addResult() {
        var listOfIds = DelfinMain.listOfMembers.getFieldFromAllMembers(Member -> Member.getName()
                + ": with member id: " + Member.getMemberId() + "\n");
        UserInput.console.println(String.valueOf(listOfIds));
        ResultHandler.addResult();
    }

    // TODO: implement manageTeams
    private static void manageTeams() {
        ResultHandler.manageTeams();
    }

    private static void exitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}
