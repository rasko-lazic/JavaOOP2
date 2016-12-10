package homeworkE.events;

import homeworkE.graphics.AppWindow;
import homeworkE.graphics.GameButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButtonClick implements ActionListener {

    private GameButton button;
    private AppWindow app;

    public GameButtonClick(GameButton b, AppWindow a) {
        button = b;
        app = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(button.isActive()) {
            button.reset();
            app.tickHit();
        } else {
            app.tickMiss();
        }
    }
}
