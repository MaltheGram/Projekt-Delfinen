package DelfinMain;

import Member.Member;
import Menu.MainMenu;
import Service.FileControl;
import Service.UserInput;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import Member.MemberList;
import org.slf4j.Logger;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DelfinMain {

    public static MemberList listOfMembers = new MemberList();

    public static void main(String[] args) {
        //INIT MEMBER LIST
        listOfMembers = FileControl.readSerializableFromFile("list",listOfMembers);

        UserInput.setupConsole();
        MainMenu.runMenu();
        FileControl.writeSerializableToFile(listOfMembers,"list");
        UserInput.textio.dispose();
    }
}