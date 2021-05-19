/*
 * @author Malthe
 * 18/05/2021 14.50
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public class MainMenu {
    private static boolean isRunning = true;
    private static String menuText = "Welcome to “Delfinen” system menu";
    private static String[] menuOptions = {
            "See president options.",
            "See accountant options",
            "See coach options.",
            "Exit."
    };

    public static void runMenu(TextIO textio, TextTerminal<?> console) {
        console.resetToBookmark("CLEAR");
        Integer menuChoice = textio.newIntInputReader()
                .withNumberedPossibleValues(0,1,2,3)
                .withValueFormatter( index -> menuOptions[index] )
                .read(menuText);

        while (isRunning) {
            switch (menuChoice) {
                case 0 -> PresidentMenu.runPresidentMenu();
                case 1 -> AccountantMenu.runAccountantMenu();
                case 2 -> CoachMenu.runCoachMenu();
                case 3 -> {
                    console.println("Exiting...");
                    isRunning = false;
                }
            }
        }
    }
}
