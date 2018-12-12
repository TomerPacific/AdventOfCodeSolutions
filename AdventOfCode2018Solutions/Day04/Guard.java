public class Guard {

    private int guardID;
    private int minutesAsleep;
    private String lastTimeAwake;


    public Guard(int id, String startedShift) {
        guardID = id;
        minutesAsleep = 0;
        lastTimeAwake = startedShift;
    }

    public void addToMinutesAsleep(int minutesToAdd) {
        minutesAsleep += minutesToAdd;
    }
}
