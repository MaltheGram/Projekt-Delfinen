/**
 * @author Malthe
 * @author Frederik
 * 25/05/2021 13.44
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;

import DelfinMain.DelfinMain;
import Member.Member;
import Service.UserInput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Team implements Serializable {
    public static final List<Member> LIST_OF_MEMBERS_IN_TEAM = new ArrayList<>();
    private String name;

    public Team(String name) {
        this.name = name;
    }
    // TODO: FIX HVIS JEG FÅR OVERSKUD

    public static void TeamCreation() {
        UserInput.clearConsole();
        String teamName = UserInput.askForTeamName();
        Team team = new Team(teamName);
        DelfinMain.listOfTeams.addNewTeam(team);
        UserInput.console.println("Team successfully created.");
    }

    public static void removeTeam(){
        UserInput.clearConsole();
        Team teamToRemove = UserInput.askForAllTeams();

        Boolean confirmRemoval = UserInput.textio.newBooleanInputReader()
                .read("Confirm removal of team: " + teamToRemove.getName());

        if (confirmRemoval){
            DelfinMain.listOfTeams.removeTeam(teamToRemove.getName());
        } else {
            UserInput.console.println("Terminating....");
        }
            UserInput.clearConsole();
    }



    public static List<Member> getListOfMembers() {
        return LIST_OF_MEMBERS_IN_TEAM;
    }
    public static void addMemberToTeam() {
        UserInput.clearConsole();
        UserInput.console.println("Not implemented yet.");
        /*Team targetTeam = UserInput.askForAllTeams();
        Member memberToAdd = UserInput.askForMember();
        targetTeam.getListOfMembers().add(memberToAdd);

         */

    }

    public static void showListOfTeams() {
        UserInput.clearConsole();
        UserInput.console.println("Current teams: " + Arrays.toString(DelfinMain.listOfTeams.getTeams().toArray()));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder tmpString = new StringBuilder();
        for (Member member : LIST_OF_MEMBERS_IN_TEAM) {
            tmpString.append(member.getName());
        }
            return "Team name: " + getName() + " with: " + tmpString;
    }
}