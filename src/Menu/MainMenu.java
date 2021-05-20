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
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to “Delfinen” system menu!";
    private static final String[] menuOptions = {
        "See president options.",
        "See accountant options",
        "See coach options.",
        "Exit."
    };

    public static void runMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = true;
        console.resetToBookmark("CLEAR");

        while (isRunning) {
            Integer menuChoice = textio.newIntInputReader()
                    .withNumberedPossibleValues(0,1,2,3)
                    .withValueFormatter( index -> menuOptions[index] )
                    .read(menuText);

            switch (menuChoice) {
                case 0 -> PresidentMenu.runPresidentMenu(textio, console);
                case 1 -> AccountantMenu.runAccountantMenu(textio, console);
                case 2 -> CoachMenu.runCoachMenu(textio, console);
                case 3 -> exitMenu(textio, console);
            }
        }
    }

    private static void exitMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = false;
    }
}

