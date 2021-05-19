/*
 * @author Malthe
 * 18/05/2021 15.18
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

public class AccountantMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Accountant menu!";
    private static final String[] menuOptions = {
            "See expected income from subscriptions.",
            "See overdue payment.",
            "Go back to main menu.",
    };

    public static void runAccountantMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = true;
        console.resetToBookmark("CLEAR");

        while (isRunning) {
            Integer menuChoice = textio.newIntInputReader()
                    .withNumberedPossibleValues(0, 1, 2)
                    .withValueFormatter(index -> menuOptions[index])
                    .read(menuText);

            switch (menuChoice) {
                case 0 -> viewAnnualIncome(textio, console);
                case 1 -> viewOverduePayments(textio, console);
                case 2 -> exitMenu(textio, console);
            }
        }
    }

    // TODO: implement expected income
    private static void viewAnnualIncome(TextIO textio, TextTerminal<?> console) {
        console.println("Not implemented yet");
        /*
        if (input == 1) {
        System.out.println("Expected income coming soon");
        }
         */
    }

    // TODO: Implement overdue payments
    private static void viewOverduePayments(TextIO textio, TextTerminal<?> console) {
        console.println("Not implemented yet");
        /*
        if (input == 2) {
            System.out.println("Overdue payments coming soon");
         */
    }

    private static void exitMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = false;

    }
}
