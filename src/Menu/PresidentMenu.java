// * @author Malthe
// * 18/05/2021 15.07
// *
// * DAT21V2-Projekt-Delfinen
// *

package Menu;

import Member.Member;
import Member.MemberHandler;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PresidentMenu {
    private static HashMap<String, Member> test = new HashMap<>();

    static Scanner sc = new Scanner(System.in);
    private static Boolean isRunning = true;
    private static final String menuText = "Welcome to President menu!";
    private static final String[] menuOptions = {
            "Add new member.",
            "Remove member.",
            "Update member information.",
            "Go back to main menu",
    };

    public static void runPresidentMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = true;
        console.resetToBookmark("CLEAR");

        while (isRunning) {
            Integer menuChoice = textio.newIntInputReader()
                    .withNumberedPossibleValues(0, 1, 2, 3)
                    .withValueFormatter(index -> menuOptions[index])
                    .read(menuText);

            switch (menuChoice) {
                case 0 -> AddMember(textio, console);
                case 1 -> RemoveMember(textio, console);
                case 2 -> UpdateMember(textio, console);
                case 3 -> ExitMenu(textio, console);
            }
        }
    }

    // TODO: Implement AddMember
    private static void AddMember(TextIO textio, TextTerminal<?> console) {
       MemberHandler.addMember();

        /*if (input == 1){
            MemberHandler.addMember();
            while (isRunning) {
                System.out.println("Add more members? Yes/No");
                sc.nextLine();
                addMoreMembers = sc.nextLine();
                if (addMoreMembers.equalsIgnoreCase("yes")) {
                    MemberHandler.addMember();
                } else
                    isRunning = false;
                //MainMenu.runMenu();

            }
        }*/
    }

    // TODO: Implement RemoveMember
    private static void RemoveMember(TextIO textio, TextTerminal<?> console) {
        console.println("Not implemented yet");
        MemberHandler.removeMember();
        /*
        if (input == 3) {
            System.out.println("Input member ID update");
            sc.nextLine();
            String memberId = sc.nextLine();
            MemberHandler.updateMemberInformation(memberId);
        }
         */
    }

    // TODO: Implement UpdateMember
    private static void UpdateMember(TextIO textio, TextTerminal<?> console) {
        console.println("Not implemented yet");
        String idToUpdate = sc.nextLine();
        MemberHandler.updateMemberInformation(idToUpdate);
        /*
        if (input == 3) {
            System.out.println("Input member ID update");
            sc.nextLine();
            String memberId = sc.nextLine();
            MemberHandler.updateMemberInformation(memberId);
        }
         */
    }

    private static void ExitMenu(TextIO textio, TextTerminal<?> console) {
        isRunning = false;
    }
}

