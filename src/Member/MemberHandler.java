/*
 * @author Malthe
 * + a little spice of @author Mark
 * 19/05/2021 10.15
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Member;

import Service.UserInput;

import java.time.*;
import java.util.Scanner;
import DelfinMain.DelfinMain;


public class MemberHandler {
    public static final Scanner sc = new Scanner(System.in);

    public static void addMember(){
        LocalDate birthDate = UserInput.askForBirthdate();
        String name = UserInput.askForName();
        String address = UserInput.askForAddress();
        String phoneNumber = UserInput.askForPhoneNumber();
        Boolean activeMembership = UserInput.askForActiveMembership();

        Member member = new Member(name, birthDate, address, phoneNumber, activeMembership);
        DelfinMain.listOfMembers.addNewMember(member);
        UserInput.clearConsole();
        UserInput.console.println("Member added.");
    }

    public static void updateMemberInformation() {
        Member memberToUpdate = UserInput.askForMember();
        // TODO: maybe print member here

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("""
                What will you update?
                1: Name.
                2: Address.
                3: Birthdate.
                4: Phone number
                5: Membership status
                6: Competition status
                9: Exit""");

        int chooseMenu = sc.nextInt();
        sc.nextLine();

        if (chooseMenu == 1){
            System.out.println("New name\n_______________");
            String newName = UserInput.askForName();
            memberToUpdate.setName(newName);
        }
        if (chooseMenu == 2){
            System.out.println("New address\n_______________");
            input = sc.nextLine();
            memberToUpdate.setAddress(input);
        }
        if (chooseMenu == 3){
            System.out.println("New birthday\n_______________");
            LocalDate birthDate = UserInput.askForBirthdate();
            memberToUpdate.setBirthDate(birthDate);
        }
        if (chooseMenu == 4){
            System.out.println("New phone number\n_______________");
            String newPhoneNumber = UserInput.askForPhoneNumber();
            memberToUpdate.setPhoneNumber(newPhoneNumber);
        }
        if (chooseMenu == 5){
            System.out.println("New membership status\n_______________");
            Boolean newMembershipStatus = UserInput.askForActiveMembership();
            memberToUpdate.setActiveMember(newMembershipStatus);
        }

        if (chooseMenu == 9){
            System.out.println("Terminating....");
        }
    }

    public static void removeMember() {
        System.out.println("Input member ID to remove");
        Member memberToRemove = UserInput.askForMember();

        System.out.println("Confirm removal of: " + memberToRemove.getName() + "\nYes/No");
        String input = sc.nextLine();
        if (UserInput.isYes(input)){
            DelfinMain.listOfMembers.removeMember(memberToRemove.getMemberId());
        }
        if (UserInput.isNo(input)){
            System.out.println("Terminating....");
        }
    }


}
