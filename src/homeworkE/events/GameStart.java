package homeworkE.events;

import homeworkE.Game;
import homeworkE.graphics.AppWindow;
import homeworkE.graphics.Time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStart implements ActionListener {

    private AppWindow app;

    public GameStart(AppWindow a) {
        app = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Time t = new Time(app);
        Game g = new Game(app);
        t.start();
        g.start();
    }
}
