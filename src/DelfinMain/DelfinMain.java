package DelfinMain;

import Competition.ResultList;
import Competition.Team;
import Competition.TeamList;
import Member.Member;
import Menu.MainMenu;
import Service.UserInput;
import Member.MemberList;

import java.util.ArrayList;
import java.util.List;

public class DelfinMain {

    public static MemberList listOfMembers = new MemberList("memberlist");
    public static ResultList listOfResults = new ResultList("resultlist");
    public static TeamList listOfTeams = new TeamList("teamNames");

    public static void main(String[] args) {
        UserInput.lightMode();
        MainMenu.runMenu();
        UserInput.textio.dispose();
    }
}