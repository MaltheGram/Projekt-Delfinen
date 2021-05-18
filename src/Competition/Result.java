package Competition;

public class Result {
    private int date;
    private int time;

    public Result(int date, int time){
        this.date = date;
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

