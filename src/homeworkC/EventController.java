package homeworkC;

import java.util.ArrayList;
import java.util.ListIterator;

public class EventController extends Thread {

    private ArrayList<Event> eventList;

    public EventController() {
        eventList = new ArrayList<>();
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void removeExpired() {
        ListIterator<Event> iterator = eventList.listIterator();

        while (iterator.hasNext()) {
            Event e = iterator.next();
            if(e.getTimeTo() == 0) {
                System.out.println("Event " + e.getTitle() + " is expired.");
                iterator.remove();
            }
        }
    }

    public boolean isEmpty() {
        return eventList.isEmpty();
    }

    public void run() {
        int counter = 0;
        while( ! this.isEmpty()) {
            System.out.println("Five minutes has passed.");
            counter++;

            for(Event e : eventList) {
                e.timeHasPassed(5);

                if(counter % 3 == 0 && e.important) {
                    e.addTime(3);
                    System.out.println("Time has been added to important event " + e.getTitle());
                }
            }

            this.removeExpired();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
