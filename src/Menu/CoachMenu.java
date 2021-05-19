/*
 * @author Malthe
 * 18/05/2021 15.32
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public class CoachMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Coach menu!";
    private static final String[] menuOptions = {
            "See leaderboard",
            "Manage teams",
            "Go back to main menu.",
        };

    public static void runCoachMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = true;
        console.resetToBookmark("CLEAR");

        while (isRunning) {
            Integer menuChoice = textio.newIntInputReader()
                    .withNumberedPossibleValues(0, 1, 2)
                    .withValueFormatter(index -> menuOptions[index])
                    .read(menuText);

            switch (menuChoice) {
                case 0 -> viewLeaderboards(textio, console);
                case 1 -> manageTeams(textio, console);
                case 2 -> exitMenu(textio, console);
            }
        }
    }

    // TODO: implement viewLeaderboards
    private static void viewLeaderboards(TextIO textio, TextTerminal<?> console) {
        if (input == 1) {

            System.out.println("Leaderboard coming soon");
        }
    }

    // TODO: implement manageTeams
    private static void manageTeams(TextIO textio, TextTerminal<?> console) {
        console.println("Not implemented yet");
        /*if (input == 2) {

            System.out.println("Manage teams coming soon");
        }*/
    }

    private static void exitMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = false;
    }
}
