
public class Patrol {

    private String date;
    private String hour;
    private String minutes;
    private String message;


    public Patrol(String _date, String _hour, String _minutes, String msg) {
        date = _date;
        hour = _hour;
        minutes = _minutes;
        message = msg;
    }

    public String getDate() {
        return date;
    }

    public int getMinutes() {
        return Integer.parseInt(minutes);
    }

    public int getHour() {
        return Integer.parseInt(hour);
    }
}
