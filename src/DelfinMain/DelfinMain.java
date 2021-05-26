package DelfinMain;

import Competition.ResultList;
import Competition.TeamList;
import Menu.MainMenu;
import Service.UserInput;
import Member.MemberList;

public class DelfinMain {

    public static final MemberList listOfMembers = new MemberList("memberlist");
    public static final ResultList listOfResults = new ResultList("resultlist");
    public static final TeamList listOfTeams = new TeamList("teamNames");

    public static void main(String[] args) {
        UserInput.lightMode();
        MainMenu.runMenu();
        UserInput.textio.dispose();
    }
}