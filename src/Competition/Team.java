/**
 * @author Malthe
 * @author Frederik
 * 25/05/2021 13.44
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;

import Member.Member;
import Service.FileControl;
import Service.UserInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Team {
    //public static final ArrayList<Member> LIST_OF_MEMBERS_ON_TEAM = new ArrayList<>();
    public static final List<Team> LIST_OF_MEMBERS_ON_TEAM = new ArrayList<>();
    private String name;

    public Team(String name) {
        this.name = name;
    }
    // TODO: FIX HVIS JEG FÅR OVERSKUD

    public static void TeamCreation(){
        String teamName = UserInput.askForTeamName();
        Team team = new Team(teamName);
        LIST_OF_MEMBERS_ON_TEAM.add(team);

        FileControl.writeSerializableToFile((ArrayList<Team>)LIST_OF_MEMBERS_ON_TEAM,"teamNames");
        UserInput.console.println("Team successfully created.");

    }

    public static void addMemberToTeam(){
          /*  FileControl.readSerializableFromFile("teamNames",LIST_OF_MEMBERS_ON_TEAM);
            UserInput.askForTeamName();
            Member memberToAdd = UserInput.askForMember();
            LIST_OF_MEMBERS_ON_TEAM.add(memberToAdd);

           */

    }

    public static void showTeamList(){
        FileControl.readSerializableFromFile("teamNames",(ArrayList<Team>)LIST_OF_MEMBERS_ON_TEAM);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        @Override
        public String toString() {
            return "Team name: " + getName();
        }
}
