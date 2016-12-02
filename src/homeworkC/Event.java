package homeworkC;

public class Event {

    private String title;
    private String description;
    private int timeTo;
    public boolean important;

    public Event(String t, String d, int time, boolean i) {
        title = t;
        description = d;
        timeTo = time;
        important = i;
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

    public void addTime(int t) {
        timeTo += t;
    }
}
