/*
 * @author Malthe
 * 19/05/2021 10.15
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Member;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import java.time.LocalDate;



public class MemberHandler {

    private static Scanner sc = new Scanner(System.in);

    // TODO: ADD MEMBER TO THE FILE
    public static void addMember(){
        boolean isActiveMember = false;

        System.out.println("Birth year");
        var yearInput = sc.nextInt();
        System.out.println("Birth month");
        var monthInput = sc.nextInt();
        System.out.println("Birth day");
        var dateInput = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter name");
        String nameInput = sc.nextLine();

        System.out.println("Enter address");
        String addressInput = sc.nextLine();

        System.out.println("Enter phone number");
        String phoneInput = sc.nextLine();
            while (!(phoneInput.length() == 8)) {
                System.out.println("Wrong phone number input. Try again.");
                phoneInput = sc.nextLine();
            }

        System.out.println("Active membership? Yes/No");
        String isActiveInput = sc.nextLine();
        if (isActiveInput.equalsIgnoreCase("yes") || isActiveInput.equalsIgnoreCase("y")) {
            isActiveMember = true;
        }

        LocalDate localDate = LocalDate.of(yearInput,monthInput,dateInput);
        Member member = new Member(nameInput,localDate,addressInput,phoneInput,isActiveMember);
        System.out.println("Member added.");
    }

    public static void updateMemberInformation(String memberId) {


        Member member = new Member(null,null,null,null,false);
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
            member.setName(input);
        }
        if (chooseMenu == 2){
            System.out.println("New address\n_______________");
            input = sc.nextLine();
            member.setAddress(input);
        }
        if (chooseMenu == 3){
            System.out.println("New birthdate\n_______________");
            System.out.println("Birth year");
            var yearInput = sc.nextInt();
            System.out.println("Birth month");
            var monthInput = sc.nextInt();
            System.out.println("Birth day");
            var dateInput = sc.nextInt();
            sc.nextLine();

            LocalDate setLocalDate = LocalDate.of(yearInput,monthInput,dateInput);
            member.setBirthDate(setLocalDate);
        }
        if (chooseMenu == 4){
            System.out.println("New phone number\n_______________");
            input = sc.nextLine();
            member.setPhoneNumber(input);
        }
        if (chooseMenu == 5){
            boolean isActiveMember = false;
            System.out.println("New membership status\n_______________");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("active"))
            member.setActiveMember(isActiveMember = true);
        }
        if (chooseMenu == 9){
            System.out.println("Terminating....");
        }


    }


    public static void removeMember(){
        System.out.println("Input member ID to remove");


    }


    public String dateFormat(){
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    }

}
