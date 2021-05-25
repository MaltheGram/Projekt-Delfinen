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
    private Member member;
    private LocalDate date;
    private ResultType type;
    private Discipline discipline;
    private Duration time;

    public Result(Member memberId, LocalDate date, ResultType type, Discipline discipline, Duration time) {
        this.member = memberId;
        this.date = date;
        this.type = type;
        this.discipline = discipline;
        this.time = time;
    }

    public Member getMember() {
        return member;
    }

    private void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

    public ResultType getType() {
        return type;
    }

    private void setType(ResultType type) {
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

    @Override
    public String toString() {
        long s = time.getSeconds();
        String timeFormatted = String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
        return "Result data: " + member.getName() + ", " + getDate() + ", " +  getDiscipline()
                + ", " + timeFormatted + ", " + getType() + "\n";
    }
}





