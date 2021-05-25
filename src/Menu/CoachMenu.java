/*
 * @author Malthe
 * 18/05/2021 15.32
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Competition.ResultHandler;
import Service.UserInput;
import java.util.Arrays;
import java.util.List;

public class CoachMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Coach menu!";
    private static final List<String> menuOptions = Arrays.asList(
            "See leaderboard",
            "Add result",
            "Remove result",
            "Manage teams - WIP",
            "Go back to main menu."
    );

    public static void runCoachMenu() {
        UserInput.clearConsole();
        isRunning = true;

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);

            switch (menuChoice) {
                case 0 -> ResultHandler.displayLeaderboards();
                case 1 -> ResultHandler.addResult();
                case 2 -> ResultHandler.removeResult();
                case 3 -> ResultHandler.manageTeams();
                case 4 -> exitMenu();
            }
        }
    }

    private static void exitMenu() {
        UserInput.clearConsole();
        isRunning = false;
    }
}
