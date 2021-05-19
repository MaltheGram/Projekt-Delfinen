/*
 * @author Malthe
 * 18/05/2021 14.50
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

/*
 * @author Malthe
 * 18/05/2021 14.45
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class MainMenu {

    public static void runMenu() {

    boolean isRunning = true;
    Scanner sc = new Scanner(System.in);


        System.out.println("Welcome to \"Delfinen\" system menu\n" +
                "1: See president options.\n" +
                "2: See accountant options.\n" +
                "3: See coach options\n" +
                "9: Exit");

        int input = sc.nextInt();
        //while (isRunning)
        if (input == 1){
            PresidentMenu.runPresidentMenu();
        }
        if (input == 2){
            AccountantMenu.runAccountantMenu();
        }
        if (input == 3){
            CoachMenu.runCoachMenu();
        }
        else if (input == 9)
            System.out.println("Terminating.....");
            isRunning = false;



    }
}
