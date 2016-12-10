package homeworkE.graphics;

public class Time extends Thread {

    private AppWindow app;

    public Time(AppWindow a) {
        app = a;
    }

    public void run() {
        long now = System.currentTimeMillis();
        long end = now + 60000;
        int counter = 60;

        while(System.currentTimeMillis() < end) {

            app.getTime().setText("Time: " + counter);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter--;
        }

        app.getTime().setText("Time: 0");
    }
}
