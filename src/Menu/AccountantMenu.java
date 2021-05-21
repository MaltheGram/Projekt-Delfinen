/*
 * @author Malthe
 * 18/05/2021 15.18
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Finance.FinanceHandler;
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
                case 0 -> viewAnnualBudget();
                case 1 -> viewOverduePayments();
                // TODO: ADD makePayment() method.
                case 2 -> exitMenu();
            }
        }
    }

    // TODO: implement expected income
    private static void viewAnnualBudget() {
        //FinanceHandler.viewAnnualBudget();
    }

    // TODO: Implement overdue payments
    private static void viewOverduePayments() {
        //FinanceHandler.viewOverduePayments();
    }

    private static void exitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}
