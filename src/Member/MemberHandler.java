/*
 * @author Malthe
 * + a little spice of @author Mark
 * 19/05/2021 10.15
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Member;

import Finance.*;
import Menu.PresidentMenu;
import Service.UserInput;
import Finance.FinanceHandler;
import java.time.*;
import java.util.Arrays;
import java.util.List;

import DelfinMain.DelfinMain;


public class MemberHandler {

    public static void addMember(){

            String name = UserInput.askForName();
            LocalDate birthDate = UserInput.askForBirthdate();
            String address = UserInput.askForAddress();
            String phoneNumber = UserInput.askForPhoneNumber();
            Boolean activeMembership = UserInput.askForActiveMembership();
            Member member = new Member(name, birthDate, address, phoneNumber, activeMembership);
            //FinanceHandler.addNewPayable(member);

            DelfinMain.listOfMembers.addNewMember(member);
            UserInput.clearConsole();
            UserInput.console.println("Member added.");
    }


    public static void updateMemberInformation() {
        boolean isRunning = true;
        PresidentMenu.showMemberList();

        Member memberToUpdate = UserInput.askForMember();
        // TODO: maybe print member here
        String menuText = "What will you update?";
        String[] menuOptions = new String[] {
                "Name",
                "Address",
                "Birthdate",
                "Phone number",
                "Membership status",
                "Competition status",
                "Go back to president menu",
        };

        while (isRunning) {

            Integer menuChoice = UserInput.askForMenuChoice(menuText, Arrays.asList(menuOptions));
            switch (menuChoice) {
                // TODO: maybe show change and ask for confirmation before changing
                case 0 -> {
                    UserInput.console.println("New name\n_______________");
                    String newName = UserInput.askForName();
                    memberToUpdate.setName(newName);
                    UserInput.clearConsole();
                }
                case 1 -> {
                    UserInput.console.println("New address\n_______________");
                    String newAddress = UserInput.askForAddress();
                    memberToUpdate.setAddress(newAddress);
                    UserInput.clearConsole();
                }
                case 2 -> {
                    UserInput.console.println("New birthday\n_______________");
                    LocalDate birthDate = UserInput.askForBirthdate();
                    memberToUpdate.setBirthDate(birthDate);
                    UserInput.clearConsole();
                }
                case 3 -> {
                    UserInput.console.println("New phone number\n_______________");
                    String newPhoneNumber = UserInput.askForPhoneNumber();
                    memberToUpdate.setPhoneNumber(newPhoneNumber);
                    UserInput.clearConsole();
                }
                case 4 -> {
                    UserInput.console.println("New membership status\n_______________");
                    Boolean newMembershipStatus = UserInput.askForActiveMembership();
                    memberToUpdate.setActiveMember(newMembershipStatus);
                    UserInput.clearConsole();
                }
                case 5 -> {
                    // TODO competition status
                }
                case 6 -> {
                    isRunning = false;
                    UserInput.clearConsole();
                }
            }
        }
    }

    public static void removeMember() {
        UserInput.console.println("Input member ID to remove");
        Member memberToRemove = UserInput.askForMember();

        Boolean confirmRemoval = UserInput.textio.newBooleanInputReader()
                .read("Confirm removal of: " + memberToRemove.getName());

        if (confirmRemoval){
            DelfinMain.listOfMembers.removeMember(memberToRemove.getMemberId());
        } else {
            UserInput.console.println("Terminating....");
        }
    }
}
