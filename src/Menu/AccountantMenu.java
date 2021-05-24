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
    private static final FinanceHandler financeHandler = new FinanceHandler();
    private static final List<String> menuOptions = Arrays.asList(
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
                case 0 -> makePayment();
                case 1 -> viewAllPayments();
                case 2 -> viewAnnualBudget();
                case 3 -> viewOverduePayments();
                // TODO: ADD makePayment() method.
                case 4 -> exitMenu();
            }
        }
    }

    // TODO: implement expected income
    private static void viewAnnualBudget() {
        financeHandler.displayAnnualBudget();
    }

    // TODO: Implement overdue payments
    private static void viewOverduePayments() {
        financeHandler.viewOverduePayments();
    }

    private static void makePayment() {
        var userInput = new UserInput();
        var member = userInput.askForMember();
        var amount = userInput.askForAmount();
        financeHandler.makePayment(member, amount);
    }

    private static void viewAllPayments() {
        financeHandler.displayAllPayments();
    }

    private static void exitMenu() {
        isRunning = false;
        UserInput.clearConsole();
    }
}
