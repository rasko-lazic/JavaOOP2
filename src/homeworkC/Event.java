package homeworkC;

public class Event {

    private String title;
    private String description;
    private int timeTo;

    public Event(String t, String d, int time) {
        title = t;
        description = d;
        timeTo = time;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public String getTitle() {
        return title;
    }

    public void timeHasPassed(int t) {
        timeTo = timeTo >= t ? timeTo - t : 0;
    }
}
