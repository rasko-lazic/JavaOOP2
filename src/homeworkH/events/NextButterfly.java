package homeworkH.events;

import homeworkH.graphic.ButterflyAppWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class NextButterfly implements ActionListener{
    private ButterflyAppWindow app;

    public NextButterfly(ButterflyAppWindow a) {
        app = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = -1;
        String butterfly = app.getTitle().toLowerCase().replace(' ', '-');

        for(int i = 0; i < app.BUTTERFLY_LIST.length; i++) {
            if(app.BUTTERFLY_LIST[i].equals(butterfly)) {
                index = i;
            }
        }

        app.setButterfly(app.BUTTERFLY_LIST[index + 1]);
    }
}
