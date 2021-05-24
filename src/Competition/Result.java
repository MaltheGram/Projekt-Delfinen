/**
 * @author Frederik
 * @author Simon
 *
 */
package Competition;

import Group.Discipline;
import Member.Member;

import java.io.Serializable;
import java.time.*;

public class Result implements Serializable {
    private Member memberId;
    private LocalDate date;
    private ResultType type;
    private Discipline discipline;
    private Duration time;

    public Result(Member memberId, LocalDate date, ResultType type, Discipline discipline, Duration time) {
        this.memberId = memberId;
        this.date = date;
        this.type = type;
        this.discipline = discipline;
        this.time = time;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ResultType getType() {
        return type;
    }

    public void setType(ResultType type) {
        this.type = type;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }
}



/*record Result( Member memberID,
               LocalDate date,
               ResultType type,
               Discipline discipline,
               Duration time
) implements Serializable {

 */





