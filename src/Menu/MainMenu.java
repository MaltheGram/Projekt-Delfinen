/*
 * @author Malthe
 * 18/05/2021 14.50
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Service.UserInput;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to “Delfinen” system menu!";
    private static final List<String> menuOptions = Arrays.asList(
            "See president options.",
            "See accountant options",
            "See coach options.",
            "Exit."
    );

    public static void runMenu() {
        UserInput.clearConsole();
        isRunning = true;

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);

            switch (menuChoice) {
                case 0 -> PresidentMenu.runPresidentMenu();
                case 1 -> AccountantMenu.runAccountantMenu();
                case 2 -> CoachMenu.runCoachMenu();
                case 3 -> exitMenu();
            }
        }
    }

    private static void exitMenu() {
        UserInput.clearConsole();
        isRunning = false;
    }
}

