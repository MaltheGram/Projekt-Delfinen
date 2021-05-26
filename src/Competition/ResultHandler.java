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
import Service.UserInput;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;


public class ResultHandler implements Serializable {

    public static void addResult() {
        UserInput.clearConsole();
        Member member = UserInput.askForMember();
        LocalDate date = UserInput.askForDate();
        ResultType type = UserInput.askForResultType();
        Discipline discipline = UserInput.askForDiscipline();
        Duration resultTime = UserInput.askForResultTime();

        Result result = new Result(member, date, type, discipline, resultTime );
        DelfinMain.listOfResults.addNewResult(member, result);
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

    public static void manageTeams() {
        UserInput.clearConsole();
        UserInput.console.println("WORK IN PROGRESS");
        String menuText = "What would you like to do?";
        List<String> menuOptions = Arrays.asList(
                "Create new team",
                "Add members to team - WIP",
                "Show list of teams",
                "Go back"
        );

        Integer menuChoice = UserInput.askForMenuChoice(menuText,menuOptions);

        switch (menuChoice) {
        case 0 -> Team.TeamCreation();
        case 1 -> Team.addMemberToTeam();
        case 2 -> Team.showListOfTeams();
        case 3 -> CoachMenu.runCoachMenu();

        }
    }

    public static void removeResult(){
        //TODO: if user has no results, disallow access
        UserInput.clearConsole();
        Member member = UserInput.askForMember();
        int listSize = DelfinMain.listOfResults.getResultsByID(member.getMemberId()).size();

        if (listSize <= 0){
            UserInput.clearConsole();
            UserInput.console.println("List is empty");
        }
        else {
            UserInput.clearConsole();
            int listChoice = UserInput.askForIndexFromList(DelfinMain.listOfResults.getResultsByID(member.getMemberId()));
            DelfinMain.listOfResults.removeResult(member, listChoice);
        }
    }
}
