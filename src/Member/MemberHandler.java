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
        System.out.println("Member added.");
    }

    public static void updateMemberInformation() {
        System.out.println("Choose member id to update");
        String memberId = sc.nextLine();
        Member memberToUpdate = DelfinMain.listOfMembers.getMemberByID(memberId);
        while (memberToUpdate == null){
            System.out.println("Invalid member id");
            memberId = sc.nextLine();
            memberToUpdate = DelfinMain.listOfMembers.getMemberByID(memberId);
        }

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
            input = sc.nextLine();
            memberToUpdate.setName(input);
        }
        if (chooseMenu == 2){
            System.out.println("New address\n_______________");
            input = sc.nextLine();
            memberToUpdate.setAddress(input);
        }
        if (chooseMenu == 3){
            LocalDate birthDate = UserInput.askForBirthdate();
            memberToUpdate.setBirthDate(birthDate);
        }
        if (chooseMenu == 4){
            System.out.println("New phone number\n_______________");
            input = sc.nextLine();
            memberToUpdate.setPhoneNumber(input);
        }
        if (chooseMenu == 5){
            System.out.println("New membership status\n_______________");
            input = sc.nextLine();
            if (UserInput.isYes(input)){
                memberToUpdate.setActiveMember(true);
            }
            if (UserInput.isNo(input)){
                memberToUpdate.setActiveMember(false);
            }
        }

        if (chooseMenu == 9){
            System.out.println("Terminating....");
        }


    }

    public static void removeMember() {
        System.out.println("Input member ID to remove");
        String memberId = sc.nextLine();
        Member memberToRemove = DelfinMain.listOfMembers.getMemberByID(memberId);
        while (memberToRemove == null) {
            System.out.println("Invalid member id");
            memberId = sc.nextLine();
            memberToRemove = DelfinMain.listOfMembers.getMemberByID(memberId);
        }
        System.out.println("Confirm removal of: " + memberToRemove.getName() + "\nYes/No");
        String input = sc.nextLine();
        if (UserInput.isYes(input)){
            DelfinMain.listOfMembers.removeMember(memberId);
        }
        if (UserInput.isNo(input)){
            System.out.println("Terminating....");
        }
    }


}
