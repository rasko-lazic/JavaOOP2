package exerciseH.server;

import exerciseH.graphics.ChatMessage;

import javax.swing.*;

public class ChatServerWindow extends JFrame{
    private JTextArea messageBox;

    public ChatServerWindow() {
        this.setTitle("Chat");
        this.setLayout(null);
        this.setSize(500, 500);

        this.initElements();

        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initElements() {
        messageBox = new JTextArea();
        messageBox.setBounds(0, 0, 500, 500);
        this.add(messageBox);
    }

    public void appendToChat(ChatMessage message) {
        messageBox.append(message.toString() + "\n");
    }
}
