/*
 * @author Malthe
 * 18/05/2021 15.18
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Service.UserInput;
import java.util.Arrays;

public class AccountantMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Accountant menu!";
    private static final String[] menuOptions = {
            "See expected income from subscriptions.",
            "See overdue payment.",
            "Go back to main menu.",
    };

    public static void runAccountantMenu() {
        isRunning = true;
        UserInput.clearConsole();

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, Arrays.asList(menuOptions));

            switch (menuChoice) {
                case 0 -> viewAnnualIncome();
                case 1 -> viewOverduePayments();
                case 2 -> exitMenu();
            }
        }
    }

    // TODO: implement expected income
    private static void viewAnnualIncome() {
        UserInput.console.println("Not implemented yet");
        /*
        if (input == 1) {
        System.out.println("Expected income coming soon");
        }
         */
    }

    // TODO: Implement overdue payments
    private static void viewOverduePayments() {
        UserInput.console.println("Not implemented yet");
        /*
        if (input == 2) {
            System.out.println("Overdue payments coming soon");
         */
    }

    private static void exitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}
