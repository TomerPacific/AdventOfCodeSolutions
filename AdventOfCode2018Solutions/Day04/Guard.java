public class Guard {

    private int guardID;
    private int minutesAsleep;
    private String lastTimeAwake;
    private String asleepTime;
    private int timeSleeping;


    public Guard(int id, String startedShift) {
        guardID = id;
        minutesAsleep = 0;
        lastTimeAwake = startedShift;
        timeSleeping = 0;
    }

    public void addToMinutesAsleep(int minutesToAdd) {
        minutesAsleep += minutesToAdd;
    }

    public void wentToSleep(String timeWentToSleep) {
        asleepTime = timeWentToSleep;
    }

    public void wokeUp(String timeWokeUp) {
        String hour = asleepTime.substring(0, asleepTime.indexOf(":"));
        String minute = asleepTime.substring(asleepTime.indexOf(":") + 1);

        String wakeUpHour = timeWokeUp.substring(0, timeWokeUp.indexOf(":"));
        String wakeUpMinute = timeWokeUp.substring(timeWokeUp.indexOf(":") + 1);

        timeSleeping += Integer.parseInt(wakeUpMinute) - Integer.parseInt(minute);
    }

    public int getGuardID() {
        return guardID;
    }

}
