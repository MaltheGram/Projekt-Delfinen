/*
 * @author Malthe
 * 18/05/2021 15.32
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;

import Member.MemberList;

import java.util.Scanner;

public class CoachMenu {

    public static void runCoachMenu(){
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Coach menu\n" +
                "1: See leaderboard\n" +
                "2: Manage teams\n" +
                "3: Go back to main menu.\n" +
                "9: Exit");

        int input = sc.nextInt();

        if (input == 1){
            // TODO: See leaderborad
            System.out.println("Leaderboard coming soon");
        }
        if (input == 2){
            // TODO: Manage teams
            System.out.println("Manage teams coming soon");
        }
        if (input == 3){
            MainMenu.runMenu();
        }
        else if (input == 9)
            System.out.println("Terminating.....");
            isRunning = false;


    }

}
