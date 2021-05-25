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
import Menu.CoachMenu;
import Menu.MainMenu;
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

    public static void displayLeaderboards() {
        UserInput.clearConsole();
        final String MENU_TEXT = "Choose discipline leaderboard to show";
        final List<String> MENU_OPTIONS = Arrays.asList(
                "See crawl leaderboard",
                "See back crawl leaderboard",
                "See butterfly leaderboard",
                "See breaststroke leaderboard",
                "Go back"
        );

        Integer menuChoice = UserInput.askForMenuChoice(MENU_TEXT,MENU_OPTIONS);

        switch (menuChoice){
            case 0 -> LeaderboardHandler.crawlLeaderboard();
            case 1 -> LeaderboardHandler.backCrawlLeaderboard();
            case 2 -> LeaderboardHandler.butterflyLeaderboard();
            case 3 -> LeaderboardHandler.breastStrokeLeaderboard();
            case 4 -> CoachMenu.runCoachMenu();
        }

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
