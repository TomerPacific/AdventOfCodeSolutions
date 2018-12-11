
public class Patrol {

    private String month;
    private String day;
    private String hour;
    private String minutes;
    private String message;


    public Patrol(String _month, String _day, String _hour, String _minutes, String msg) {
        month = _month;
        day = _day;
        hour = _hour;
        minutes = _minutes;
        message = msg;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public int getMinutes() {
        return Integer.parseInt(minutes);
    }

    public int getHour() {
        return Integer.parseInt(hour);
    }
}
