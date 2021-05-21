package DelfinMain;

import Menu.MainMenu;
import Service.UserInput;
import Member.MemberList;

public class DelfinMain {

    public static MemberList listOfMembers = new MemberList("memberlist");

    public static void main(String[] args) {
        UserInput.setupConsole();
        MainMenu.runMenu();
        UserInput.textio.dispose();
    }
}