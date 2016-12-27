package exerciseH.events;

import exerciseH.graphics.ChatMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SendMessageEvent implements ActionListener {
    private ObjectOutputStream out;
    private JTextField name;
    private JTextArea message;

    public SendMessageEvent(ObjectOutputStream o, JTextField n, JTextArea m) {
        out = o;
        name = n;
        message = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChatMessage chatMessage = new ChatMessage(name.getText(), message.getText());
        try {
            out.writeObject(chatMessage);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
