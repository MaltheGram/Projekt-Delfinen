/*
 * @author Malthe
 * 18/05/2021 15.07
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import java.util.Scanner;

public class PresidentMenu {

    public static void runPresidentMenu(){
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);


        System.out.println("Welcome to President menu\n" +
                "1: Add member.\n" +
                "2: Remove member.\n" +
                "3: Update member information.\n" +
                "4: Go back to main menu\n" +
                "9: Exit");

        int input = sc.nextInt();

        if (input == 1){
            // TODO: Add member
            System.out.println("adding coming soon");
        }
        if (input == 2){
            // TODO: Remove member
            System.out.println("Remove coming soon");
        }
        if (input == 3){
            // TODO: Update member information
            System.out.println("Update member coming soon");
        }
        if (input == 4){
            Menu.runMenu();
        }
        else if (input == 9)
            isRunning = false;


        }

    }


