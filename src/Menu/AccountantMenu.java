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
import java.util.List;

public class AccountantMenu {
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to Accountant menu!";
    private static final List<String> menuOptions = Arrays.asList(
            "Make a payment",
            "View all payments",
            "See expected income from subscriptions.",
            "See overdue payment.",
            "Go back to main menu."
    );

    public static void runAccountantMenu() {
        isRunning = true;
        UserInput.clearConsole();

        while (isRunning) {
            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);

            switch (menuChoice) {
                case 0 -> FinanceHandler.makePayment();
                case 1 -> FinanceHandler.displayAllPayments();
                case 2 -> FinanceHandler.displayAnnualBudget();
                case 3 -> FinanceHandler.displayOverduePayments();
                case 4 -> exitMenu();
            }
        }
    }

    private static void exitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}
