/*
 * @author Malthe
 * 18/05/2021 15.07
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Menu;


import Member.MemberHandler;
import java.util.Scanner;

public class PresidentMenu {

    public static void runPresidentMenu(){
        boolean isRunning = true;
        String addMoreMembers;

        Scanner sc = new Scanner(System.in);


        System.out.println("""
                Welcome to President menu
                1: Add member.
                2: Remove member.
                3: Update member information.
                4: Go back to main menu
                9: Exit""");

        var input = sc.nextInt();

        if (input == 1){
            MemberHandler.addMember();
            while (isRunning) {
                System.out.println("Add more members? Yes/No");
                sc.nextLine();
                addMoreMembers = sc.nextLine();
                if (addMoreMembers.equalsIgnoreCase("yes")) {
                    MemberHandler.addMember();
                } else
                    isRunning = false;
                    MainMenu.runMenu();

            }
        }

        if (input == 2){
            // TODO: Remove member
            System.out.println("Remove coming soon");
        }
        if (input == 3){
            MemberHandler.updateMemberInformation();
        }
        if (input == 4){
            MainMenu.runMenu();
        }
        else if (input == 9)
            System.out.println("Terminating....");
        }

    }


