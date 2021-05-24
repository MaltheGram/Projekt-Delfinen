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


        Result result = new Result(date, type, discipline, resultTime );
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
}
