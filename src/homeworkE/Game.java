package homeworkE;

import homeworkE.events.GameButtonClick;
import homeworkE.graphics.AppWindow;

import java.awt.*;
import java.util.Random;

public class Game extends Thread {

    private AppWindow app;

    public Game(AppWindow a) {
        app = a;
    }

    public void pickButtons(int count) {
        Random rnd = new Random();

        for(int i = 0; i < count; i++) {
            int x = rnd.nextInt(5);
            int y = rnd.nextInt(5);

            app.getGameButtons()[x][y].set();
        }
    }

    public void resetButtons() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                app.getGameButtons()[i][j].reset();
            }
        }
    }

    public void run() {
        long now = System.currentTimeMillis();
        long half = now + 30000;
        long end = now + 60000;
        Random rnd = new Random();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                app.getGameButtons()[i][j].addActionListener(new GameButtonClick(app.getGameButtons()[i][j], app));
            }
        }

        while (System.currentTimeMillis() < end) {

            if(System.currentTimeMillis() < half) {
                this.pickButtons(3);
            } else {
                this.pickButtons(5);
            }

            int sleepTime = rnd.nextInt(700) + 800;

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.resetButtons();

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
