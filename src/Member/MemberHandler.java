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
import java.util.Arrays;
import java.util.List;

import DelfinMain.DelfinMain;
public class MemberHandler {

    public static void addMember(){
        UserInput.clearConsole();
        String tmpMember = "";
        String splitter = "\n" + "-";
        UserInput.console.println("Create a member by entering user data" + splitter);

        String name = UserInput.askForName();
        tmpMember += "Member name: " + name;
        UserInput.clearConsole();
        UserInput.console.println( tmpMember + splitter);

        LocalDate birthDate = UserInput.askForBirthdate();
        tmpMember += "\nDate of birth: " + birthDate;
        UserInput.clearConsole();
        UserInput.console.println( tmpMember + splitter);

        String address = UserInput.askForAddress();
        tmpMember += "\nAddress: " + address;
        UserInput.clearConsole();
        UserInput.console.println( tmpMember + splitter);

        String phoneNumber = UserInput.askForPhoneNumber();
        tmpMember += "\nPhone number: " + phoneNumber;
        UserInput.clearConsole();
        UserInput.console.println( tmpMember + splitter);

        Boolean activeMembership = UserInput.askForActiveMembership();

        Member member = new Member(name, birthDate, address, phoneNumber, activeMembership);

        DelfinMain.listOfMembers.addNewMember(member);
        UserInput.clearConsole();
        UserInput.console.println("Member added.");
    }


    public static void updateMember() {
        boolean isRunning = true;

        Member memberToUpdate = UserInput.askForMember();
        UserInput.console.println(memberToUpdate.toString());

        String menuText = "What will you update?";
        List<String> menuOptions = Arrays.asList(
                "Name",
                "Address",
                "Birthdate",
                "Phone number",
                "Membership status",
                "Competition status",
                "Go back to president menu"
        );

        while (isRunning) {

            Integer menuChoice = UserInput.askForMenuChoice(menuText, menuOptions);
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

            DelfinMain.listOfMembers.updateMember(memberToUpdate);
        }
    }

    public static void removeMember() {
        Member memberToRemove = UserInput.askForMember();

        Boolean confirmRemoval = UserInput.textio.newBooleanInputReader()
                .read("Confirm removal of: " + memberToRemove.getName());

        if (confirmRemoval){
            DelfinMain.listOfMembers.removeMember(memberToRemove.getMemberId());
        } else {
            UserInput.console.println("Terminating....");
        }
    }

    public static void displayMemberList() {
        var listOfIds = DelfinMain.listOfMembers.getFieldFromAllMembers(Member -> Member.getName() + ": with member id: " + Member.getMemberId() + ". Is member active: " + Member.isActiveMember() + "\n");
        if (listOfIds.isEmpty()){
            UserInput.console.println("There are no members");
        } else {
            UserInput.console.println(String.valueOf(listOfIds));
        }
    }
}
