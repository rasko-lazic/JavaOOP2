package homeworkC;

public class Main {

    public static void main() {
        Event e1 = new Event("Title1", "description1", 10);
        Event e2 = new Event("Title2", "description2", 15);
        Event e3 = new Event("Title3", "description3", 20);
        Event e4 = new Event("Title4", "description4", 30);

        EventController controller = new EventController();

        controller.addEvent(e1);
        controller.addEvent(e2);
        controller.addEvent(e3);
        controller.addEvent(e4);

        controller.start();
    }
}
