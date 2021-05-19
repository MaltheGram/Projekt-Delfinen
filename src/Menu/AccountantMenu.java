/*
 * @author Malthe
 * 18/05/2021 15.18
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import java.util.Scanner;

public class AccountantMenu {
    public static void runAccountantMenu(){
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Accountant menu\n" +
                "1: See expected income from subscriptions.\n" +
                "2: See overdue payment.\n" +
                "3: Go back to main menu.\n" +
                "9: Exit");

        int input = sc.nextInt();

        if (input == 1){
            // TODO: See expected income
            System.out.println("Expected income coming soon");
        }
        if (input == 2){
            // TODO: See overdue payments
            System.out.println("Overdue payments coming soon");
        }
/*        if (input == 3){
            MainMenu.runMenu();
        }*/
        else if (input == 9 || input == 3)
            //System.out.println("Terminating.....");
            isRunning = false;

    }
}
