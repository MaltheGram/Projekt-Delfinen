package Competition;

import DelfinMain.DelfinMain;
import Group.Discipline;
import Member.Member;
import Service.UserInput;
import java.time.Duration;
import java.time.LocalDate;

public class ResultHandler {

    public static void addResult() {
        Member member = UserInput.askForMember();
        LocalDate date = UserInput.askForDate();
        ResultType type = UserInput.askForResultType();
        Discipline discipline = UserInput.askForDiscipline();
        Duration resultTime = UserInput.askForResultTime();

        Result result = new Result(member, date, type, discipline, resultTime );
        DelfinMain.resultList.addNewResult(member, result);
    }

    //TODO: implement viewLeaderboards
    public static void viewLeaderboards() {
        UserInput.console.println("Not implemented yet");
    }

    //TODO: implement manageTeams
    public static void manageTeams() {
        UserInput.console.println("Not implemented yet");
    }

    public static void removeResult(){
        Member member = UserInput.askForMember();
        int listSize = DelfinMain.resultList.getResultsByID(member.getMemberId()).size();

        if (listSize <= 0){
            UserInput.console.println("List is empty");
        }
        else {
            int listChoice = UserInput.askForIndexFromList(DelfinMain.resultList.getResultsByID(member.getMemberId()));
            DelfinMain.resultList.removeResult(member, listChoice);
        }
    }
}
