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

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardHandler {

    private static final Integer LEADERBOARD_LIMIT = 10;

    private static List<Result> makeLeaderboard(ResultType type, Discipline discipline) {
        List<Result> listOfResults = new ArrayList<>();
        DelfinMain.listOfResults.getAllResults().forEach(listOfResults::addAll);

        return listOfResults.stream()
                .filter( result -> result.getType() == type )
                .filter( result -> result.getDiscipline() == discipline )
                .sorted(Comparator.comparing(Result::getTime))
                .limit(LEADERBOARD_LIMIT)
                .collect(Collectors.toList());
    }

    private static void prettyPrint(List<Result> leaderboard) {
        int i = 0;
        for (Result result : leaderboard) {
            Integer place = i + 1;
            String name = result.getMember().getName();
            String time = durationAsString(result.getTime());

            UserInput.console.println(
                    String.format("%2s. %-15s %s", i + 1, result.getMember().getName(), durationAsString(result.getTime()))
            );

            i++;
        }
    }

    private static String durationAsString(Duration time) {
        return String.format("%d:%02d:%02d", time.getSeconds() / 3600, (time.getSeconds() % 3600) / 60, (time.getSeconds() % 60));
    }

    public static void crawlLeaderboard(){
        UserInput.clearConsole();
        List<Result> leaderboard = makeLeaderboard(ResultType.COMPETITION, Discipline.CRAWL);
        UserInput.console.println("Crawl Leaderboard");
        prettyPrint(leaderboard);
    }

    public static void butterflyLeaderboard(){
        UserInput.clearConsole();
        List<Result> leaderboard = makeLeaderboard(ResultType.COMPETITION, Discipline.BUTTERFLY);
        UserInput.console.println("Butterfly Leaderboard");
        prettyPrint(leaderboard);
    }

    public static void breastStrokeLeaderboard(){
        UserInput.clearConsole();
        List<Result> leaderboard = makeLeaderboard(ResultType.COMPETITION, Discipline.BREAST_STROKE);
        UserInput.console.println("Breast Stroke Leaderboard");
        prettyPrint(leaderboard);
    }

    public static void backCrawlLeaderboard(){
        UserInput.clearConsole();
        List<Result> leaderboard = makeLeaderboard(ResultType.COMPETITION, Discipline.BACK_CRAWL);
        UserInput.console.println("Back Crawl Leaderboard");
        prettyPrint(leaderboard);
    }
}

