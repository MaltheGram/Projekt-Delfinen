/**
 * @author Malthe Gram
 * @author Simon Gredal
 * modded by @author Mark Larsen
 * 25/05/2021 09.41
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;

import DelfinMain.DelfinMain;
import Group.Discipline;
import Member.Member;
import Service.UserInput;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ResultHandler {

    public static void addResult() {
        UserInput.clearConsole();
        Member member = UserInput.askForMember();
        LocalDate date = UserInput.askForDate();
        ResultType type = UserInput.askForResultType();
        Discipline discipline = UserInput.askForDiscipline();
        Duration resultTime = UserInput.askForResultTime();

        Result result = new Result(member, date, type, discipline, resultTime );
        DelfinMain.resultList.addNewResult(member, result);
        UserInput.clearConsole();
    }

    //TODO: implement viewLeaderboards
    public static void displayLeaderboards() {
        UserInput.clearConsole();

        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.resultList.getAllResults().forEach(listOfResults::addAll);

        List<Result> competitionCrawlLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.CRAWL )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());

        List<Result> competitionBreastLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.BREAST_STROKE )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());

        //TODO: Should be printed side be side
        UserInput.console.println( competitionCrawlLeaderboard.toString() );
        UserInput.console.println( competitionBreastLeaderboard.toString() );
    }

    //TODO: implement manageTeams
    public static void manageTeams() {
        UserInput.clearConsole();
        UserInput.console.println("Not implemented yet");
    }

    public static void removeResult(){
        UserInput.clearConsole();
        Member member = UserInput.askForMember();
        int listSize = DelfinMain.resultList.getResultsByID(member.getMemberId()).size();

        if (listSize <= 0){
            UserInput.clearConsole();
            UserInput.console.println("List is empty");
        }
        else {
            UserInput.clearConsole();
            int listChoice = UserInput.askForIndexFromList(DelfinMain.resultList.getResultsByID(member.getMemberId()));
            DelfinMain.resultList.removeResult(member, listChoice);
        }
    }
}
