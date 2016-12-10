package homeworkE.graphics;

import java.awt.*;

public class GameButton extends Button {

    private boolean active = false;

    public void set() {
        active = true;
        setBackground(new Color(255,165,0));
    }

    public void reset() {
        active = false;
        setBackground(new Color(0, 47, 255));
    }

    public boolean isActive() {
        return active;
    }
}
