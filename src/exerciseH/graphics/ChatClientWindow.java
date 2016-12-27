package exerciseH.graphics;

import exerciseH.events.SendMessageEvent;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ChatClientWindow extends JFrame{
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private JTextField nameInput;
    private JTextArea messageInput;
    private JButton sendButton;

    public ChatClientWindow(ObjectInputStream i, ObjectOutputStream o) {
        in = i;
        out = o;

        this.setTitle("Chat m8");
        this.setLayout(null);
        this.setSize(300, 300);

        this.initElements();

        this.setLocationByPlatform(true);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initElements() {
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(0, 20, 40, 20);
        this.add(nameLabel);

        nameInput = new JTextField();
        nameInput.setBounds(45, 20, 230, 20);
        this.add(nameInput);

        JLabel messageLabel = new JLabel("Message: ");
        messageLabel.setBounds(0, 50, 70, 20);
        this.add(messageLabel);

        messageInput = new JTextArea();
        messageInput.setBounds(70, 50, 215, 100);
        this.add(messageInput);

        sendButton = new JButton("SEND");
        sendButton.setBounds(10, 170, 280, 20);
        this.add(sendButton);

        sendButton.addActionListener(new SendMessageEvent(out, nameInput, messageInput));
    }
}
