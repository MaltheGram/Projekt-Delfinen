/**
 * @author Malthe
 * 25/05/2021 21.11
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;


import Member.Member;
import Service.FileControl;
import Service.UserInput;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TeamList {

    private final String filePath;
    private final HashMap<String, Team> teams;

    public TeamList(String filePath){
        this.filePath = filePath;
        this.teams = FileControl.readSerializableFromFile(this.filePath, new HashMap<>());
    }

    public void addNewTeam(Team team){
        this.teams.put(team.getName(), team);
        FileControl.writeSerializableToFile(this.teams,this.filePath);
    }

    public void removeTeam(String teamName){
        this.teams.remove(teamName);
        FileControl.writeSerializableToFile(this.teams, this.filePath);

    }

    public Set<String> getTeams(){
         return teams.keySet();
    }

    // Refers to UserInput.java line 266
    public Collection<Team> getAllTeams(){
        return Collections.unmodifiableCollection(
                this.teams.values()
        );
    }

    @Override
    public String toString(){
        return teams.toString();
    }
}