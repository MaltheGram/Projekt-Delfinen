/*
 * @author Malthe
 * @author Simon
 * 25/05/2021 12.33
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Competition;

import DelfinMain.DelfinMain;
import Group.Discipline;
import Service.UserInput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardHandler {

    public static void crawlLeaderboard(){
        UserInput.clearConsole();
        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.resultList.getAllResults().forEach(listOfResults::addAll);

        List<Result> competitionCrawlLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.CRAWL )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());
        UserInput.console.println( competitionCrawlLeaderboard.toString());
    }

    public static void butterflyLeaderboard(){
        UserInput.clearConsole();
        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.resultList.getAllResults().forEach(listOfResults::addAll);

        List<Result> butterflyLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.BUTTERFLY )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());
        UserInput.console.println( butterflyLeaderboard.toString());
    }

    public static void breastStrokeLeaderboard(){
        UserInput.clearConsole();
        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.resultList.getAllResults().forEach(listOfResults::addAll);

        List<Result> breastStrokeLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.BREAST_STROKE )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());
        UserInput.console.println( breastStrokeLeaderboard.toString());
    }

    public static void backCrawlLeaderboard(){
        UserInput.clearConsole();
        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.resultList.getAllResults().forEach(listOfResults::addAll);

        List<Result> backCrawlLeaderboard = listOfResults.stream()
                .filter( result -> result.getType() == ResultType.COMPETITION )
                .filter( result -> result.getDiscipline() == Discipline.BACK_CRAWL )
                .sorted(Comparator.comparing(Result::getTime))
                .collect(Collectors.toList());
        UserInput.console.println( backCrawlLeaderboard.toString());
    }
}
