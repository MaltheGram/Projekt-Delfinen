package Competition;

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
    }
}
