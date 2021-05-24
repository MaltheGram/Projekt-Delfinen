/**
 * @author Frederik
 * @author Simon
 *
 */
package Competition;

import Group.Discipline;
import Member.Member;
import Service.UserInput;

import java.time.*;

record Result( Member memberID,
               LocalDate date,
               ResultType type,
               Discipline discipline,
               Duration time
) {

    private static Result addResult(){
        UserInput.askForDate();
        UserInput.askForResultTime();

        return null;
    }





}



