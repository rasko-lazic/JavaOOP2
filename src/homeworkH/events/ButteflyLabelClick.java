package homeworkH.events;

import homeworkH.graphic.ButterflyAppWindow;
import homeworkH.graphic.ButterflyIcon;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButteflyLabelClick implements MouseListener {
    private String butterflyName;
    private ButterflyAppWindow mainWindow;

    public ButteflyLabelClick(ButterflyIcon butterflyIcon, ButterflyAppWindow w) {
        butterflyName = butterflyIcon.getButtrerflyName();
        mainWindow = w;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mainWindow.setButterfly(butterflyName);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
