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


public class Team {
    private static final ArrayList<Member> LIST_OF_MEMBERS_ON_TEAM = new ArrayList<>();
    private String name;

    public Team(String name) {
        this.name = name;
    }
    // TODO: FIX HVIS JEG FÅR OVERSKUD

    public static void TeamCreation() {
        String teamName = UserInput.askForTeamName();
        Team team = new Team(teamName);

        FileControl.writeSerializableToFile(teamName,"teamNames");

    }

    public static void addMemberToTeam(){

            UserInput.askForTeamName();
            Member memberToAdd = UserInput.askForMember();

            LIST_OF_MEMBERS_ON_TEAM.add(memberToAdd);

    }

    public static void showTeamList(){
        UserInput.console.println(LIST_OF_MEMBERS_ON_TEAM.toString());
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
