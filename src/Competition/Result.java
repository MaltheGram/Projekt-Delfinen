/**
 * @author Frederik
 * @author Simon
 *
 */
package Competition;

import Group.Discipline;
import Member.Member;
import java.time.Duration;
import java.time.LocalDate;

record Result( Member memberID,
               LocalDate date,
               ResultType type,
               Discipline discipline,
               Duration time
) {

}

